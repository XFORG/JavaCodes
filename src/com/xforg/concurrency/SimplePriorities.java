package com.xforg.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/4/25.
 */
public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priorities;
    public SimplePriorities(int priorities){
        this.priorities = priorities;
    }
    public String toString(){
        return Thread.currentThread()+":"+countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priorities);
        while (true){
            for(int i = 0; i < 100000; i++){
                d += (Math.PI + Math.E) / (double)i;
                if(i % 100000 ==0)
                    Thread.yield();
            }
            System.out.println(this);
            if(--countDown == 0)
                return;
        }
    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0 ; i < 5; i++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
