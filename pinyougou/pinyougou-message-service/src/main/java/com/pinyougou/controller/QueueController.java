package com.pinyougou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/message")
public class QueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping(value = "/send")
    public String sendMessage(){
        Map<String,String> dataMap = new HashMap<String, String>();

        dataMap.put("mobile","15027007457");
        dataMap.put("templateCode","SMS_154950909");
        dataMap.put("signName","阿里云短信测试");
        dataMap.put("param","{\"code\":\"1234\"}");

        jmsMessagingTemplate.convertAndSend("message-list",dataMap);

        return "success";
    }
}
