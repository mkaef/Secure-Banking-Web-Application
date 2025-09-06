<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Branch Form</title>
</head>
<body>
<div align="center">

<table>
<tr>
<td><a href="home">Home</a></td><td>|</td>
<td><a href="userForm">User Form</a></td><td>|</td>
<td><a href="branchForm">Branch Form</a></td>

<td>|</td>
<td><a href="logout">Logout</a></td>

</tr>
</table>
<sec:authorize access="hasAuthority('Admin')" >	
		<h1>Branch Form</h1>
		
		<f:form action="saveBranch" modelAttribute="branch">
			<table border="1">
			

				<tr>
					<td>BranchId</td>
					<td><f:input type="text" path="branchId" name="branchId"
							value="${b.getBranchId()}" /></td>
				</tr>

				<tr>
					<td>BranchName:</td>
					<td><f:input type="text" path="branchName" name="branchName"
							value="${b.getBranchName()}" /></td>
				</tr>

				<tr>
					<td colspan="2">Address:</td>
				</tr>

				<tr>
					<td>AddressLine1:</td>
					<td><f:input path="branchAddress.addressLine1"
							value="${b.getBranchAddress().getAddressLine1()}" /></td>

				</tr>

				<tr>
					<td>AddressLine2:</td>
					<td><f:input path="branchAddress.addressLine2"
							value="${b.getBranchAddress().getAddressLine2()}" /></td>

				</tr>

				<tr>
					<td>City:</td>
					<td><f:input path="branchAddress.city"
							value="${b.getBranchAddress().getCity()}" /></td>

				</tr>

				<tr>
					<td>State:</td>
					<td><f:input path="branchAddress.state"
							value="${b.getBranchAddress().getState()}" /></td>

				</tr>

				<tr>
					<td>Country:</td>
					<td><f:input path="branchAddress.country"
							value="${b.getBranchAddress().getCountry()}" /></td>

				</tr>

				<tr>
					<td>ZipCode:</td>
					<td><f:input path="branchAddress.zipCode"
							value="${b.getBranchAddress().getZipCode()}" /></td>

				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Submit" /></td>
				</tr>

				<thead>
			</table>
		</f:form>
        </sec:authorize>
		<table border="1">
			<tr>
				<td>Branch Id</td>
				<td>Branch Name</td>
				<td>Branch Address</td>
				<sec:authorize access="hasAuthority('Admin')" >
				<td colspan="2" align="center">Action</td>
				</sec:authorize>
			</tr>
			<c:forEach items="${branches}" var="b">
				<tr>
					<td>${b.getBranchId()}</td>
					<td>${b.getBranchName()}</td>
					<td>${b.getBranchAddress().getAddressLine1()}
						${b.getBranchAddress().getAddressLine2()}
						${b.getBranchAddress().getCity()}
						${b.getBranchAddress().getState()}
						${b.getBranchAddress().getCountry()}
						${b.getBranchAddress().getZipCode()}</td>
						
                    <sec:authorize access="hasAuthority('Admin')" >	
					<td><a href="updateBranch?branchId=${b.getBranchId()}">Update</a></td>
					<td><a href="deleteBranch?branchId=${b.getBranchId()}">Delete</a></td>
					</sec:authorize>
				</tr>
			</c:forEach>

		</table>

	</div>
</body>
</html>
