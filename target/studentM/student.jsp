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
    <title>学生信息</title>
</head>
<body>
当前用户为：<s:property value="#session.user.name"/>&nbsp;身份为：<s:property value="#session.identity"/><br/>
<s:debug></s:debug>
<h2>学生信息</h2>
    ID：<input type="text" name="student.id"  value="<s:property value="#session.user.id"/>"><br>
    姓名：<input type="text" name="student.name"  value="<s:property value="#session.user.name"/>"><br>
    密码：<input type="password" name="student.password" value="<s:property value="#session.user.password"/>"><br>
    性别：<input type="text" name="student.sex"   value="<s:property value="#session.user.sex"/>"><br>
    生日：<input type="date" name="student.birthday"   value="<s:date name="#session.user.birthday" format="yyyy-MM-dd"/>"><br>
    学校：<input type="text" name="student.university" value="<s:property value="#session.user.university"/>"><br>
    年级：<input type="text" name="student.grade"   value="<s:property value="#session.user.grade"/>"><br>
    学院：<input type="text" name="student.department"   value="<s:property value="#session.user.department"/>"><br>
    专业：<input type="text" name="student.major"  value="<s:property value="#session.user.major"/>"><br>
<a href="login.jsp" ><button >返回登录</button></a> <br/>
</body>
</html>
