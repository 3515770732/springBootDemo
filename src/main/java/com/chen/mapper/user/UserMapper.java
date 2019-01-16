package com.chen.mapper.user;

import com.chen.entity.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from t_hr_user where userName=#{userName}")
    public User queryUserByUserName(String userName);
}
