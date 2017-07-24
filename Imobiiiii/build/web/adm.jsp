<%-- 
    Document   : adm
    Created on : 02/12/2010, 12:28:20
    Author     : Administrador
--%>

<%@page import="negocios.Acesso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>

                               

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
       usuario = (String) session.getAttribute("usuario");
       System.out.println(usuario);
       if (usuario == null) {
           usuario = "usuário";
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

                            <div align="center"><span>Empresa no Ramo de Aluguel de Imóveis</span><br />
                                Nossa satisfação é a sua confiança
                            </div>
                        </div>
                    </div>
                </div>
                <!-- header ends -->
                <!-- content begins -->
                <div id="content">
                    <div id="right">
                        <h1>Operações</h1>
                        <div class="text"><br />
                            <h4><a href="inserirCliente.jsp">Inserir Cliente</a></h4>
                            <h4><a href="inserirCorretor.jsp">Inserir Corretor</a></h4>
                            <h4><a href="inserirImovel.jsp">Inserir Imovel</a></h4>
                            <h4><a href="inserirVenda.jsp">Inserir Venda</a></h4>
                            <br/>
                            <h4><a href="consultar.jsp">Consultas</a></h4>

                        </div>


                        <h1>&nbsp;</h1>
                    </div>
                    <div style="clear: both"></div>
                </div>

                

                <div id="footer">
                    <p>Imobi - Imobiliária Limoeirense</p>
                </div>
            </div></body>





    </html>
