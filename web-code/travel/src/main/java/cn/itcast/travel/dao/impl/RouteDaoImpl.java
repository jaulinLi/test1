package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Integer findTotalCount(int cid, String rname) {
        //String sql = "select count(*) from tab_route where cid=?";
        String sql = "select count(*) from tab_route where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();

        if (cid != 0) {
            sb.append(" and cid = ? ");
            params.add(cid);
        }
        if (rname != null && rname.length() > 0) {
            sb.append(" and rname like ? ");
            params.add("%" + rname + "%");
        }

        sql = sb.toString();
        return template.queryForObject(sql, Integer.class, params.toArray());
    }

    @Override
    public List<Route> findByPage(int start, int cid, int pageSize, String rname) {
        //String sql = "select *from tab_route where cid = ? limit ?,?";
        String sql = "select *from tab_route where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();

        if (cid != 0) {
            sb.append(" and cid = ? ");
            params.add(cid);
        }
        if (rname != null && rname.length() > 0) {
            sb.append(" and rname like ? ");
            params.add("%" + rname + "%");
        }

        sb.append(" limit ? , ? ");
        sql = sb.toString();

        params.add(start);
        params.add(pageSize);

        List<Route> list = template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), params.toArray());

        return list;
    }

    @Override
    public Route findOne(int rid) {
        Route route = null;
        try {
            String sql = "select * from tab_route where rid = ? ";
            route = template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return route;
    }

    @Override
    public void updateCount(int rid, int count) {
        String sql = "update tab_route set count = ? where rid = ?";
        template.update(sql, count, rid);
    }


    @Override
    public List<Route> findFavoriteByPage(int start, int pageSize, String rname, double priceBegin, double priceEnd) {
        //String sql = "select * from tab_route order by count desc where 1 = 1 ";
        String sql = "select * from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();
        if (rname != null && rname.length() > 0 ) {
            sb.append(" and rname like ? ");
            params.add("%" + rname + "%");
        }
        if (priceBegin != 0 && priceEnd != 0 && priceBegin <= priceEnd) {
            sb.append(" and price between ? and ? ");
            params.add(priceBegin);
            params.add(priceEnd);
        }

        sb.append(" order by count desc limit ? , ? ");
        params.add(start);
        params.add(pageSize);
        sql = sb.toString();
        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), params.toArray());
    }
    /*@Override
    public List<Route> findFavoriteByPage(int start, int pageSize) {
        String sql = "select * from tab_route order by count desc limit ? ,?";
        return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),start,pageSize);
    }*/

    @Override
    public int findAllTotalCount(String rname, double priceBegin, double priceEnd) {
        String sql = "select count(*) from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();
        if (rname != null && rname.length() > 0) {
            sb.append(" and rname like ? ");
            params.add("%" + rname + "%");
        }
        if (priceBegin != 0.0 && priceEnd != 0.0 && priceBegin <= priceEnd) {
            sb.append(" and price between ? and ? ");
            params.add(priceBegin);
            params.add(priceEnd);
        }
        sql = sb.toString();
        return template.queryForObject(sql, Integer.class, params.toArray());
    }
}

    /*@Override
    public int findAllTotalCount() {
        String sql = "select count(*) from tab_route";

        return template.queryForObject(sql,Integer.class);
    }
}*/
