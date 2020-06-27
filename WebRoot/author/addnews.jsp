<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>新闻轻资讯</title>
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
<body class="lay-blog">
		<div class="header">
			<div class="header-wrap">
				<h1 class="logo pull-left">
					<a href="index.html">
                        <h8 style="color: white">今日新闻</h8>
						<!-- <img src="/res/static/images/logo.png" alt="" class="logo-img">
						<img src="../res/static/images/logo-text.png" alt="" class="logo-text"> -->
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
					  <li class="layui-nav-item" lay-unselect="">
					    <a href="javascript:;"><img src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>
					    <dl class="layui-nav-child">
					      <dd><a href="javascript:;">修改信息</a></dd>
					      <dd><a href="javascript:;">安全管理</a></dd>
					      <dd><a href="javascript:;">退了</a></dd>
					    </dl>
  					  </li>
					</ul>
					

<!-- 					<a href="#" class="personal pull-left"> -->
<!-- 						<i class="layui-icon layui-icon-username"></i> -->
<!-- 					</a> -->
				</div>
				<div class="mobile-nav pull-right" id="mobile-nav">
					<a href="javascript:;">
						<i class="layui-icon layui-icon-more"></i>
					</a>
				</div>
			</div>
			<ul class="pop-nav" id="pop-nav">
				<li><a href="../index.html">首页</a></li>
				<li><a href="../message.html">留言</a></li>
				<li><a href="../about.html">关于</a></li>
			</ul>
        </div>
        
        <div class="layui-container">  
  
            <div class="layui-row">
                <div class="layui-col-md1 left" >


                    <table class="layui-table">
               
                        <thead>
                            <tr>
                                <th><a href="">推荐</a> </th>             
                            </tr> 
                        </thead>
                        <tbody>

                                <tr>
                                    <td><a href="NewsSort?sortId=<s:property value="id"/>">我的新闻</a> </td> 
                                                                                  
                                </tr> 
                                <tr>
                                    <td><a href="NewsSort?sortId=<s:property value="id"/>">添加新闻</a> </td> 
                                               
                                </tr> 

                        </tbody>
                    </table>
                    
                </div>

                <div class="layui-col-md8"> 
                        <!-- <form class="layui-form" action="">
                            <div class="layui-form-item layui-form-text" style="margin: 10px; ">
                                <textarea  class="layui-textarea" id="LAY-msg-content" style="resize:none" placeholder="有什么新鲜事想告诉大家"></textarea>
                                <button class="layui-btn layui-btn-normal" id="item-btn" style="float: right;" type="submit">提交</button>
                            </div>
                        
                        </form> -->
                    
                    
                    
                    <div class="container" style="margin-top: 16px;">
                        <div class="contar-wrap">

                            <h4 class="item-title">
                                <p><i class="layui-icon layui-icon-speaker"></i>公告：<span>欢迎来到今日新闻</span></p>
                            </h4>

                            <s:iterator value="#session.newslist">
                            <div class="item">
                                <div class="item-box  layer-photos-demo3 layer-photos-demo">
                                    <div class="layui-row">
                                        <div class="layui-col-md2" style="margin: 6px;">
                                            <img src="../res/static/images/item.png" alt="" width="100%">
                                        </div>
                                        <div class="layui-col-md9">
                                            <h3><a href="NewsDetails?id=<s:property value="id"/>"><s:property value="title" escape="false"/></a></h3>
                                            <h5><span><s:property value="author"/>&nbsp;</span>发布于：<span><s:property value="createTime"/></span></h5>
                                        </div>
                                    </div>
                                    
                                </div>
                                <div class="comment count">
                                    <a href="NewsDetails?id=<s:property value="id"/>">评论</a>
                                    <a href="javascript:;" class="like">点赞</a>
                                </div>
                            </div>
                            </s:iterator>

                        </div>
                        <div class="item-btn">
                            <button class="layui-btn layui-btn-normal">下一页</button>
                        </div>

                            
                    </div>
                </div>
              

                <div class="layui-col-md3" style=" padding-top: 15px">
                    <div class="layui-form-item blog-sewrap">
					    <div class="layui-input-block blog-sebox">

					      <input type="text" name="title" lay-verify="title" autocomplete="off"  class="layui-input" placeholder="搜索">
					    </div>
					</div>
                    <div class="layui-card" style=" margin-top: 15px">
                        <div class="layui-card-header">卡片面板</div>
                        <div class="layui-card-body">
                            卡片式面板面板通常用于非白色背景色的主体内<br>
                            从而映衬出边框投影
                        </div>
                    </div>
                </div>
            </div>
        </div>

        

		<div class="footer">
			<p>
				<span>&copy; 2019</span>
				<span><a href="http://www.layui.com" target="_blank">layui.com</a></span> 
				<span>MIT license</span>
			</p>
			<p><span>人生就是一场修行</span></p>
		</div>
	<script src="../res/layui/layui.js"></script>
	<script>
		layui.config({
		  base: '../res/static/js/' 
		}).use('blog');	
	</script>
</body>
</html>