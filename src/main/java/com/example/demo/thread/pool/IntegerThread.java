package com.example.demo.thread.pool;

/**
 * @ClassName IntegerThread
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/20 16:54
 **/
public class IntegerThread implements Runnable {

    public int num;

    public IntegerThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("线程名称=" + Thread.currentThread().getName() + "；对象内容：" + num);
    }

}
