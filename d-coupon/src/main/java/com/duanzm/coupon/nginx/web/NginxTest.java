package com.duanzm.coupon.nginx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author duanzm
 * @Date 2023/3/26 上午11:38
 * @Version 1.0
 **/
@Controller
@RequestMapping("/nginx")
public class NginxTest {

    @ResponseBody
    @RequestMapping("/queryInfo")
    public String queryInfo() {
        return "7071服务器";
    }
}
