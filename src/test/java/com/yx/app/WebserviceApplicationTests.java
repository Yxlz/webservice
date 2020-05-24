package com.yx.app;

import com.yx.app.dao.LisInspecUserMapper;
import com.yx.app.entity.LisInspecUser;
import com.yx.app.service.LisInspecUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class WebserviceApplicationTests {

    @Autowired
    private LisInspecUserService lisInspecUserService;

    @Resource
    private LisInspecUserMapper mapper;

    @Test
    public  void test(){
//        LisInspecUser user = mapper.selectByPrimaryKey("18");
//        LisInspecUser user = lisInspecUserService.getLisInspecUserById("18");
//        System.out.println(user.getUsernameCn());
        List<LisInspecUser> list = mapper.queryList();//lisInspecUserService.getLisInspecUserList();
        for (LisInspecUser user:list) {
            System.out.println(user.getUsernameCn());
        }
    }

    @Test
    void contextLoads() {
    }

}
