package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;
//import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao dao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        Jedis jedis = JedisUtil.getJedis();
        //Set<String> categories = jedis.zrange("category", 0, -1);
        Set<Tuple> tuples = jedis.zrangeWithScores("category", 0, -1);
        List<Category> cs = null;

        if (tuples == null || tuples.size() == 0) {
            cs = dao.findAll();
            for (Category c : cs) {
                jedis.zadd("category", c.getCid(), c.getCname());
            }
        } else {
            cs = new ArrayList<Category>();
            for (Tuple set : tuples) {
                Category category = new Category();
                category.setCname(set.getElement());
                category.setCid((int)set.getScore());
                cs.add(category);
            }
        }
        return cs;
    }

    @Override
    public Category findOne(int cid) {
        Category category = dao.findByCid(cid);
        return category;
    }
}
