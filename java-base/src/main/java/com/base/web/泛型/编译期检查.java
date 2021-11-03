package com.base.web.泛型;

import java.util.ArrayList;
import java.util.List;

public class 编译期检查 {

    //既然有泛型擦出，那为什么我们往 ArrayList 创建的对象中添加整数会报错呢？不是说泛型变量String会在编译的时候变为Object类型吗？
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        //list.add(1); //编译报错，因此泛型变量的使用，是会在编译之前检查的。

        //类型检查就是编译时完成的，new ArrayList()只是在内存中开辟了一个存储空间，可以存储任何类型对象，
        //而真正设计类型检查的是它的引用，因为我们是使用它引用list1来调用它的方法，比如说调用add方法，所以list2引用能完成泛型类型的检查。
        //而引用list3没有使用泛型，所以不行。
        List<String> list2 = new ArrayList<>(); // 第一种情况
        //list2.add(32);  //编译报错
        List list3 = new ArrayList<String>();   // 第二种情况
        list3.add(32);
        //类型检查就是针对引用的，谁是一个引用，用和这个引用调用泛型方法，就会对这个引用调用的方法进行类型检查，而无关它真正的引用的对象。
    }
}
