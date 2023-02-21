<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/10/11 0011
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>

    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "/day16/checkCodeServlet?time=" + new Date().getTime();
            }
            
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
    <form action="/day16/loginServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" placeholder="请输入用户名" name="username"> </td>
        </tr>

        <tr>
            <td>密码</td>
            <td><input type="password" placeholder="请输入密码" name="password"> </td>
        </tr>

        <tr>
            <td>验证码</td>
            <td><input type="text" placeholder="请输入验证码" name="checkCode"> </td>
        </tr>

        <tr>
            <td colspan="2"><img id ="img" src="/day16/checkCodeServlet" > </td>
        </tr>

        <tr>
            <td colspan="2"><input type= "submit" value="登录"> </td>
        </tr>

    </table>
    </form>

    <div><%=request.getAttribute("login_error")==null? "":request.getAttribute("login_error") %></div>
    <div><%=request.getAttribute("cc_error") ==null? "":request.getAttribute("cc_error") %></div>

</body>
</html>
