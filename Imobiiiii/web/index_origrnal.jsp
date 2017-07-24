<%-- 
    Document   : index
    Created on : 05/10/2010, 16:50:05
    Author     : Mário
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
            String dias[] = {"Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};
            String meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

            Calendar hoje = Calendar.getInstance();

            String data = dias[hoje.get(Calendar.DAY_OF_WEEK) - 1] + ", " + hoje.get(Calendar.DAY_OF_MONTH) + " de " + meses[hoje.get(Calendar.MONTH)] + " de " + hoje.get(Calendar.YEAR);

            int hora = hoje.get(Calendar.HOUR_OF_DAY);//armazena a hora
            int minutos = hoje.get(Calendar.MINUTE);//armazena o minutos
            String saudacao = null;

            String usuario = null;
            if(usuario == null)
                usuario = "usuário";

            if (hora == 18 &&( hora < 23 && minutos <= 59)) {
                saudacao = "Tenha uma Boa Noite!";
            }else
            if (hora >= 0 && hora < 6) {
                saudacao = "Tenha Bom Comerço de Dia!";
            }else
            if (hora >= 6 && hora < 12) {
                saudacao = "Boa Manhã para você!";
            }else
            if (hora >= 12 && hora < 18) {
                saudacao = "Boa Tarde Companheiro!";
            }

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

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
                    <a href="adm.jsp"  class="but" title="">Operações</a><div class="razd_b"></div>
                    <a href="contato.jsp"  class="but" title="">Contato</a><div class="razd_b"></div>
                    <a href="Administracao.jsp" class="but" title="">Login</a>
                </div>
                <div id="logo">

                    <div class="logo_l">
                        <a >IMOBI</a>
                        <h2><a>Limoeiro Imobilioaria</a></h2>
                    </div>
                    <div>

                        <h5>Bem-vindo <%=usuario%><br/> <%= saudacao%> <br/><%= data%> <br/>  <%=hora%> <%= minutos%>min</h5>

                        <span>Empresa no Ramo de Compra,Venda e Aluguel de Imóveis</span><br />
                        Nossa satisfação é a sua confiança
                    </div>
                </div>
            </div>
            <!-- header ends -->
            <!-- content begins -->
            <div id="content">
                <div id="right">
                    <h1>Metamorphosis Design</h1>
                    <div class="text">
                        <img src="images/img1.jpg" class="img" width="122"  height="92" alt="" /><span>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</span><br />
                        Vivamus sagittis erat hendrerit orci porttitor fringilla. Donec quis ante convallis massa pharetra condimentum quis eget massa. Donec fringilla elementum lorem sit. amet tempor. Aliquam id arcu ac turpis pulvinar sagittis ac eget libero leo a erat porttitor vestibulum in ut dui. Phasellus et augue et nunc aliquet pellentesque. Fusce commodo sagittis metus, in faucibus lacus placerat in.<br /><br />
                        <span>Sed fringilla faucibus euismod. </span><br />
							Donec eleifend vehicula ligula, a volutpat ante sollicitudin non. Maecenas euismod pharetra magna et commodo. Nam sed arcu et urna consequat ornare. Donec vestibulum varius mi, eget pulvinar orci posuere eget. Cras gravida aliquam
                        <div class="read"><a href="#"><img src="images/read_more.png" alt=""/></a></div>
                    </div>

                    <h1>FREE WEBSITE TEMPLATES USEFUL LINKS</h1>
                    <div class="text">
                        <ol>
                            <li><a href="http://www.metamorphozis.com/free_templates/free_templates.php">Free Website Templates</a></li>
                            <li><a href="http://www.metamorphozis.com/free_flash_templates/free_flash_templates.php">Free Flash Templates</a></li>
                            <li><a href="http://www.metamorphozis.com/shop/flash_templates.php">Flash Templates</a></li>
                            <li><a href="http://www.metamorphozis.com/shop/easy_flash_templates.php">Easy Flash Templates</a> (no flash experience needed to edit)</li>
                            <li><a href="http://www.metamorphozis.com/website_hosting/index.php">Top Hosting Providers</a></li>

                        </ol>
                        <div class="read"><a href="#"><img src="images/read_more.png" alt=""/></a></div>
                    </div>

                    <h1>Free Website Templates</h1>
                    <div class="text">
                        <img src="images/img2.jpg" class="img" width="122"  height="92" alt="" /><span>Aliquam a dui ligula, eget faucibus sapien.</span><br />
                        Aliquam eu augue augue. Nullam urna elit, ornare quis congue at, interdum ac nulla. Etiam gravida quam ut diam fermentum eu fringilla lacus rhoncus. Etiam eleifend ligula ac nunc sagittis non elementum sapien luctus. Curabitur quis elit qua.<br />
                        <br /><br />
                        <span>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. </span><br />
							Vestibulum dictum adipiscing tortor, in condimentum felis tincidunt nec. Fusce pharetra cursus leo, sed rhoncus nunc vehicula eu. Phasellus tempor lobortis lacus non tristique. Phasellus eu velit scelerisque justo aliquet condimentum. Class
                        <div class="read"><a href="#"><img src="images/read_more.png" alt=""/></a></div>
                    </div>
                </div>
                <div id="left">
                    <h1>Categories</h1>
                    <div class="list">
                        <div class="opt"><div class="opt_a">
                                <a class="" href="">Lorem ipsum dolor</a>
                            </div></div>
                        <div class="opt"><div class="opt_a">
                                <a class="" href="">Cras in ante quam</a>
                            </div>
                        </div>
                        <div class="opt"><div class="opt_a">
                                <a class="" href="">Phasellus ege</a>
                            </div>
                        </div>
                        <div class="opt"><div class="opt_a">
                                <a class="" href="">Donec luctus nunc</a>
                            </div>
                        </div>
                        <div class="opt"><div class="opt_a">
                                <a class="" href="">Nam varius arcu </a>
                            </div>
                        </div>
                    </div>
                    <h1>Company News</h1>
                    <div class="box10">
                        <div class="box_top"></div>
                        <div class="left_b"><span class="w">Friday, June 12, 2010</span><br />
                            In hac habitasse platea dictumst. Pel- lentesque porttitor urna dictum mauris
                            <div class="read"><a href="#"><img src="images/read_more.png" alt=""/></a></div>
                        </div>
                        <div class="box_bot"></div>
                    </div>
                    <div style="height:7px"></div>
                    <div class="box10">
                        <div class="box_top"></div>
                        <div class="left_b"><span class="w">Saturday, June 13, 2010</span><br />
                            In hac habitasse platea dictumst. Pel- lentesque porttitor urna dictum mauris
                            <div class="read"><a href="#"><img src="images/read_more.png" alt="" /></a></div>
                        </div>
                        <div class="box_bot"></div>
                    </div>
                </div>
                <div style="clear: both"></div>
            </div>
            <!-- content ends -->
            <!-- footer begins -->
            <div id="footer">
                <p>Copyright  2010. <a href="#">Privacy Policy</a> | <a href="#">Terms of Use</a> | <a href="http://validator.w3.org/check/referer" title="This page validates as XHTML 1.0 Transitional"><abbr title="eXtensible HyperText Markup Language">XHTML</abbr></a> | <a href="http://jigsaw.w3.org/css-validator/check/referer" title="This page validates as CSS"><abbr title="Cascading Style Sheets">CSS</abbr></a></p>
                <p>Design by <a href="http://www.metamorphozis.com/" title="Flash Templates">Flash Templates</a> for <a href="http://www.flashtemplatesdesign.com/" title="Free Flash Templates">Free Flash Templates</a></p>
            </div>
            <!-- footer ends -->
        </div>



        <div style="text-align: center; font-size: 0.75em;">Design downloaded from <a href="http://www.freewebtemplates.com/">free website templates</a>.</div></body>
</html>
