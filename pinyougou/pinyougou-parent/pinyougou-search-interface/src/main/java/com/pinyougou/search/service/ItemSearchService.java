package com.pinyougou.search.service;

import com.pinyougou.model.Item;

import java.util.List;
import java.util.Map;

public interface ItemSearchService {

    /**
     * 搜索
     * @param searchMap
     * @return
     */
    public Map<String,Object> search (Map searchMap);

    /**
     * 导入索引库数据
     * @param items
     */
    void importItems(List<Item> items);

    /**
     * 根据goodsids删除索引数据
     * @param ids
     */
    void deleteByGoodsIds(List<Long> ids);
}
