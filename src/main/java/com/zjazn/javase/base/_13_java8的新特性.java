package com.zjazn.javase.base;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _13_java8的新特性 {
    /**
     * Lambda表达式： 为函数式interface创建一个实例
     */
    @Test
    public void test1() {
        Comparator<Integer> comparator = (o1,o2) -> {  //Lambda表达式完整式， 使用要求：函数式接口
            return o1 -o2;
        };
        Comparator<Integer> comparato2 = (o1,o2) -> o1 - o2; //{}简化要求：只有一条语句（return 要忽略）
        Consumer<String> consumer = s -> System.out.println("你好，大聪明！"); //()简化要求：只有一个参数时
    }

    /**
     * 函数式接口： 函数式接口一般会在类上加“@FunctionalInterface” 注解，用于检验。
     *         特点是：接口只有一个抽象方法，可以使用Lambda表达式
     *         作用是：可以使用Lambda表达式，除此，
     *               还内置了四个常用的函数式接口：Consumer<T>,Supplier<T>, Function<T,R>, Predicate<T>结合Lambda用于快速构建具有指定特征的实例对象。
     */
    @Test
    public void test2 () {
        //功能：筛选出含有"京"的元素
        ArrayList<String> str = new ArrayList<>();
        str.add("京东");
        str.add("北京");
        str.add("南京");
        str.add("上海");
        ArrayList<String> pick = pick(str, obj -> ((String)obj).indexOf("京") > -1);
        System.out.println(pick);

    }
    public ArrayList pick(ArrayList list, Predicate<Object> predicate) {
        ArrayList<Object> obj = new ArrayList<>();
        for (Object unit: list) {
            if (predicate.test(unit)) {
                obj.add(unit);
            }
        }
        return  obj;

    }
    /**
     * 方法引用:  Hms hms = gms :: pr;
     *          引用实质是Lambda表达式，可说是Lambda的语法糖
     *          引用gms对象中的与Hms函数接口方法的参数列表&返回值类型相同的pr方法作为方法体来构建Hms接口实例。
     *          类 :: 静态方法  || 实例 :: 静态/普通方法
     *                讲解： 都是上面的语法
     *          类 :: 普通方法
     *                讲解： 这个比较难理解， 我们可以用
     *                      接口中的   float compare(Gms gms1, Gms gms2); 方法引用的是其它类已存在的非静态方法时
     *                      引用的类一定要是Gms（作为gms1）,且引用的方法体是：
     *                               float  compareTo(Gms gms2) {...}
     *          类 :: new; 构造器引用略
     */
    @Test
    public void test3 () {
        System.out.println("----------对象 :: 实例方法-----------");
        Gms gms = new Gms(1.2f);
        Hms hms = gms :: pr;
        System.out.println("----------类 :: 静态方法-----------");
        Pms pms = Gms :: getName;
        System.out.println(pms.getName());
        System.out.println("----------类 :: 实例方法-----------");
        Oms oms = Gms::compareTo;


    }
    interface Hms {
        void pr(String str);
    }
    interface Pms {
        String  getName();
    }
    interface Oms {
        float compare(Gms gms1, Gms gms2);
    }


}
class Gms {
    void pr() {
        System.out.println("--A--");
    }
    void pr(String str) {
        System.out.println("--B--");
        System.out.println(str);
    }

    float v;
    public Gms(float v) {
        this.v = v;
    }
    float  compareTo(Gms gms2) {
        return v - gms2.v;
    }

    static final String name = "谷歌GMS";
    static String  getName() {
        return name;
    }

}


/**
 * 除了上面说的，还有StreamAPI等JAVA8的新特性
 * 继续学习请转自哔哩哔哩： https://www.bilibili.com/video/BV1Kb411W75N?p=677
 */