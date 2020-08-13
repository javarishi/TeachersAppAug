<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SQL Tags</title>
</head>
<body>
<sql:setDataSource var="conn" 
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/sakila"
		user="root" 
		password="password"/>


<%
String firstName = "RYAN";
%>


<sql:update dataSource="${conn}"  var="count" >
	UPDATE actor SET first_name = ? where actor_id = ?;
	<sql:param value="<%= firstName %>" />
	<sql:param value="<%=45 %>" />
	
	<c:out value="${count}"></c:out>
</sql:update>

		
<sql:query dataSource="${conn}" var="result">
	SELECT * from Actor;
</sql:query>
<table border="1" width="100%">
<tr>
	<th>Actor ID</th>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Last Update</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
	<td><c:out value="${row.actor_id}" /></td>
	<td><c:out value="${row.first_name}"/></td>
	<td><c:out value="${row.last_name}"/></td>
	<td><c:out value="${row.last_update}"/></td>
</tr>
</c:forEach> 
</table>


</body></html>
