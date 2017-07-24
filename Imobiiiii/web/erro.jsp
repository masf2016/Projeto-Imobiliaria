<%-- 
    Document   : index
    Created on : 15/09/2010, 14:54:49
    Author     : Beto
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1" %>

<%@page isErrorPage="true" %>
>

<%


%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Imobi</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>

<body>





    <!-- End Left Column -->

    <!-- Begin Ri</center>ght Column -->
    <center>
        <div id="rightcolumn">
            <h2>OPS! PARECE QUE OCORREU UM ERRO INESPERADO!</h2>
            <p><font color="#CD0000 "><%= exception.toString() %></font></p>
            <p>
              <input type="BUTTON" value="Clique aqui para voltar" onClick="history.go(-1)">
            </p>
            
            <p><br />
          <img alt="0"  src="images/aha!.jpg"/>
            </p>
            <p>&nbsp;</p>
        </div>
        </center>
    
    <!-- End Right Column -->

    <div style="clear: both;"></div>
    <!-- Footer -->

    <!-- End Footer -->

    <!-- End Wrapper -->


</body>
</html>
