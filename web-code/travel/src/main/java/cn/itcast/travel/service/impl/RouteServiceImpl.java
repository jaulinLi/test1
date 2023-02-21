package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.ImgDao;
import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.dao.impl.ImgDaoImpl;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.dao.impl.SellerDaoImpl;
import cn.itcast.travel.domain.*;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {

    private RouteDao dao = new RouteDaoImpl();
    private ImgDao imgDao = new ImgDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int currentPage, int cid, int pageSize, String rname) {

        PageBean<Route> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);

        Integer totalCount = dao.findTotalCount(cid, rname);
        pageBean.setTotalCount(totalCount);

        int totalPage = totalCount / pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pageBean.setTotalPage(totalPage);

        int start = (currentPage - 1) * pageSize;

        List<Route> list = dao.findByPage(start, cid, pageSize, rname);
        pageBean.setList(list);

        return pageBean;
    }

    @Override
    public Route findOne(int rid) {
        Route route = dao.findOne(rid);

        List<RouteImg> list = imgDao.findImg(route.getRid());
        route.setRouteImgList(list);

        Seller seller = sellerDao.findSeller(route.getSid());
        route.setSeller(seller);

        int count = favoriteDao.findCountByRid(route.getRid());
        route.setCount(count);

        dao.updateCount(route.getRid(),route.getCount());
        return route;
    }

    @Override
    public PageBean<Route> favoritePageQuery(int currentPage,int pageSize,String rname,double priceBegin,double priceEnd) {
        PageBean<Route> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);

        int totalCount = dao.findAllTotalCount(rname,priceBegin,priceEnd);
        pb.setTotalCount(totalCount);

        int totalPage = totalCount % pageSize == 0? totalCount / pageSize : totalCount / pageSize + 1;
        pb.setTotalPage(totalPage);

        int start = (currentPage - 1) * pageSize;

        List<Route> list = dao.findFavoriteByPage(start, pageSize,rname,priceBegin,priceEnd);
        pb.setList(list);

        return pb;
    }
}
