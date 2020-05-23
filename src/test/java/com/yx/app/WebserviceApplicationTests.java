package com.yx.app;

import com.yx.app.entity.LisInspecUser;
import com.yx.app.service.LisInspecUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WebserviceApplicationTests {

    @Autowired
    private LisInspecUserService lisInspecUserService;

    @Test
    public  void test(){
        List<LisInspecUser> list = lisInspecUserService.getLisInspecUserList();
        for (LisInspecUser user:list) {
            System.out.println(user.getUsernameCn());
        }
    }

    @Test
    void contextLoads() {
    }

}
