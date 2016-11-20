package cn.fql.coderush.thread;

import java.util.concurrent.Callable;

/**
 * Created by fuquanlin on 20/11/2016.
 */
public class CallJob implements Callable {
    @Override
    public Object call() throws Exception {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName();
    }
}
