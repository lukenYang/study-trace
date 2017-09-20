package com.deep.web.http.controller;

import com.deep.service.test.TestService;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by yangliuhua on 2017-6-6.
 */

@Controller
@RequestMapping(value = "/api/test")
public class TestController {

    @Resource
    private TestService testService;


    @RequestMapping("/getTest1.do")
    public Object test1() {

        return "success";
    }

    @RequestMapping("/getTest2.do")
    @ResponseBody
    public Object test2() {
        Map<String, String> map = Maps.newHashMap();
        map.put("1", "12312");
        map.put("2", "232132");
        map.put("3", "123132132112");
        String string = null;
        try {
//            string = testService.getString();
            testService.addEntity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("testService", "32");
        return map;
    }
}
