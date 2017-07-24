<%-- 
    Document   : JSP_9b
    Created on : 09/12/2010, 12:09:28
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
String name = request.getParameter( "username" );
session.setAttribute( "theName", name );
%>
<html>
<head>
<title>Exemplo JSP_9b (Uso da sessão)</title>
</head>
<body>
<A HREF="JSP_9c.jsp">continue, <%= name %></A>
</body>
</html>
