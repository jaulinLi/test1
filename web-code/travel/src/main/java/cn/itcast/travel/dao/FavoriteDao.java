package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.Route;
import sun.tools.jstat.Literal;

import java.util.List;


public interface FavoriteDao {

    Favorite findCountByUidAndRid(int uid,int rid);

    void addFavorite(int rid ,int uid);

    int findCountByRid(int rid);

    int findCountByUid(int uid);

    List<Route> findRouteByUid(int uid,int start,int pageSize);

}
