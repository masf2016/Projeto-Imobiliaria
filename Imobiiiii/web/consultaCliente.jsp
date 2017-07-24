<%--
    Document   : consultaCliente
    Created on : 15/09/2010, 14:54:49
    Author     : Mario
--%>

<%@page import="java.util.Calendar"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>

<%@page import="negocios.Cliente" %>
<%@page import="negocios.EnderecoCliente" %>
<%@page import="negocios.TelefoneCliente" %>

<%@page import="repositorios.RepositorioCliente" %>

<%

RepositorioCliente repositorioCliente = new RepositorioCliente();



String cpfCliente = request.getParameter("cpfCliente");

Cliente cliente = repositorioCliente.consultarCliente(cpfCliente);


session.setAttribute("cliente", cliente);

//System.out.println(session.getAttribute("cliente"));
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

                            <div align="center"><span>Empresa no Ramo de Aluguel de Imóveis</span><br />
                                Nossa satisfação é a sua confiança
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    <%
    if(cliente != null)
        {

%>

    <!-- end of content left -->
    <div id="rightcolumn">
            <h4 align="center">Cliente Localizado </h4>
            <br />
            <form action="consultarCliente.jsp" method="post">
              <div align="center">
                <table width="709" border="0" cellspacing="3" cellpadding="1">
                  
                  
                  <tr>
                    <td width="701"><strong>CPF
                      <input style="text-align: center;" readonly type="text" size="16" value="<%= cliente.getCpfCliente() %>">
                    Nome
                    <input style="text-align: center;" readonly type="text" size="50" value="<%= cliente.getNomeCliente() %>">
                    RG
                    <input style="text-align: center;" readonly type="text" size="20" value="<%= cliente.getRgCliente() %>">
                    </strong></td>
                  </tr>
                  <tr>
                    <td width="701"></input></td>
                  </tr>
                  <tr>
                    
                    <td><strong>E-mail
                      <input style="text-align: center;" readonly type="text" size="50" value="<%= cliente.getEmailCliente() %>">
                    </strong></td>
                  </tr>
                  <tr>
                    <td height="13"></input></td>
                  </tr>
                  
                  <tr>
                    <td width="701"><strong>Tipo de Telefone
                                  <%

                  String fixo = null;
                  String celular = null;
                  String conceder = null;

                  if(cliente.getTelefoneCliente().getTipoTelefoneCliente().equals("fixo"))
                  {
                    fixo = "checked";
                    conceder = "disabled";
                  }
                  else
                  {
                    celular = "checked";
                    conceder = "disabled";
                  }
                  %>

                      <input type="radio" <% out.println(conceder); %> name="tipoTelefoneCliente" value="fixo" <% out.println(fixo); %> >
                    fixo &nbsp;
  <input type="radio" <% out.println(conceder); %> name="tipoTelefoneCliente" value="celular" <% out.println(celular); %>>
                    celular </strong></td>
                  </tr>
                  <tr>
                    <td width="701"></input></td>
                  </tr>
                  <tr>
                    <td><strong>DDD
                      <input style="text-align: center;" readonly type="text" size="2" value="<%= cliente.getTelefoneCliente().getDddTelefoneCliente() %>">
                    Numero
                    <input style="text-align: center;" readonly type="text" size="10" value="<%= cliente.getTelefoneCliente().getNumeroTelefoneCliente() %>">
                    </strong></td>
                  </tr>
                  <tr>
                    <td height="13"></input></td>
                  </tr>
                  
                  
                  
                  
                  <tr>
                    <td><strong>Rua
                      <input style="text-align: center;" readonly type="text" size="50" value="<%= cliente.getEnderecoCliente().getRuaCliente() %>">
                    Numero
                    <input style="text-align: center;" readonly type="text" size="10" value="<%= cliente.getEnderecoCliente().getNumeroCliente() %>">
                    </strong></td>
                  </tr>
                  <tr>
                    <td></input></td>
                  </tr>
                  <tr>
                    <td><strong>Bairro
                      <input style="text-align: center;" readonly type="text" size="50" value="<%= cliente.getEnderecoCliente().getBairroCliente() %>">
                    Cidade
                    <input style="text-align: center;" readonly type="text" size="30" value="<%= cliente.getEnderecoCliente().getCidadeCliente() %>">
                    </strong></td>
                  </tr>
                  <tr>
                    <td></input></td>
                  </tr>
                  <td height="12"></tr>
                  
                  <tr>
                    <td><strong>login
                      <input style="text-align: center;" readonly type="text" size="20" value="<%= cliente.getAcesso().getLogin() %>">
                    senha
                    <input style="text-align: center;" readonly type="text" size="20" value="<%= cliente.getAcesso().getSenha() %>">
                    Tipo de Usuario 
                    <input style="text-align: center;" readonly type="text" size="30" value="<%= cliente.getAcesso().getTipoDeUsuario() %>">
                    </strong></td>
                  </tr>
                  <tr>
                    <td></input></td>
                  </tr>
                  <tr>
                    <td></input></td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td></input></td>
                  </tr>
                  <tr>
                    <td></input></td>
                  </tr>
                  
                  <tr>
                    <td colspan="2" align="right"><div align="center">
                      <INPUT TYPE= "BUTTON" VALUE= "Procurar Outro"  ONCLICK= history.go(-1)>
</input><input type="button" onClick="MM_goToURL('parent','alterarCliente.jsp');return document.MM_returnValue" value=" Editar "></input>&nbsp;<input type="button" onClick="MM_goToURL('parent','excluirCliente.jsp');return document.MM_returnValue" value=" Excluir "></input>
                      </div></td>
                  </tr>
                </table>
              </div>
    </form>
        <div align="center"><br />
                         
  <%
        }else{
 %>		
 <center>
 <h4>Cliente não Localizado</h4>
 <INPUT align="center" TYPE= BUTTON VALUE= Voltar  ONCLICK= history.go(-1) >
  </center>
   <%
   }
    %>
   
       
      </div>
    </div>
    <!-- end of content right -->
            <div id="footer">Imobi - Imobiliaria Limoeirense

</div>
        <!-- End Footer -->
 
    <!-- End Wrapper -->

        <!-- End Footer -->
 
    <!-- End Wrapper -->


</body>
</html>

