package com.pinyougou.user.service;

import com.pinyougou.model.User;

public interface UserService {

    /***
     * 增加User信息
     * @param user
     * @return
     */
    int add(User user);


    /**
     * 创建验证码
     * @param phone
     * @return
     */
    void createCode(String phone) throws Exception;

    /**
     * 根据用户名查询用户是否存在
     * @param username
     * @return
     */
    int getUserByUserName(String username);

    /**
     * 根据手机号查询用户是否存在
     * @param phone
     * @return
     */
    int getUserByPhone(String phone);

    /**
     * 判断验证码是否相同
     * @param phone
     * @param code
     * @return
     */
    Boolean checkCode(String phone, String code);

    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    User findUserByUserName(String name);
}
