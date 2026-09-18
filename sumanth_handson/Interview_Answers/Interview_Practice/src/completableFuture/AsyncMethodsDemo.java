package completableFuture;

import java.util.concurrent.CompletableFuture;

public class AsyncMethodsDemo
{
    public static void main(String[] args)
    {
    CompletableFuture<String> supplyFuture =
            CompletableFuture.supplyAsync(() -> {
                return "Customer Data";
            });

    CompletableFuture<Void> runFuture =
            CompletableFuture.runAsync(() -> {
                System.out.println("Sending notification...");
            });

      System.out.println(supplyFuture.join());

      runFuture.join();
   }
}
