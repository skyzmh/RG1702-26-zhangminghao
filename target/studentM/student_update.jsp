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
<h2>修改学生信息</h2>
<form action="StuUpdate" method="post">
    <s:iterator value="#session.studentList.{?#this.id==#parameters.id[0]}" status="ad" >
    ID：<input type="text" name="student.id" value="<s:property value="id"/>"><br>
    姓名：<input type="text" name="student.name" value="<s:property value="name"/>"><br>
    密码：<input type="password" name="student.password" value="<s:property value="password"/>"><br>
    性别：<input type="text" name="student.sex" value="<s:property value="sex"/>"><br>
    身份：<input type="date" name="student.birthday" value="<s:property value="birthday"/>"><br>
    学校：<input type="text" name="student.university" value="<s:property value="university"/>"><br>
    年级：<input type="text" name="student.grade" value="<s:property value="grade"/>"><br>
    学院：<input type="text" name="student.department" value="<s:property value="department"/>"><br>
    专业：<input type="text" name="student.major" value="<s:property value="major"/>"><br>
    <input type="submit" value="修改">
    <a href="student_query.jsp" ><button >返回</button></a> <br/>
</s:iterator>
</form>

</body>
</html>
