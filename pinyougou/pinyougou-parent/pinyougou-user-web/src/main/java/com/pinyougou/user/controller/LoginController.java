package com.pinyougou.user.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/name")
    public Map<String,String> loginName(){

        Map<String ,String> dataMap = new HashMap<String, String>();
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        dataMap.put("loginName",name);
        return dataMap;
    }
}
