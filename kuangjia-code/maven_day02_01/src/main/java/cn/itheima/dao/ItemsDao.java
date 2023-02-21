package cn.itheima.dao;

import cn.itheima.domain.Items;

/**
 * dao层
 */
public interface ItemsDao {
    /**
     * 根据id查询项目
     * @param id
     * @return
     */
    Items findItemsById(Integer id);
}
