<%@page import="de.java2enterprise.onlineshop.HalloWeltApplet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Onlineshop</title>
</head>
<body>
	<jsp:plugin codebase="." type="applet" archive="HalloWeltApplet.jar" code="HalloWeltApplet.class" width="400" height="400" jreversion="1.7"></jsp:plugin>
</body>
</html>