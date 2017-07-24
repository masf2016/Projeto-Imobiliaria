<%--
    Document   : alteraCliente
    Created on : 11/10/2010, 02:10:18
    Author     : Administrador
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>

<%@page import="negocios.Cliente" %>
<%@page import="negocios.EnderecoCliente" %>
<%@page import="negocios.Acesso" %>
<%@page import="negocios.TelefoneCliente" %>
<%@page import="repositorios.RepositorioCliente" %>

<%
RepositorioCliente repositorioCliente = new RepositorioCliente();

//Usuario usuarioAntigo = (Usuario) session.getAttribute("usuario");

String cpfClienteAnterior = (String) session.getAttribute("cpfClienteAnterior");
//String loginAnterior = (String) session.getAttribute("loginAnterior");

String cpfCliente = request.getParameter("cpfCliente");
String nomeCliente = request.getParameter("nomeCliente");
String rgCliente = request.getParameter("rgCliente");
String emailCliente = request.getParameter("emailCliente");

String ruaCliente = request.getParameter("ruaCliente");
String numeroCliente = request.getParameter("numeroCliente");
String complementoCliente = request.getParameter("complementoCliente");
String bairroCliente = request.getParameter("bairroCliente");
String cidadeCliente = request.getParameter("cidadeCliente");

String tipoTelefoneCliente =request.getParameter("tipoTelefoneCliente");
int dddTelefoneCliente = Integer.parseInt("dddTelefoneCliente");
int numeroTelefoneCliente = Integer.parseInt("numeroTelefoneCliente");


String login = request.getParameter("login");
String senha = request.getParameter("senha");
String tipoDeUsuario = request.getParameter("tipoDeUsuario");


EnderecoCliente enderecoCliente = new EnderecoCliente(ruaCliente, numeroCliente, complementoCliente, bairroCliente, cidadeCliente);

TelefoneCliente telefoneCliente = new TelefoneCliente(tipoTelefoneCliente, dddTelefoneCliente, numeroTelefoneCliente);

Acesso acesso = new Acesso(login, senha, tipoDeUsuario);
// Recebe o cliente pela sessão para ser alterado
Cliente cliente = new  Cliente(nomeCliente, cpfCliente, rgCliente, emailCliente, enderecoCliente, telefoneCliente, acesso);
// altera usuário
repositorioCliente.alterarCliente(cpfClienteAnterior, cliente, enderecoCliente, telefoneCliente, acesso);

%>

<%
            String dias[] = {"Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};
            String meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

            Calendar hoje = Calendar.getInstance();

            String data = dias[hoje.get(Calendar.DAY_OF_WEEK) - 1] + ", " + hoje.get(Calendar.DAY_OF_MONTH) + " de " + meses[hoje.get(Calendar.MONTH)] + " de " + hoje.get(Calendar.YEAR);

            int hora = hoje.get(Calendar.HOUR_OF_DAY);//armazena a hora
            int minutos = hoje.get(Calendar.MINUTE);//armazena o minutos
            String saudacao = null;



            String usuario = null/*session.getAttribute(name)*/;
            String imagem = null;
            usuario =(String)session.getAttribute("usuario");
            System.out.println(usuario);
            if(usuario == null)
                usuario = "usuário";

            if (hora == 18 &&( hora < 23 && minutos <= 59)) {
                saudacao = " Tenha uma Boa Noite!";
                imagem = "images/lua.png";
            }else
            if (hora >= 0 && hora < 6) {
                saudacao = " Tenha um Bom Comerço de Dia!";
                imagem = "images/lua.png";
            }else
            if (hora >= 6 && hora < 12) {
                saudacao = " Boa Manhã para você!";
                imagem = "images/sol.png";
            }else
            if (hora >= 12 && hora < 18) {
                saudacao = " Boa Tarde Companheiro!";
                imagem = "images/sol.png";
            }

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Imobi -Imobiliaria Limoeirense - Alteração de dados</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="main">
                <!-- header begins -->
                <div id="header">
                    <div id="buttons">
                        <a href="index.jsp" class="but"  title="">Início</a><div class="razd_b"></div>
                        <a href="Sobre.jsp" class="but" title="">Sobre</a><div class="razd_b"></div>
                        <a href="login.jsp"  class="but" title="">Operações</a><div class="razd_b"></div>
                        <a href="contato.jsp"  class="but" title="">Contato</a><div class="razd_b"></div>
                        <a href="login.jsp" class="but" title="">Login</a>

                    </div>
                    <div id="logo">

                        <div class="logo_l">
                            <h2>&nbsp;</h2>
                        </div>
                        <div>
                             <div class="logo_r_super">
                              <p align="center"><img src="<%= imagem %>"/></p>
                            </div>
                            <h5 align="center">Bem-vindo <%=usuario%><br/> <%= saudacao%> <br/><%= data%> <br/>  <%=hora%>H <%= minutos%>min</h5>

                            <div align="center"><span>Empresa no Ramo de Aluguel de Imóveis</span><br />
                                Nossa satisfação é a sua confiança
                            </div>
                        </div>
                    </div>
                </div>
                <!-- header ends -->
                <!-- content begins -->

                <!-- content ends -->
                <!-- footer begins -->
                <div id="footer">
                    <p>Imobi - Imobiliária Limoeirense</p>
                </div>
            </div>
<!-- end of container -->
</body>
</html>
