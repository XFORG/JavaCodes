package com.xforg.concurrency;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2016/4/25.
 */

class TaskWithResult implements Callable<String>{
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    public String call(){
        return "result of TaskWithResult"+ id;
    }
}

public class CallableDemo {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> result = new ArrayList<Future<String>>();
        for(int i = 0; i < 10; i++){
            result.add(exec.submit(new TaskWithResult(i)));/*submit（）方法会产生Future对象，它用Callable返回结果的特定类型进行参数化*/
        }
        for(Future<String> fs : result){
            try{
                System.out.println(fs.get());/*调用get()方法来获取结果*/
            }catch (InterruptedException e){
                System.out.println(e);
                return;
            }catch (ExecutionException e){
                System.out.println(e);
            }finally {
                exec.shutdown();
            }
        }
    }
}
