<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Kevin NA
  Date: 11/11/2017
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <s:form action="searchStory">
        <s:textfield placeholder="Buscar retos..."/>
        <s:submit value="Buscar"/>
    </s:form>

    <a href="index.jsp"> Regresar a Index </a>


</body>
</html>
