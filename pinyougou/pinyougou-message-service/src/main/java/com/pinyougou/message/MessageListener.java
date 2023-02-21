package com.pinyougou.message;


import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MessageListener {

    @Autowired
    private MessageSender messageSender;

    @JmsListener(destination = "message-list")
    public void readMessage(Map<String,String> map) throws ClientException {
        String mobile = map.get("mobile");
        String templateCode = map.get("templateCode");
        String signName = map.get("signName");
        String param = map.get("param");

        messageSender.sendSms(mobile,templateCode,signName,param);
    }

}
