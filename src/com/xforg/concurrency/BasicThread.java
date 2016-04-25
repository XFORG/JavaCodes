package com.xforg.concurrency;

/**
 * Created by Administrator on 2016/4/25.
 */
public class BasicThread {
    public static void main(String[] args){
        Thread t = new Thread(new ListOff());/*将Runnable对象转变为工作任务的传统方式是把它提交给一个Thread的构造器*/
        t.start();/*为该线程执行必须的初始化操作，然后调用Runnable的run方法，以便在新线程中启动该任务*/
        System.out.println("Waiting for Listoff");
    }
}
