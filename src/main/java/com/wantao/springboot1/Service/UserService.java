package com.wantao.springboot1.Service;/*
 *author:wantao
 *createTime:18-6-27 11:21
 *description:
 */

import com.wantao.springboot1.bean.User;
import com.wantao.springboot1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
