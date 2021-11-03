package com.base.web.泛型;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 *     一、Java泛型这个特性是从JDK1.5开始加入的，为了兼容以前的版本，Java泛型的实现采取了"伪泛型"的策略，即Java在语法上支持泛型，
 *  但在编译阶段会进行"类型擦出"，将所有的泛型表示（<>中的内容）都替换为具体的类型，就像完全没有泛型一样。
 *     二、泛型的类型擦除原则是：
 *      1、消除类型参数声明，即删除<>及其包围的部分。
 *      2、根据类型参数的上下界推断并替换所有的类型参数为原生态类型：如果类型参数是无限制通配符或没有上下界限定则替换为Object，如果存在上下界限定则根据子类替换原则取类型参数的最左边限定类型（即父类）。
 *      3、为了保证类型安全，必要时插入强制类型转换代码。
 *      4、自动产生“桥接方法”以保证擦除类型后的代码仍然具有泛型的“多态性”。
 * */
public class 泛型擦除 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(2);

        List<String> list2 = new ArrayList<String>();
        list2.add("aa");


        //验证类型擦出。说明泛型类型String和Integer都被擦除掉了，只剩下原始类型
        System.out.println("-------------");
        System.out.println(list1.getClass() == list2.getClass());// true
        System.out.println("-------------");

        /**-------------通过反射添加其他元素------------------------**/
        list1.getClass().getMethod("add", Object.class).invoke(list1, "gjhg");
        for(int i = 0; i < list1.size(); i++){
            System.out.println(list1.get(i));
        }
    }

}

