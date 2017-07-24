package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;

public final class index_005forigrnal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

            String dias[] = {"Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};
            String meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

            Calendar hoje = Calendar.getInstance();

            String data = dias[hoje.get(Calendar.DAY_OF_WEEK) - 1] + ", " + hoje.get(Calendar.DAY_OF_MONTH) + " de " + meses[hoje.get(Calendar.MONTH)] + " de " + hoje.get(Calendar.YEAR);

            int hora = hoje.get(Calendar.HOUR_OF_DAY);//armazena a hora
            int minutos = hoje.get(Calendar.MINUTE);//armazena o minutos
            String saudacao = null;

            String usuario = null/*session.getAttribute(name)*/;
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


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <title>Imobi - limoeiro Imobiliária</title>\n");
      out.write("        <meta name=\"keywords\" content=\"\" />\n");
      out.write("        <meta name=\"description\" content=\"\" />\n");
      out.write("        <link href=\"styles.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"main\">\n");
      out.write("            <!-- header begins -->\n");
      out.write("            <div id=\"header\">\n");
      out.write("                <div id=\"buttons\">\n");
      out.write("                    <a href=\"index.jsp\" class=\"but\"  title=\"\">Início</a><div class=\"razd_b\"></div>\n");
      out.write("                    <a href=\"Sobre.jsp\" class=\"but\" title=\"\">Sobre</a><div class=\"razd_b\"></div>\n");
      out.write("                    <a href=\"adm.jsp\"  class=\"but\" title=\"\">Operações</a><div class=\"razd_b\"></div>\n");
      out.write("                    <a href=\"contato.jsp\"  class=\"but\" title=\"\">Contato</a><div class=\"razd_b\"></div>\n");
      out.write("                    <a href=\"Administracao.jsp\" class=\"but\" title=\"\">Login</a>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"logo\">\n");
      out.write("\n");
      out.write("                    <div class=\"logo_l\">\n");
      out.write("                        <a >IMOBI</a>\n");
      out.write("                        <h2><a>Limoeiro Imobilioaria</a></h2>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("\n");
      out.write("                        <h5>Bem-vindo ");
      out.print(usuario);
      out.write("<br/> ");
      out.print( saudacao);
      out.write(" <br/>");
      out.print( data);
      out.write(" <br/>  ");
      out.print(hora);
      out.write(' ');
      out.print( minutos);
      out.write("min</h5>\n");
      out.write("\n");
      out.write("                        <span>Empresa no Ramo de Compra,Venda e Aluguel de Imóveis</span><br />\n");
      out.write("                        Nossa satisfação é a sua confiança\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- header ends -->\n");
      out.write("            <!-- content begins -->\n");
      out.write("            <div id=\"content\">\n");
      out.write("                <div id=\"right\">\n");
      out.write("                    <h1>Metamorphosis Design</h1>\n");
      out.write("                    <div class=\"text\">\n");
      out.write("                        <img src=\"images/img1.jpg\" class=\"img\" width=\"122\"  height=\"92\" alt=\"\" /><span>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</span><br />\n");
      out.write("                        Vivamus sagittis erat hendrerit orci porttitor fringilla. Donec quis ante convallis massa pharetra condimentum quis eget massa. Donec fringilla elementum lorem sit. amet tempor. Aliquam id arcu ac turpis pulvinar sagittis ac eget libero leo a erat porttitor vestibulum in ut dui. Phasellus et augue et nunc aliquet pellentesque. Fusce commodo sagittis metus, in faucibus lacus placerat in.<br /><br />\n");
      out.write("                        <span>Sed fringilla faucibus euismod. </span><br />\n");
      out.write("\t\t\t\t\t\t\tDonec eleifend vehicula ligula, a volutpat ante sollicitudin non. Maecenas euismod pharetra magna et commodo. Nam sed arcu et urna consequat ornare. Donec vestibulum varius mi, eget pulvinar orci posuere eget. Cras gravida aliquam\n");
      out.write("                        <div class=\"read\"><a href=\"#\"><img src=\"images/read_more.png\" alt=\"\"/></a></div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <h1>FREE WEBSITE TEMPLATES USEFUL LINKS</h1>\n");
      out.write("                    <div class=\"text\">\n");
      out.write("                        <ol>\n");
      out.write("                            <li><a href=\"http://www.metamorphozis.com/free_templates/free_templates.php\">Free Website Templates</a></li>\n");
      out.write("                            <li><a href=\"http://www.metamorphozis.com/free_flash_templates/free_flash_templates.php\">Free Flash Templates</a></li>\n");
      out.write("                            <li><a href=\"http://www.metamorphozis.com/shop/flash_templates.php\">Flash Templates</a></li>\n");
      out.write("                            <li><a href=\"http://www.metamorphozis.com/shop/easy_flash_templates.php\">Easy Flash Templates</a> (no flash experience needed to edit)</li>\n");
      out.write("                            <li><a href=\"http://www.metamorphozis.com/website_hosting/index.php\">Top Hosting Providers</a></li>\n");
      out.write("\n");
      out.write("                        </ol>\n");
      out.write("                        <div class=\"read\"><a href=\"#\"><img src=\"images/read_more.png\" alt=\"\"/></a></div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <h1>Free Website Templates</h1>\n");
      out.write("                    <div class=\"text\">\n");
      out.write("                        <img src=\"images/img2.jpg\" class=\"img\" width=\"122\"  height=\"92\" alt=\"\" /><span>Aliquam a dui ligula, eget faucibus sapien.</span><br />\n");
      out.write("                        Aliquam eu augue augue. Nullam urna elit, ornare quis congue at, interdum ac nulla. Etiam gravida quam ut diam fermentum eu fringilla lacus rhoncus. Etiam eleifend ligula ac nunc sagittis non elementum sapien luctus. Curabitur quis elit qua.<br />\n");
      out.write("                        <br /><br />\n");
      out.write("                        <span>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. </span><br />\n");
      out.write("\t\t\t\t\t\t\tVestibulum dictum adipiscing tortor, in condimentum felis tincidunt nec. Fusce pharetra cursus leo, sed rhoncus nunc vehicula eu. Phasellus tempor lobortis lacus non tristique. Phasellus eu velit scelerisque justo aliquet condimentum. Class\n");
      out.write("                        <div class=\"read\"><a href=\"#\"><img src=\"images/read_more.png\" alt=\"\"/></a></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"left\">\n");
      out.write("                    <h1>Categories</h1>\n");
      out.write("                    <div class=\"list\">\n");
      out.write("                        <div class=\"opt\"><div class=\"opt_a\">\n");
      out.write("                                <a class=\"\" href=\"\">Lorem ipsum dolor</a>\n");
      out.write("                            </div></div>\n");
      out.write("                        <div class=\"opt\"><div class=\"opt_a\">\n");
      out.write("                                <a class=\"\" href=\"\">Cras in ante quam</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"opt\"><div class=\"opt_a\">\n");
      out.write("                                <a class=\"\" href=\"\">Phasellus ege</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"opt\"><div class=\"opt_a\">\n");
      out.write("                                <a class=\"\" href=\"\">Donec luctus nunc</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"opt\"><div class=\"opt_a\">\n");
      out.write("                                <a class=\"\" href=\"\">Nam varius arcu </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <h1>Company News</h1>\n");
      out.write("                    <div class=\"box10\">\n");
      out.write("                        <div class=\"box_top\"></div>\n");
      out.write("                        <div class=\"left_b\"><span class=\"w\">Friday, June 12, 2010</span><br />\n");
      out.write("                            In hac habitasse platea dictumst. Pel- lentesque porttitor urna dictum mauris\n");
      out.write("                            <div class=\"read\"><a href=\"#\"><img src=\"images/read_more.png\" alt=\"\"/></a></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"box_bot\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <div style=\"height:7px\"></div>\n");
      out.write("                    <div class=\"box10\">\n");
      out.write("                        <div class=\"box_top\"></div>\n");
      out.write("                        <div class=\"left_b\"><span class=\"w\">Saturday, June 13, 2010</span><br />\n");
      out.write("                            In hac habitasse platea dictumst. Pel- lentesque porttitor urna dictum mauris\n");
      out.write("                            <div class=\"read\"><a href=\"#\"><img src=\"images/read_more.png\" alt=\"\" /></a></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"box_bot\"></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div style=\"clear: both\"></div>\n");
      out.write("            </div>\n");
      out.write("            <!-- content ends -->\n");
      out.write("            <!-- footer begins -->\n");
      out.write("            <div id=\"footer\">\n");
      out.write("                <p>Copyright  2010. <a href=\"#\">Privacy Policy</a> | <a href=\"#\">Terms of Use</a> | <a href=\"http://validator.w3.org/check/referer\" title=\"This page validates as XHTML 1.0 Transitional\"><abbr title=\"eXtensible HyperText Markup Language\">XHTML</abbr></a> | <a href=\"http://jigsaw.w3.org/css-validator/check/referer\" title=\"This page validates as CSS\"><abbr title=\"Cascading Style Sheets\">CSS</abbr></a></p>\n");
      out.write("                <p>Design by <a href=\"http://www.metamorphozis.com/\" title=\"Flash Templates\">Flash Templates</a> for <a href=\"http://www.flashtemplatesdesign.com/\" title=\"Free Flash Templates\">Free Flash Templates</a></p>\n");
      out.write("            </div>\n");
      out.write("            <!-- footer ends -->\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div style=\"text-align: center; font-size: 0.75em;\">Design downloaded from <a href=\"http://www.freewebtemplates.com/\">free website templates</a>.</div></body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
