<%--
    Document   : alterarCliente
    Created on : 22/10/2010, 19:53:45
    Author     : Mario
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@page import="java.util.Calendar"%>
<%@page import="negocios.Cliente" %>
<%@page import="negocios.Acesso" %>
<%@page import="negocios.EnderecoCliente" %>
<%@page import="negocios.TelefoneCliente" %>
<%@page import="repositorios.RepositorioCliente" %>

<%

RepositorioCliente repositorioCliente = new RepositorioCliente();

// Recebe o usurio pela sesso para ser alterado
Cliente cliente = (Cliente) session.getAttribute("cliente");

Acesso acesso = new Acesso();
acesso = repositorioCliente.consultaAcesso(cliente.getCpfCliente());

session.setAttribute("cliente", cliente.getCpfCliente());
session.setAttribute("loginAntigo", acesso.getLogin());

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

                            <div align="center"><span>Empresa no Ramo de Aluguel de Imveis</span><br />
                                Nossa satisfao  a sua confiana
                            </div>
                        </div>
                    </div>
                </div>
    <div id="rightcolumn">
            <h4>&bull; Alterar Cliente - <a class="painel" href="adm.jsp">Painel</a></h4>
            <br />
            <form action="alteraCliente.jsp" method="post">
            <table width="208" border="0" cellspacing="3" cellpadding="1">
            <tr>
                <td width="200"><strong> Novo Cliente </strong> </td>
            </tr>
            <tr>
              <td><strong> Acesso </strong></td>
            </tr>
            <tr>
              <td width="200"><strong> Login </strong><input type="text" size="30" value="<%= cliente.getAcesso().getLogin() %>" name="login"></input></td>
            </tr>
            <tr>
              <td></td>
            </tr>
            <tr>
              <td><strong>Senha</strong><input type="text" size="30" value="<%= cliente.getAcesso().getSenha() %>" name="senha"></input></td>
            </tr>

            <tr>
                <td width="200"> <input type="hidden" value="cliente" name="tipoDeUsuario"></td>
            </tr>

            <tr>
              <td width="200"><strong>CPF</strong><input type="text" size="16" value="<%= cliente.getCpfCliente() %>" name="cpfCliente"></input></td>
            </tr>            
            <tr>
              <td><strong> RG </strong><input type="text" size="20" value="<%= cliente.getRgCliente() %>" name="rgCliente"></input></td>
            </tr>
            <tr>
              <td><strong>Nome</strong><input type="text" size="50" value="<%= cliente.getNomeCliente() %>" name="nomeCliente"></input></td>
            </tr>
            
            <tr>
                <td><strong> Endereo </strong></td>
            </tr>
            <tr>
              <td><strong> Rua </strong><input type="text" size="30" value="<%= cliente.getEnderecoCliente().getRuaCliente() %>" name="ruaCliente"></input></td>
            </tr>
            <tr>
              <td></td>
            </tr>
            <tr>
              <td><strong>Nmero</strong><input type="text" size="30" value="<%= cliente.getEnderecoCliente().getNumeroCliente() %>" name="numeroCliente"></input></td>
            </tr>
            <tr>
              <td></td>
            </tr>
            <tr>
              <td><strong>Bairro</strong><input type="text" size="30" value="<%= cliente.getEnderecoCliente().getBairroCliente() %>" name="bairro"></input></td>
            </tr>
            <tr>
              <td></td>
            </tr>
            <tr>
              <td><strong>Cidade</strong><input type="text" size="20" value="<%= cliente.getEnderecoCliente().getRuaCliente() %>" name="cidade"></input></td>
            </tr>
            <tr>
              <td> <strong>Telefone</strong></td>
            </tr>

            
                        <tr>
              <td><strong>tipo de Telefone</strong>&nbsp;&nbsp;
                  <%

                  String fixo = null;
                  String celular = null;

                  if(cliente.getTelefoneCliente().getTipoTelefoneCliente().equals("fixo"))
                  {
                    fixo = "checked";
                  }
                  else
                  {
                    celular = "checked";
                  }
                  %>
                  <input type="radio" name="tipoDeUsuario" value="fixo" <% out.println(fixo); %> ></input> fixo &nbsp;<input type="radio" name="tipoDeUsuario" value="celular" <% out.println(celular); %>></input> celular
              </td>
            </tr>
            
            <tr>
              <td></td>
            </tr>
            <tr>
              <td><strong> DDD </strong><input type="text" size="30" value="<%= cliente.getTelefoneCliente().getDddTelefoneCliente() %>" name="dddTelefoneCliente"></input></td>
            </tr>
            
            <tr>
              <td></td>
            </tr>
            <tr>
              <td><strong> Numero </strong><input type="text" size="30" value="<%= cliente.getTelefoneCliente().getNumeroTelefoneCliente() %>" name="numeroTelefoneCliente"></input></td>
            </tr>

                          
            <tr>
              <td align="right"><input type="submit" value=" Alterar "></input>&nbsp;<input type="reset" value=" Limpar "></input></td>
            </tr>
            </table>

            </form>
            <br /><br />

        </div>
    <!-- end of content right -->
    <div class="cleaner_with_height">&nbsp;</div>
  </div>
  <!-- end of content -->
  <!-- end of footer -->
<div id="footer">
                    <p>Imobi - Imobiliria Limoeirense</p>
                </div>
<!-- end of container -->
</body>
</html>
