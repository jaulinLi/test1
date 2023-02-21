package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/favorite/*")
public class FavoriteServlet extends BaseServlet {

    private FavoriteService service = new FavoriteServiceImpl();

    public void findFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int uid;
        if (user == null) {
            uid = 0;
        } else {
            uid = user.getUid();
        }
        Boolean flag = service.findFavorite(Integer.parseInt(rid), uid);
        writeValue(flag, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int uid;
        if (user == null) {
            return;
        } else {
            uid = user.getUid();
        }
        service.addFavorite(Integer.parseInt(rid), uid);
    }

    public void myFavoritePageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uidStr = request.getParameter("uid");
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");

        int uid = Integer.parseInt(uidStr);

        int currentPage = 0;
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }

        int pageSize = 0;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 12;
        }

        PageBean<Route> pb = service.myFavoritePageQuery(uid, currentPage, pageSize);
        writeValue(pb, response);

    }
}
