<%--
    Document   : inserirCorretor
    Created on : 10/11/2010 17:10
    Author     : Administrador
--%>



<%@page import="negocios.Corretor" %>
<%@page import="negocios.EnderecoCorretor" %>
<%@page import="negocios.TelefoneCorretor" %>
<%@page import="negocios.Acesso" %>
<%@page import="repositorios.RepositorioCorretor" %>
<%--
<%@page import="repositorios.RepositorioEnderecoCorretor" %>
<%@page import="repositorios.RepositorioTelefoneCorretor" %>
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
        <style type="text/css">
<!--
#leftcolumn form table tr td div strong em {
	color: #F60;
}
#leftcolumn form table tr td div em strong {
	color: #F60;
}
#leftcolumn h4 {
	font-size: 18px;
	color: #000;
}
#leftcolumn form div table tr td strong em {
	color: #F60;
}
#leftcolumn form div table tr td em strong {
	color: #F60;
}
-->
        </style>
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
        </div>
        <!-- End Left Column -->

        <!-- Begin Right Column -->
        <!-- End Left Column -->

        <!-- Begin Right Column -->
        <div id="leftcolumn">
            <h4 align="center">Corretor </h4>
            <br />
            <form action="insereCorretor.jsp" method="post">
              <div align="center">
                <table width="647" border="0" cellpadding="1" cellspacing="3" class="mario">
                  <tr>
                    <td><strong><em>Corretor</em></strong></td>
                  </tr>
                  <tr>
                    <td width="639"><strong>Nome
                      <input type="text" size="50" maxlength="14" name="nomeCorretor">
                    CPF
                    <input type="text" size="11" maxlength="11" name="cpfCorretor">
                    RG
                    <input type="text" size="20" maxlength="20" name="rgCorretor">
                    </strong></td>
                  </tr>
                  <tr>
                    <td width="639"></input></td>
                  </tr>
                  <tr>
                    <td><strong>Email
                      <input type="text" size="50" maxlength="100" name="emailCorretor">
                    </strong></td>
                  </tr>
                  <tr>
                    <td></input></td>
                  </tr>
                  
                  
                  <tr>
                    <td width="639"><em><strong>Endereço</strong></em></td>
                  </tr>
                  <tr>
                    <td width="639"></input></td>
                  </tr>
                  <tr>
                    <td width="639"><strong>Rua
                      <input type="text" size="50" maxlength="100" name="ruaCorretor">
                    Número
                    <input type="text" size="10" maxlength="5" name="numeroCorretor">
                    </strong></td>
                  </tr>
                  <tr>
                    <td width="639"></input></td>
                  </tr>
                  <tr>
                    <td><hr /></td>
                  </tr>
                  <tr>
                    <td><strong>Complemento
                      <input type="text" size="30" maxlength="50" name="complementoCorretor">
                    Bairro
                    <input type="text" size="30" maxlength="100" name="bairroCorretor">
                    </strong></td>
                  </tr>
                  <tr>
                    <td width="639"><strong>Cidade
                      <input type="text" size="30" maxlength="100" name="cidadeCorretor">
                    </strong></td>
                  </tr>
                  <tr>
                    <td width="639"></input></td>
                  </tr>
                  <tr>
                    <td width="639"><em><strong>Telefone</strong></em></td>
                  </tr>
                  <tr>
                    <td width="639"></input></td>
                  </tr>
                  <tr>
                    <td width="639"><strong>Tipo de Telefone</strong> &nbsp;&nbsp;
                      <input checked type="radio" name="tipoTelefoneCorretor" value="Fixo">
Fixo &nbsp;
<input type="radio" name="tipoTelefoneCorretor" value="Celular">
Celular</td>
                  </tr>
                  <tr>
                    <td width="639"></input></td>
                  </tr>
                  <tr>
                    <td width="639"><strong>DDD
                      <input type="text" size="3" maxlength="2" name="dddTelefoneCorretor">
                    Número
                    <input type="text" size="20" maxlength="10" name="numeroTelefoneCorretor">
                    </strong></td>
                  </tr>
                  <tr>
                    <td width="639"></input></td>
                  </tr>
                  <tr>
                    <td width="639"><em><strong>Acesso</strong></em></td>
                  </tr>
                  <tr>
                    <td width="639"></input></td>
                  </tr>
                  <tr>
                    <td><hr /></td>
                  </tr>
                  <tr>
                    <td><strong>login
                      <input type="text" size="20" maxlength="40" name="login">
                    Senha
                    <input type="password" size="20" maxlength="40" name="senha">
                    </strong></td>
                  </tr>
                  <tr>
                    <td width="639"></input></td>
                  </tr>
                  
                  <tr>
                    <td align="right"><div align="center">
                    <input type="BUTTON" value="Voltar" onClick="history.go(-1)">
                    <input type="submit" value=" Inserir "></input>&nbsp;<input type="reset" value=" Limpar ">
                    </div>                      </input></td>
                  </tr>
                </table>
              </div>
          </form>
            <br /><br />

        </div>
        <!-- End Right Column -->

        <div style="clear: both;"></div>
        <!-- Footer -->
        <div id="footer">
            Imobi
        </div>
        <!-- End Footer -->
    </div>
    <!-- End Wrapper -->


</body>
</html>
