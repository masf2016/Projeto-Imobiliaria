<%-- 
    Document   : JSP_9c
    Created on : 09/12/2010, 12:10:50
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Insert title here</title> <title>Insert title here</title>
</head>
<body>
Parabéns, <%= session.getAttribute( "theName" ) %>
</body>
</html>
