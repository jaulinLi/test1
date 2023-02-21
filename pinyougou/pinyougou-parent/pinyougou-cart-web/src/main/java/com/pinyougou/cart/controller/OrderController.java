package com.pinyougou.cart.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.http.Result;
import com.pinyougou.model.Order;
import com.pinyougou.order.service.OrderService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Reference
    private OrderService orderService;

    @RequestMapping("/add")
    public Result add(@RequestBody Order order) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        order.setUserId(username);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        order.setStatus("1");

        try {
            int acount = orderService.add(order);
            if (acount > 0) {
                return new Result(true, "添加订单成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Result(false, "添加订单失败！");
    }
}
