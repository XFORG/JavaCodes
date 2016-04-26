package com.xforg.concurrency;//: concurrency/SerialNumberGenerator.java

public class SerialNumberGenerator {
  private static volatile int serialNumber = 0;
  public static int nextSerialNumber() {/*问题在于nextSerialNumber在没有同步的情况下对共享可变值进行了访问*/
    return serialNumber++; // Not thread-safe
  }
} ///:~
