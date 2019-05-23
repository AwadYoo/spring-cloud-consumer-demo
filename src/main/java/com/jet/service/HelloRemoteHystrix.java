package com.jet.service;

import org.springframework.stereotype.Service;

/**
 * 创建回调类，实现回调方法
 *
 * @author awad_yoo
 * @create 2019-05-23 13:45
 */
@Service
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello(String name) {
        return "hello " + name + ",此消息接收说明接口调用失败了！";
    }
}
