<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Complete User Details</title>
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
			if (document.forms["useraccountDetails"]["accountno"].value == ""
					&& document.forms["useraccountDetails"]["username"].value == "") {
				alert("Please Enter The Field on which Basis You Want to Search");
				document.forms["useraccountDetails"]["accountno"].focus();
				document.forms["useraccountDetails"]["username"].focus();

				return false;
			}

		}
	</script>
	<div class="topnav-right">
		<ul class="footer-nav">
			<li><a href="depositdirection"><h4>Deposit&nbsp;&nbsp;|</h4></a></li>
			<li><a href="withdrawdirection"><h4>&nbsp;&nbsp;withdraw&nbsp;&nbsp;|</h4></a></li>

			<li><a href="userdirection"><h4>&nbsp;&nbsp;Back To
						Home Page</h4></a></li>
		</ul>
	</div>
	<form action="useraccountDetails" name="useraccountDetails">
		<table
			style="background-color: #ffffff; filter: alpha(opacity = 40); opacity: 0.95; border: 1px black solid;">
			<tbody>
				<tr>
					<td><h2>Get User List</h2></td>
				</tr>
				<tr>
					<td>Account No :</td>
					<td><input type="number" name="accountno" id="accountno" /></td>
				</tr>

				<tr>
					<td>User Name :</td>
					<td><input type="text" name="username" id="username"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"
						onclick="return validate();"></td>
				</tr>
		</table>

	</form>

</body>
</html>