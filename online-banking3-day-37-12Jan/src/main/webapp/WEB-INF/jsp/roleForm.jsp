<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" >
<meta charset="ISO-8859-1">
<title>Role Form</title>
<style type="text/css">
.error(color:red;)
</style>
</head>
<body>
<div align="center">
<h1>Role Form</h1>
<f:form action="saveRole" method="POST" modelAttribute="role">
<table>
<tr>
<td>Role Id:</td>
<td><f:input path="roleId" /></td>
<td><f:errors path="roleId" cssClass="error" /></td>
</tr>

<tr>
<td>Name:</td>
<td><f:input path="name" /></td>
<td><f:errors path="name" cssClass="error" /></td>
</tr>

<tr>
<td colspan="3" align="center"><input type="submit"
value="submit" class="btn btn-primary"/></td>
</tr>



</table>
</f:form>
</div>

<div class="container-sm">
<table class="table table-bordered border-primary">
<thead>
<tr>
<td>Role Id</td>
<td>Role Name</td>
</tr>
</thead>
<c:forEach items="${roles}" var="role">

<tr>
<td>${role.getRoleId()}</td>
<td>${role.getName()}</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>