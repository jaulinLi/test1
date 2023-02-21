package cn.itcast.jdbc;


import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.Collections;

/**
 * account表 删除一条记录
 */
public class JDBCDemo4 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from account where id = 3";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(stmt, conn);
        }
    }
}
