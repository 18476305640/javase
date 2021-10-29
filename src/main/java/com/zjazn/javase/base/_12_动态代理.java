package com.zjazn.javase.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.function.Consumer;

interface Proson_i {
    String say(String str);
}
class Proson_o implements Proson_i{

    @Override
    public String say(String str) {
        System.out.println("已调用！");
        return "你好，猪猪,我是"+str;
    }
}
public class _12_动态代理 {
    public static void main(String[] args) {
        Proson_o proson_o = new Proson_o();
        Proson_i proxyInstance = (Proson_i) ProxyFactory.getProxyInstance(proson_o);
        System.out.println(proxyInstance.say("大聪明"));
    }
}

class ProxyFactory {
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandle invocationHandle = new MyInvocationHandle(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),invocationHandle );
    }

}

class MyInvocationHandle implements InvocationHandler {
    private Object obj;
    public MyInvocationHandle(Object obj) {
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+"-method-invoke-before~"); //AOP
        Object invoke = method.invoke(obj, args);
        System.out.println(method.getName()+"-method-invoke-after~"); //AOP
        return invoke;

    }
}

