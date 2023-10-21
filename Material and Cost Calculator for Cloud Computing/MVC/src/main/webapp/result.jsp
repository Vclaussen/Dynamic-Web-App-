<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="com.Inputs" %>


<%
//get inputs
Inputs inputs = (Inputs) request.getAttribute("inputs");
String outputHTML = (String) request.getAttribute("outputHTML");

//conversion and processing

//create outputs
%>

<html>
<head>
<meta charset="UTF-8">
<title>Results</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>


<h1>Calculator Results:</h1>



<%= outputHTML %> 

<br>

<a href="index.jsp">Calculate again:</a>







</body>
</html>