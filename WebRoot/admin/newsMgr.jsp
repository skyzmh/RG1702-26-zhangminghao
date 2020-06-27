<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新闻管理</title>
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


</style>
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
        <tr><td colspan="4">
            <form class="layui-form" action="newsFind">
                <div class="layui-form-item" style="float: right;clear: none;">
                    <div class="layui-input-block" style="margin-left:0px;">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">搜索</button>
                    </div>
                </div>
                <div class="layui-form-item" style="float: right;clear: none;">
                    <div class="layui-input-block">
                        <input type="text" name="news.title" required  lay-verify="required" placeholder="请输入搜索内容" autocomplete="off" class="layui-input" style="width:200px;">
                    </div>
                </div>
            </form>
        </td></tr>
        <tr>
            <td>新闻标题</td>
            <td>新闻作者</td>
            <td>新闻发布时间</td>
            <td>operation</td>
        </tr>
        <s:iterator value="#session.newslist">
            <tr>
                <td><a href="newsDetails?id=<s:property value="id"/>"><s:property value="title"/></a> </td>
                <td><a><s:property value="author"/></a></td>
                <td><a><s:property value="createTime"/></a></td>
                <td><a href="newsDelete?id=<s:property value="id"/>"><button class="layui-btn layui-btn-danger">删除</button></a></td>
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