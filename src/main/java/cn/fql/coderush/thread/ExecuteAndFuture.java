package cn.fql.coderush.thread;

import java.util.concurrent.*;

/**
 * Created by fuquanlin on 2016/11/18.
 */
public class ExecuteAndFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        FutureTask future = new FutureTask(new CallJob());
        executorService.execute(future);
        executorService.submit(new CallJob());
        executorService.submit(new CallJob());
        executorService.submit(new CallJob());
        executorService.submit(new CallJob());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(future.get() + "");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

    }
}
