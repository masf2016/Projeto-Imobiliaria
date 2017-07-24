<%--
    Document   : index
    Created on : 15/09/2010, 14:54:49
    Author     : Mrio
--%>


<%@page import="java.util.Calendar"%>
<%@page import="dados.Conexao"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@page import="negocios.TelefoneCorretor"%>
<%@page import="negocios.EnderecoCorretor"%>
<%@page import="negocios.Corretor" %>
<%@page import="negocios.Acesso" %>
<%@page import="repositorios.RepositorioCorretor" %>


<%

Conexao connect = new Conexao();
connect.abrirConexao();


String nomeCorretor = request.getParameter("nomeCorretor");
String cpfCorretor = request.getParameter("cpfCorretor");
String rgCorretor = request.getParameter("rgCorretor");
String emailCorretor = request.getParameter("emailCorretor");


String ruaCorretor = request.getParameter("ruaCorretor");
String numeroCorretor = request.getParameter("numeroCorretor");
String complementoCorretor = request.getParameter("complementoCorretor");
String bairroCorretor = request.getParameter("bairroCorretor");
String cidadeCorretor = request.getParameter("cidadeCorretor");

String tipoTelefoneCorretor = request.getParameter("tipoTelefoneCorretor");
int dddTelefoneCorretor = Integer.parseInt(request.getParameter("dddTelefoneCorretor"));
int numeroTelefoneCorretor = Integer.parseInt(request.getParameter("numeroTelefoneCorretor"));


//variaveis temporarias que recebem valores a serem adicionados em Acesso

String tempTipoCorretor = "corretor";

String login = request.getParameter("login");
String senha = request.getParameter("senha");
String tipoDeUsuario = tempTipoCorretor;



RepositorioCorretor repositorioCorretor = new RepositorioCorretor();
//objeto enderecoCorretor.
EnderecoCorretor enderecoCorretor = new EnderecoCorretor(ruaCorretor, numeroCorretor, complementoCorretor, bairroCorretor, cidadeCorretor);

//objeto telefoneCorretor.
TelefoneCorretor telefoneCorretor = new TelefoneCorretor(tipoTelefoneCorretor, dddTelefoneCorretor, numeroTelefoneCorretor);

Acesso acesso = new Acesso(login, senha, tipoDeUsuario);
//objeto corretor.
Corretor corretor = new Corretor(nomeCorretor, cpfCorretor, rgCorretor, emailCorretor, enderecoCorretor, telefoneCorretor, acesso);
// chamada do metodo inserirCorretor em seguida passa Corretor,EnderecoCorretor e TelefoneCorretor como parmetro.
repositorioCorretor.inserirCorretor(corretor, enderecoCorretor, telefoneCorretor, acesso);

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
        </div>        <!-- End Left Column -->

        <!-- Begin Right Column -->
        <div id="rightcolumn">
            <h4 align="center">Cadastro Efetuado  com sucesso!<a class="painel" href="paineladm.jsp">    </a></h4>
            <div align="center"><br>
              
            </div>
            <h5 align="center"><a class="painel" href="adm.jsp">retornar ao menu</a></h5>
                    <h5 align="center"><a class="painel" href="inserirCorretor.jsp">Cadastrar outro Corretor</a></h5>


</div>
        <!-- End Right Column -->

        <div style="clear: both;"></div>
        <!-- Footer -->
        <div id="footer">Imobi -Imobiliaria Limoeirense

</div>
        <!-- End Footer -->
  
    <!-- End Wrapper -->


</body>
</html>
