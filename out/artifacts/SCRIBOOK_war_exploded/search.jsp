<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: Angelo
  Date: 11/11/2017
  Time: 02:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Buscar Cuentos</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" type="text/css" href="css/style.css">



</head>
<body>
<jsp:include page="navbar.jsp"/>
<h3 class="bg-success"><s:property value="msgstory"/></h3>

<div class="container">

     <div class="row">

        <s:iterator value="stories" status="sto" var="stor">

            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3><s:label value="Reto:"/><s:property value="challenge.title"/></h3>
                        <s:label value="Titulo:"/>
                        <s:property value="title"/>
                    </div>
                    <div class="panel-footer">

                        <s:label value="Descripción:"/>
                        <s:property value="description"/>
                        <s:label value="Fecha Creación del Cuento:"/>
                        <s:property value="createDate"/>
                        <s:label value="Puntaje:"/>
                        <s:property value="scoreTotal"/>

                    </div>

                </div>
            </div>
        </s:iterator>


    </div>

</div>






<jsp:include page="footer.jsp"/>




<script src="js/index.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
    $('.form_date').datetimepicker({
        language:  'es',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    $('.form_time').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
</script>
</body>
</html>
