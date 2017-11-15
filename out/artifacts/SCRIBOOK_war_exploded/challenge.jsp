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
<html>
<head>
    <title>Retos</title>
</head>
<body>

<h1>Lista De Retos:</h1>

<s:form action="challenge">
    <s:textfield name="title" placeholder="Titulo" size="100%"/>
    <s:textfield name="description" placeholder="Descripcion" size="100%"/>
    <s:textfield name="user.id" placeholder="Descripcion" size="100%"/>
    <s:textfield name="category.id" placeholder="Descripcion" size="100%"/>
    <s:textfield name="lastDate" placeholder="Fecha" size="100%"/>
    <s:submit value="Ir al usuario Mostrar"/>
</s:form>

<div>
    <a href="showChallenge.jsp"><b>Ir</b></a>
</div>

</body>
</html>
