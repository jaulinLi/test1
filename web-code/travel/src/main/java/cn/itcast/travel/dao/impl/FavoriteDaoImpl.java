package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

public class FavoriteDaoImpl implements FavoriteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Favorite findCountByUidAndRid(int uid, int rid) {
        Favorite favorite = null;
        try {
            String sql = "select count(*) from tab_favorite where uid = ? and rid = ?";
            favorite = template.queryForObject(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class), uid, rid);
            } catch (DataAccessException e) {

        }
        return favorite;
    }

    @Override
    public void addFavorite(int rid, int uid) {
        String sql = "insert into tab_favorite values (?,?,?)";
        template.update(sql,rid,new Date(),uid);
    }

    @Override
    public int findCountByRid(int rid) {
        String sql = "select count(*) from tab_favorite where rid = ?";
        return template.queryForObject(sql,Integer.class,rid);
    }

    @Override
    public int findCountByUid(int uid) {
        String sql = "select count(*) from tab_favorite where uid = ?";
        return template.queryForObject(sql,Integer.class,uid);
    }

    @Override
    public List<Route> findRouteByUid(int uid,int start,int pageSize) {
        String sql = "select * from tab_route where rid in (select rid from tab_favorite where uid = ? ) limit ?, ? ";
        return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),uid,start,pageSize);
    }
}
