package com.example.demo.mybatis.v1;

/**
 * @ClassName UserInfoMapper
 * @Description 模拟Mybatis的mapper接口
 * @Author Jacob
 * @Version 1.0
 * @since 2020/5/14 15:18
 **/
public interface UserInfoMapper {

    UserInfo selectByPrimaryKey(String id);

}
