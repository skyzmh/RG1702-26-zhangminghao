<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>新闻发布后台管理</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="../res/layui/css/layui.css">
	<link rel="stylesheet" href="../res/static/css/mian.css">
</head>
<style>
   .if{
       position: absolute;
       top: 120px;
       left: 200px;

       width: 1100px;
       height: 540px;
   }

    
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
		<div class="header">

				<ul class="layui-nav layui-bg-cyan" >
                    <li class="layui-nav-item"><a href="">新闻发布后台管理</a></li>
                    <li class="layui-nav-item layui-this"><a href="">管理</a></li>
                    <li class="layui-nav-item"><a href="../index.jsp">首页</a></li>
                    <li class="layui-nav-item">
                      <a href="javascript:;">解决方案</a>
                      <dl class="layui-nav-child">
                        <dd><a href="">新闻模块</a></dd>
                        <dd><a href="">后台模版</a></dd>
                        <dd><a href="">发布平台</a></dd>
                      </dl>
                    </li>
                    <li class="layui-nav-item"><a href="">社区</a></li>
                  </ul>
                  <ul class="layui-nav layui-nav-tree" lay-filter="test" style="height: 572px;">
                    <!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
                      <li class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;">管理内容</a>
                        <dl class="layui-nav-child">
                          <dd><a href="newsList" target="xxx">&nbsp;&nbsp;新闻管理</a></dd>
                          <dd><a href="sortList" target="xxx">&nbsp;&nbsp;分类管理</a></dd>
                          <dd><a href="userList" target="xxx">&nbsp;&nbsp;用户管理</a></dd>
                          <dd><a href="commList" target="xxx">&nbsp;&nbsp;评论管理</a></dd>
                          <dd><a href="imgsList" target="xxx">&nbsp;&nbsp;头像管理</a></dd>
                        </dl>
                      </li>
                      <li class="layui-nav-item">
                        <a href="sortLists" target="xxx">发布新闻</a>
                        <%--<dl class="layui-nav-child">
                          <dd><a href="">移动模块</a></dd>
                          <dd><a href="">后台模版</a></dd>
                          <dd><a href="">电商平台</a></dd>
                        </dl>--%>
                      </li>
                      <li class="layui-nav-item"><a href="">产品</a></li>
                      <li class="layui-nav-item"><a href="">大数据</a></li>
                    </ul>
        </div>
        
        
        <div class="if">

            <iframe src="" name="xxx" frameborder="0" style="height: 100%;width: 100%;" ></iframe>

        </div>

	<script src="../res/layui/layui.js"></script>
	<script>
		layui.config({
		  base: '../res/static/js/' 
		}).use('blog');	
	</script>


</body>
</html>