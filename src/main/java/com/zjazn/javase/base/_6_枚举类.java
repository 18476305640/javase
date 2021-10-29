package com.zjazn.javase.base;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * 当要定义一组常量时强烈推荐使用枚举类,
 * 一般使用enum代替class, 上来直接常量名(构建参)， 与定义外部不可以见的常量与构造方法
 */
class test {
    
    public static void main(String[] args) {
        _6_枚举类 spring = _6_枚举类.SPRING;
        System.out.println(spring);

        _6_使用enum创建枚举类 spring1 = _6_使用enum创建枚举类.SPRING;
        System.out.println(spring1);
        System.out.println("--valueOf--");
        System.out.println(_6_使用enum创建枚举类.valueOf("SPRING"));
        System.out.println("--values--");
        _6_使用enum创建枚举类[] values = _6_使用enum创建枚举类.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

    }
}

/**
 * 使用enum创建枚举类
 */
enum _6_使用enum创建枚举类 {
    SPRING("有天","春暖花开"),
    SUMMER("夏天","春暖花开"),
    AUTUMN("秋天","春暖花开"),
    WINTER("冬天","春暖花开");
    private final String SEASON;
    private final String  DESCRIPTION;
    private  _6_使用enum创建枚举类(String SEASON, String DESCRIPTION) {
        this.SEASON = SEASON;
        this.DESCRIPTION = DESCRIPTION;
    }
    public String getSEASON() {
        return SEASON;
    }

    @Override
    public String toString() {
        return "_6_使用enum创建枚举类{" +
                "SEASON='" + SEASON + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                '}';
    }
}

/**
 * 自定义枚举类
 */
class _6_枚举类 {
    private final String SEASON;
    private final String  DESCRIPTION;
    private _6_枚举类(String SEASON, String  DESCRIPTION) {
        this.SEASON=SEASON;
        this.DESCRIPTION=DESCRIPTION;
    }

    public static final _6_枚举类 SPRING= new _6_枚举类("有天","春暖花开");
    public static final _6_枚举类 SUMMER= new _6_枚举类("夏天","春暖花开");
    public static final _6_枚举类 AUTUMN= new _6_枚举类("秋天","春暖花开");
    public static final _6_枚举类 WINTER= new _6_枚举类("冬天","春暖花开");

    public String getSEASON() {
        return SEASON;
    }

    @Override
    public String toString() {
        return "_6_枚举类{" +
                "SEASON='" + SEASON + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                '}';
    }
}
