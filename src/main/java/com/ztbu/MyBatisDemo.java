package com.ztbu;


import com.ztbu.mapper.userMapper;
import com.ztbu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1.加载Mybatis的核心配置文件 获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlsession对象 用来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();

/*        //3.执行sql
        *//**
         * 存在硬编码  不利于后期维护
         * 采用  Mapper代理方式 解决硬编码 简化后期执行sql
         *//*
        List<User> users = sqlSession.selectList("com.ztbu.mapper.userMapper.selectAll");
        System.out.println(users);*/

        //3.1获取usermapper接口的代理对象
        userMapper userMapper = sqlSession.getMapper(userMapper.class);
        //3.2执行sql
        List<User> users = userMapper.selectAll();//查询所有 返回对象为集合  查询单个 用对象 根据sql语句判断
        System.out.println(users);


        //4.释放资源
        sqlSession.close();

    }
}
