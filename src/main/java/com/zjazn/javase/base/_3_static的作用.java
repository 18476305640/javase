package com.zjazn.javase.base;

public class _3_static的作用 {
    /**
     *被"static"修饰的变量是随类的加载而加载的，且类加载先于对象的创建。
     *  所以被”static“修饰的变量叫”类变量“,不被~的叫”实例变量“
     *  所以我们可以通过"类.类变量名|类.静态方法名"、“实例.变量名|实例.方法名”来调用类变量
     *  所以被static修饰的方法是无法获取“实例变量“的
     *  所以类变量只会加载一次（因为类只加载一次），共实例对象共同
     *  所以当方法不用操作实例变量或说操作静态变量的，只操作传入参数的，就可以考虑将方法设为静态的方法
     */
    public static int ZJAZN = 129;
    //静态代码块
    static {
        ZJAZN++;
    }
    public  int getStaticVal() {
        return ZJAZN;
    }
    public  void setStaticVal(int new_val) {
        ZJAZN = new_val;
    }
//    int x= 1;
//    public static void test() {
//        System.out.println(x);
//    }

    /**
     * 很好的一个示例
     * @param args
     */
    public static void main(String[] args) {
        _3_static的作用 o1 = new _3_static的作用();
        o1.setStaticVal(55);
        _3_static的作用 o2 = new _3_static的作用();
        System.out.println(o2.getStaticVal());

    }
}
