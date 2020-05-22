package com.example.demo.lamda;

/**
 * @ClassName Something
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/5/20 16:57
 **/
public class Something {

    public Something() {
    }

    public Something(String something) {
        System.out.println(something);
    }

    static String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    String endWith(String s){
        return String.valueOf(s.charAt(s.length() - 1));
    }

    void endWith(){

    }

}
