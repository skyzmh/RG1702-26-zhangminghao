<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>新闻轻资讯</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="./res/layui/css/layui.css">
	<link rel="stylesheet" href="./res/static/css/mian.css">
	
		<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
	<meta http-equiv="expires" content="0">
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
<body class="lay-blog" >
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
					  <li class="layui-nav-item layui-this"><a href="index.jsp">首页</a></li>
					  <li class="layui-nav-item"><a href="user.jsp">个人信息</a></li>
					  <li class="layui-nav-item"><a href="admin/admin.jsp">后台管理</a></li>
					  
					  <li class="layui-nav-item" lay-unselect="">
					    <a href="javascript:;"><img src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>
					    <dl class="layui-nav-child">
					      <dd><a href="user.jsp">修改信息</a></dd>
					      <dd><a href="admin/admin.jsp">安全管理</a></dd>
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
                            <s:iterator value="#session.sortlist">
                                <tr>
                                    <th><a href="NewsSort?sortId=<s:property value="id"/>"><s:property value="sortName"/></a> </th>  
                                               
                                </tr> 
                            </s:iterator>
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
                        <div class="contar-wrap"id="test1">

                            <h4 class="item-title">
                                <p><i class="layui-icon layui-icon-speaker"></i>公告：<span>欢迎来到今日新闻</span></p>
                            </h4>



							<ul class="list-group">
                            <s:iterator value="#session.newslist">
                            <li class="list-group-item">
                            <div class="item" >
                                <div class="item-box  layer-photos-demo3 layer-photos-demo">
                                    <div class="layui-row">
                                        <div class="layui-col-md2" style="margin: 6px;">
                                            <img src="<s:property value="img"/>" alt="" width="100%">
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
                            </li>
                            </s:iterator>
                            </ul>
                            
                            

                        </div>
                        <div class="item-btn">
                            <button class="layui-btn layui-btn-normal">下一页</button>
                        </div>

                            
                    </div>
                </div>
              

                <div class="layui-col-md3" style=" padding-top: 15px">
                    <div class="layui-form-item blog-sewrap">
					    <div class="layui-input-block blog-sebox">
						<form class="layui-form" action="NewsSer">
					      <input type="text" name="news.title" lay-verify="title" autocomplete="off"  class="layui-input" placeholder="搜索">
					      <button class="layui-btn layui-btn-normal" type="">搜索</button>
					      
					      </form>
					      
					      
					    </div>
					</div>
                    <div class="layui-card" style=" margin-top: 15px">
                    <object type="application/x-shockwave-flash" style="outline:none;" data="http://cdn.abowman.com/widgets/penguins/penguins.swf?" width="100%" height="200"><param name="movie" value="http://cdn.abowman.com/widgets/penguins/penguins.swf?"></param><param name="AllowScriptAccess" value="always"></param><param name="wmode" value="opaque"></param><param name="scale" value="noscale"/><param name="salign" value="tl"/></object>
                          <object type="application/x-shockwave-flash" style="outline:none;" data="http://cdn.abowman.com/widgets/hamster/hamster.swf?" width="100%" height="225"><param name="movie" value="http://cdn.abowman.com/widgets/hamster/hamster.swf?"></param><param name="AllowScriptAccess" value="always"></param><param name="wmode" value="opaque"></param></object>
                    <a href="login/login.html"> <button class="layui-btn">登录</button></a>
                    <a href="user.jsp"> <button class="layui-btn">我的信息</button></a>
                    <a href="admin/admin.jsp"> <button class="layui-btn">后台管理</button></a>

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
	<script src="./res/layui/layui.js"></script>
	<script>
		layui.config({
		  base: './res/static/js/' 
		}).use('blog');	
	</script>
	
	<script src="./res/static/js/paginathing.js"></script>
	<script type="text/javascript">
  jQuery(document).ready(function($){
    $('.list-group').paginathing({
          perPage: 3,
          containerClass: 'contar-wrap'
    })
  });
</script>
	

</body>
</html>