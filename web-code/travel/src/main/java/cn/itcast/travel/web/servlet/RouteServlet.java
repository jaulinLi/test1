package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {

    RouteService service = new RouteServiceImpl();

    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPageStr = request.getParameter("currentPage");
        String cidStr = request.getParameter("cid");
        String pageSizeStr = request.getParameter("pageSize");
        String rname = request.getParameter("rname");

        rname = new String(rname.getBytes("iso-8859-1"), "utf-8");

        int cid = 0;
        if (cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }

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
            pageSize = 7;
        }

        PageBean<Route> pb = service.pageQuery(currentPage, cid, pageSize, rname);
        writeValue(pb, response);
    }

    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ridStr = request.getParameter("rid");
        int rid = 0;
        if (ridStr != null && ridStr.length() > 0 && !"null".equals(ridStr)) {
            rid = Integer.parseInt(ridStr);
        }

        Route route = service.findOne(rid);

        writeValue(route, response);
    }

    public void favoritePageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String rname = request.getParameter("rname");
        String priceBeginStr = request.getParameter("priceBegin");
        String priceEndStr = request.getParameter("priceEnd");

        rname = new String(rname.getBytes("iso-8859-1"), "utf-8");

        int currentPage = 0;
        if (currentPageStr != null && currentPageStr.length() > 0 ){
            currentPage = Integer.parseInt(currentPageStr);
        }
        else {
            currentPage = 1;
        }

        int pageSize = 0;
        if (pageSizeStr != null && pageSizeStr.length() > 0){
            pageSize = Integer.parseInt(pageSizeStr);
        }
        else {
            pageSize = 8;
        }

        double priceBegin = 0;
        if (priceBeginStr != null && priceBeginStr.length() > 0 && !"null".equals(priceBeginStr)){
            priceBegin = Double.parseDouble(priceBeginStr);
        }

        double priceEnd = 0;
        if (priceEndStr != null && priceEndStr.length() > 0 && !"null".equals(priceEndStr)){
            priceEnd = Double.parseDouble(priceEndStr);
        }

        PageBean<Route> pb = service.favoritePageQuery(currentPage,pageSize,rname,priceBegin,priceEnd);
        writeValue(pb, response);
    }
}
