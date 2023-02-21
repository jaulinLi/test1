package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @Override
    public boolean registService(User user) {

        User u = dao.findByUsername(user.getUsername());

        if (u != null) {
            return false;
        } else {
            user.setCode(UuidUtil.getUuid());
            user.setStatus("N");
            dao.save(user);

            String content = "<a href='http://localhost/travel/user/active?code=" + user.getCode() + "'>点击激活【黑马旅游网】</a>";
            MailUtils.sendMail(user.getEmail(), content, "激活邮件");
            return true;
        }
    }

    /**
     * 激活
     *
     * @param code
     * @return
     */
    @Override
    public Boolean active(String code) {
        User user = dao.findByCode(code);
        if (user != null) {
            dao.updateStatus(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User login(User user) {
        User u = dao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return u;
    }
}
