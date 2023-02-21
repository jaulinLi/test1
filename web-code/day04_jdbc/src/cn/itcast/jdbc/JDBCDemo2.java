package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * account表 添加一条记录 insert 语句
 */
public class JDBCDemo2 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接对象 Connection
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "123456");
            //3.定义sql
            String sql = "ALTER TABLE account MODIFY id INT primary key AUTO_INCREMENT";
            // 4.获取执行sql语句的对象
            stmt = conn.createStatement();
            // 5.执行sql，接受返回结果
            int count = stmt.executeUpdate(sql);
            // 6.处理结果
            System.out.println(count);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stmt != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}