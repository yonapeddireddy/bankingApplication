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

		var x = document.forms["usersave"]["email"].value;

		if (document.forms["usersave"]["email"].value == ""
				|| !(x.includes("@")) || !(x.includes(".com"))) {
			alert("Please Enter Valid Email Address");
			document.forms["usersave"]["email"].focus();
			return false;
		}

		if (document.forms["usersave"]["firstname"].value == "") {
			alert("Please enter first name");
			document.forms["usersave"]["firstname"].focus();
			return false;
		}
		if (document.forms["usersave"]["last_name"].value == "") {
			alert("Please enter last name");
			document.forms["usersave"]["last_name"].focus();
			return false;
		}
		if (document.forms["usersave"]["pancard"].value == "") {
			alert("Please enter Pancard Details");
			document.forms["usersave"]["pancard"].focus();
			return false;
		}
		var phn = document.forms["usersave"]["phonenumber"].value;
		if (phn == "" || !(phn.toString().length == 12)) {
			alert("Please Enter Phone Number with Country code");
			document.forms["usersave"]["phonenumber"].focus();
			return false;
		}
		if (document.forms["usersave"]["city"].value == "") {
			alert("Please enter city name");
			document.forms["usersave"]["city"].focus();
			return false;
		}
		if (document.forms["usersave"]["state"].value == "") {
			alert("Please enter Your State");
			document.forms["usersave"]["state"].focus();
			return false;
		}
		if (document.forms["usersave"]["username"].value == "") {
			alert("Please Create Username For Further Use");
			document.forms["usersave"]["username"].focus();
			return false;
		}

	}
</script>
</head>
<body>
	<div class="topnav-right">
		<ul class="footer-nav">
			<li><a href="depositdirection"><h4>Deposit&nbsp;&nbsp;|</h4></a></li>
			<li><a href="useraccountdetails"><h4>&nbsp;&nbsp;Search
						User Details&nbsp;&nbsp;|</h4></a></li>
			<li><a href="withdrawdirection"><h4>&nbsp;&nbsp;withdraw&nbsp;&nbsp;|</h4></a></li>

			<li><a href="accountdirection"><h4>&nbsp;&nbsp;
						Generate Account For User&nbsp;&nbsp;|</h4></a></li>

			<li><a href="login"><h4>&nbsp;&nbsp;Logout</h4></a></li>
		</ul>
	</div>
	<br>
	<br>
	<form:form modelAttribute="usersave" action="saveuserdetails"
		name="usersave">
		<table
			style="background-color: #ffffff; filter: alpha(opacity = 40); opacity: 0.95; border: 1px black solid;">
			<tbody>
				<tr>
					<td><h2>User Details</h2></td>
				</tr>


				<tr>
					<td><form:hidden path="userId" /></td>
				</tr>


				<tr>
					<td>Email :</td>
					<td><form:input path="email" id="email" /></td>
				</tr>
				<tr>
					<td>First-Name :</td>
					<td><form:input path="firstname" id="firstname" /></td>
				</tr>
				<tr>
					<td>Last-Name :</td>
					<td><form:input path="last_name" id="last_name" /></td>
				</tr>
				<tr>
					<td>Pancard :</td>
					<td><form:input path="pancard" id="pancard" /></td>
				</tr>
				<tr>
					<td>Phone Number :</td>
					<td><form:input path="phonenumber" id="phonenumber" /></td>
				</tr>
				<tr>
					<td>city :</td>
					<td><form:input path="city" id="city" /></td>
				</tr>
				<tr>
					<td>State :</td>
					<td><form:input path="state" id="state" /></td>
				</tr>
				<tr>
					<td>Username :</td>
					<td><form:input path="username" id="username" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"
						onclick="return validate();"></td>
				</tr>
			</tbody>
		</table>
	</form:form>


</body>
</html>