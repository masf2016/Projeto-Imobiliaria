<%-- 
    Document   : listarCliente
    Created on : 02/12/2010, 12:30:31
    Author     : Administrador
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="negocios.Cliente" %>
<%@page import="negocios.EnderecoCliente" %>
<%@page import="negocios.TelefoneCliente" %>
<%@page import="repositorios.RepositorioCliente" %>

<%
RepositorioCliente repositorioCliente = new RepositorioCliente();
ArrayList<Cliente> clientes = new ArrayList<Cliente>();

clientes = repositorioCliente.listaCliente();

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

                        <div align="center"><span>Empresa no Ramo de Aluguel de Imveis</span><br />
                            Nossa satisfação é a sua confiança
                        </div>
                    </div>
                </div>
            </div>
        </div>
            <div id="rightcolumn">
        <h4 align="center">&bull; Listagem de Clientes  </h4>
            <br />
            <center>
            <form action="#" method="post">

            <%
            int cont  = 0;
            for(int i = 0; i < clientes.size(); i++)
            {
                String cor = null;
                if(i % 2 == 0)
                {
                    cor = "#D2691E";
                  //cor = "#FF6600";
                }
                else
                {
                    cor = "#778899";
                  //cor = "#FFCC33";
                }

            %>

            <table width="829" border="0" cellspacing="3" cellpadding="1" bgcolor="<%=cor %>">


            <tr>
                <td ><br></br></td>
            </tr>

            <tr>
              <td width="50%"><strong> <%=i+1 %>° Cliente</strong></td>
            </tr>

            
            <tr>
                <td width="50%"><strong> Nome </strong><input readonly type="text" size="30" name="cpfCliente" value="<% out.println(clientes.get(i).getNomeCliente()); %>"></input><strong> CPF </strong><input readonly type="text" size="16" name="nomeCliente" value="<% out.println(clientes.get(i).getCpfCliente()); %>"></input><strong> RG </strong><input readonly type="text" size="14" name="ruaCliente" value="<% out.println(clientes.get(i).getRgCliente()); %>"></input>
                   </td>
            </tr> 
            <tr>
                <td><strong>E-mail</strong><input readonly type="text" size="50" name="numeroCliente2" value="<% out.println(clientes.get(i).getEmailCliente()); %>"></td>
            </tr>
          



            <tr>
                <td width="50%" height="11"></input></td>
            </tr>

            <tr>
                <td height="27" ><strong>Endereco </strong>
                  <input readonly type="text" size="37" name="idEnderecoCLiente" value="<% out.println(clientes.get(i).getEnderecoCliente().getRuaCliente()); %>">
                  <br></br></td>
            </tr>
            <tr>
              <td width="50%"></td>
            </tr>
            <tr>
                <td width="50%"><strong>N°</strong>
                  <input readonly type="text" size="5" name="numeroCliente" value="<% out.println(clientes.get(i).getEnderecoCliente().getNumeroCliente()); %>">
                  <strong>DDD </strong>
                  <input readonly type="text" size="2" name="dddTelefoneCliente" value="<% out.println(clientes.get(i).getTelefoneCliente().getDddTelefoneCliente()); %>">
                  <strong> Telefone </strong>
                <input readonly type="text" size="10" name="idTelefoneCliente" value="<% out.println(clientes.get(i).getTelefoneCliente().getNumeroTelefoneCliente()); %>"></td>
            </tr>

            <tr>
                <td width="50%" height="32"><strong>Login </strong><input readonly type="text" size="15" name="login" value="<% out.println(clientes.get(i).getAcesso().getLogin()); %>"></input><strong> Senha </strong><input readonly type="text" size="15" name="senha" value="<% out.println(clientes.get(i).getAcesso().getSenha()); %>"></input><strong> Tipo de Usuário </strong><input readonly type="text" size="10" name="tipoDeUsuario" value="<% out.println(clientes.get(i).getAcesso().getTipoDeUsuario()); %>"></input></td>
            </tr>

            <tr>
                <td ><br></br></td>
            </tr>


            
            </table>
            <%
            cont++;
            }
            %>
            <br />
            <p><h3>Foram encontrados <%=cont%> clientes.</h3></p>
            <br />
           
            
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
