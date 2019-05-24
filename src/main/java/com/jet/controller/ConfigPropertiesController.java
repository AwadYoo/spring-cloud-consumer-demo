package com.jet.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author awad_yoo
 * @create 2019-05-24 13:29
 */
@RestController
public class ConfigPropertiesController {

    @Value("${server.port}")
    private String msg;

    @GetMapping("/configMsg")
    public String configMsg() {
        return msg;
    }

}
