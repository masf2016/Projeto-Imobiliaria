<%-- 
    Document   : sobre
    Created on : 13/12/2010, 18:36:10
    Author     : Administrador
--%>

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
                              <p align="center"><img src="<%= imagem %>"/></p>
                            </div>
                            <h5 align="center">Bem-vindo <%=usuario%><br/> <%= saudacao%> <br/><%= data%> <br/>  <%=hora%>H <%= minutos%>min</h5>

                            <div align="center"><span>Empresa no Ramo de Aluguel de Imóveis</span><br />
                                Nossa satisfação é a sua confiança
                            </div>
                        </div>
                    </div>
                </div>
              <p><strong>Histórico</strong></p>
                <p>A  Imobi, no mercado imobiliário de Pernambuco há mais de 10 anos, trabalha  especialmente com Vendas e Locações de Casas, Terrenos, Imóveis para  incorporação, áreas industriais, loteamentos fechados, apartamentos em áreas  nobres principalmente nas regiões de Recife,Salvador,Natal e João Pessoa.</p>
                <p>&nbsp;</p>
                <p>A  Imobi possui como principal objetivo a melhoria contínua, buscando a satisfação  do cliente e cativando-o para sempre.</p>
                <p><strong>Missão</strong></p>
                <p>1.  Atender o maior número possível de clientes, em suas necessidades de comprar,  vender ou alugar imóveis.</p>
                <p>2.  Usar nossa experiência de anos no mercado, para proteger o patrimônio dos  nossos clientes.</p>
                <p>3.  Conseguir, a cada negócio, novos amigos, tanto vendedores quanto compradores,  dando com isso continuidade aos negócios, resgatando a idéia do corretor da família.</p>
                <p><strong>Visão</strong></p>
                <p>O  negócio só é bom se todos os envolvidos ficarem satisfeitos, isto é  compradores, vendedores e corretores. &quot;Para que um ganhe, o outro não  precisa perder&quot;</p>
                <p><strong>Valores</strong></p>
              <p> * Ética<br>
                  * Transparência<br>
                  * Honestidade<br>
                  * Empenho máximo para ter sempre clientes e  colaboradores felizes.</p>
                <p>&nbsp;</p>
<h1>&nbsp;</h1>
    <div id="footer">
<p>Imobi - Imobiliária Limoeirense</p>
                </div>
            </div></body>





    </html>
