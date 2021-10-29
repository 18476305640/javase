package com.zjazn.javase.base;
/**
 * final可以修改类，方法，变量
 *      修饰类，类不可以被继承;
 *      修饰方法，方法不可以被重写
 *      修饰变量，只要变量加载就必须要赋值，可以通过代码块或构造方法，如果同时被static修饰只能被static初始化代码块修饰了
 */
final class Base {
    //1、此类不能被继承
}
class Be {
    public final void go() {
        //2、此方法不能被重写
    }
}
public class _5_final修饰 /*extends Base*/ extends Be{


    private static final int F;
//    {  //3、静态final不能被非静态初始化代码块
//        F = 12;
//    }
    static { //3、可以
        F = 12;
    }
//    public _5_final修饰() { //3、不可以
//        this.F = 13;
//    }







}

