<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit</title>
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
			if (document.forms["transaction"]["fromAccount"].value == "0") {
				alert("Please enter your Account Number");
				document.forms["transaction"]["fromAccount"].focus();
				return false;
			}
			if (document.forms["transaction"]["toAccount"].value == "0") {
				alert("Please Enter Account Number you want to transfer");
				document.forms["transaction"]["toAccount"].focus();
				return false;
			}
			/* if (document.forms["transaction"]["amount"].value == "") {
				alert("Please enter Amount To Transfer");
				document.forms["transaction"]["amount"].focus();
				return false;
			} */
		}
	</script>
<body>
	<div class="topnav-right">
		<ul class="footer-nav">
			<li><a href="transactionlist"><h4>Get Mini
						Statement&nbsp;&nbsp;|</h4></a></li>
			<li><a href="fulltransactionlist"><h4>&nbsp;&nbsp;Get
						full Statement&nbsp;&nbsp;|</h4></a></li>

			<li><a href="userlogin"><h4>&nbsp;&nbsp;Logout</h4></a></li>
		</ul>
	</div>
	<br>
	<br>
	<form:form modelAttribute="transaction" action="savetransaction"
		name="transaction">
		<table
			style="background-color: #ffffff; filter: alpha(opacity = 40); opacity: 0.95; border: 1px black solid;">
			<tbody>
				<tr>
					<td><h2>Transfer Amount In Between Accounts</h2></td>
				</tr>
				<tr>
					<td><form:hidden path="transactionId" /></td>

				</tr>
				<tr>
					<td>Your Account Number :</td>
					<td><form:input path="fromAccount" id="fromAccount" /></td>
				</tr>

				<tr>
					<td>To Account Number :</td>
					<td><form:input path="toAccount" id="toAccount" /></td>
				</tr>
				<tr>
					<td>Transfer Amount :</td>
					<td><form:input path="amount" id="amount" /></td>
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