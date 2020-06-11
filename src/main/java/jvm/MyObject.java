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

        //自己定义的类加载器，走的是  sun.misc.Launcher$AppClassLoader@18b4aac2
        MyObject myObj = new MyObject();
        System.out.println(myObj.getClass().getClassLoader());

    }
}
