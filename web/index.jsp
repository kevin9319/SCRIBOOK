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


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SCRIBOOK</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" type="text/css" href="css/style.css">




</head>
<body>

<jsp:include page="navbar.jsp"/>
<h3 class="bg-success"><s:property value="msgalerta"/></h3>

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
            <h3>Regístrate</h3>
            <h4>Únete a nosotros y experimenta</h4>
            <s:form action="user" cssClass="form-group">
                <s:textfield placeholder="Usuario" cssClass="form-control" name="userName"/>
                <s:textfield placeholder="Nombres" cssClass="form-control" name="firstName"/>
                <s:textfield placeholder="Apellidos" cssClass="form-control" name="lastName"/>
                <s:radio list="{'Masculino','Femenino'}" name="gender"></s:radio>
                <s:textfield placeholder="Correo electrónico" cssClass="form-control" name="email" type="email"/>
                <s:password placeholder="Contraseña" cssClass="form-control" name="password" type="password"/>
                <s:hidden name="acti" value="3"/>
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















<jsp:include page="footer.jsp"/>




<script src="js/index.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

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