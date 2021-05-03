<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="stag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Statement</title>
<style>
tbody, th, td {
	border-collapse: collapse;
		border: 1px solid black;
	
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
			<li><a href="transaction"><h4>&nbsp;&nbsp;Back To Home
						Page</h4></a></li>
		</ul>
	</div>
	<br>
	<br>
	<table>
		<tbody>
			<tr>
				<h2 align="center">Full Statement</h2>
			</tr>
			<tr>
				<th>Transaction_Id</th>
				<th>Amount</th>
				<th>Date_of_Transaction</th>
				<th>From_account</th>
				<th>To_account</th>
				<th>Transaction Type</th>

			</tr>
			<c:forEach items="${transactionList}" var="obj">
				<tr>
					<td>${obj.transactionId}</td>
					<td>${obj.amount}</td>
					<td>${obj.dateOfTransaction}</td>
					<td>${obj.fromAccount}</td>
					<td>${obj.toAccount}</td>
					<td>${obj.type}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>