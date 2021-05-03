<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Transaction List</title>
</head>
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
			if (document.forms["transaction"]["fromAccount"].value == "") {
				alert("Please enter Account Number");
				document.forms["transaction"]["fromAccount"].focus();
				return false;
			}
			if (document.forms["transaction"]["fromdate"].value == "") {
				alert("Please Enter the Starting Date");
				document.forms["transaction"]["fromdate"].focus();
				return false;
			}
			if (document.forms["transaction"]["todate"].value == "") {
				alert("Please Enter the Ending Date");
				document.forms["transaction"]["todate"].focus();
				return false;
			}
		}
	</script>
<body>
	<div class="topnav-right">
		<ul class="footer-nav">
			<li><a href="transaction"><h4>&nbsp;&nbsp;Back To Home
						Page</h4></a></li>
		</ul>
	</div>
	<br>
	<br>
	<form action="fulltransactionslist" name="transaction">
		<table
			style="background-color: #ffffff; filter: alpha(opacity = 40); opacity: 0.95; border: 1px black solid;">
			<tbody>
				<tr>
					<td><h2>Get Your Complete Transactions</h2></td>
				</tr>
				<tr>
					<td>From Account Number :</td>
					<td><input type="number" name="fromAccount" id="fromAccount" /></td>
				</tr>

				<tr>
					<td>From Date :</td>
					<td><input type="date" name="fromdate" id="fromdate" /></td>
				</tr>
				<tr>
					<td>To Date :</td>
					<td><input type="date" name="todate" id="todate" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"
						onclick="return validate();"></td>
				</tr>
		</table>

	</form>

</body>
</html>