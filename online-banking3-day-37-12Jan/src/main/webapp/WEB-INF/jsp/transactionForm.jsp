<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Form</title>
</head>
<body>
<div align="center">
<table>

<tr>
<td><a href="home">Home</a></td><td>|</td>
<td><a href="userForm">User Form</a></td><td>|</td>
<td><a href="branchForm">Branch Form</a></td><td>|</td>
<td><a href="transactionForm">Transaction Form</a></td>
<sec:authorize access="isAuthenticated()">
<td>|</td>
<td><a href="logout">Logout</a></td>
</sec:authorize>
</tr>
</table>

<h1>Transaction Form</h1>
<f:form action="saveTransaction" modelAttribute="bankTransaction">
<table border="1">

<tr>
<td>BankTransactionId:</td>
<td><f:input type="text" path="bankTransactionId" name="bankTransactionId" 
            value="${bt.getBankTransactionId()}"/></td>
</tr>

<tr>
<td>BankTransactionFromAccount:</td>
<td><f:input type="text" path="bankTransactionFromAccount" name="bankTransactionFromAccount" 
            value="${bt.getBankTransactionFromAccount()}"/></td>
</tr>

<tr>
<td>BankTransactionToAccount:</td>
<td><f:input type="text" path="bankTransactionToAccount" name="bankTransactionToAccount" 
            value="${bt.getBankTransactionToAccount()}"/></td>
</tr>

<tr>
<td>BankTransactionToAccount:</td>
<td><f:input type="text" path="bankTransactionToAccount" name="bankTransactionToAccount" 
            value="${bt.getBankTransactionToAccount()}"/></td>
</tr>

<tr>
<td>BankTransactionAmount:</td>
<td><f:input type="text" path="bankTransactionAmount" name="bankTransactionAmount" 
            value="${bt.getBankTransactionAmount()}"/></td>
</tr>

<tr>
<td>BankTransaction Type:</td>
<td>
<input type="radio" name="bankTrnasactionType" value="deposit"/>DEPOSIT
<input type="radio" name="bankTrnasactionType" value="withdraw"/>WITHDRAW
<input type="radio" name="bankTrnasactionType" value="transfer"/>TRANSFER
<input type="radio" name="bankTrnasactionType" value="new_account"/>NEW_ACCOUNT
</td>          
</tr>

<tr>
<td>BankTransactionDateTime:</td>
<td><f:input type="date"  path="bankTransactionDateTime" name="bankTransactionDateTime" 
            value="${bt.getBankTransactionDateTime()}"/></td>
</tr>

<tr>
<td>Comment:</td>
<td><f:input type="text" path="comment"  name="comment" value="${bt.getComment()}"/></td>
        
</tr>

<tr>
<td colspan="2" align="center"><input type="submit" value="Submit"/></td>
</tr>

</table>
</f:form>

<table border="1">
<tr>
  <td>BankTransaction Id</td> 
  <td>BankTransaction From Account</td> 
  <td>BankTransaction To Account</td> 
  <td>BankTransaction Amount</td>
  <td>BankTransaction Type</td>
  <td>BankTransaction DateTime</td>
  <td colspan="2" align="center">Action</td>
  
</tr>
<c:forEach items="${transactions}" var="bt">

   <tr>
     <td>${bt.getBankTransactionId()}</td>
     <td>${bt.getBankTransactionFromAccount()}</td>
     <td>${bt.getBankTransactionToAccount()}</td>
     <td>${bt.getBankTransactionAmount()}</td>
     <td>${bt.getBankTransactionTypes}</td>
     <td>${bt.getBankTransactionDateTime()}</td>
     
    <td><a href="updateTransaction?bankTransactionId=${bt.getBankTransactionId()}">Update</a></td>
	<td><a href="deleteTransaction?bankTransactionId=${bt.getBankTransactionId()}">Delete</a></td>
   </tr>

</c:forEach>
</table>

</div>
</body>
</html>