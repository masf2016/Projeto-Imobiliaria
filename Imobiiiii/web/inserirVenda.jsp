<%-- 
    Document   : inserirVenda
    Created on : 02/12/2010, 13:58:49
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="negocios.Venda" %>
<%@page import="repositorios.RepositorioVenda" %>
<%@page errorPage="erro.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
               <div id="leftcolumn">
            <h4>&bull; Inserir Venda - </h4>
            <br />
            <form action="insereImovel.jsp" method="post">
            <table width="204" border="0" cellspacing="3" cellpadding="1">
            <tr>
              <td><strong>Venda</strong></td>
            </tr>
            <%--
            <tr>
              <td width="196"><strong>Data </strong></td>
            </tr>
            <tr>
                <td width="196"><input type="text" size="10" maxlength="14" name="dataVenda"></input></td>
            </tr>

            <tr>
                <td width="196">(DD/MM/AAAA)</td>
            </tr>
            --%>
            <tr>
              <td><strong>CPF Do Cliente</strong></td>
            </tr>
            <tr>
              <td><input type="text" size="10" maxlength="50" name="cliente"></input></td>
            </tr>

            <%--
            <tr>
              <td width="196"><strong>CPF do Corretor</strong></td>
            </tr>
            <tr>
                <td width="196"><input type="text" size="10" maxlength="50" name="corretor"></input></td>
            </tr>
            --%>
            <tr>
              <td width="196"><strong>Id do Imovel</strong></td>
            </tr>
            <tr>
                <td width="196"><input type="text" size="10" maxlength="50" name="corretor"></input></td>
            </tr>
            <%--
            <tr>
              <td width="196"><strong>ID do Pagamento</strong></td>
            </tr>
            <tr>
                <td width="196"><input type="text" size="10" maxlength="50" name="pagamento"></input></td>
            </tr>
            
            --%>

            <tr>
              <td align="right"><input type="submit" value=" Inserir "></input>&nbsp;<input type="reset" value=" Limpar "></input></td>
            </tr>
            </table>

            <INPUT TYPE="BUTTON" VALUE="Voltar" ONCLICK="history.go(-1)">

            </form>
            <br /><br />

        </div>
    </body>
</html>
