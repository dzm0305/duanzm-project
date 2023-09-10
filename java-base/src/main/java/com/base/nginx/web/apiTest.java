package com.base.nginx.web;

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
public class apiTest {

    @ResponseBody
    @RequestMapping("/api1/queryInfo")
    public String queryInfo1() {
        return "api1-8081服务器";
    }


    @ResponseBody
    @RequestMapping("/api2/queryInfo")
    public String queryInfo2() {
        return "api2-8081服务器";
    }

    @ResponseBody
    @RequestMapping("/api3/queryInfo")
    public String queryInfo3() {
        return "api3-8081服务器";
    }

    @ResponseBody
    @RequestMapping("/api4/queryInfo")
    public String queryInfo4() {
        return "api4-8081服务器";
    }

    @ResponseBody
    @RequestMapping("/api5/user/queryInfo")
    public String queryInfo5() {
        return "api5-8081服务器";
    }

    @ResponseBody
    @RequestMapping("/api6/queryInfo")
    public String queryInfo6() {
        return "api6-8081服务器";
    }

    @ResponseBody
    @RequestMapping("/api7/queryInfo")
    public String queryInfo7() {
        return "api7-8081服务器";
    }

    @ResponseBody
    @RequestMapping("/api8/queryInfo")
    public String queryInfo8() {
        return "api8-8081服务器";
    }

    @ResponseBody
    @RequestMapping("/queryInfo")
    public String queryInfo() {
        return "没有api-8081服务器";
    }

    @ResponseBody
    @RequestMapping("/user/queryInfo")
    public String queryInfoUser() {
        return "/user/queryInfo-8081服务器";
    }

    @ResponseBody
    @RequestMapping("/userqueryInfo")
    public String queryInfoApiUser() {
        return "/userqueryInfo-8081服务器";
    }
}
