<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
    <form name="register" action="/news/UserRegister" method="post">
        <table border="2" align="center">
            <caption>注册</caption>
            <tr>
                <th>用户名：</th>
                <td><input name="user.name" id="" type="text" /></td>
            </tr>
            <tr>
                <th>密码：</th>
                <td><input name="user.pass" id="" type="password" /></td>
            </tr>

            <tr>
            
                <td colspan="2" align="center"><input type="submit" value="提交"
                    width="120ppx" /></td>
            </tr>

        </table>
    </form>
</body>
</html>