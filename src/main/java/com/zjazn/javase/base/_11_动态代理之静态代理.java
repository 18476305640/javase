package com.zjazn.javase.base;

public class _11_动态代理之静态代理 {
    public static void main(String[] args) {
        NikeClothFactory nike = new NikeClothFactory();
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        proxyClothFactory.produceCloth();
    }
}

interface ClothFactory {
    void produceCloth();
}
//代理类
class ProxyClothFactory implements ClothFactory {
    private ClothFactory factory;
    public ProxyClothFactory(ClothFactory clothFactory) {
        this.factory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("开始准备请人做事！");
        factory.produceCloth();
        System.out.println("他已经做好了！");
    }
}
//被代理类
class NikeClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("正在生产nike!");
    }
}

