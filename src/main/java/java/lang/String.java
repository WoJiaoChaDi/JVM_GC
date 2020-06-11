package java.lang;

public class String {

    //由于存在双亲委派，会从Bootstrap类往下找，找到类后，就不会再往下找了
    //
    //错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
    //public static void main(String[] args)
    //否则 JavaFX 应用程序类必须扩展javafx.application.Application

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
