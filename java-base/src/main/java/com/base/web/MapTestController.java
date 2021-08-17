package com.base.web;

import com.base.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/map/test")
public class MapTestController {

    /**
     * Map排序
     * @return
     */
    @ResponseBody
    @RequestMapping("/sort")
    public HashMap<Integer, UserVo> sort(){
        HashMap<Integer, UserVo> map = new HashMap<Integer, UserVo>();
        map.put(1, new UserVo("xiaoba", 18));
        map.put(2, new UserVo("xiaoliu", 16));
        map.put(3, new UserVo("xiaojiu", 19));
        map.put(4, new UserVo("xiaoqi", 17));
        System.out.println(map);
        Set<Map.Entry<Integer, UserVo>> entries = map.entrySet();
        ArrayList<Map.Entry<Integer, UserVo>> list = new ArrayList<>(entries);
        System.out.println("------------------------------------");
        System.out.println(list);
        Collections.sort(list, new Comparator<Map.Entry<Integer, UserVo>>() {
            @Override
            public int compare(Map.Entry<Integer, UserVo> o1, Map.Entry<Integer, UserVo> o2) {
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });
        LinkedHashMap<Integer, UserVo> integerUserVoLinkedHashMap = new LinkedHashMap<>();
        for(Map.Entry<Integer, UserVo> entry : list){
            integerUserVoLinkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return integerUserVoLinkedHashMap;
    }
}
