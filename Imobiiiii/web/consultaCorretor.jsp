o<%-- 
    Document   : consultaCorretor
    Created on : 08/12/2010, 18:55:26
    Author     : Administrador
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="negocios.Corretor" %>
<%@page import="negocios.EnderecoCorretor" %>
<%@page import="negocios.EnderecoImovel" %>

<%@page import="repositorios.RepositorioCorretor" %>

<%

            RepositorioCorretor repositorioCorretor = new RepositorioCorretor();

// consulta cliente

            String cpfCorretor = request.getParameter("cpfCorretor");

            Corretor corretor = repositorioCorretor.consultarCorretor(cpfCorretor);

// Sessão com os dados do cliente para ser alterado
////session.setAttribute("usuario", cliente);

//Cliente cliente = rep.consultarCliente("123.456.789-00");

//out.println(cliente.getCpf()+" | "+cliente.getNome()+" | "+cliente.getSexo());

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

                        <div align="center"><span>Empresa no Ramo de Aluguel de Imóveis</span><br />
                            Nossa satisfação  a sua confiança
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%
                    if (corretor != null) {

        %>

        <!-- end of content left -->
        <div id="rightcolumn">
            <h4 align="center"> Corretor Localizado </h4>
          <br />
            <form action="consultarCorretor.jsp" method="post">
                <div align="center">
                  <table width="674" border="0" cellpadding="1" cellspacing="3" class="mario">
                    
                    
                    <tr>
                      <td width="666"><strong>CPF
                        <input style="text-align: center;" readonly type="text" size="16" value="<%= corretor.getCpfCorretor()%>">
                        Nome
                        <input style="text-align: center;" readonly type="text" size="50" value="<%= corretor.getNomeCorretor()%>">
                        RG
                        <input style="text-align: center;" readonly type="text" size="20" value="<%= corretor.getRgCorretor()%>">
                        </strong></td>
                      </tr>
                    <tr>
                      <td width="666"></input></td>
                      </tr>
                    <tr>
                      
                      <td height="33"><strong>E-mail
                        <input style="text-align: center;" readonly type="text" size="50" value="<%= corretor.getEmailCorretor()%>">
                        </strong></td>
                      </tr>
                    <tr>
                      <td height="14"></input></td>
                      </tr>
                    
                    <tr>
                      <%

                                    String fixo = null;
                                    String celular = null;
                                    String conceder = null;

                                    if (corretor.getTelefoneCorretor().getTipoTelefoneCorretor().equals("fixo")) {
                                        fixo = "checked";
                                        conceder = "disabled";
                                    } else {
                                        celular = "checked";
                                        conceder = "disabled";
                                    }
                        %>
                      <td width="666"><strong>Tipo de Telefone
                        <input type="radio" <% out.println(conceder);%> name="tipoTelefoneCorretor" value="fixo" <% out.println(fixo);%> >
                        fixo &nbsp;
                        <input type="radio" <% out.println(conceder);%> name="tipoTelefoneCorretor" value="celular" <% out.println(celular);%>>
                        celular </strong></td>
                      </tr>
                    <tr>
                      <td width="666"></input></td>
                      </tr>
                    <tr>
                      <td><strong>DDD
                        <input style="text-align: center;" readonly type="text" size="2" value="<%= corretor.getTelefoneCorretor().getDddTelefoneCorretor()%>">
                        Numero
                        <input style="text-align: center;" readonly type="text" size="10" value="<%= corretor.getTelefoneCorretor().getNumeroTelefoneCorretor()%>">
                        </strong></td>
                      </tr>
                    <tr>
                      <td height="16"></input></td>
                      </tr>
                    
                    
                    
                    
                    <tr>
                      <td><strong>Rua
                        <input style="text-align: center;" readonly type="text" size="50" value="<%= corretor.getEnderecoCorretor().getRuaCorretor()%>">
                        Número
                        <input style="text-align: center;" readonly type="text" size="10" value="<%= corretor.getEnderecoCorretor().getNumeroCorretor()%>">
                        </strong></td>
                      </tr>
                    <tr>
                      <td></input></td>
                      </tr>
                    <tr>
                      <td><strong>Bairro
                        <input style="text-align: center;" readonly type="text" size="50" value="<%= corretor.getEnderecoCorretor().getBairroCorretor()%>">
                        Cidade
                        <input style="text-align: center;" readonly type="text" size="30" value="<%= corretor.getEnderecoCorretor().getCidadeCorretor()%>">
                        </strong></td>
                      </tr>
                    <tr>
                      <td>&nbsp;</td>
                      </tr>
                    <tr>
                      <td></input></td>
                      </tr>
                    <tr>
                      <td><strong>login
                        <input style="text-align: center;" readonly type="text" size="20" value="<%= corretor.getAcesso().getLogin()%>">
                        senha
                        <input style="text-align: center;" readonly type="text" size="20" value="<%= corretor.getAcesso().getSenha()%>">
                        Tipo de Usuario
                        <input style="text-align: center;" readonly type="text" size="30" value="<%= corretor.getAcesso().getTipoDeUsuario()%>">
                        </strong></td>
                      </tr>
                    
                    <tr>
                      <td colspan="2" align="right"><div align="center">
                        <input type="button" value=" Procurar Outro " ONCLICK= "history.go(-1)">
                        </input><input type="button" onClick="MM_goToURL('parent','alterarcliente.jsp');return document.MM_returnValue" value=" Alterar "></input>&nbsp;<input type="button" onClick="MM_goToURL('parent','excluirCliente.jsp');return document.MM_returnValue" value=" Excluir ">
                        </div>                  </input></td>
                      </tr>
                    </table>
              </div>
          </form>
            <br /><br />

    <%
                        } else{
    %>
    <center>                       
    <h4>Corretor não Localizado</h4>
    <INPUT TYPE= BUTTON VALUE= Voltar  ONCLICK= history.go(-1) >
    </center> 
    <%
                        }
    %>
        </div>
        <!-- end of content right -->
        <div class="cleaner_with_height">&nbsp;</div>


        <div id="footer">Imobi - Imobiliaria Limoeirense

</div>
        <!-- End Footer -->
 
    <!-- End Wrapper -->


</body>
</html>
