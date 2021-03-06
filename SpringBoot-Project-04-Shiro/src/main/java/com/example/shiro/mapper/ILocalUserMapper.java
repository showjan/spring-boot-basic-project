package com.example.shiro.mapper;

import com.example.shiro.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ILocalUserMapper {

    /**
     * 根据用户名查询用户
     * 使用了when...then... 来映射权限
     */
    @Select(
            "SELECT userName,password,perm," +
            "(case user_table.role when 1 then 'role:user' when 2 then 'role:manger' when 3 then 'role:admin' end) as role " +
            "FROM user_table   " +
            "where userName = #{username};"
    )
    User findUserByUsername(String username);



}
