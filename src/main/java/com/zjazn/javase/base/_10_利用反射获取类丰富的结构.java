package com.zjazn.javase.base;

import com.sun.org.glassfish.external.arc.Taxonomy;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.reflect.*;

public class _10_利用反射获取类丰富的结构  {
    /**
     * 获取属性
     */
    @Test
    public void run1() throws Exception{
        Class clazz = Wo.class;
        //获取的自己及父类的public属性
        Field[] fields = clazz.getFields();
        for (Field field: fields) {
            System.out.println(field);
        }
        System.out.println("===========================");
       //获取自己的所有访问权限的变量
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field: declaredFields) {
            int modifiers = field.getModifiers();
            Class<?> type = field.getType();
            String name = field.getName();
            //输出示例：public	class java.lang.String	name
            System.out.println(Modifier.toString(modifiers) +"\t"+type+"\t"+name);
        }
        System.out.println("=====================");
        //常用操作
        Wo wo = (Wo) clazz.newInstance();
        Field age = clazz.getDeclaredField("age"); //获取到了但还没解锁访问
        age.setAccessible(true); //解锁访问，使可访问
        age.set(wo,18); //设置指定实例中指定变量的值
        System.out.println(age.get(wo)); //获取指定实例指定变量的值
    }



    /**
     * 获取方法  如何调用私有方法与static修饰的方法，它们是存在不同的
     */
    @Test
    public void run2() throws Exception{
        Class clazz = Prosonx.class;
        Prosonx o = (Prosonx)clazz.newInstance();
        Method m = clazz.getDeclaredMethod("clever", int.class, int.class);
        m.setAccessible(true);
        System.out.println("=====开始获取方法的结构====");
        Annotation[] annotations = m.getAnnotations();
        for (Annotation annotation: annotations) {
            System.out.println(annotation);
        }
        System.out.print(Modifier.toString(m.getModifiers())+"\t"+m.getReturnType()+"\t"+m.getName()+" (");
        Parameter[] parameters = m.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            if (i == parameters.length-1) {
                System.out.print(parameters[i].getType()+"  "+parameters[i].getName());
                break;
            }
            System.out.print(parameters[i].getType()+"  "+parameters[i].getName()+",");
        }
        System.out.println(") {...}");
        System.out.println("=====开始调用方法====");
        m.invoke(o,1,2);


        System.out.println("==============常用===========");
        clazz = Wo.class;
        Wo wo = (Wo) clazz.newInstance();
        Method say = clazz.getDeclaredMethod("say");//参数以String.class，int.class形式设置
        say.setAccessible(true);
        say.invoke(wo);//有参接着传参
        System.out.println("----开始调用static方法---");
        Method saying = clazz.getDeclaredMethod("saying", String.class);
        saying.setAccessible(true);
        saying.invoke(Wo.class,"大家好~");



    }

    /**
     * 获取构造方法
     */
    @Test
    public void run3() throws Exception{
        Class clazz = Wo.class;
        //获取自己的public修饰的构造器
        Constructor constructor = clazz.getConstructor();
        Wo o = (Wo) constructor.newInstance();
        System.out.println(o);

        //调用私有构造器
        Constructor _constructor = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        _constructor.setAccessible(true);
        Wo obj = (Wo) _constructor.newInstance("大聪明", 18, "温暖，声音超好听！");
        System.out.println(obj);
        System.out.println("=====常用=====");
        Wo o1 = (Wo)clazz.newInstance();
        o1.say();

    }
    /**
     * 获取继承的父类的泛型
     */
    @Test
    public void run4() throws Exception{
        Class clazz = Wo.class;
        //com.zjazn.javase.base.Prosonx<java.lang.String>
        ParameterizedType type = (ParameterizedType)clazz.getGenericSuperclass();
        String generic = ((Class) type.getActualTypeArguments()[0]).getName();
        System.out.println(generic);

    }

    /**
     * 获取接口、所在包、类上注解
     */
    @Test
    public void run5() throws Exception{
        Class clazz = Wo.class;
        Class[] interfaces = clazz.getInterfaces();
        System.out.println("========接口========");
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println(interfaces[i]);
        }
        System.out.println("========包========");
        Package pack = clazz.getPackage();
        System.out.println(pack.getName());
        System.out.println("========注解========");
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }

    }
    @Test
    public void run6() throws Exception {
        Class clazz = Class.forName("com.zjazn.javase.base.Wo");
        Wo wo = (Wo) clazz.newInstance();
        System.out.println(wo);
    }

}
@Taxonomy
class Wo extends Prosonx<String> implements Prosony {
    public String name;
    private int age;
    protected String description;
    public Wo() {

    }
    private Wo(String name, int age, String description) {
        this.name=name;
        this.age=age;
        this.description=description;
    }
    @Override
    public void say() {
        System.out.println("我会说话");
    }
    public static void saying(String say_str) {
        System.out.println(say_str);
    }

    @Override
    public String toString() {
        return "Wo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                '}';
    }
}
class Prosonx<T> {
    public String lastname;
    @Deprecated
    public void clever(int iq, int eq) throws NullPointerException, IllegalAccessException{
        System.out.println("是一个聪明的人！，智商："+iq+", 情商："+eq);
    }
}
interface Prosony {
    public void say();

}
