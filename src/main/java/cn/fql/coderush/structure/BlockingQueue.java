package cn.fql.coderush.structure;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by fuquanlin on 2016/11/18.
 */
public class BlockingQueue {
    private LinkedList<Object> queue = new LinkedList<>();
    private int limit = 10;

    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public void put(Object obj) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == limit) {
                notFull.await();
            }
            queue.offer(obj);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        Object result = null;
        lock.lock();
        try {
            while (queue.size() == 0) {
                notEmpty.await();
            }
            result = queue.poll();
            notFull.signal();
        } finally {
            lock.unlock();
        }
        return result;
    }
}
