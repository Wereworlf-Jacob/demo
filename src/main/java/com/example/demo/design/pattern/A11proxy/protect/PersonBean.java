package com.example.demo.design.pattern.A11proxy.protect;

/**
 * @auth Jacob
 * @date 2023/2/28 14:38
 */
public interface PersonBean {

    String getName();
    String getGender();
    String getInterests();
    int getHotOrNotRating();

    void setName(String name);
    void setGender(String gender);
    void setInterests(String interests);
    void setHotOrNotRating(int rating);

}
