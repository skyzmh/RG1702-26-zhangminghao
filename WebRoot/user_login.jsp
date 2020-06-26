<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>新闻轻资讯</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
	<meta http-equiv="expires" content="0">

	<link rel="stylesheet" href="./res/layui/css/layui.css">
	<link rel="stylesheet" href="./res/static/css/mian.css">
</head>
  
  <body>


    <br>
    
    
<body class="lay-blog">
		<div class="header">
			<div class="header-wrap">
				<h1 class="logo pull-left">
					<a href="index.html">
                        <h8 style="color: white">今日新闻</h8>
						<!-- <img src="/res/static/images/logo.png" alt="" class="logo-img">
						<img src="./res/static/images/logo-text.png" alt="" class="logo-text"> -->
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
					    <a href="javascript:;"><img src="<s:property value="#session.user.img"/>" class="layui-nav-img">我</a>
<!-- 					    <dl class="layui-nav-child"> -->
<!-- 					      <dd><a href="javascript:;">修改信息</a></dd> -->
<!-- 					      <dd><a href="javascript:;">安全管理</a></dd> -->
<!-- 					      <dd><a href="javascript:;">退了</a></dd> -->
<!-- 					    </dl> -->
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
				<li><a href="./index.html">首页</a></li>
				<li><a href="./message.html">留言</a></li>
				<li><a href="./about.html">关于</a></li>
			</ul>
        </div>
        
        <div class="layui-container">  
  
            <div class="layui-row">
                <div class="layui-col-md1 " >


                    
                    
                </div>

                <div class="layui-col-md8"> 
                        <!-- <form class="layui-form" action="">
                            <div class="layui-form-item layui-form-text" style="margin: 10px; ">
                                <textarea  class="layui-textarea" id="LAY-msg-content" style="resize:none" placeholder="有什么新鲜事想告诉大家"></textarea>
                                <button class="layui-btn layui-btn-normal" id="item-btn" style="float: right;" type="submit">提交</button>
                            </div>
                        
                        </form> -->
                    
                    
                    
                    <div class="container" >
                        <div class="contar-wrap">
                        

                            <h4 class="item-title">
                                
    <form class="layui-form" name="register" action="/news/UserLogin" method="get">
        <table border="2" align="center">
            <caption>用户登录</caption>
            <tr>
                <th>用户名：</th>
                <td><input name="user.name"  type="text" /></td>
            </tr>
            <tr>

            </tr>
            
            <tr>
                <th>密码：</th>
                <td><input name="user.pass"  type="password" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="提交"
                    width="120ppx" /></td>
            </tr>
            

        </table>
    </form>
                
                             
    
	
	
                            
                    </div>
                </div>
              

                <div class="layui-col-md3" style=" padding-top: 15px">
                    
                </div>
            </div>
        </div>


	<script src="./res/layui/layui.js"></script>
	<script>
		layui.config({
		  base: './res/static/js/' 
		}).use('blog');	
		$(document).ready(function () {

		     if(location.href.indexOf("#reloaded")==-1){
		        location.href=location.href+"#reloaded";
		        location.reload();
		    }
		 })



    
    


	</script>
   


  </body>
</html>
