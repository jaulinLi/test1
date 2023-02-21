package com.pinyougou.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.pinyougou.mapper.UserMapper;
import com.pinyougou.model.User;
import com.pinyougou.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.DigestUtils;

import javax.jms.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Destination destination;

    @Value("${template_code}")
    private String templateCode;

    @Value("${sign_name}")
    private String signName;




    /**
     * 创建验证码
     * @param phone
     * @return
     */
    @Override
    public void createCode(String phone) throws Exception {
        //生成4位以内随机数
        //String code = String.valueOf((int)(Math.random()*10000));
        String code = "1234";
        //存入Redis缓存
        redisTemplate.boundHashOps("MobileInfo").put(phone,code);

        //将code存入到Map中，然后转成JOSN
        Map<String,String> dataMap = new HashMap<String,String>();
        dataMap.put("code",code);
        String json = JSON.toJSONString(dataMap);

        sendMessage(phone, json);
    }

    /***
     * 消息发送
     * @param phone
     * @param json
     * @throws JMSException
     */
    public void sendMessage(final String phone, final String json) throws JMSException {
        //将消息发送给ActiveMQ
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                //创建MapMessage
                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setString("signName",signName);
                mapMessage.setString("templateCode",templateCode);
                mapMessage.setString("mobile",phone);
                mapMessage.setString("param",json);
                return mapMessage;
            }
        });
    }

    @Override
    public int getUserByUserName(String username) {
        User user = new User();
        user.setUsername(username);

        return userMapper.selectCount(user);
    }

    @Override
    public int getUserByPhone(String phone) {
        User user = new User();
        user.setPhone(phone);
        return userMapper.selectCount(user);
    }

    @Override
    public Boolean checkCode(String phone, String code) {

        String redisCode = (String) redisTemplate.boundHashOps("MobileInfo").get(phone);
        if (redisCode==null){
            return false;
        }
        if (!redisCode.equals(code)){
            return false;
        }

        return true;
    }

    @Override
    public User findUserByUserName(String name) {
        User user = new User();
        user.setUsername(name);
        return userMapper.selectOne(user);
    }

    /***
     * 增加User信息
     * @param user
     * @return
     */
    @Override
    public int add(User user) {

        Date date = new Date();
        user.setCreated(date);
        user.setUpdated(date);

        String pwd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(pwd);

        int sount = userMapper.insertSelective(user);
        if (sount>0){
            redisTemplate.boundHashOps("MobileInfo").delete(user.getPhone());
        }
        return sount;
    }

}
