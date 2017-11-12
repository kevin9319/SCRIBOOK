<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Kevin NA
  Date: 11/11/2017
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear Historia</title>
</head>
<body>
<s:form action="createStory">
<h1> Crear historia</h1>
<p> Crea una nueva historia, relato en las diversas categorias</p>

    <s:textfield placeholder="Titulo" name="title" size="100%"/>
    <s:textfield placeholder="Contenido" name="description" size="100%"/>
    <s:submit value="Crear"/>
</s:form>

<a href="index.jsp">Regresar Index</a>
</body>
</html>
