package com.example.crud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.crud.model.User;

@Mapper
public interface UserMapper {

    @Select("SELECT EXISTS (SELECT 1 FROM USER_TABLE WHERE username = #{username} and password = #{password})")
    boolean isUserExists(User user);

}