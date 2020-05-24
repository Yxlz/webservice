package com.yx.app.service.impl;

import com.yx.app.annotation.SwitchDataSource;
import com.yx.app.dao.LisInspecUserMapper;
import com.yx.app.entity.LisInspecUser;
import com.yx.app.service.LisInspecUserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2020/5/23 0023 19:19
 * @Copyright: Copyright (c) 2020
 * @Company: 成都信通网易医疗科技发展有限公司
 * @Version: 1.0
 */
@Service("lisInspecUserServiceImpl")
@Transactional("dynamicTransactionManager")
public class LisInspecUserServiceImpl implements LisInspecUserService {

    @Resource
    private LisInspecUserMapper lisInspecUserMapper;

    @SwitchDataSource
    @Override
    public List<LisInspecUser> getLisInspecUserList() {
        return lisInspecUserMapper.queryList();
    }

    @Override
    public LisInspecUser getLisInspecUserById(String id) {
        return lisInspecUserMapper.selectByPrimaryKey(id);
    }
}
