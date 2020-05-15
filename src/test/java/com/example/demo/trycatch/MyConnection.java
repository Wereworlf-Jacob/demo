package com.example.demo.trycatch;

/**
 * @ClassName MyConnection
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/5/15 17:04
 **/
public class MyConnection implements AutoCloseable {

    public MyConnection() {
        System.out.println("new Myconection!");
    }

    public MyStatement preparedStatement(){
        System.out.println("connection get preparedStatement");
        return new MyStatement();
    }

    @Override
    public void close() throws Exception {
        System.out.println("I'm closed");
    }

}
