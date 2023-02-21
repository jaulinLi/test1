package com.pinyougou.page.service;

public interface ItemPageService {

    /**
     * 根据goodsId生成静态页
     * @param goodsId
     * @return
     */
    Boolean buildHtml(long goodsId) throws Exception;

    /**
     * 根据goodsId删除静态页
     * @param id
     */
    void deleteHtml(Long id);
}
