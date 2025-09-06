<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<div align="center">
<h1>Home</h1>
<!--  <br>ContextPath: ${pageContext.request.contextPath} -->
<table>
<tr>
<td><a href="${pageContext.request.contextPath}/home">Home</a></td><td>|</td>
<td><a href="${pageContext.request.contextPath}/branchForm">Branch Form</a>|</td>
<td><a href="${pageContext.request.contextPath}/roleForm">Role Form</a></td><td>|</td>
<td><a href="${pageContext.request.contextPath}/userForm">User Form</a></td><td>|</td>
<td><a href="${pageContext.request.contextPath}/customerForm">Customer Form</a></td><td>|</td>
<td><a href="${pageContext.request.contextPath}/transactionForm">Transaction Form</a></td>
<sec:authorize access="isAuthenticated()">
<td>|</td>
<td><a href="${pageContext.request.contextPath}/logout">Logout</a></td>
</sec:authorize>
</tr>
</table>

</div>

</body>
</html>