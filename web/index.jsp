<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Junior Cabrera
  Date: 17/10/2017
  Time: 05:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <title>SCRIBOOK</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>


<jsp:include page="navbar.jsp"/>

<div class="container">
<div class="row">
    <div class="col-md-4">
        <img src="img/imgstory.png" class="img-thumbnail" width="300" height="300">
    </div>

<s:if test="%{#session.userId==null || #session.userId==0}">
    <div class="col-md-4">
        <div class="container">
            <h3>Iniciar Sesión:</h3>
            <s:form action="user" cssClass="form-group">
            <s:textfield  name="userName" cssClass="form-control" placeholder="Usuario"/>
            <s:password name="password" cssClass="form-control" placeholder="Contraseña"/>
            <s:hidden name="acti" value="1"/>
            <s:submit value="Iniciar sesión" cssClass="btn btn-danger"/>
            </s:form>
        </div>
    </div>
    <div class="col-md-4">
        <div class="container">
            <s:form action="user" cssClass="form-group">
                <h3>Regístrate</h3>
                <h4>Únete a nosotros y experimenta</h4>
                <s:textfield placeholder="Nombre" cssClass="form-control" name="firstName"/>
                <s:textfield placeholder="Apellidos" cssClass="form-control" name="lastName"/>
                <s:textfield placeholder="Correo electrónico" cssClass="form-control" name="email" type="email"/>
                <s:password placeholder="Contraseña" cssClass="form-control" name="password" type="password"/>
                <s:submit cssClass="btn btn-primary" class="form-control" value="Registrarme"/>
            </s:form>
        </div>

    </div>


</s:if>

<s:if test="%{#session.userId>0}">
    <div class="col-md-8">
        <img src="img/imgstory.png" alt="..." class="img-thumbnail" width="600" height="600">
    </div>
</s:if>








</div>

</div>






<s:form action="category">
    <s:label for="name" value="Id Categoria"/>
    <s:textfield id="act" name="act"/>
    <s:submit value="Mostrar"/>
</s:form>

<s:form action="user">
    <s:textfield  name="userName" placeholder="Usuario" size="100%"/>
    <s:password name="password" placeholder="Contraseña" size="100%"/>
    <s:hidden name="acti" value="1"/>
    <s:submit value="Ir al usuario Mostrar"/>
</s:form>



<div>
    <a href="challenge.jsp"><b>Ir</b></a>
</div>

<div class="container">
    <form action="" class="form-horizontal"  role="form">
        <fieldset>
            <legend>Test</legend>

            <div class="form-group">
                <label for="dtp_input2" class="col-md-2 control-label">Date Picking</label>
                <div class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                    <input class="form-control" size="16" type="text" value="" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                </div>
                <input type="hidden" id="dtp_input2" value="" /><br/>
            </div>

        </fieldset>
    </form>
</div>



<div>1234</div>
<div>1234</div>
<div>1234</div>




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
        language:  'fr',
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


<%    /* <h1>Lista De Categorias</h1>
<p>Product Descripción:</p>

<jsp:useBean id="service" class="pe.edu.utp.scribookwebprofile.models.ScService"/>
<c:forEach var="category" items="${service.findAllCategories()}">
    <p><c:out value="${category.id}"/> - - -
    <c:out value="${category.description}"/> - - -
    <c:out value="${category.shortDescription}"/></p>
</c:forEach> */%>