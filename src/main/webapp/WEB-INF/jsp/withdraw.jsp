<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WithDraw</title>
<style>
tbody, th, td {
	border-collapse: collapse;
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

	<script type="text/javascript">
		function validate() {
			if (document.forms["withdraw"]["accountNumber"].value == "") {
				alert("Please enter Account Number");
				document.forms["withdraw"]["accountNumber"].focus();
				return false;
			}
			if (document.forms["withdraw"]["amount"].value == "") {
				alert("Please enter Amount To Be Deposited");
				document.forms["withdraw"]["amount"].focus();
				return false;
			}
		}
	</script>
<body>
	<div class="topnav-right">
		<ul class="footer-nav">
			<li><a href="depositdirection"><h4>Deposit&nbsp;&nbsp;|</h4></a></li>
			<li><a href="withdrawdirection"><h4>&nbsp;&nbsp;withdraw&nbsp;&nbsp;|</h4></a></li>

			<li><a href="userdirection"><h4>&nbsp;&nbsp;Back To
						Home Page</h4></a></li>
		</ul>
	</div>
	<br>
	<br>
	<form:form modelAttribute="withdraw" action="withdraw" name="withdraw">
		<table
			style="background-color: #ffffff; filter: alpha(opacity = 40); opacity: 0.95; border: 1px black solid;">
			<tbody>
				<tr>
					<td><h2>WithDraw Amount</h2></td>
				</tr>

				<tr>
					<td><form:hidden path="accountId" /></td>
				</tr>
				<tr>
					<td>Account Number :</td>
					<td><form:input path="accountNumber" id="accountNumber" /></td>
				</tr>

				<tr>
					<td>Amount :</td>
					<td><form:input path="amount" id="amount" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"
						onclick="return validate();"></td>
				</tr>
			</tbody>
		</table>

	</form:form>
</html>