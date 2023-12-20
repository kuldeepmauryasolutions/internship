<%@page import="java.io.PrintWriter"%>
<%@page import="com.solutions.springJsp.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.solutions.springJsp.service.MvcService" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Page</title>
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
</style>

</head>
<body>
	<%
	List<User> users=(List<User>)request.getAttribute("users");
	out.println("<h2>Registered Users Are: </h2><br>");
/*	for(User user: users){
		out.println("Name: "+user.getName()+"<br>");
		out.println("Email: "+user.getEmail()+"<br>");
		out.println("Password: "+user.getPassword()+"<br>");
		out.println("Gender: "+user.getGender()+"<br>");
		out.println("Address: "+user.getAddress()+"<br>");
		out.println("Birthday: "+user.getBirthday()+"<br>");
		out.println("****************************<br>");
	}
*/
	out.println("<div><table border=\"1\"><tr><th>Key</th><th>Value</th></tr>");
	for(User user: users){
		out.println("<tr><td>Name: </td><td>"+user.getName()+"</td></tr>");
		out.println("<tr><td>Email: </td><td>"+user.getEmail()+"</td></tr>");
		out.println("<tr><td>Password: </td><td>"+user.getPassword()+"</td></tr>");
		out.println("<tr><td>Gender: </td><td>"+user.getGender()+"</td></tr>");
		out.println("<tr><td>Address: </td><td>"+user.getAddress()+"</td></tr>");
		out.println("<tr><td>Birthday: </td><td>"+user.getBirthday()+"</td></tr>");
		out.println("<tr><td>**********</td><td>****************</td></tr>");
	}
	out.println("</table><div>");
	
	%>
</body>
</html>