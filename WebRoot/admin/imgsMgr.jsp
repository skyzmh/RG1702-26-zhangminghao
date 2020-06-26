<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>头像管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../res/layui/css/layui.css">
    <link rel="stylesheet" href="../res/static/css/mian.css">
</head>
<style>
    /* .left{
        background-color: aliceblue;
        color:black;
        margin: 10px;
        padding: 10px
    }
    li{
        margin: 10px;
    } */
#cl-dashboard {
    position: fixed;
    top: 30px;
    right: 30px;
    display:none;
}
    
</style>
<body class="lay-blog">
    <s:iterator value="#session.userlist">
        <div style="width: 200px; height: 200px;text-align: center;margin-left: 50px;margin-top:60px;float: left;">
                <img src="../res/file/<s:property value='img'/>" width="180px" height="180px" /><br>
                <s:property value="name"/><br>
                <button class="layui-btn layui-btn-danger"><a href="userDelete?user.id=<s:property value="id"/>" style="color: white;">删除</a></button></td>
        </div>
    </s:iterator>



<script src="../res/layui/layui.js"></script>
<script>
    layui.config({
        base: './res/static/js/'
    }).use('blog');
</script>
</body>
</html>