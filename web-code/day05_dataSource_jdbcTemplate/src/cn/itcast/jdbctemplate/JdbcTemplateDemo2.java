package cn.itcast.jdbctemplate;


import cn.itcast.domain.Emp;
import cn.itcast.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {

    //Junit单元测试，可以让方法独立执行
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    // 1> 修改1号数据的 salary 为 8000
    @Test
    public void test1 (){
        String sql = "update emp set salary = 8000 where id = ?";
        int count = template.update(sql, 1001);
        System.out.println(count);
    }

    // 2> 添加一条记录
    @Test
    public void test2 () {
        String sql = "insert into emp(id , ename , salary) values(? , ? , ?)";
        int count = template.update(sql, 1015, "张三", 15000);
        System.out.println(count);
    }

    // 3> 删除刚才添加的记录
    @Test
    public void test3 (){
        String sql = "delete from emp where id = ?";
        int count = template.update(sql, 1015);
        System.out.println(count);
    }

    // 4> 查询id为1的记录，将其封装为Map集合
    @Test
    public void test4 (){
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
    }

    // 5> 查询所有记录，将其封装为List
    @Test
    public void test5 (){
        String sql = "select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

    // 6> 查询所有记录，将其封装为Emp对象的List集合
    @Test
    public void test6 (){
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class) {
        });
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    // 7> 查询总记录数
    @Test
    public void test7 (){
        String sql = "select count(id) from emp";
        Long count = template.queryForObject(sql, long.class);
        System.out.println(count);
    }
}
