package com.xforg.concurrency;//: concurrency/EvenGenerator.java
// When threads collide.

public class EvenGenerator extends IntGenerator {
  private int currentEvenValue = 0;
  public int next() {/*一个任务有可能在另一个任务执行第一个currentEventValue的递增操作之后，但是没有执行第二个操作之前调用next（）方法*/
    ++currentEvenValue; // Danger point here!
    ++currentEvenValue;
    return currentEvenValue;
  }
  public static void main(String[] args) {
    EvenChecker.test(new EvenGenerator());
  }
}
