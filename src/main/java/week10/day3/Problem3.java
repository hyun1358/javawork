package week10.day3;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * [연습 문제 3] ScheduledExecutorService
 * 문제: 스케줄러 풀을 사용해 "1초마다" 현재 시간을 출력하는 작업을 만들어보세요.
 */
public class Problem3 {
    public static void main(String[] args) throws Exception
    {
        // TODO (힌트: Executors.newScheduledThreadPool, scheduleAtFixedRate)
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> task = pool.scheduleAtFixedRate(()-> System.out.println(LocalTime.now()),0,1, TimeUnit.SECONDS);

        Thread.sleep(3500);

        pool.shutdown();
    }
}
