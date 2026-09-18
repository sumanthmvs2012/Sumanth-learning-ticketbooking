package completableFuture;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

public class CompletableFutureDemo
{
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();

        CompletableFuture<String> customerFuture =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                    return "Customer: Sumanth";
                });


        CompletableFuture<String> orderFuture =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                    return "Order:3000";
                });

        CompletableFuture<String> paymentFuture =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                    return "Payment: SUCCESS";
                });

        CompletableFuture<Void> allFuture = CompletableFuture.allOf(
                                     customerFuture,
                                          orderFuture,
                                          paymentFuture);
        allFuture.join();

        System.out.println(customerFuture.join());
        System.out.println(orderFuture.join());
        System.out.println(paymentFuture.join());

        long end = System.currentTimeMillis();

        System.out.println("Total time: " + (end - start) + " ms");

    }

}
