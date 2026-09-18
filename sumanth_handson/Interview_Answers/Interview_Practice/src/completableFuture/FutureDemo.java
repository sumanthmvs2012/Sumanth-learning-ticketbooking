package completableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.*;

public class FutureDemo
{
    public static void main(String[] args) throws Exception
    {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<String> future = executor.submit(() -> {
                                Thread.sleep(3000);
                    return "API Result";
                });

        System.out.println("Task submitted");

        String result = future.get();

        System.out.println(result);

        executor.shutdown();
    }
}
