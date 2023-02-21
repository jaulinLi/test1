package cn.itheima.controller;

import cn.itheima.domain.Items;
import cn.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * web层
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/findItemsById")
    public String findItemsById(Model model){
        Items item = itemsService.findItemsById(1);
        model.addAttribute("item",item);
        return "itemDetail";
    }
}
