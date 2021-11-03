package com.base.web.异常;

public class Test {

    private static int num = 0;

    public static void main(String[] args) {
        try{
            //int i = 1/0;
            System.out.println(number());
            System.out.println("----------");
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }

    public static Integer number(){
        try{
            // 此处返回1
            return ++num;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            //此处返回2
            return ++num;
        }
    }
}
