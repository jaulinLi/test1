package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao {
    /**
     * 根据用户名查询用户是否存在
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 保存用户信息
     * @param user
     */
    public void save(User user);

    /**
     * 根据激活码查询用户是否存在
     * @return
     */
    User findByCode(String code);

    /**
     * 更新激活状态
     */
    void updateStatus(User user);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username, String password);
}
