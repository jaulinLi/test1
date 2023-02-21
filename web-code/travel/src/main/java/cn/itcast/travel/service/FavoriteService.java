package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

public interface FavoriteService {
    /**
     * 查询是否收藏
     * @param rid
     * @param uid
     * @return
     */
    Boolean findFavorite(int rid,int uid);

    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    void addFavorite(int rid,int uid);

    /**
     * 我的收藏分页展示
     * @param uid
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Route> myFavoritePageQuery(int uid,int currentPage, int pageSize);
}
