package com.xforg.concurrency;//: concurrency/DaemonFromFactory.java
// Using a Thread Factory to create daemons.
import java.util.concurrent.*;
import static com.xforg.utils.Print.print;


public class DaemonFromFactory implements Runnable {
  public void run() {
    try {
      while(true) {
        TimeUnit.MILLISECONDS.sleep(100);
        print(Thread.currentThread() + " " + this);
      }
    } catch(InterruptedException e) {
      print("Interrupted");
    }
  }
  public static void main(String[] args) throws Exception {
    ExecutorService exec = Executors.newCachedThreadPool(
      new DaemonThreadFactory());/*如有需要根据DaemonThreadFactory创建一个新线程*/
    for(int i = 0; i < 10; i++)
      exec.execute(new DaemonFromFactory());/*执行该线程*/
    print("All daemons started");
    TimeUnit.MILLISECONDS.sleep(1000); // Run for a while
  }
}
