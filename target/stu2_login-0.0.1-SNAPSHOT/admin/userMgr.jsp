<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
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

    <table class="layui-table">

        <tbody align="center">
        <tr><td colspan="3">
            <form class="layui-form" action="userFind">
                <div class="layui-form-item" style="float: right;clear: none;">
                    <div class="layui-input-block" style="margin-left:0px;">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">搜索</button>
                    </div>
                </div>
                <div class="layui-form-item" style="float: right;clear: none;">
                    <div class="layui-input-block">
                        <input type="text" name="user.name" required  lay-verify="required" placeholder="请输入搜索内容" autocomplete="off" class="layui-input" style="width:200px;">
                    </div>
                </div>
            </form>
        </td></tr>
        <tr>
            <td>username</td>
            <td>privileges</td>
            <td>opration</td>
        </tr>
        <s:iterator value="#session.userlist">
            <tr>
                <td><s:property value="name"/> </td>
                <td><s:property value="privileges"/> </td>
                <td><button class="layui-btn layui-btn-danger"><a href="userDelete?user.id=<s:property value="id"/>" style="color: white;">删除</a></button></td>
            </tr>
        </s:iterator>
        </tbody>
    </table>



<script src="../res/layui/layui.js"></script>
<script>
    layui.config({
        base: './res/static/js/'
    }).use('blog');
</script>
</body>
</html>