package completableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo
{
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++)
        {
            int taskNumber = i;
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " processing task " + taskNumber);
            });
        }

        executor.shutdown();
    }
}
//You'll see something like:
//
//pool-1-thread-1 processing task 1
//pool-1-thread-2 processing task 2
//pool-1-thread-3 processing task 3
//pool-1-thread-1 processing task 4
//...
//
//Notice:
//
//Only 3 threads exist.
//
//But they execute 10 tasks.
//
//That is thread reuse.
