package com.zjazn.javase.base;

public class _2_包装类的一个坑 {
    /**
     * 我们要知道
     * Integer m = 1; //自动装箱
     * 与
     * Integer m = new Integer(1);
     * 是不一样的，凡是new出来的相比较是比地址的，
     * 而Integer m = 1;内部声明了一个IntegerCache的缓存,从这个范围中找的（-128~127），超出后才通过new的方式。所以后面两个不相等
     * @param args
     */
    public static void main(String[] args) {
        Integer x = new Integer(1);
        Integer y = new Integer(1);
        System.out.println(x==y); //false
        Integer m = 1;
        Integer n = 1;
        System.out.println(m==n); //true
        Integer o = 128;
        Integer p = 128;
        System.out.println(o==p); //false



    }
}
