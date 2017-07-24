<%-- 
    Document   : logar
    Created on : 08/12/2010, 17:05:25
    Author     : Administrador
--%>

<%@page import="negocios.Acesso"%>
<%@page import="repositorios.RepositorioCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
<%@page errorPage="erro.jsp" %>
<%@page session="true" %>

<%

            RepositorioCliente repositorioCliente = new RepositorioCliente();

            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            Acesso acesso = repositorioCliente.consultaAcesso(login);

            session.setAttribute("usuario", login);
            //  session.setAttribute("pass", senha);



//Exibi o nome do usuario


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


            if (usuario == null) {
                usuario = "usuário";
            } else if (usuario != null && usuario.equals(acesso.getLogin())) {
                usuario = (String) session.getAttribute("usuario");
            }

            if (hora == 18 && (hora < 23 && minutos <= 59)) {
                saudacao = " Tenha uma Boa Noite!";
                imagem = "images/lua.png";
            } else if (hora >= 0 && hora < 6) {
                saudacao = " Tenha um Bom Comerço de Dia!";
                imagem = "images/lua.png";
            } else if (hora >= 6 && hora < 12) {
                saudacao = " Boa Manhã para você!";
                imagem = "images/sol.png";
            } else if (hora >= 12 && hora < 18) {
                saudacao = " Boa Tarde Companheiro!";
                imagem = "images/sol.png";
            }

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <html>
        <head>
            <meta http-equiv="content-type" content="text/html; charset=utf-8" />
            <title>Imobi - limoeiro Imobiliária</title>
            <meta name="keywords" content="" />
            <meta name="description" content="" />
            <link href="styles.css" rel="stylesheet" type="text/css" />
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
                                <p align="center"><img src="<%= imagem%>"/></p>
                            </div>
                            <h5 align="center">Bem-vindo <%=usuario%><br/> <%= saudacao%> <br/><%= data%> <br/>  <%=hora%>H <%= minutos%>min</h5>
                            <p align="center">&nbsp;</p>

                            <div align="center"><span>Empresa no Ramo de Aluguel de Imóveis</span><br />
                                Nossa satisfação é a sua confiança
                            </div>
                        </div>
                    </div>
                </div>

                <div id="content">
                    <div style="clear: both"></div>
                </div><div id="rightcolumn">

                    <%

// Criar um método para verificar login e senha

            String tipoUsuario1 = "cliente";
            String tipoUsuario2 = "corretor";
// Login e senha encontrados

            String loginEncontrado = null;
            String senhaEncontrada = null;


// OP diferencia cliente e funcionário
            int op = 0;

// testes

            if (login.equals(acesso.getLogin()) && senha.equals(acesso.getSenha()) && tipoUsuario1.equals(acesso.getTipoDeUsuario())) {
                loginEncontrado = acesso.getLogin();
                senhaEncontrada = acesso.getSenha();
                op = 1;
            } else if (login.equals(acesso.getLogin()) && senha.equals(acesso.getSenha()) && tipoUsuario2.equals(acesso.getTipoDeUsuario())) {
                loginEncontrado = acesso.getLogin();
                senhaEncontrada = acesso.getSenha();
                op = 2;
            } else {
                loginEncontrado = acesso.getLogin();
                senhaEncontrada = acesso.getSenha();
                op = 3;
            }

%>

                    <%
                                if (login.isEmpty() || senha.isEmpty()) {
                                    response.sendRedirect("login.jsp");
                                } else {
                                    if (login.equals(loginEncontrado) && senha.equals(senhaEncontrada)) {

                                        if (op == 1) {
                                            response.sendRedirect("PainelCliente.jsp");
                                        } else if (op == 2) {
                                            response.sendRedirect("PainelCorretor.jsp");
                                        } else if (op == 3) {
                                            response.sendRedirect("adm.jsp");
                                        }

                                    } else {
                    %>
                    <center>
                        <b>Login ou Senha inválidos!</b>
                        <br />
                        Aguarde...
                        <META HTTP-EQUIV="Refresh" CONTENT="3;URL=index.jsp">
                    </center>
                    <%                                    //response.sendRedirect("adm.jsp");
                                    }
                                }
                    %>

                </div>
                <!-- content ends -->
                <!-- footer begins -->
                <div id="footer">
                    <p>Imobi - Imobiliária Limoeirense</p>
                </div>
            </div></body>





    </html>