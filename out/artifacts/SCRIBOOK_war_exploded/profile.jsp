<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 14/11/2017
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Perfil de Usuario</title>


    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/simple-sidebar.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>

<jsp:include page="navbar.jsp"/>




<div id="wrapper">
    <jsp:include page="menuleft.jsp"/>


    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">

                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h1>Datos del Usuario: </h1>
                        </div>
                        <div class="panel-body">
                            <h3>Usuario: <s:property value="#session.userUserName"/></h3>
                            <h3>Nombres: <s:property value="#session.userFirstName"/></h3>
                            <h3>Apellidos: <s:property value="#session.userLastName"/></h3>
                            <h3>Correo electrónico: <s:property value="#session.userEmail"/></h3>
                        </div>
                    </div>


                </div>

            </div>



        </div>
    </div>


</div>





<script type="text/javascript" src="js/jquery-1.8.3.min.js" charset="UTF-8"></script>


<script src="js/bootstrap.min.js"></script>


<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>

</body>
</html>
