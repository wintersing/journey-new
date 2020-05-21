package com.lt.commons.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Title: <br>
 * Description: <br>
 * Company: winter.com <br>
 *
 * @author 刘汀
 * @version 1.0
 */
public class ThreadPoolExecutor {

    private static ExecutorService executorService;

    public static ExecutorService newThreadPool(){
        if (executorService != null) {
            return executorService;
        }
        executorService =
                new java.util.concurrent.ThreadPoolExecutor(5,
                10,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5));
        return executorService;
    }

    public static void shutdown(){
        if (executorService != null){
            executorService.shutdown();
        }
    }
}
