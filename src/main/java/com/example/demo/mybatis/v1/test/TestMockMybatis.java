package com.example.demo.mybatis.v1.test;


import com.example.demo.mybatis.v1.*;

/**
 * @ClassName TestMockMybatis
 * @Description 测试mybatis核心模拟流程
 * @Author Jacob
 * @Version 1.0
 * @since 2020/5/15 17:20
 **/
public class TestMockMybatis {
    public static void main(String[] args) {
        MySqlSession mySqlSession = new MySqlSession(
                new MyConfiguration(),
                new MySimpleExecutor());
        UserInfoMapper mapper = mySqlSession.getMapper(UserInfoMapper.class);
        System.out.println(mapper.selectByPrimaryKey("4028802266a52efb0166e14f8d820531"));

        //如此便模拟了一个mybatis1.0核心流程的实现
    }
}
