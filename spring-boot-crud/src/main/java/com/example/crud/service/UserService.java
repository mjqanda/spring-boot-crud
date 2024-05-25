package com.example.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud.mapper.UserMapper;
import com.example.crud.model.User;

@Service
@Transactional
public class UserService {

    @Autowired
    UserMapper userMapper;

    public boolean isUserExists(User user) {
        return userMapper.isUserExists(user);
    }

}