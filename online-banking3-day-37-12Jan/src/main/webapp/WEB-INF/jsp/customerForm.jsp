<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%> 
    
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Customer Form</title>
</head>
<body>
<div align="center">

<table>
<tr>
<td><a href="home">Home</a></td><td>|</td>
<td><a href="customerForm">Customer Form</a></td>
<sec:authorize access="isAuthenticated()">
<td>|</td>
<td><a href="logout">Logout</a></td>
</sec:authorize>
</tr>
</table>

<h2>Customer Registration</h2>
<f:form action="saveCustomer" modelAttribute="customer">
<table style="with:50%">

<tr>
<td>Customer Id:</td>
<td><input type="text" name="customerId" value="${c.getCustomerId()}"/></td>
</tr>

<tr>
<td>Full Name:</td>
<td><input type="text" name="customerName" value="${c.getCustomerName()}"/></td>
</tr>

<tr>
<td>Gender:</td>
<td>
<input type="radio" name="gender" value="Male"/>Male
<input type="radio" name="gender" value="Female"/>Female
</td>
</tr>

<tr>
<td>DOB</td><td><f:input type="date"  path="customerDOB" name="customerDOB"  value="${c.getcustomerDOB()}"/></td>
</tr>

<tr>
<td>MobileNo:</td>
<td><input type="text" name="customerMobileNo" value="${c.getCustomerMobileNo()}"/></td>
</tr>
  
<tr>
<td>Address:</td>
<td><input type="text" name="customerAddress" value="${c.getCustomerAddress()}"/></td>
</tr>  

<tr>
<td>RealId:</td>
<td><input type="text" name="customerRealId" value="${c.getCustomerRealId()}"/></td>
</tr>

<tr>
<td>UserId:</td>
<td><input type="text" name="userId" value="${user.getUserId()}"/></td>
</tr>

<tr>
<td>UserName:</td>
<td><input type="text" name="username" value="${user.getUserName()}"/></td>
</tr>

</table>          
 
 <f:button>Register</f:button>
 
            
        </f:form>
        <table border="1">
        <tr>
        <td>Customer Id</td>
        <td>Full Name</td>
        <td>Gender</td>
        <td>DOB</td>
        <td>MobileNo</td>
        <td>Address</td>
        <td>RealId</td>
        <td>UserId</td>
        <td>User Name</td>
        <td colspan="2" align="center">Action</td>
        </tr>
        <c:forEach items="${customrs}" var="c">
        <c:forEach items="${users}" var="user">
         <tr>
         <td>${c.getCustomerId()}</td>
         <td>${c.getCustomerName()}</td>
         <td>${c.getGender()}</td>
         <td>${c.getcustomerDOB()}</td>
         <td>${c.getCustomerMobileNo()}</td>
         <td>${c.getCustomerAddress()}</td>
         <td>${c.getCustomerRealId()}</td>
         <td>${user.getUserId()}</td>
         <td>${user.getUserName()}</td>
         
         <td><a href="updateCustomer?customerId=${c.getCustomerId()}">Update</a></td>
		 <td><a href="deleteCustomer?customerId=${c.getCustomerId()}">Delete</a></td>
          </tr>
          </c:forEach>
          <td>
          <a href="${pageContext.request.contextPath}/update?userId=${user.getUserId()}">Update</a>
          <a href="${pageContext.request.contextPath}/delete?userId=${user.getUserId()}">Delete</a>
          </td>
        </c:forEach>
        </table>
        
    </div>
</body>
</html>