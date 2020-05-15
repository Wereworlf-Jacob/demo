package com.example.demo.trycatch;

/**
 * @ClassName MyStatement
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/5/15 17:10
 **/
public class MyStatement implements AutoCloseable {

    public MyStatement() {
        System.out.println("new MyStatement");
    }

    public void setParams(){
        System.out.println("statement setParams");
    }

    public MyResultSet executeQuery(){
        System.out.println("statement executeQuery");
        return new MyResultSet();
    }

    @Override
    public void close() throws Exception {
        System.out.println("myStatement closed!");
    }
}
