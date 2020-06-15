package jvm;

class Mother {
    private int i = test();
    private int j = method();
    private static int k = method2();

    static {
        System.out.print("(M1)");
    }

    Mother(){
        System.out.print("(M2)");
        System.out.print("||");
    }

    {
        System.out.print("(M3)");
    }

    public int test(){
        System.out.print("(M4)");
        return 1;
    }

    public static int method() {
        System.out.print("(M5)");
        return 1;
    }
    public static int method2() {
        System.out.print("(M6)");
        return 1;
    }
}

class Father {

    private int i = test();
    private int j = method();
    private static int k = method2();

    static {
        System.out.print("(1)");
    }

    Father(){
        System.out.print("(2)");
        System.out.print("||");
    }

    {
        System.out.print("(3)");
    }

    public int test(){
        System.out.print("(4)");
        return 1;
    }

    public static int method() {
        System.out.print("(5)");
        return 1;
    }
    public static int method2() {
        System.out.print("(6)");
        return 1;
    }
}

class Son extends Father {
    private int i = test();
    private int j = method();
    private static int k = method2();

    static {
        System.out.print("(7)");
    }

    Son(){
        System.out.print("(8)");
        System.out.print("||");
    }

    {
        System.out.print("(9)");
    }

    public int test(){
        System.out.print("(10)");
        return 1;
    }

    public static int method() {
        System.out.print("(11)");
        return 1;
    }

    public static int method2() {
        System.out.print("(12)");
        return 1;
    }
}


public class ClassLoadSequence {

    static {
        System.out.print("(13)");
    }

    private int i = test();
    private int j = method();
    private static int k = method2();

    ClassLoadSequence(){
        System.out.print("(14)");
        System.out.print("||");
    }

    {
        System.out.print("(15)");
    }

    public int test(){
        System.out.print("(16)");
        return 1;
    }

    public static int method() {
        System.out.print("(17)");
        return 1;
    }
    public static int method2() {
        System.out.print("(18)");
        return 1;
    }

    public static void main(String[] args) {

        System.out.println("---1");
        Son s1 = new Son();
        System.out.println("---2");
        Father f1 = new Father();
        System.out.println("---3");
        Son s2 = new Son();
        System.out.println("---4");
    }

    //执行结果
    //(13)(18)---1
    //(6)(1)(12)(7)(10)(5)(3)(2)||(10)(11)(9)(8)||---2
    //(4)(5)(3)(2)||---3
    //(10)(5)(3)(2)||(10)(11)(9)(8)||---4
}
