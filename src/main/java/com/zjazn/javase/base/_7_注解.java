package com.zjazn.javase.base;

import java.lang.annotation.*;

/**
 * 使用注解
 */
@MyAnnonation("Hello")
public class _7_注解 {

}

/**
 * 定义了一个注解， @interface与class，interface同级的关键字
 * 元注解：
 *      @Retention   注解的生命周期
 *      @Target      能修饰的类型
 *      @Documented  注解在被javadoc解析时，保留下来
 *      @Inherited   被修饰类的子类也会继承，具有继承性
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE})
@Documented
@Inherited
@interface MyAnnonation {
    String value() default "Hello";
}
