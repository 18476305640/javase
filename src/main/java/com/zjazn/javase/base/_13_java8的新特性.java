package com.zjazn.javase.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
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

}

