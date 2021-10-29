package com.zjazn.javase.base;

public class _4_初始化代码块 {
    /**
     * {}是初始化代码块，并用于初始化变量。它是自动执行的，只能由static修饰。
     */
    private static String sb = "";
    static {
        sb = "随类的加载而执行且执行一次";
    }

    {
        sb = "每实例一次就执行一次";
    }
}
