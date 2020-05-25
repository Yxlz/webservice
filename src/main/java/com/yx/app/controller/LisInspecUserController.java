package com.yx.app.controller;

import com.yx.app.entity.LisInspecUser;
import com.yx.app.service.LisInspecUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 用户controller
 * @Author: Administrator
 * @CreateDate: 2020/5/24 0024 16:39
 * @Copyright: Copyright (c) 2020
 * @Company: 成都信通网易医疗科技发展有限公司
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class LisInspecUserController {
    @Resource(name = "lisInspecUserServiceImpl")
    private LisInspecUserService lisInspecUserService;

    @RequestMapping("getUsers")
    public List<LisInspecUser> getUsers(){
        return lisInspecUserService.getLisInspecUserList();
    }

    @RequestMapping("getUser")
    public LisInspecUser getUser(){
        return lisInspecUserService.getLisInspecUserById("18");
    }
}
