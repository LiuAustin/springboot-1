package com.wantao.springboot1.mapper;

import com.wantao.springboot1.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    @Select(value = "SELECT * FROM tb_user")
    public User findUserByName(@Param("name") String name);

    @Insert("INSERT INTO tb_user(name,age) VALUES(#{name},#{age})")
    public void insertUser(User user);
}
