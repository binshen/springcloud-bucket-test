package com.thmarket.producer.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @ApolloConfig
    private Config config;

    @Value("${userName}")
    private String userName;

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "Hello " + name + "，you age is " + config.getProperty("userAge", "25") + ". This is built by " + userName;
    }

    @RequestMapping("/fail")
    public String fail() {
        return "Tested Fail Succefully";
    }
}
