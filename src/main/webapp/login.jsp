<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/4/9
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>基于Struts2+Hibernate的学生信息管理系统</h1>
<h3>管理员登录</h3>
<form  name="register" action="AdminLogin" method="post">
    <table border="2" align="center">
        <caption>管理员登录</caption>
        <tr>
            <th>用户名：</th>
            <td><input name="admin.name"  type="text" /></td>
        </tr>
        <tr>

        </tr>

        <tr>
            <th>密码：</th>
            <td><input name="admin.password"  type="password" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"
                                                  width="120ppx" /></td>
        </tr>


    </table>
</form>
<h3>学生登录</h3>
<form  name="register" action="StudentLogin" method="post">
    <table border="2" align="center">
        <caption>学生登录</caption>
        <tr>
            <th>用户名：</th>
            <td><input name="student.name"  type="text" /></td>
        </tr>
        <tr>

        </tr>

        <tr>
            <th>密码：</th>
            <td><input name="student.password"  type="password" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"
                                                  width="120ppx" /></td>
        </tr>


    </table>
</form>
</body>
</html>
