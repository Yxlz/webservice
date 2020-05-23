package com.yx.app.webservice.impl;

import com.yx.app.constants.WsConst;
import com.yx.app.entity.Author;
import com.yx.app.entity.Sex;
import com.yx.app.webservice.AuthorService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @Author: Administrator
 * @CreateDate: 2020/5/22 0022 15:54
 * @Copyright: Copyright (c) 2020
 * @Company: 成都信通网易医疗科技发展有限公司
 * @Version: 1.0
 */
@WebService(
        targetNamespace = WsConst.NAMESPACE_URL, //wsdl命名空间
        name = "authorPortType",                 //portType名称 客户端生成代码时 为接口名称
        serviceName = "authorService",           //服务name名称
        portName = "authorPortName",             //port名称
        endpointInterface = "com.yx.app.webservice.AuthorService")//指定发布webservcie的接口类，此类也需要接入@WebService注解
public class AuthorServiceImpl implements AuthorService {
    /**
     * @param name
     * @return: com.yx.app.entity.Author
     * @throws:
     * @author: Administrator
     * @description: 根据姓名获取作者信息
     * @Param name:
     * @date: 2020/5/22 0022 15:52
     */
    @Override
    public Author getAuthor(String name) {
        Author author = new Author();
        author.setBirthday("1990-01-23");
        author.setName("姓名：" + name);
        author.setSex(Sex.MALE);
        author.setHobby(Arrays.asList("电影","旅游"));
        author.setDescription("描述：一枚趔趄的猿。现在时间：" + new Date().getTime());
        return author;
    }

    /**
     * @return: java.util.List<com.yx.app.entity.Author>
     * @throws:
     * @author: Administrator
     * @description: 获取作者列表信息
     * @date: 2020/5/22 0022 15:54
     */
    @Override
    public List<Author> getAuthorList() {
        List<Author> resultList = new ArrayList<>();
        Author author = new Author();
        author.setBirthday("1990-01-23");
        author.setName("姓名：oKong");
        author.setSex(Sex.MALE);
        author.setHobby(Arrays.asList("电影","旅游"));
        author.setDescription("描述：一枚趔趄的猿。现在时间：" + new Date().getTime());
        resultList.add(author);
        resultList.add(author);
        return resultList;
    }

    @Override
    public String getAuthorString(String name) {
        Author author = getAuthor(name);
        return author.toString();
    }
}
