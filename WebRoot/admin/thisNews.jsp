<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>今日新闻</title>
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
		<div class="header">
			<div class="header-wrap">
				<h1 class="logo pull-left">
					<a href="index.html">
						<img src="./res/static/images/logo.png" alt="" class="logo-img">
						<img src="./res/static/images/logo-text.png" alt="" class="logo-text">
					</a>
				</h1>
				<form class="layui-form blog-seach pull-left" action="">
					<div class="layui-form-item blog-sewrap">
					    <div class="layui-input-block blog-sebox">
					      <i class="layui-icon layui-icon-search"></i>
					      <input type="text" name="title" lay-verify="title" autocomplete="off"  class="layui-input">
					    </div>
					</div>
				</form>
				<div class="blog-nav pull-right">
					<ul class="layui-nav pull-left">
					  <li class="layui-nav-item layui-this"><a href="index.html">首页</a></li>
					  <li class="layui-nav-item"><a href="message.html">留言</a></li>
					  <li class="layui-nav-item"><a href="about.html">关于</a></li>
					</ul>
					<a href="#" class="personal pull-left">
						<i class="layui-icon layui-icon-username"></i>
					</a>
				</div>
				<div class="mobile-nav pull-right" id="mobile-nav">
					<a href="javascript:;">
						<i class="layui-icon layui-icon-more"></i>
					</a>
				</div>
			</div>
			<ul class="pop-nav" id="pop-nav">
				<li><a href="index.html">首页</a></li>
				<li><a href="message.html">留言</a></li>
				<li><a href="about.html">关于</a></li>
			</ul>
		</div>
		<div class="container-wrap">
			<div class="container container-message container-details">
					<div class="contar-wrap">
						<div class="item">
							<div class="item-box  layer-photos-demo1 layer-photos-demo">
								<h3><a href="details.html"><s:property value="#session.news.title"/></a></h3>
								<h5><s:property value="#session.news.author"/> 发布于：<span><s:property value="#session.news.createTime"/></span></h5>
								<p><s:property value="#session.news.content"/></p>
								<img src="./res/static/images/item.png" alt="">
								<div class="count layui-clear">
									<span class="pull-left">阅读 <em>100000+</em></span>
									<span class="pull-right like"><i class="layui-icon layui-icon-praise"></i><em>999</em></span>
								</div>
							</div>
						</div>	
						<a name="comment"> </a>
						<div class="comt layui-clear">
							<a href="javascript:;" class="pull-left">评论</a>
							<a href="comment.jsp" class="pull-right">写评论</a>
						</div>
						<form class="layui-form" action="CommentsAdd" method="post">
							<div class="layui-form-item layui-form-text">
							<input name="comments.author" value="<s:property value="#session.user.name"/>" type="hidden">
							<input name="comments.newsId" value="<s:property value="#session.news.id"/>" type="hidden">
								<textarea name="comments.content" class="layui-textarea"  style="resize:none" placeholder="写点什么啊"></textarea>
							</div>
							<div class="btnbox">
							  	<button type="submit" class="layui-btn" style="float:right;">确定</button>
							</div>
						</form>
						<br><br>
						<div id="LAY-msg-box">

							<s:iterator value="#session.commentslist">
								<div class="info-item">
									<img class="info-img" src="./res/static/images/info-img.png" alt="">
									<div class="info-text">
										<p class="title count">
											<span class="name"><s:property value="author"/></span>
											<span class="info-img like"><i class="layui-icon layui-icon-praise"></i><s:property value="zan"/></span>
										</p>
										<p class="info-intr"><s:property value="content"/></p>
									</div>
								</div>
							</s:iterator>
										
						</div>
					</div>
			</div>
		</div>
		<div class="footer">
			<p>
				<span>&copy; 2018</span>
				<span><a href="http://www.layui.com" target="_blank">layui.com</a></span> 
				<span>MIT license</span>
			</p>
			<p><span>人生就是一场修行</span></p>
		</div>
	<script src="../res/layui/layui.js">

	</script>
	<script>
		layui.config({
		  base: './res/static/js/' 
		}).use('blog');
	</script>
	<script id="LAY-msg-tpl" type="text/html">
		<div class="info-box">
			<div class="info-item">
				<img class="info-img" src="{{ d.avatar }}" alt="">
			  <div class="info-text">
					<p class="title">
					  <span class="name">{{ d.username }}</span>
					  <span class="info-img">
					  	<i class="layui-icon layui-icon-praise"></i>
					  	{{ d.praise }}
					 	</span>
					</p>
					<p class="info-intr">
						{{ d.content }}
					</p>
			  </div>
			</div>
		</div>
	</script>
</body>
</html>