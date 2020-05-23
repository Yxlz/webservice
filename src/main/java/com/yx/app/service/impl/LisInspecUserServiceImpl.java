package com.yx.app.service.impl;

import com.yx.app.dao.LisInspecUserMapper;
import com.yx.app.entity.LisInspecUser;
import com.yx.app.service.LisInspecUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO
 * @Author: Administrator
 * @CreateDate: 2020/5/23 0023 19:19
 * @Copyright: Copyright (c) 2020
 * @Company: 成都信通网易医疗科技发展有限公司
 * @Version: 1.0
 */
@Service
public class LisInspecUserServiceImpl implements LisInspecUserService {

    @Resource
    private LisInspecUserMapper lisInspecUserMapper;

    @Override
    public List<LisInspecUser> getLisInspecUserList() {
        return lisInspecUserMapper.queryList();
    }
}
