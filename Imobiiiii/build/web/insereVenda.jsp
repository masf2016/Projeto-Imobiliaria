<%-- 
    Document   : insereVendal
    Created on : 02/12/2010, 14:11:44
    Author     : Administrador
--%>


<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@page import="dados.Conexao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="utilitarios.FormataData" %>
<%@page import="negocios.EnderecoImovel"%>
<%@page import="negocios.EnderecoCliente"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>

<%@page import="negocios.Venda"%>
<%@page import="negocios.Cliente" %>
<%@page import="negocios.Corretor" %>
<%@page import="negocios.Imovel" %>
<%@page import="negocios.Pagamento" %>
<%@page import="repositorios.RepositorioVenda" %>


<%
Conexao connect = new Conexao();
Connection c = null;

RepositorioVenda repositorioVenda = null;

Venda v = new Venda();
repositorioVenda.inserirVenda(venda, cliente, imovel, corretor, pagamento);

//objeto corretor.
RepositorioVenda repositorioVenda = new RepositorioVenda();
repositorioVenda.inserirVenda(venda, cliente, imovel, corretor, pagamento);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>   </title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>

<body>

    <!-- Begin Wrapper -->
    <div id="wrapper">

        <!-- Begin Header -->
        <div id="header">

            <img src="images/header.jpg" alt="your header image" height="170px" width="921px" />

        </div>
        <!-- End Header -->

        <!-- Begin Navigation -->
        <div id="navigation">

            <div class="row-2">
                <ul class="site-nav">


                </ul>
            </div>


        </div>
        <!-- End Navigation -->

        <!-- Begin Left Column -->
        <div id="leftcolumn">



        </div>
        <!-- End Left Column -->

        <!-- Begin Right Column -->
        <div id="rightcolumn">
            <h4>&bull; Corretor Inserido! - <a class="painel" href="paineladm.jsp">    </a></h4>
            <br>


        </div>
        <!-- End Right Column -->

        <div style="clear: both;"></div>
        <!-- Footer -->
        <div id="footer">

        </div>
        <!-- End Footer -->
    </div>
    <!-- End Wrapper -->


</body>
</html>