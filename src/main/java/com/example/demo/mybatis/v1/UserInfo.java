package com.example.demo.mybatis.v1;

/**
 * @ClassName UserInfo
 * @Description 模拟对应数据库的一个实体类
 * @Author Jacob
 * @Version 1.0
 * @since 2020/5/14 15:19
 **/
public class UserInfo {

    private String id;

    private String username;

    private String trueName;

    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "{\"id\": \"" + this.id + "\", \"username\": \"" + this.username
                + "\", \"trueName\": \"" + this.trueName + "\", \"phone\": \"" + this.phone + "\"}";
    }
}
