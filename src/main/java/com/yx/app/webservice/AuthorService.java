package com.yx.app.webservice;

import com.yx.app.constants.WsConst;
import com.yx.app.entity.Author;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * @Description: 创建服务接口
 * @Author: Administrator
 * @CreateDate: 2020/5/22 0022 15:48
 * @Copyright: Copyright (c) 2020
 * @Company: 成都信通网易医疗科技发展有限公司
 * @Version: 1.0
 */
@WebService(targetNamespace = WsConst.NAMESPACE_URL, name = "authorPortType")
public interface AuthorService {
    /**
     * @return: com.yx.app.entity.Author
     * @throws:
     * @author: Administrator
     * @description: 根据姓名获取作者信息
     * @Param name:
     * @date: 2020/5/22 0022 15:52
     */
    @WebMethod(operationName = "getAuthorByName")
    public Author getAuthor(@WebParam(name = "authorName") String name);

    /**
     * @return: java.util.List<com.yx.app.entity.Author>
     * @throws:
     * @author: Administrator
     * @description: 获取作者列表信息
     * @date: 2020/5/22 0022 15:54
     */
    @WebMethod
    List<Author> getAuthorList();

    String getAuthorString(@WebParam(name = "authorName") String name);
}
