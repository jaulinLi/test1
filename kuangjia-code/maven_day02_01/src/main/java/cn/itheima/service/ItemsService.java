package cn.itheima.service;

import cn.itheima.domain.Items;

/**
 * service层
 */
public interface ItemsService {

    /**
     * 根据id查询项目
     * @param id
     * @return
     */
    Items findItemsById(Integer id);
}
