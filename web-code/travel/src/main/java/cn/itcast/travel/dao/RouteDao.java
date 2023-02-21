package cn.itcast.travel.dao;


import cn.itcast.travel.domain.Route;

import java.util.List;

public interface RouteDao {

    /**
     * 查询总记录数
     * @return
     */
    public Integer findTotalCount(int cid,String rname);

    /**
     * 每页显示的数据
     * @return
     */
    public List<Route> findByPage(int start, int cid, int pageSize,String rname);

    /**
     * 根据线路rid查询线路
     * @param rid
     * @return
     */
    public Route findOne(int rid);

    void updateCount(int rid,int count);

    /**
     * 收藏分页查询
     * @param start
     * @param pageSize
     * @return
     */
    public List<Route> findFavoriteByPage(int start, int pageSize,String rname,double priceBegin,double priceEnd);

    /**
     * 所有收藏数
     * @return
     */
    public int findAllTotalCount(String rname,double priceBegin,double priceEnd);


}
