package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.FavoriteService;

import java.util.ArrayList;
import java.util.List;

public class FavoriteServiceImpl implements FavoriteService {

    private FavoriteDao favoriteDao = new FavoriteDaoImpl();
    @Override
    public Boolean findFavorite(int rid, int uid) {
        Favorite favorite = favoriteDao.findCountByUidAndRid(uid, rid);
        if (favorite == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void addFavorite(int rid, int uid) {
        favoriteDao.addFavorite(rid,uid);
    }

    @Override
    public PageBean<Route> myFavoritePageQuery(int uid,int currentPage, int pageSize) {
        PageBean<Route> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);

        int totalCount = favoriteDao.findCountByUid(uid);
        pb.setTotalCount(totalCount);

        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        pb.setTotalPage(totalPage);

        int start = (currentPage - 1) * pageSize;

        List<Route> list = favoriteDao.findRouteByUid(uid,start,pageSize);
        pb.setList(list);

        return pb;
    }
}
