<%--
    Document   : listarCorretor
    Created on : 02/12/2010, 12:30:31
    Author     : Administrador
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="negocios.Imovel" %>
<%@page import="negocios.EnderecoImovel" %>
<%@page import="repositorios.RepositorioImovel" %>

<%
RepositorioImovel repositorioImovel = new RepositorioImovel();
ArrayList<Imovel> imoveis = new ArrayList<Imovel>();

imoveis = repositorioImovel.listaImoveis();

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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <html>
        <head>
            <meta http-equiv="content-type" content="text/html; charset=utf-8" />
            <title>Imobi - limoeiro Imobiliria</title>
            <meta name="keywords" content="" />
            <meta name="description" content="" />
            <link href="styles.css" rel="stylesheet" type="text/css" />
            <style type="text/css">
                <!--
                #leftcolumn form table tr td div strong em {
                    color: #F60;
                }
                #leftcolumn form table tr td div em strong {
                    color: #F60;
                }
                #leftcolumn h4 {
                    font-size: 16px;
                    color: #000;
                }
                #rightcolumn h4 {
                    font-size: 24px;
                }
                -->
            </style>



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

                        <div align="center"><span>Empresa no Ramo de Aluguel de Imoveis</span><br />
                            Nossa satisfação é a sua confiança
                        </div>
                    </div>
                </div>
            </div>
        </div>

            <div id="rightcolumn">
        <h4 align="center"> Listagem de Imoveis</h4>
            <br />
            <center>
            <form action="#" method="post">

            <%
            int cont  = 0;
            for(int i = 0; i < imoveis.size(); i++)
            {
                String cor = null;
                if(i % 2 == 0)
                {
                    cor = "#FFDEAD";
                   // cor = "#F84A61";
                }
                else
                {
                    cor = "#A2B5CD";
                   // cor = "#A7B0D6";
                }

            %>

            <table width="632" border="0" cellspacing="3" cellpadding="1" bgcolor="<%=cor %>">

            <tr>
              <td width="50%"><div align="center"><strong><%=i+1 %>° Imovel  </strong></div></td>
            </tr>

  
            <tr>
                <td width="50%"><div align="center"><strong> Area </strong>
                  <input readonly type="text" size="8" name="cpf" value="<% out.println(imoveis.get(i).getAreaImovel()); %>"></input>
                  <strong> Comodos </strong>
                  <input readonly type="text" size="2" name="nome" value="<% out.println(imoveis.get(i).getQtdComodos()); %>"></input>
                  <strong> Valor R$ </strong>
                  <input readonly type="text" size="10" name="nome" value="<% out.println(imoveis.get(i).getValorImovel()); %>"></input>
                </div></td>
            </tr>


           
           
            <tr>
              <td width=""></td>
            </tr>
            <tr>
                <td width=""><strong> Rua </strong><input readonly type="text" size="30" name="nome" value="<% out.println(imoveis.get(i).getEnderecoImovel().getRuaImovel()); %>"></input><strong> Número </strong><input readonly type="text" size="5" name="nome" value="<% out.println(imoveis.get(i).getEnderecoImovel().getNumeroImovel()); %>"></input>
                  <strong>Cidade </strong>
                <input readonly type="text" size="30" name="nome2" value="<% out.println(imoveis.get(i).getEnderecoImovel().getCidadeImovel()); %>"></td>
            </tr>
            <tr>
              <td width=""></td>
            </tr>
            
           <tr>
                <td width="">&nbsp;</td>
            </tr>
            <tr>
              <td width=""></td>
            </tr>
 

            </table>
            <%
            cont++;
            }
            %>
            <br />
            <h3> Imoveis encontrados: <%=cont%> </h3><br />
            <INPUT TYPE="BUTTON" VALUE="Voltar" ONCLICK="history.go(-1)">
            </form>
            </center>
            <br />

        </div>
    <div id="footer">Imobi - Imobiliaria Limoeirense

</div>
        <!-- End Footer -->
 
    <!-- End Wrapper -->


</body>
</html>

