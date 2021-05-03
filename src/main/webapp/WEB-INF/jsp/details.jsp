<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="stag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
<style>
tbody, th, td {
	border-collapse: collapse;
	border: 0.5px solid black;
}

table {
	margin: 0 auto;
	margin-left: auto;
	margin-right: auto;
	margin-top: 30px;
}

a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:hover {
	color: hotpink;
}

th, td {
	padding: 10px;
	text-align: left;
}

.topnav-right {
	float: right;
}

.footer-nav li {
	display: inline;
	float: left;
}
</style>
</head>
<body>
	<div class="topnav-right">
		<ul class="footer-nav">
			<li><a href="userdirection"><h4>&nbsp;&nbsp;Back To
						Home Page</h4></a></li>
		</ul>
	</div>
	<br>
	<br>
<body>
	<table>


		<tbody>
			<tr>
				<h3 align="center">
					<c:out value="${details.user.getFirstname()}" />
					Details
				</h3>
			</tr>
			<tr>
				<th>FrstName:</th>
				<td><c:out value="${details.user.getFirstname()}" /></td>
			</tr>
			<tr>
				<th>LastName:</th>
				<td><c:out value="${details.user.getLast_name()}" /></td>
			</tr>
			<tr>
				<th>Pancard:</th>
				<td><c:out value="${details.user.getPancard()}" /></td>
			</tr>
			<tr>
				<th>PhoneNumber:</th>
				<td><c:out value="${details.user. getPhonenumber()}" /></td>
			</tr>
			<tr>
				<th>City:</th>
				<td><c:out value="${details.user.getCity()}" /></td>
			</tr>
			<tr>
				<th>State:</th>
				<td><c:out value="${details.user.getState()}" /></td>
			</tr>

			<tr>
				<th>City:</th>
				<td><c:out value="${details.user.getCity()}" /></td>
			</tr>

			<tr>
				<th>Account Number:</th>
				<td><c:out value="${details.account.getAccountNumber()}" /></td>
			</tr>
			<tr>
				<th>Available Balance:</th>
				<td><c:out value="${details.account.getBalance()}" /></td>
			</tr>

		</tbody>
	</table>
</body>
</html>