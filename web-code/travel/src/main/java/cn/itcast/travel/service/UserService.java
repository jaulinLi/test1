package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

public interface UserService {

    /**
     * 用户注册
     * @param user
     * @return
     */
    public boolean registService(User user);

    /**
     * 激活
     * @param code
     * @return
     */
    Boolean active(String code);

    /**
     * 根据用户名和密码查询用户
     * @param user
     * @return
     */
    User login(User user);
}
