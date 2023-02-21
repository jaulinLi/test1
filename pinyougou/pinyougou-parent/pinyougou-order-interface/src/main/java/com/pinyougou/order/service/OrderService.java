package com.pinyougou.order.service;

import com.pinyougou.model.Order;
import com.pinyougou.model.PayLog;

public interface OrderService {

    PayLog getPayLogByUserId(String username);

    /**
     * 添加订单
     * @param order
     * @return
     */
    int add(Order order);

    /**
     * 修改订单和日志状态
     * @param username
     * @param transaction_id
     */
    void updatePayStatus(String username, String transaction_id);
}
