package jvm;

import java.util.Random;

/**
 * 1 JVM系统架构图
 *
 * 2 类加载器
 *  2.1 有哪几种类加载器：
 *          Bootstrap、ExtClassLoader、AppClassLoader、用户自定义ClassLoader
 *  2.2 双亲委派
 *  2.3 沙箱安全机制
 *
 * 3 Native 本地方法
 *  3.1 native是一个关键字
 *  3.2 声明有，实现无：因为调用的是底层的其他语言的方法
 *
 * 4 PC寄存器
 *  4.1 记录了方法之间的调用和执行情况，类似排版值日表
 *      用来存储指向下一条指令的地址，也即将要执行的指令代码，它是当前线程所执行的字节码的行号指示器 *
 *
 * 5 方法区
 *  5.1 它存储了每一个类的结构信息
 *  5.2 方法区是规范，在不同虚拟机里面实现是不一样的，最典型的就是永久代（PermGen space）和元空间（Metaspace）。
 *
 *  方法区 f = new 永久代     java.17
 *  方法区 f = new 元空间     java1.8
 *
 * 6 stack 栈
 *  6.1 栈管运行，堆管存储
 *  6.2 栈保存什么东西？
 *          8种基本类型 + 引用类型 + 实例方法
 *
 * 7 heap 堆
 *
 * 8 heap --> 对象的生命周期 -> OOM
 *  8.1 老师讲解的heap结构是否正确？
 *  8.2
 *
 */
public class JVMNote {

    public int add(int x, int y) {
        int result = -1;
        result = x + y;
        return result;
    }

    public static void method01(){
        method01();
    }

    public static void main(String[] args) {
        //不停的往 栈里面压方法，直至 超过了栈的最大限制
        //Exception in thread "main" java.lang.StackOverflowError
        //method01();

        System.out.println("进程数量：" + Runtime.getRuntime().availableProcessors());
        long maxMemory = Runtime.getRuntime().maxMemory() ;//返回 Java 虚拟机试图使用的最大内存量。
        long totalMemory = Runtime.getRuntime().totalMemory() ;//返回 Java 虚拟机中的内存总量。
        System.out.println("MAX_MEMORY = " + maxMemory + "（字节）\t" + (maxMemory / (double)1024 / 1024) + "MB");
        System.out.println("TOTAL_MEMORY = " + totalMemory + "（字节）\t" + (totalMemory / (double)1024 / 1024) + "MB");

        //[Full GC (Allocation Failure) Exception in thread "main" java.lang.OutOfMemoryError: Java heap space

        byte[] bytes = new byte[40 * 1024 * 1024];

        String str = "";
        while (true) {
            str += str + new Random().nextInt(88888888) + new Random().nextInt(9999999);
        }


    }
}
