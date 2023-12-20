<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.solutions.springJsp.controller.MvcController" %>
<%@ page import="com.solutions.springJsp.service.MvcService" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<jsp:useBean id="user" class="com.solutions.springJsp.entity.User" scope="page"/>
	<jsp:setProperty name="user" property="*" />

	<h2><%=user.getName()+" " %>Registered Successfully.</h2>
	<h2>Register Another User: <a href="userForm">Click here</a></h2>
	<h2>View Registered Users: <a href="registeredUsers">Click here</a> </h2>
</body>
</html>