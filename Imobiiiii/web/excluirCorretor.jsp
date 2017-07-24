<%-- 
    Document   : excluirCorretor
    Created on : 02/12/2010, 13:40:06
    Author     : Administrador
--%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>

<%@page import="negocios.Corretor" %>
<%@page import="repositorios.RepositorioCorretor" %>

<%
RepositorioCorretor repositorioCorretor = new RepositorioCorretor();

Corretor corretor = (Corretor) session.getAttribute("corretor");

repositorioCorretor.excluirCorretor(corretor.getCpfCorretor());


%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Book Store</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>

            <h4>&bull; Corretor Excluído</h4>
            <br />
			<a href="ladm.jsp">Clique aqui para voltar</a>

          <!-- end of content right -->
    <div class="cleaner_with_height">&nbsp;</div>



<!-- end of container -->
</body>
</html>