package com.example.demo.trycatch;

/**
 * @ClassName MyResultSet
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/5/15 17:13
 **/
public class MyResultSet implements AutoCloseable {

    public MyResultSet() {
        System.out.println("new MyResultSet!");
    }

    public void getString(){
        System.out.println("myResultSet get Result string");
    }

    @Override
    public void close() throws Exception {
        System.out.println("myResultSet closed!");
    }

}
