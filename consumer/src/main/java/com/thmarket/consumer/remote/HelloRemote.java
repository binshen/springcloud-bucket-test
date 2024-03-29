package com.thmarket.consumer.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="springcloud-eureka-producer")
public interface HelloRemote {

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/fail2") // @RequestMapping(value = "/fail")
    public String tryFail();
}