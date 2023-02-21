package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

public interface ImgDao {

    public List<RouteImg> findImg(int rid);
}
