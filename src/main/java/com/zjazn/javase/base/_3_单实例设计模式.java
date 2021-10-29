package com.zjazn.javase.base;

/**
 * 实例模式： 也就是创建一个只有一个实例的类
 *      创建实例单例类有两种：饿汉式vs懒汉式，但本质都是将构建方法设为私有，让外部无法能来new来创建，获取实例的方法通过类方法来获取，且获取的是同一个实例。
 *      懒汉式线程是不安全的。
 */
public class _3_单实例设计模式 {
    public static void main(String[] args) {
        Bride bride1 = Bride.getBride();
        Bride bride2 = Bride.getBride();
        System.out.println(bride1.equals(bride2)); //true
        _Bride _bride1 = _Bride.getBride();
        _Bride _bride2 = _Bride.getBride();
        System.out.println(_bride1.equals(_bride2)); //true

    }
}
/**
 * 饿汉式创建单实例：提前创建
 */
class Bride {
    private Bride(){

    }
    private static Bride bride = new Bride();

    public static Bride getBride() {
        return bride;
    }
}

/**
 * 懒汉式创建单实例：当需要时才创建
 */
class _Bride {
    private _Bride(){

    }
    private static _Bride bride = null;

    public static _Bride getBride() {
        if (bride == null) {
            bride = new _Bride();
        }
        return bride;
    }
}
