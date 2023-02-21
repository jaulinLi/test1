package cn.itcast.service;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 查询用户列表
     * @return
     */
    List<User> findAll();

    /**
     * 添加用户
     * @param addUser
     */
    void add(User addUser);

    /**
     * 删除当前用户
     * @param id
     */
    void delete(String id);

    /**
     * 修改用户信息
     * @param updateUser
     */
    void update(User updateUser);

    /**
     * 管理员登录
     * @param loginUser
     * @return
     */
    User login(User loginUser);

    /**
     * 查找用户
     * @param id
     * @return
     */
    User findUser(String id);

    /**
     * 批量删除用户
     * @param u_ids
     */
    void deleteSelect(String[] u_ids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
