<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/4/9
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生查询</title>
</head>
<body>
当前用户为：<s:property value="#session.user.name"/>&nbsp;身份为：<s:property value="#session.identity"/><br/>
<s:debug/>
<a href="student_add.jsp" ><button >新增学生</button></a> <br/>
<form action="StuSearch" method="post">
    <input type="text" name="student.name" value=""><input type="submit" value="查询">
</form>
<table border="1">
    <tr>
        <td>id</td>
        <td>学号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>生日</td>
        <td>学校</td>
        <td>学院</td>
        <td>专业</td>
        <td>年级</td>
<s:if test="#session.identity == '超级管理员' " >
        <td></td>
        <td></td>
</s:if >
    </tr>
    <s:iterator value="#session.studentList" status="st">
    <tr>
        <td><s:property value="#st.count"/></td>
        <td><s:property value="id"/></td>
        <td><s:property value="name"/></td>
        <td><s:property value="sex"/></td>
        <td><s:date name="birthday" format="yyyy-MM-dd"/></td>
        <td><s:property value="university"/></td>
        <td><s:property value="department"/></td>
        <td><s:property value="major"/></td>
        <td><s:property value="grade"/></td>
        <s:if test="#session.identity == '超级管理员'" >
        <td><a href="student_update.jsp?id=<s:property value="id"/>" >修改</a></td>
        <td><a href="StuDelete?student.id= <s:property value="id"/>" >删除</a></td>
        </s:if >
    </tr>
</s:iterator>
</table>
</body>
</html>
