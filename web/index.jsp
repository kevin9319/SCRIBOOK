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
</head>
<body>


<jsp:include page="navbar.jsp"/>






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

<h1>Lista De Categorias</h1>
<p>Product Descripción:</p>

<jsp:useBean id="service" class="pe.edu.utp.scribookwebprofile.models.ScService"/>
<c:forEach var="category" items="${service.findAllCategories()}">
    <p><c:out value="${category.id}"/> - - -
    <c:out value="${category.description}"/> - - -
    <c:out value="${category.shortDescription}"/></p>
</c:forEach>

<div>
    <a href="challenge.jsp"><b>Ir</b></a>
</div>




</body>
</html>
