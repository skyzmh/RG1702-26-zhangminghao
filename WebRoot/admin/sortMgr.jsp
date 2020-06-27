<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>分类管理</title>
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
        <tr><td colspan="3">
            <form class="layui-form" action="sortFind">
                <div class="layui-form-item" style="float: right;clear: none;">
                    <div class="layui-input-block" style="margin-left:0px;">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">搜索</button>
                    </div>
                </div>
                <div class="layui-form-item" style="float: right;clear: none;">
                    <div class="layui-input-block">
                        <input type="text" name="sort.sortName" required  lay-verify="required" placeholder="请输入搜索内容" autocomplete="off" class="layui-input" style="width:200px;">
                    </div>
                </div>
            </form>
        </td></tr>
        <tr><td colspan="3"><button class="layui-btn layui-btn-danger" onclick="func()">增加新栏目</button></td></tr>
        <tr>
            <td>栏目</td>
            <td colspan="2">operation</td>
        </tr>
        <s:iterator value="#session.sortlist">
            <tr>
                <td><a href="#"><s:property value="sortName"/></a> </td>
                <td><button class="layui-btn layui-btn-danger" onclick="func2(<s:property value="id"/> )">修改</button></td>
                <td><a href="sortDelete?id=<s:property value="id"/>"><button class="layui-btn layui-btn-danger">删除</button></a></td>
            </tr>
        </s:iterator>
        </tbody>
    </table>



<script src="../res/layui/layui.js"></script>
<script>
    layui.config({
        base: '../res/static/js/'
    }).use('blog');

    function func() {
        var type = window.prompt("请输入新增栏目的名字：");
        if(type!=null && type!=""){
            window.location.href = "sortAdd?sort.sortName="+type;
        }
    }

    function func2(x){
        var type = window.prompt("请输入更改后的栏目的名字：");
        if(type!=null && type!=""){
            window.location.href = "sortUpdate?sort.id="+x+"&sort.sortName="+type;
        }
    }
</script>
</body>
</html>