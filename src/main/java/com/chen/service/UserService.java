package com.chen.service;

import com.chen.entity.po.User;
import com.chen.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryAllUser() {
        return null;
    }

    public User queryUserByName(String userName) {
        return userMapper.queryUserByUserName(userName);
    }

}
