package jvm;

import java.util.ArrayList;
import java.util.List;

public class MyObject {
    public static void main(String[] args) {

        //JDK自带的，类加载器走的是  Bootstrap ，但是底层是 C++ 写的，所以写的是 null
        Object obj = new Object();
        System.out.println(obj.getClass().getClassLoader());
        List list = new ArrayList();
        System.out.println(list.getClass().getClassLoader());

        System.out.println("====自定义类====");
        //自己定义的类加载器，走的是  sun.misc.Launcher$AppClassLoader@18b4aac2
        MyObject myObj = new MyObject();
        //空指针
        //System.out.println(myObj.getClass().getClassLoader().getParent().getParent().getParent());
        //---  Bootstrap -> null
        System.out.println(myObj.getClass().getClassLoader().getParent().getParent());
        //---  sun.misc.Launcher$ExtClassLoader@4554617c
        System.out.println(myObj.getClass().getClassLoader().getParent());
        //---  sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(myObj.getClass().getClassLoader());

    }
}
