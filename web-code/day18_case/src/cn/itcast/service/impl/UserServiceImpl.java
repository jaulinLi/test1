package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        List<User> users = dao.findAll();
        return users;
    }

    @Override
    public void add(User addUser) {
        dao.add(addUser);

    }

    @Override
    public void delete(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public void update(User updateUser) {
        dao.update(updateUser);
    }

    @Override
    public User login(User loginUser) {
        return dao.login(loginUser.getUsername(), loginUser.getPassword());
    }

    @Override
    public User findUser(String id) {
        return dao.findUser(Integer.parseInt(id));
    }

    @Override
    public void deleteSelect(String[] u_ids) {
        if (u_ids != null && u_ids.length > 0) {
            for (String u_id : u_ids) {
                dao.delete(Integer.parseInt(u_id));
            }
        }

    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        PageBean<User> pb = new PageBean<>();
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        pb.setRows(rows); //每页显示条数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount); //总记录数

        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : (totalCount / rows) + 1;

        if (currentPage <= 1) {
            currentPage = 1;
        }
        if (currentPage >= totalPage) {
            currentPage = totalPage;
        }

        pb.setCurrentPage(currentPage); //当前页码
        pb.setTotalPage(totalPage); //总页码

        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start, rows,condition);
        pb.setList(list); //每页的数据
        return pb;
    }
}
