package week10.day3;

import java.util.concurrent.*;

/**
 * [연습 문제 2] Callable과 Future
 * 문제: Callable<String>을 구현해 "작업 완료" 문자열을 반환하게 하고,
 * 메인에서 Future로 받아서 출력하세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        ExecutorService pool = Executors.newFixedThreadPool(1);

        Callable<String> call = () ->
        {
          return "작업 완료";
        };

        Future<String> future = pool.submit(call);


        try
        {
            String result = future.get();
            System.out.println(result);
        }
        catch (InterruptedException | ExecutionException e)
        {
            e.printStackTrace();
        }

        pool.shutdown();

    }
}
