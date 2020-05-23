package com.yx.app.dao;

import com.yx.app.entity.LisInspecUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LisInspecUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(LisInspecUser record);

    int insertSelective(LisInspecUser record);

    LisInspecUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LisInspecUser record);

    int updateByPrimaryKeyWithBLOBs(LisInspecUser record);

    int updateByPrimaryKey(LisInspecUser record);

    @Select("select * from lis_inspec_users")
    List<LisInspecUser> queryList();
}