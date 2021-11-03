package com.base.web.设计模式.工厂方法模式;

import org.apache.tomcat.jni.Proc;

/**
 * 工厂方法模式：
 *      定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法模式使得一个类的实例化延迟到子类
 * 应用场景：
 *  1、当你不知道该使用对象的确切类型的时候
 *  2、当你希望为库或框架提供扩展其内部组件的方法时
 * 主要优点：
 *  1、将具体产品和创建者解耦
 *  2、符合单一职责原则
 *  3、符合开闭原则
 *
 * 源码中的应用；
 *  java api
 *  静态工厂方法
 *  Calendar.getInstance()
 *  java.text.NumberFormat.getInstance()
 *  java.util.ResourceBundle.getBundle()
 *
 *  工厂方法
 *  java.net.URLStreamHandlerFactory
 *  java.xml.bind.JAXBContext.createMarshaller
 *
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Application2 application2 = new ConcreateProduceB();
        Produce2 produce2 = application2.getProduce();
        produce2.getMethod();
    }
}

interface Produce2{
    public void getMethod();
}

class Produce2A implements Produce2{

    @Override
    public void getMethod() {
        System.out.println("执行2A方法");
    }
}

class Produce2B implements Produce2{

    @Override
    public void getMethod() {
        System.out.println("执行2B方法");
    }
}

abstract class Application2{
    abstract Produce2 createProduce();

    public Produce2 getProduce(){
        Produce2 produce2 = createProduce();
        return produce2;
    }
}

class ConcreateProduceA extends Application2{

    @Override
    Produce2 createProduce() {
        return new Produce2A();
    }
}

class ConcreateProduceB extends Application2{

    @Override
    Produce2 createProduce() {
        return new Produce2B();
    }
}