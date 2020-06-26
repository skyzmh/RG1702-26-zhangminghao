<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/4/11
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
当前用户为：<s:property value="#session.user.name"/>&nbsp;身份为：<s:property value="#session.identity"/><br/>
<s:debug></s:debug>
<h2>增加学生信息</h2>
<form action="StuAdd" method="post">
        ID：<input type="text" name="student.id" value=""><br>
        姓名：<input type="text" name="student.name" value=""><br>
        密码：<input type="password" name="student.password" value=""><br>
        性别：<input type="text" name="student.sex" value=""><br>
        生日：<input type="date" name="student.birthday" value=""><br>
        学校：<input type="text" name="student.university" value=""><br>
        年级：<input type="text" name="student.grade" value=""><br>
        学院：<input type="text" name="student.department" value=""><br>
        专业：<input type="text" name="student.major" value=""><br>
        <input type="submit" value="增加">
        <a href="student_query.jsp" ><button >返回</button></a> <br/>
</form>

</body>
</html>
