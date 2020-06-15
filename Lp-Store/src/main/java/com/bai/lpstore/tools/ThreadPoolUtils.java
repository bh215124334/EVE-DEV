package com.bai.lpstore.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtils {
    private static ExecutorService THREAD_POOL;
    private ThreadPoolUtils(){}

    public static ExecutorService getInstance(){
        if (THREAD_POOL == null){
            synchronized (ThreadPoolUtils.class){
                if (THREAD_POOL == null){
                    THREAD_POOL = new ThreadPoolExecutor(20, 50, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
                }
            }
        }
        return THREAD_POOL;
    }
}
