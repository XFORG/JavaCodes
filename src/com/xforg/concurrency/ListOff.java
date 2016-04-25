package com.xforg.concurrency;

/**
 * Created by Administrator on 2016/4/25.
 */
public class ListOff implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;/*用来区分任务的多个实例，它是final的一旦被初始化之后就不希望被修改*/
    public ListOff(){};
    public ListOff(int countDown){
        this.countDown = countDown;
    }
    public String status(){
        return "#"+id +"("+
                (countDown > 0 ? countDown : "Liftoff") + ") +";
    }
    public void run(){/*任务的run方法通常总会有魔种形式的循环，使得任务一直运行下去知道不再需要，所以要设定跳出循环的条件*/
        while (countDown-- > 0){
            System.out.print(status());
           // Thread.yield();/*在run中对静态方法Thread.yield的调用是对线程调度器的一种建议*/
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
