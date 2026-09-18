package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class TimeoutDemo
{
    public static void main(String[] args) {

        CompletableFuture<String> paymentFuture =
                CompletableFuture.supplyAsync(() -> {

                    sleep(5000);

                    return "Payment Success";
                });

        try {

            String result =
                    paymentFuture
                            .orTimeout(
                                    2,
                                    TimeUnit.SECONDS
                            )
                            .join();

            System.out.println(result);

        } catch (Exception e) {

            System.out.println(
                    "Payment API timed out"
            );
        }
    }

//    try
//    {
//
//    String result = paymentFuture.completeOnTimeout(
//                            "Payment Status Unavailable",
//                            2, TimeUnit.SECONDS);
//
//    System.out.println(result);
//
//    }
//    catch (Exception e)
//    {
//        System.out.println("Payment API timed out");
//    }


    static void sleep(long millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

//API takes:
//
//5 seconds
//
//but timeout is:
//
//2 seconds
//
//So you'll see:
//
//Payment API timed out
