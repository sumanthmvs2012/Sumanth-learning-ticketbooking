package multithreading_concepts;

public class VolatileDemo
{
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException
    {

        Thread worker = new Thread(() ->
        {
                    while (running) {
                        // working
                    }

                    System.out.println("Worker stopped");
                });

        worker.start();

        Thread.sleep(2000);

        running = false;

        worker.join();
    }
}
