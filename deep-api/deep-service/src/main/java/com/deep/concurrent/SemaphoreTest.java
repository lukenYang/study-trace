package com.deep.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Administrator on 2017/8/26 0026.
 *
 * 对于锁来说，它是互斥的排他的。意思就是，只要我获得了锁，没人能再获得了。
 *而对于Semaphore来说，它允许多个线程同时进入临界区。
 * 可以认为它是一个共享锁，但是共享的额度是有限制的，额度用完了，其他没有拿到额度的线程还是要阻塞在临界区外。当额度为1时，就相等于lock
 */
public class SemaphoreTest implements Runnable
{
    final Semaphore semaphore = new Semaphore(5);

    @Override
    public void run()
    {
        try
        {
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + " done");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        final SemaphoreTest t = new SemaphoreTest();
        for (int i = 0; i < 20; i++)
        {
//            executorService.submit(t);
            executorService.execute(t);
        }
    }

}