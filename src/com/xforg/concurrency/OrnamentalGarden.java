package com.xforg.concurrency;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/4/27.
 */
class Count{
    private int count = 0;
    private Random rand = new Random(47);
    public synchronized int increment(){
        int temp = count;
        if(rand.nextBoolean())
            Thread.yield();
        return (count = ++temp);
    }
    public synchronized int value(){
        return count;
    }
}

class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<Entrance>();
    private int number = 0;
    private final int id;
    private static volatile boolean canceled = false;

    public static void cancel() {
        canceled = true;
    }

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    public void run() {
        while (!canceled) {
           synchronized (this){/*每个Entrance任务都维护着一个本地值number，它包含通过魔哥特定入口的参观者的数量，这提供了对count的
                               对象的双重检查，以确保其记录的参观者的数量的正确性*/
                ++number;
            }
            System.out.println(this + "Total:" + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
        System.out.println("Stoping this");
    }

    public synchronized int getValue(){
        return number;
    }
    public String toString(){
        return "Entrance"+id+":"+getValue();
    }
    public static int getTatalCount(){
        return count.value();
    }
    public static int sumEntrances(){
        int sum = 0;
        for(Entrance entrance : entrances)
            sum +=entrance.getValue();
        return sum;
    }
}

public class OrnamentalGarden {
    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++){
            exec.execute(new Entrance(i));/*开启了五个线程，类似于公园的五个大门*/
        }
        TimeUnit.MILLISECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdown();
        if(!exec.awaitTermination(250, TimeUnit.MICROSECONDS))
            System.out.println("Some tasks were not terminated");
        System.out.println("Total:"+Entrance.getTatalCount());
        System.out.println("Sum of Entrance:"+ Entrance.sumEntrances());
    }
}
