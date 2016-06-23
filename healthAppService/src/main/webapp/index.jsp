<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/login" method = "post">
		<input type = "text" placeholder="请输入您的用户名" name = "userName">
		<input type = "password" placeholder="请输入密码" name = "userPassword">
		<input type = "submit" id = "submit">
	</form>
</body>
</html>