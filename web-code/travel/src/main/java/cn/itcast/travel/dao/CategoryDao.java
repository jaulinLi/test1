package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;

import java.util.List;

public interface CategoryDao {

    /**
     * 查询所有分类列表
     * @return
     */
    public List<Category> findAll();

    /**
     * 根据cid查询分类
     * @param cid
     * @return
     */
    Category findByCid(int cid);
}
