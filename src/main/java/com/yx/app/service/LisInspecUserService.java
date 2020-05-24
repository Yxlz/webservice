package com.yx.app.service;

import com.yx.app.entity.LisInspecUser;

import java.util.List;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2020/5/23 0023 19:18
 * @Copyright: Copyright (c) 2020
 * @Company: 成都信通网易医疗科技发展有限公司
 * @Version: 1.0
 */
public interface LisInspecUserService {
    public List<LisInspecUser> getLisInspecUserList();
    public LisInspecUser getLisInspecUserById(String id);
}
