package com.yx.app.aspect;

import com.yx.app.annotation.SwitchDataSource;
import com.yx.app.db.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author: Administrator
 * @CreateDate: 2020/5/23 0023 18:22
 * @Copyright: Copyright (c) 2020
 * @Company: 成都信通网易医疗科技发展有限公司
 * @Version: 1.0
 */
@Aspect
@Component
public class ChangeDataSourceAspect implements Ordered {

    @Before("@annotation(switchDataSource)")
    public void switchDataSource(JoinPoint joinPoint, SwitchDataSource switchDataSource){
        String classType = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("============"+ classType + "." + methodName + ":设置了读写分离-切换到只读数据库");
        DynamicDataSourceContextHolder.setDataSourceType(DynamicDataSourceContextHolder.DataSourceType.SLAVE);
    }

    @After("@annotation(switchDataSource)")
    public void afterSwitchDataSource(JoinPoint joinPoint, SwitchDataSource switchDataSource){
        DynamicDataSourceContextHolder.clearDataSourceType();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
