package com.base.web.java8.lambda表达式;

@FunctionalInterface
public interface MyFunc<T> {

    public T getValue(T t);
}
