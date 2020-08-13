<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Function Tags</title>
</head>
<body>
<%
String variable = "This is also a String variable";
%>

<c:set var="string1" value=" This is first String." />
<c:set var="string2" value="This is second String."/>


<p>contains(1) : ${fn:contains(string2, "second")}</p>
<p>containsIgnoreCase(2) : ${fn:containsIgnoreCase(string2, "Second")}</p>

<p>Index (1) : ${fn:indexOf(string1, "first")}</p>
<p>Index (2) : ${fn:indexOf(string2, "second")}</p>

<p>toUpperCase (3) : ${fn:toUpperCase(string1)}</p>

<c:set var = "string3" value = "${fn:replace(string2, 'second', 'first')}" />
<c:out value="${string3}" />

<p>Length  : ${fn:length(string2)}</p>

<p>substring  : ${fn:substring(string2, 5, 10)}</p>
<p>trim : ${fn:trim(string1)}</p>

</body>
</html>