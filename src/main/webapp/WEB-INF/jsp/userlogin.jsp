<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<style>
tbody, th, td {
	border-collapse: collapse;
}

table {
	margin: 0 auto;
	margin-left: auto;
	margin-right: auto;
	margin-top: 40px;
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
</style>
</head>
<script type="text/javascript">
	function validate() {

		if (document.forms["user"]["userName"].value == "") {
			alert("Please enter User username");
			document.forms["user"]["userName"].focus();
			return false;
		}
		if (document.forms["user"]["password"].value == "") {
			alert("Please enter password");
			document.forms["user"]["password"].focus();
			return false;
		}

	}
</script>
</head>
<body>
	<div class="topnav-right">
		<a href="login"><h4>User Login</h4></a>

	</div>
	<br>
	<br>
	<form:form modelAttribute="user" action="Userlogin" name="user">
		<table
			style="background-color: #ffffff; filter: alpha(opacity = 40); opacity: 0.95; border: 1px black solid;">
			<tbody>
				<tr>
					<td><h2>User Login</h2></td>
				</tr>

				<tr>
					<th>User Name :</th>
					<td><form:input path="username" id="userName" /></td>
				</tr>

				<tr>
					<th>Password :</th>
					<td><form:password path="password" id="password" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"
						onclick="return validate();"></td>
				<tr align="center">
				</tr>
			</tbody>
		</table>

	</form:form>


</body>
</html>