<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" ></link>
</head>
<body>
<div id="login" style=" position:relative;margin : 0 auto;width : 500px;">
<div><s:property value="message"/></div>
<form action="login" method="post">
<table>
	<tr>
		<td><label>Name:</label></td>
		<td><input name="name" type="text"></input></td>
	</tr>
	<tr>
		<td><label>PassWord:</label></td>
		<td><input name="password" type="password" ></input></td>
	</tr>
	<tr>
		<td><input type="submit" value="Submit"></input></td>
	</tr>
</table>
</form>
</div>
<script type="text/javascript" src="extjs/adapter/ext/ext-base.js"></script>
</body>
</html>