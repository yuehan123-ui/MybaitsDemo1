package com.ztbu.mapper;

import com.ztbu.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface userMapper {
    /**
     * 使用注解开发
     * 复杂sql语句依旧使用配置xml文件
     */
    @Select("select * from tb_user;")
    List<User> selectAll();


}
