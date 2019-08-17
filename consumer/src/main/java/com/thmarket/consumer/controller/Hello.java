package com.thmarket.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.thmarket.consumer.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @Autowired
    com.thmarket.consumer.remote.HelloRemote HelloRemote;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return HelloRemote.hello(name);
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/fail")
    public String tryFail() {
        return HelloRemote.tryFail();
    }

    String fallback() {
        return "服务器繁忙";
    }
}
