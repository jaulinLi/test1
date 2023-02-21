package cn.itheima.service.impl;

import cn.itheima.dao.ItemsDao;
import cn.itheima.domain.Items;
import cn.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemsServiceImpl implements ItemsService{

    @Autowired
    private ItemsDao itemsDao ;

    public Items findItemsById(Integer id) {
        return itemsDao.findItemsById(id);
    }
}
