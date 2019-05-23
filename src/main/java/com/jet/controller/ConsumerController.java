package com.jet.controller;

import com.jet.service.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author awad_yoo
 * @create 2019-05-23 11:56
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloRemote helloRemote;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return helloRemote.hello(name);
    }

}
