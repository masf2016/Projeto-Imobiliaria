<%--
    Document   : inserirCliente
    Created on : 10/11/2010 17:10
    Author     : Administrador
--%>



<%@page import="negocios.Imovel" %>
<%@page import="negocios.EnderecoImovel" %>
<%@page import="repositorios.RepositorioImovel" %>



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
	font-size: 16px;
	color: #000;
}
#leftcolumn form div .mario tr td strong em {
	color: #F60;
}
#leftcolumn form div .mario tr td em strong {
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
            <h4 align="center"> Imovel </h4>
            <br />
            <form action="insereImovel.jsp" method="post">
              <div align="center">
                <table width="571" border="0" cellpadding="1" cellspacing="3" class="mario">
                  <tr>
                    <td><strong><em>Imovel</em></strong></td>
                  </tr>
                  <tr>
                    <td width="563"><strong>Area 
                      <input type="text" size="10" maxlength="10" name="areaImovel">
                    <i>(Em M²)</i></strong></td>
                  </tr>
                  <tr>
                    <td width="563"><strong>Quantidade de Comodos
                      <input type="text" size="2" maxlength="2" name="qtdComodos">
                    Valor do Imovel R$</strong>
                      <input type="text" size="10" maxlength="15" name="valorImovel"></td>
                  </tr>
                  <tr>
                    <td><strong>Descrição
                      <input type="text" size="30" maxlength="100" name="descricaoImovel">
                    </strong></td>
                  </tr>
                  <tr>
                    <td><em><strong>Endereço</strong></em></td>
                  </tr>
                  
                  
                  <tr>
                    <td width="563"><strong>Rua
                      <input type="text" size="30" maxlength="100" name="ruaImovel">
                    Número
                    <input type="text" size="10" maxlength="5" name="numeroImovel">
                    </strong></td>
                  </tr>
                  <tr>
                    <td width="563"><strong>Bairro
                      <input type="text" size="20" maxlength="100" name="bairroImovel">
                    Cidade
                    <input type="text" size="20" maxlength="100" name="cidadeImovel">
                    </strong></td>
                  </tr>
                  <tr>
                    <td width="563">&nbsp;</td>
                  </tr>
                  <tr>
                    <td width="563"></input></td>
                  </tr>
                  <tr>
                    <td><hr /></td>
                  </tr>
                  <tr>
                    <td width="563"></input></td>
                  </tr>
                  
                  <tr>
                    <td><hr /></td>
                  </tr>
                  
                  
                  <tr>
                    <td align="right"><div align="center">
                    <input type="BUTTON" value="Voltar" onClick="history.go(-1)">
                    <input type="submit" value=" Inserir "></input>&nbsp;<input type="reset" value=" Limpar "></input>
                    </div></td>
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
