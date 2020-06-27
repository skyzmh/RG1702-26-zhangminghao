<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>发布新闻</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="../res/layui/css/layui.css">
	<link rel="stylesheet" href="../res/static/css/mian.css">
</head>
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

<table  border="1" class="layui-table">

<tbody align="center">

<form method="post" action="newsAdd">
	<tr>
		<td> 分类 </td>
		<td>
		<select name="newsClassId" lay-verify="">
			<s:iterator value="#session.sortlist">
				<option name="news.newsClassId" value="<s:property value="id"/>"><s:property value="sortName"/></option>
			</s:iterator>
		</select>
		</td>
	</tr>
	<tr>
		<td> 标题 </td>
		<td><input name="news.title" type="text" value="" class="layui-input"/> </td>
	</tr>
	<tr>
		<td>内容</td>
		<td><textarea style="width:600px;height:300px;" name="news.content" type="text" value="" class="layui-textarea"></textarea></td>
	</tr>
	<tr>
		<td>操作</td>
		<td><div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit>立即提交</button>
			</div>
		</div></td>
		
	</tr>
</form> 	

	

</tbody>
</table>

</body>

</html>
