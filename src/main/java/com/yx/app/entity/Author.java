package com.yx.app.entity;

import lombok.Data;

import java.util.List;

/**
 * @Description: TODO
 * @Author: Administrator
 * @CreateDate: 2020/5/22 0022 15:43
 * @Copyright: Copyright (c) 2020
 * @Company: 成都信通网易医疗科技发展有限公司
 * @Version: 1.0
 */
@Data
public class Author {
    private String name;
    private String birthday;
    private String description;
    private List<String> hobby;
    Sex sex;
}
