package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

public interface RouteService {

    /**
     * 分页查询所需的数据
     * @return
     */
    public PageBean<Route> pageQuery(int currentPage, int cid, int pageSize,String rname);

    /**
     * 根据线路id查询线路详情
     * @param rid
     * @return
     */
    Route findOne(int rid);

    PageBean<Route> favoritePageQuery(int currentPage,int pageSize,String rname,double priceBegin,double priceEnd);

}
