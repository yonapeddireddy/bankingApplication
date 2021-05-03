<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details Save</title>
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
<script type="text/javascript">
	function validate() {
		if (document.forms["update"]["password"].value == "") {
			alert("Please Enter New Password");
			document.forms["update"]["password"].focus();
			return false;
		}
		if (document.forms["update"]["userId"].value == "") {
			alert("Please enter UserId To Update Your Password");
			document.forms["update"]["userId"].focus();
			return false;
		}

	}
</script>
</head>
<body>
	<div class="topnav-right">
		<ul class="footer-nav">

			<li><a href="transaction"><h4>&nbsp;&nbsp;Back To Home</h4></a></li>
		</ul>
	</div>
	<br>
	<br>
	<form:form modelAttribute="update" action="update" name="update">
		<table
			style="background-color: #ffffff; filter: alpha(opacity = 40); opacity: 0.95; border: 1px black solid;">
			<tbody>
				<tr>
					<td><h2>Update Password</h2></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><form:password path="password" id="password" /></td>
				</tr>
				<tr>
					<td>UserId :</td>
					<td><form:input path="userId" id="userId" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"
						onclick="return validate();"></td>
		</table>
		<a href="depositdirection">Deposit</a>
		<a href="withdrawdirection">withdraw</a>
		<a href="login">Logout</a>


	</form:form>


</body>
</html>