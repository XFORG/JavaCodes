package com.xforg.concurrency.com.xforg;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/5/5.
 */
class Car{
    private boolean waxOn = false;
    public synchronized void waxed(){
        waxOn = true;
        notifyAll();
    }
    public synchronized void buffed() throws InterruptedException{
        waxOn = false;
        notifyAll();
    }
    public synchronized void waitForWaxing() throws InterruptedException{
        while (waxOn == true)/*必须用一个检查感兴趣条件的while循环包围wait，并在条件不满足时返回到wait中*/
            wait();/*如果waxOn为true。那么这个调用任务将通过调用wait而被挂起，此时线程被挂起，锁被释放*/
    }
    public synchronized void waitForBuffing() throws InterruptedException{
        while (waxOn == true)
            wait();
    }
}
 class WaxOn implements Runnable {
    private Car car;
    public WaxOn(Car c){
        car = c;
    }

    @Override
    public void run() {
        try{
            while (! Thread.interrupted()){
                System.out.println("Wax On !");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }catch (InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax on  task");
    }
}
class WaxOff implements Runnable{
    private Car car;
    public WaxOff(Car c){
        car = c;
    }

    @Override
    public void run() {
        try{
            while(! Thread.interrupted()){
                car.waitForWaxing();
                System.out.println("Wax Off");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }catch (InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
        System.out.println("EndingWax off task");
    }
}
public class WaxOMatic{
    public static void main(String[] args) throws Exception{
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdown();/*此时会调用所有由它控制的线程的interrupt*/
    }
}