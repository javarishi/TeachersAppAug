<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:set var="xmltext">
	<books>
		<book>
			<name>Human History</name>
			<author>ZARA</author>
			<price>100</price>
		</book>
		<book>
			<name>Great Mistry</name>
			<author>NUHA</author>
			<price>2000</price>
		</book>
	</books>
</c:set>
<x:parse xml="${xmltext}" var="output"/>

<x:if select="$output//book" >
	Document has at least one book element.
</x:if>


<ul class="list"> 
	<x:forEach select="$output/books/book/name" var="item">
		<li>Book Name: <x:out select="$item" /></li>
	</x:forEach>
</ul>

<x:choose>
	<x:when select="$output//book/author = 'ZARA'">
		Book is written by ZARA
	</x:when>
	<x:when select="$output//book/author = 'NUHA'">
		Book is written by NUHA
	</x:when>
	<x:otherwise>
		Unknown author.
	</x:otherwise>
</x:choose>


<x:set var="fragment" select="$output/books[1]/book/price"/>
	<b>The price of the second book</b>: <x:out select="$fragment" />
</body>
</html>