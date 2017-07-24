package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;

public final class consultar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

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


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <html>\n");
      out.write("        <head>\n");
      out.write("            <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("            <title>Imobi - limoeiro Imobiliria</title>\n");
      out.write("            <meta name=\"keywords\" content=\"\" />\n");
      out.write("            <meta name=\"description\" content=\"\" />\n");
      out.write("            <link href=\"styles.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("            <style type=\"text/css\">\n");
      out.write("                <!--\n");
      out.write("                #leftcolumn form table tr td div strong em {\n");
      out.write("                    color: #F60;\n");
      out.write("                }\n");
      out.write("                #leftcolumn form table tr td div em strong {\n");
      out.write("                    color: #F60;\n");
      out.write("                }\n");
      out.write("                #leftcolumn h4 {\n");
      out.write("                    font-size: 16px;\n");
      out.write("                    color: #000;\n");
      out.write("                }\n");
      out.write("                #rightcolumn h4 {\n");
      out.write("                    font-size: 24px;\n");
      out.write("                }\n");
      out.write("                -->\n");
      out.write("            </style>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"main\">\n");
      out.write("            <!-- header begins -->\n");
      out.write("            <div id=\"header\">\n");
      out.write("                <div id=\"buttons\">\n");
      out.write("                        <a href=\"index.jsp\" class=\"but\"  title=\"\">Início</a><div class=\"razd_b\"></div>\n");
      out.write("                        <a href=\"Sobre.jsp\" class=\"but\" title=\"\">Sobre</a><div class=\"razd_b\"></div>\n");
      out.write("                        <a href=\"adm.jsp\"  class=\"but\" title=\"\">Operações</a><div class=\"razd_b\"></div>\n");
      out.write("                        <a href=\"contato.jsp\"  class=\"but\" title=\"\">Contato</a><div class=\"razd_b\"></div>\n");
      out.write("                        <a href=\"login.jsp\" class=\"but\" title=\"\">Login</a>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div id=\"logo\">\n");
      out.write("\n");
      out.write("                    <div class=\"logo_l\">\n");
      out.write("                        <h2>&nbsp;</h2>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                         <div class=\"logo_r_super\">\n");
      out.write("                              <p align=\"center\"><img src=\"");
      out.print( imagem );
      out.write("\"/></p>\n");
      out.write("                            </div>\n");
      out.write("                        <h5 align=\"center\">Bem-vindo ");
      out.print(usuario);
      out.write("<br/> ");
      out.print( saudacao);
      out.write(" <br/>");
      out.print( data);
      out.write(" <br/>  ");
      out.print(hora);
      out.write('H');
      out.write(' ');
      out.print( minutos);
      out.write("min</h5>\n");
      out.write("\n");
      out.write("                        <div align=\"center\"><span>Empresa no Ramo de Aluguel de Imveis</span><br />\n");
      out.write("                            Nossa satisfao  a sua confiana\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("            <div id=\"rightcolumn\">\n");
      out.write("            <h4 align=\"center\">Consultas</h4>\n");
      out.write("            <div align=\"center\"><br />\n");
      out.write("              \n");
      out.write("              <b>Listar</b>\n");
      out.write("              <table width=\"550\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" class=\"mario\" id=\"tabela\">\n");
      out.write("                <tr>\n");
      out.write("                  <td class=\"classe1\"  align=\"center\"><a class=\"classe2\" href=\"listarCliente.jsp\">Clientes</a></td>\n");
      out.write("                  <td class=\"classe1\" align=\"center\"><a class=\"classe2\" href=\"listarCorretor.jsp\">Corretores</a></td>\n");
      out.write("                  <td class=\"classe1\"  align=\"center\"><a class=\"classe2\" href=\"listarImovel.jsp\">Imoveis</a></td>\n");
      out.write("                </tr>\n");
      out.write("              </table>\n");
      out.write("              <br/>\n");
      out.write("              <b>Consulta Individual</b>\n");
      out.write("              <table width=\"541\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" class=\"mario\" id=\"tabela\">\n");
      out.write("                <tr>\n");
      out.write("                  <td width=\"179\"  align=\"center\" class=\"classe1\"><a class=\"classe2\" href=\"buscarCliente.jsp\"> Procurar por Cliente</a></td>\n");
      out.write("                  <td width=\"164\"  align=\"center\" class=\"classe1\"><a class=\"classe2\" href=\"buscarCorretor.jsp\"> Procurar por Corretor</a></td>\n");
      out.write("                  <td width=\"188\"  align=\"center\" class=\"classe1\"><a class=\"classe2\" href=\"buscarImovel.jsp\"> Procurar por Imovel</a></td>\n");
      out.write("                </tr>\n");
      out.write("              </table>\n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("              <br/>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("              <div align=\"center\">\n");
      out.write("                <INPUT TYPE=\"BUTTON\" VALUE=\"Voltar\" ONCLICK=\"history.go(-1)\">\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("    </div>\n");
      out.write("<div id=\"footer\">Imobi - Imobiliaria Limoeirense\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("        <!-- End Footer -->\n");
      out.write(" \n");
      out.write("    <!-- End Wrapper -->\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
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
