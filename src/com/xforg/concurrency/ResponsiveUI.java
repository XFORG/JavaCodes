package com.xforg.concurrency;

/**
 * Created by Administrator on 2016/4/26.
 */
 class UnResponsiveUI {
    private volatile double d = 1;
    public UnResponsiveUI() throws Exception{
        while (d > 0)
            d = d + (Math.PI + Math.E) / d;
        System.in.read();
    }
}

public class ResponsiveUI extends Thread{
    private static volatile double d = 1;
    public ResponsiveUI(){
        setDaemon(true);
        start();
    }

    @Override
    public void run() {/*想要让程序有响应，就得把计算放在run（）方法中，这样他就可以让出处理器给别的程序*/
        while (true)
            d = d + (Math.PI + Math.E) / d;
    }
    public static void main(String[] args) throws Exception{
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
