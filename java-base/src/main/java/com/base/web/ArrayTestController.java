package com.base.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("/array/test")
public class ArrayTestController {

    /**
     * 用面向对象的方法求出给定数组中重复 VALUE 的个数。
     */
    @ResponseBody
    @RequestMapping("/countNum")
    public void countNum(){
        int[] arr = {2, 4, 5, 6, 7, 8, 9, 4, 2, 1, 3, 4, 5, 8, 1, 3, 3, 2};
        Map<Integer, Integer> result = new TreeMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++){
            if(result.containsKey(arr[i])){
                result.put(arr[i], result.get(arr[i]) + 1);
            }else{
                result.put(arr[i], 1);
            }
        }
        System.out.println(result);
    }
}
