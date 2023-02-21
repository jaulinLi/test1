package cn.itcast.travel.service;

import cn.itcast.travel.domain.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 查询所有分类条目
     * @return
     */
    public List<Category> findAll();

    /**
     * 根据cid查询分类
     * @return
     */
    Category findOne(int id);
}
