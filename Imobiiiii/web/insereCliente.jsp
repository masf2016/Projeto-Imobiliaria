<%-- 
    Document   : index
    Created on : 15/09/2010, 14:54:49
    Author     : Mrio
--%>


<%@page import="dados.Conexao"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@page import="negocios.TelefoneCliente"%>
<%@page import="negocios.EnderecoCliente"%>
<%@page import="negocios.Cliente" %>
<%@page import="negocios.Acesso" %>
<%@page import="repositorios.RepositorioCliente" %>
<%@page import="java.util.Calendar"%>

<%

Conexao connect = new Conexao();
connect.abrirConexao();



String ruaCliente = request.getParameter("ruaCliente");
String numeroCliente = request.getParameter("numeroCliente");
String complementoCliente = request.getParameter("complementoCliente");
String bairroCliente = request.getParameter("bairroCliente");
String cidadeCliente = request.getParameter("cidadeCliente");

String tipoTelefoneCliente = request.getParameter("tipoTelefoneCliente");
int dddTelefoneCliente = Integer.parseInt(request.getParameter("dddTelefoneCliente"));
int numeroTelefoneCliente = Integer.parseInt(request.getParameter("numeroTelefoneCliente"));



String nomeCliente = request.getParameter("nomeCliente");
String cpfCliente = request.getParameter("cpfCliente");
String rgCliente = request.getParameter("rgCliente");
String emailCliente = request.getParameter("emailCliente");



String tempTipoCliente = "cliente";

String login = request.getParameter("login");
String senha = request.getParameter("senha");
String tipoDeUsuario = tempTipoCliente;


RepositorioCliente repositorioCliente = new RepositorioCliente();
//objeto enderecoCliente.
EnderecoCliente enderecoCliente = new EnderecoCliente(ruaCliente, numeroCliente, complementoCliente, bairroCliente, cidadeCliente);
//objeto telefoneCliente.
TelefoneCliente telefoneCliente = new TelefoneCliente(tipoTelefoneCliente, dddTelefoneCliente, numeroTelefoneCliente);



Acesso acesso = new Acesso(login, senha, tipoDeUsuario);

//objeto cliente.
Cliente cliente = new Cliente(nomeCliente, cpfCliente, rgCliente, emailCliente, enderecoCliente, telefoneCliente, acesso);

// chamada do metodo inserirCliente em seguida passa Cliente,EnderecoCliente , TelefoneCliente e acesso.
repositorioCliente.inserirCliente(cliente, enderecoCliente, telefoneCliente, acesso);

connect.fecharConexao();
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
        </div>
        <!-- End Left Column -->

        <!-- Begin Right Column -->
        <div id="rightcolumn">
            <h4 align="center">Cadastrado efetuado com sucesso! </h4>
          <br>
            <h5 align="center"><a class="painel" href="adm.jsp">retornar ao menu</a></h5>
            <h5 align="center"><a class="painel" href="inserirCliente.jsp">Cadastrar outro Cliente</a></h5>
			

        </div>
        <!-- End Right Column -->

        <div style="clear: both;"></div>
        <!-- Footer -->
        <div id="footer">Imobi - Imobiliaria Limoeirense

        </div>
        <!-- End Footer -->
    
    <!-- End Wrapper -->


</body>
</html>
