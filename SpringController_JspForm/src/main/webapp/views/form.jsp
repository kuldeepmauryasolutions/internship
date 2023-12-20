<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
<style type="text/css">
body{
background-color: cyan;
}
div{
background-color:silver;
margin-top:50px;
margin-left: 35%;
margin-right: 35%;
}
h2{
color:graytext;
text-decoration: underline;
}
#submit{
font-size: 20px;
margin-left:90%;
}
</style>
</head>
<body>
<div>
	<h2 ALIGN="CENTER">Registration form</h2>
	<form action="submitForm" method="post">
		<table border="1" align="center">
			<tbody>
						
				<tr>
					<td><label for="name">Name: </label></td>
					<td><input id="name" maxlength="50" name="name" type="text" /></td>
				</tr>
				
				<tr>
					<td><label for="email">Email Id:</label></td>
					<td><input id="email" maxlength="50" name="email" type="text" /></td>
				</tr>
				
				<tr>
					<td colspan="2" ><label for="gender">Gender : </label></td>
				</tr>
				<tr>
					<td><label for="gender">Male: </label></td>
					<td><input id="gender" maxlength="50" name="gender" type="radio" value="Male"/></td>
				</tr>
				<tr>
					<td><label for="gender">Female: </label></td>
					<td><input id="gender" maxlength="50" name="gender" type="radio" value="Female"/></td>
				</tr>
				
				<tr>
					<td><label for="birthday">Birthday: </label></td>
					<td><input id="birthday" maxlength="50" name="birthday" type="date" /></td>
				</tr>
				
				<tr>
					<td><label for="address">Address:</label></td>
					<td valign="middle" align="center"><textarea id="address" name="address"></textarea></td>
				</tr>
				
				<tr>
					<td><label for="password">Password:</label></td>
					<td><input id="password" maxlength="50" name="password"
					type="password" /></td>
				</tr>
				
				<tr>
					<td align="right"><input id="submit" name="Submit" type="Submit" value="Register" /></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>