package jvm;

public class MyThread {
    public static void main(String[] args) {

        Thread t1 = new Thread();
        t1.start();
        // 一个线程不能多次运行
        // Exception in thread "main" java.lang.IllegalThreadStateException
        t1.start();
    }
}
