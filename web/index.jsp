<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Junior Cabrera
  Date: 17/10/2017
  Time: 05:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:if test="%{id==0}">
    <s:set var="user_id" value="id" scope="session"/>
    <s:set var="user_name" value="userName" scope="session"/>
</s:if>

<html>
<head>
    <title>SCRIBOOK</title>
</head>
<body>

<jsp:include page="navbar.jsp"/>




<h1>Lista De Categorías</h1>
<p>Product Descripción: <s:property value="Description"/></p>

<div>
    <a href="challenge.jsp"><b>Ir</b></a>
</div>

</body>
</html>
