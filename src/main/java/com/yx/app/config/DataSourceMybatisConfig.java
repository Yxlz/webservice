package com.yx.app.config;

import com.yx.app.db.DynamicDataSource;
import com.yx.app.db.DynamicDataSourceContextHolder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 数据源配置类
 * @Author: Administrator
 * @CreateDate: 2020/5/23 0023 17:53
 * @Copyright: Copyright (c) 2020
 * @Company: 成都信通网易医疗科技发展有限公司
 * @Version: 1.0
 */
@Configuration
@MapperScan(basePackages = {"com.yx.app.dao"}, sqlSessionFactoryRef = "dynamicSqlSessionFactory")
public class DataSourceMybatisConfig {
    /**
     * @return:  javax.sql.DataSource
     * @author: Administrator
     * @description: 主数据源
     * @date: 2020/5/23 0023 17:57
     */
    @Bean(name = "dataSourceMaster")
    @ConfigurationProperties(prefix = "spring.datasource.hikari.master")
    public DataSource dataSourceMaster(){
        return DataSourceBuilder.create().build();
    }

    /**
     * @return:  javax.sql.DataSource
     * @author: Administrator
     * @description: 从数据源
     * @date: 2020/5/23 0023 17:57
     */
    @Bean(name = "dataSourceSlave")
    @ConfigurationProperties(prefix = "spring.datasource.hikari.slave")
    public DataSource dataSourceSlave(){
        return DataSourceBuilder.create().build();
    }

    /**
     * @return:  javax.sql.DataSource
     * @author: Administrator
     * @description: 动态数据源，通过AOP动态切换
     * @date: 2020/5/23 0023 18:03
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //设置默认主数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSourceMaster());
        //配置多数据源
        Map<Object,Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DynamicDataSourceContextHolder.DataSourceType.MASTER,dataSourceMaster());
        dataSourceMap.put(DynamicDataSourceContextHolder.DataSourceType.SLAVE,dataSourceSlave());
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        return dynamicDataSource;
    }

    /**
     * @return:  org.apache.ibatis.session.SqlSessionFactory
     * @author: Administrator
     * @description: 配置sqlSessionFactory
     * @date: 2020/5/23 0023 19:34
     */
    @Bean(name = "dynamicSqlSessionFactory")
    public SqlSessionFactory dynamicSqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath:com/yx/app/entity/*.xml"));
        return bean.getObject();
    }

    /**
     * @return:  org.springframework.transaction.PlatformTransactionManager
     * @author: Administrator
     * @description: 配置Transactional注解
     * @date: 2020/5/23 0023 18:07
     */
//    public PlatformTransactionManager transactionManager(){
//        return new DataSourceTransactionManager(dynamicDataSource());
//    }
}
