package com.yx.app.entity;

/**
 * @Description: TODO
 * @Author: Administrator
 * @CreateDate: 2020/5/22 0022 15:45
 * @Copyright: Copyright (c) 2020
 * @Company: 成都信通网易医疗科技发展有限公司
 * @Version: 1.0
 */
public enum Sex {
    MALE("male"),
    FEMALE("female");

    String value;

    Sex(String value){
        this.value = value;
    }

    public static Sex fromValue(String v) {
        for (Sex c : Sex.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
