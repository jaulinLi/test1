package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 练习：
 * 		* 需求：
 * 			1. 通过键盘录入用户名和密码
 * 			2. 判断用户是否登录成功
 */
public class JDBCDemo9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        boolean result = new JDBCDemo9().login(username, password);
        if (result == true){
            System.out.println("登录成功");
        } else {
            System.out.println("用户名或密码错误");
        }
    }


    /**
     * 登录方法
     */
    public boolean login(String username,String password){
        if (username == null || password == null){
            return false;
        }
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where username = ? and password = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,username);
            pstm.setString(2,password);
            rs = pstm.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,pstm,conn);
        }
        return false;
    }
}
