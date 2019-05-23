package com.jet.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spring-cloud-provider", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    @GetMapping("/hello")
    String hello(@RequestParam(value = "name") String name);
}
