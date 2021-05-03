<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Generate Account</title>
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
			if (document.forms["accountsave"]["accountType"].value == "") {
				alert("Please enter Type Of Account");
				document.forms["accountsave"]["accountType"].focus();
				return false;
			}
			if (document.forms["accountsave"]["balance"].value == "") {
				alert("Please enter Intial Balance");
				document.forms["accountsave"]["balance"].focus();
				return false;
			}
			if (document.forms["accountsave"]["branch"].value == "") {
				alert("Please enter Branch");
				document.forms["accountsave"]["branch"].focus();
				return false;
			}
			if (document.forms["accountsave"]["userid"].value == "") {
				alert("Please enter UserId You want to create Account");
				document.forms["accountsave"]["userid"].focus();
				return false;
			}
		}
	</script>
</head>
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

	<form:form modelAttribute="accountsave" action="saveaccountdetails"
		name="accountsave">
		<table
			style="background-color: #ffffff; filter: alpha(opacity = 40); opacity: 0.95; border: 1px black solid;">
			<tbody>
				<tr>
					<td><h2>Provide Account Details</h2></td>
				</tr>

				<tr>
					<td><form:hidden path="accountId" /></td>
				</tr>
				<tr>
					<td>Account Type :</td>
					<td><form:input path="accountType" id="accountType" /></td>
				</tr>

				<tr>
					<td>Balance :</td>
					<td><form:input path="balance" id="balance" /></td>
				</tr>
				<tr>
					<td>Branch :</td>
					<td><form:input path="branch" id="branch" /></td>
				</tr>
				<tr>
					<td>UserId :</td>
					<td><form:input path="userid" id="userid" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Submit"
						onclick="return validate();"></td>
				<tr>
				</tr>
			</tbody>
		</table>

	</form:form>


</body>
</html>