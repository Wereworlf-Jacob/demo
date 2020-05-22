package com.example.demo.lamda;

/**
 * @ClassName LamdaTest
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/5/20 17:02
 **/
public class LamdaTest {
    public static void main(String[] args) {
        IConvert<String, String> convert = Something::startsWith;
        System.out.println(convert.convert("zhangsan"));

        Something something = new Something();
        IConvert<String, String> convertEnd = something::endWith;
        System.out.println(convertEnd.convert("zhangsan"));

        //由F 决定了，构造方法的参数为String， T 决定了返回值为Something，如此就定位到了调用Something(String something)方法
        IConvert<String, Something> convertNew = Something::new;
        convertNew.convert("zhangsan");
    }
}
