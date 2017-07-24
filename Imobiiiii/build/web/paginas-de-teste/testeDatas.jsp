<%-- 
    Document   : newjsp
    Created on : 09/12/2010, 15:57:22
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*" %>
<%
String dias[] = {"Domingo", "Segunda-feira","Terça-feira", "Quarta-feira", "Quinta-feira","Sexta-feira", "Sábado"};
String meses[] = {"Janeiro", "Fevereiro", "Março","Abril", "Maio", "Junho", "Julho", "Agosto","Setembro", "Outubro", "Novembro", "Dezembro"};

Calendar hoje = Calendar.getInstance();

String data = dias[hoje.get(Calendar.DAY_OF_WEEK) - 1] +", " + hoje.get(Calendar.DAY_OF_MONTH) + " de " +meses[hoje.get(Calendar.MONTH)] +" de " + hoje.get(Calendar.YEAR);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p><b>Hoje é:</b> <%= data %></p>
    </body>
</html>
