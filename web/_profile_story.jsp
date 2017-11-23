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
    <title>Perfil - Mis Cuentos</title>


    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/simple-sidebar.css" rel="stylesheet">
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
                            <h1>Mis Cuentos: </h1>
                        </div>
                        <div class="panel-body">
                            <div class="row">

                                <s:iterator value="stories" status="sto" var="stor">

                                    <div class="col-md-12">
                                        <div class="panel panel-default">
                                            <div class="panel-body">
                                                <h3><s:label value="Reto:"/><s:property value="challenge.title"/></h3>
                                                <h4><s:label value="Titulo:"/></h4>
                                                <h4><s:property value="title"/></h4>
                                            </div>
                                            <div class="panel-footer">

                                                <h5><s:label value="Descripción:"/></h5>
                                                <h5><s:property value="description"/></h5>
                                                <h5><s:label value="Fecha Creación del Cuento:"/></h5>
                                                <h5><s:property value="createDate"/></h5>
                                                <h5><s:label value="Puntaje:"/></h5>
                                                <h5><s:property value="scoreTotal"/></h5>

                                            </div>

                                        </div>
                                    </div>
                                </s:iterator>


                            </div>
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
