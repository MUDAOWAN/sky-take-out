package com.sky.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;


import java.util.HashMap;
import java.util.Map;

@RestController
//检测本地阿里云accesskeyID和secret是否生效
//通过访问 http://localhost:8080/debug/oss-config查看配置读取情况。
public class ConfigCheckController {

    @Value("${sky.alioss.access-key-id:NOT_FOUND}")
    private String accessKeyId;

    @Value("${sky.alioss.access-key-secret:NOT_FOUND}")
    private String accessKeySecret;

    @Value("${sky.alioss.endpoint:NOT_FOUND}")
    private String endpoint;

    @GetMapping("/debug/oss-config")
    public Map<String, String> debugOssConfig() {
        Map<String, String> config = new HashMap<>();
        config.put("accessKeyId", accessKeyId);
        config.put("accessKeySecret", accessKeySecret);
        config.put("endpoint", endpoint);
        config.put("environmentVariable", System.getenv("ALIBABA_ACCESS_KEY_ID"));
        return config;
    }
}
