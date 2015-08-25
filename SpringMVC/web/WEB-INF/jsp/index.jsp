<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="/WEB-INF/tld/spring-form.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Welcome</title>
</head>
<body>
<div style="margin:0 auto;width: 850px;">
<form action="helloForm.htm" method="post"><input
	name="bookingNo" type="text"></input> <input type="submit" value="<fmt:message key="label.add"></fmt:message>"></input>
</form>
<fmt:message key="label.searchResult"></fmt:message>:
<br />
<table width="100%" border="1" style="border-collapse: collapse;text-align : center;">
	<thead>
		<tr>
			<th><fmt:message key="label.id"></fmt:message></th>
			<th><fmt:message key="label.no"></fmt:message></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="o" items="${list}">
			<tr>
				<td><c:out value="${o.id}"></c:out></td>
				<td><c:out value="${o.bookingNo}"></c:out></td>
				<td><a href="helloDel.htm?id=<c:out value="${o.id}"></c:out>"><fmt:message key="label.delete" /></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>