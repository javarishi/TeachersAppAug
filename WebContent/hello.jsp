<%@ page 
		language="java" 
		contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"
		autoFlush="true"
		buffer="8kb"
		isErrorPage="false"
		session="true"
		isThreadSafe="true"
		isELIgnored="false"
		errorPage="errorPage.jsp"
		%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello JSP</title>
</head>
<body>
	<c:set var="salary" scope="session" value="${2000*2*2}" />
	
	<c:out value="Value of Salary :: " />
	<fmt:formatNumber value="${salary}" type="currency" groupingUsed="true"  />
	
	<c:forTokens items="Zara,nuha,roshy,raju" delims="," var="name" varStatus="indx" >
		<p> For with Tokens: <c:out value="${name}" /></p>
		<p> For with Tokens: <c:out value="${indx}" /></p>
</c:forTokens>
	
	<p> Hello World </p>
	<%-- This is JSP comment --%>
	<!-- this is HTML Comment -->
	<p> Today's date: <%= new java.util.Date() %> </p>
	<%! int i = 1; %>
	<%
		out.println("Your IP address is " + request.getRemoteAddr());
		out.println("Division " + (100/i));
		pageContext.setAttribute("PageAttributeName", "PageAttributeValue", PageContext.PAGE_SCOPE);
		pageContext.setAttribute("REQUESTAttributeName", "REQUESTAttributeValue", PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("SESSIONPageAttributeName", "SESSIONAttributeValue", PageContext.SESSION_SCOPE);
		pageContext.setAttribute("APPLICATIONPageAttributeName", "APPLICATIONAttributeValue", PageContext.APPLICATION_SCOPE);
	%>
	<%@ include file="footer.jsp" %>
</body>
</html>



