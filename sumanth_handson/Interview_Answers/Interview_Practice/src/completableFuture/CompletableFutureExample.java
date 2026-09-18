package completableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample
{
    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> {
                  sleep(3000);
                  return "API Result";
                })
                .thenApply(result ->
                        result.toUpperCase()
                ).thenAccept(System.out::println)
                .join();
    }

    static void sleep(long millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
