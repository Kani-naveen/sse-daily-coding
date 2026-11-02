import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("========Unbounded Queue Demo=============");

//        ThreadPoolExecutor unboundedPool = new ThreadPoolExecutor(
//                10,                 //core pool size
//                50,                             //Maximum pool size
//                60,                             //Keep alive time
//                TimeUnit.SECONDS,
//                new LinkedBlockingDeque<>()  //unbounded queue
//        );

        ThreadPoolExecutor unboundedPool = new ThreadPoolExecutor(
                10,                 //core pool size
                50,                             //Maximum pool size
                60,                             //Keep alive time
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(200),
                new ThreadPoolExecutor.CallerRunsPolicy()//unbounded queue
        );

        //submit 500 tasks
        for(int i=0; i<500;i++){

            final int taskId = i;
            unboundedPool.submit(() -> {
                System.out.println(
                        "Task " + taskId + " running on " +
                                Thread.currentThread().getName()
                );
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        System.out.println("\n======= Pool Statistics ============");

        System.out.println("Pool Size: "+unboundedPool.getPoolSize());
        System.out.println("Active Thread: "+unboundedPool.getActiveCount());
        System.out.println("Queued Tasks: "+unboundedPool.getCompletedTaskCount());

        //Graceful shutdown
        unboundedPool.shutdown();

        if(!unboundedPool.awaitTermination(5, TimeUnit.MINUTES)) {
            unboundedPool.shutdownNow();
        }
        System.out.println("\nAll tasks completed.");
    }
}
