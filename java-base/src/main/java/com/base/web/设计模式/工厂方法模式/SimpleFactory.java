package com.base.web.设计模式.工厂方法模式;

import java.util.Map;

/**
 * 简单工厂，并不是设计模式，只是一种编程习惯
 */
public class SimpleFactory {
    public static void main(String[] args) {
        Application application = new Application();
        Produce produce = application.getObject("B");
        produce.getMethod();
    }

}

interface Produce{
    public void getMethod();
}

class ProduceA implements Produce{
    @Override
    public void getMethod() {
        System.out.println("执行 A 方法");
    }
}

class ProduceB implements Produce{
    @Override
    public void getMethod() {
        System.out.println("执行 B 方法");
    }
}

class Application{
    private Produce createProduce(String type){
        return SimpleFactory2.createProduce(type);
    }
    public Produce getObject(String type){
        Produce produce = createProduce(type);
        return produce;
    }
}

class SimpleFactory2{
    public static Produce createProduce(String type){
        if("A".equals(type)){
            return new ProduceA();
        }else if("B".equals(type)){
            return new ProduceB();
        }else {
            return null;
        }
    }
}