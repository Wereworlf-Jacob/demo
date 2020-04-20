package com.example.demo.thread;

import com.example.demo.thread.pool.IntegerThread;
import com.example.demo.thread.pool.IntegerThreadFactory;

import java.util.concurrent.*;

/**
 * @ClassName TreadTest
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/20 16:55
 **/
public class TreadTest {

    public static void main(String[] args) {
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(10);
        for (int i = 0; i < 10; i ++) {
            blockingQueue.offer(new IntegerThread(i));
        }
        Executors.newScheduledThreadPool(1);
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(1);
        Executors.newSingleThreadExecutor();
        Executors.newSingleThreadScheduledExecutor();

        ExecutorService executorService = new ThreadPoolExecutor(2, 4, 200
                , TimeUnit.SECONDS,blockingQueue, new IntegerThreadFactory());
        executorService.submit(new Thread());
        executorService.shutdown();
    }

}
