package com.xforg.concurrency;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/4/25.
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try{
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() +" "+this);
            }
        }catch (InterruptedException e){
            System.out.println("sleep() interrupted");
        }
    }
    public static void main(String[] args) throws  Exception{
        for(int i = 0; i<10; i++){
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);/*必须在线程启动之前调用setDaemon（），才能把它设置为后台线程*/
            daemon.start();
        }
        System.out.println("All daemon started");
        TimeUnit.MILLISECONDS.sleep(100);
    }
}
