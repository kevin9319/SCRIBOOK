<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrador
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
    <title>Crear Reto</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" type="text/css" href="css/style.css">



</head>
<body>
<jsp:include page="navbar.jsp"/>

<div class="container">

<h1>Crear Reto:</h1>


<s:form action="addchallenge" cssClass="form-horizontal">

    <label for="dtp_input2" class="col-md-2 control-label">Seleccionar Fecha Final del Reto:</label>
    <div class="input-group date form_date col-md-4" data-date="" data-date-format="dd/mm/yyyy" data-link-field="dtp_input2" data-link-format="dd/mm/yyyy">
        <input class="form-control" size="16" type="text" value="" readonly>
        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
        <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
    </div>
    <s:textfield type="hidden" name="lastDate" placeholder="Seleccionar Fecha:" id="dtp_input2"/>

        <s:label value="Categorías:"/>
        <s:select label="Seleccionar Categoría"
                  headerKey="0" headerValue="Seleccionar Categoría"
                  list="categories" listValue="description" listKey="id" name="category.id"  Class="btn btn-default">
        </s:select>


        <s:label value="Titulo"/>
        <s:textfield name="title" placeholder="Titulo" size="100%" label="Titulo" Class="form-control"/>


        <s:label value="Descricción"/>
        <s:textfield name="description" placeholder="Descripcion" size="100%" Class="form-control"/>

    <s:hidden name="user.id" value="%{#session.userId}"/>


    <s:hidden name="chAct" value="2"/>

        <s:submit value="Crear Reto" Class="btn btn-default"/>



</s:form>




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
