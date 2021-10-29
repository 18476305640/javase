package com.zjazn.javase.base;

import org.junit.Test;

public class _1_junit {
    /**
     * 首先引入junit包，然后在要测试的方法前中“@Test” 注解即可！
     */
    @Test
    public void junit_test() {
        String s1 = "1";
        String s2 = "1";
        System.out.println(s1.equals(s2));

    }
}
