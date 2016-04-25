package com.xforg.concurrency;

/**
 * Created by Administrator on 2016/4/25.
 */
public class MoreBasicThreads {
    public static void main(String[] args){
        for(int i = 0; i< 5; i++){
          new Thread(new ListOff()).start();
        }
    }
}
