package com.wantao.springboot1.bean;/*
 *author:wantao
 *createTime:18-6-27 11:11
 *description:
 */

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    @Value("${user.id}")
    private Integer id;
    @Value("${user.name}")
    private String name;
    @Value("${user.age}")
    private Integer age;
}
