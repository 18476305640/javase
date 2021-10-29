package com.zjazn.javase.base;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class _8_反射 {
    @Test
    public void test() throws Exception{

        /**
         * 首先是要获取Class,然后再通过Class的实例，即目标的加载类，对变量，构建方法，方法进行访问。而涉及访问权限不够的，
         * 看到Constructor, Field,Method 等要调用.setAccessible(true); 的方法琰解除。
         * 特别的对于调用"具有访问权限"且"无参"的构造方法我们可以直接 加载类.newInstance() 创建类的实例。
         *
         * 无参构造方法的好处： 在创建Javabean时 & 子类加载时supper()
         *
         *
         */

        Class clazz = Proson.class; //第一种方式获取运行时类
        //Proson proson_obj1 = new Proson();
        //Class clazz = proson_obj1.getClass(); //第二种方式获取运行时类
        //Class clazz = Class.forName("com.zjazn.javase.base.Proson"); //第二种方式获取运行时类
        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true); //调用私有的关键
        Proson proson = (Proson) constructor.newInstance("大聪明", 21);
        System.out.println(proson);

        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true); //调用私有的关键
        age.set(proson, 18);
        System.out.println(proson);

        Method personality = clazz.getDeclaredMethod("personality");
        personality.setAccessible(true); //调用私有的关键
        System.out.println(personality.invoke(proson));


    }
}

class Proson {
    public String name = "小美";
    //私有的变量
    private int age = 21;

    //私有的构造方法
    public Proson() {

    }
    private Proson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //私有的方法
    private String personality() {
        return "人美，腿长，大眼睛！";
    }

    @Override
    public String toString() {
        return "Proson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}