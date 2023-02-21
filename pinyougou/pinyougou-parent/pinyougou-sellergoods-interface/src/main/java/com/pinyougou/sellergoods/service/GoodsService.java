package com.pinyougou.sellergoods.service;
import com.github.pagehelper.PageInfo;
import com.pinyougou.model.Goods;
import com.pinyougou.model.Item;

import java.util.List;

public interface GoodsService {

	/**
	 * 返回Goods全部列表
	 * @return
	 */
	public List<Goods> getAll();

    /***
     * 分页返回Goods列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Goods> getAll(Goods goods, int pageNum, int pageSize);

    /***
     * 增加Goods信息
     * @param goods
     * @return
     */
    int add(Goods goods);

    /***
     * 根据ID查询Goods信息
     * @param id
     * @return
     */
    Goods getOneById(Long id);

    /***
     * 根据ID修改Goods信息
     * @param goods
     * @return
     */
    int updateGoodsById(Goods goods);

    /***
     * 根据ID批量删除Goods信息
     * @param ids
     * @return
     */
    int deleteByIds(List<Long> ids);

    /**
     * 更新商品状态
     * @param ids
     * @param status
     * @return
     */
    int updateStatus(List<Long> ids, String status);

    /**
     * 根据商品id和状态查询item
     * @param ids
     * @param status
     * @return
     */
    List<Item> findItemLIstByGoodIdsAndStatus(List<Long> ids, String status);
}
