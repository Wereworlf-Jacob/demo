package com.example.demo.thread.pool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName IntegerThreadFactory
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/20 16:55
 **/
public class IntegerThreadFactory implements ThreadFactory {

    private final AtomicInteger index = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "IntegerThread-" + index.getAndIncrement() + "-pool");
    }

}
