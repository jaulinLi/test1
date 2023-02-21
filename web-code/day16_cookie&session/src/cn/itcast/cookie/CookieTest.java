package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/*在服务器中的Servlet判断是否有一个名为lastTime的cookie
        ① 有：不是第一次访问
        1> 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
        2> 写回Cookie：lastTime=2018年6月10日11:50:01
        ② 没有：是第一次访问
        1> 响应数据：您好，欢迎您首次访问
        2> 写回Cookie：lastTime=2018年6月10日11:50:01*/


@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //1.获取所有Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        //2.遍历cookie数组
        if (cookies !=null && cookies.length!=0){
            for (Cookie cookie : cookies) {
                //3.获取cookie的名称
                String name = cookie.getName();
                //4.判断名称是否是：lastTime
                if ("lastTime".equals(name) ){
                    //有：不是第一次访问
                    //设置Cookies的value
                    flag = true;
                    Date date =new Date();

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    //URl编码
                    str_date = URLEncoder.encode(str_date,"utf-8");
                    //写回Cookie
                    cookie.setValue(str_date);
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(cookie);

                    //响应数据
                    String value = cookie.getValue();
                    //URl解码
                    value = URLDecoder.decode(value,"utf-8");
                    response.getWriter().write("<h1>欢迎回来，您上次访问的时间为：" + value+"</h1>");

                    break;
                }
            }
        }

        if (cookies==null || cookies.length == 0 || flag == false){
            //没有：是第一次访问
            Date date =new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            str_date = URLEncoder.encode(str_date,"utf-8");
            //写回Cookie
            Cookie cookie = new Cookie("lastTime",str_date);
            cookie.setValue(str_date);
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);

            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
