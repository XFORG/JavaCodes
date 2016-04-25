package com.xforg.concurrency;
import java.util.concurrent.ThreadFactory;
/**
 * Created by Administrator on 2016/4/25.
 */
public class DaemonThreadFactory implements ThreadFactory{
    public Thread newThread(Runnable r){/*返回一个后台线程*/
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
