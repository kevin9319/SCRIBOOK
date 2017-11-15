<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 08/11/2017
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Regístrate</title>
</head>
<body>
<div>
    <s:form action="addUser">
        <h3>Regístrate</h3>
        <h4>Únete a nosotros y disfruta:</h4>
        <s:textfield placeholder="Usuario" name="userName" size="100%"/>
        <s:textfield placeholder="Nombres" name="firstName" size="100%"/>
        <s:textfield placeholder="Apellidos" name="lastName" size="100%"/>
        <s:textfield placeholder="Correo electrónico" name="email" size="100%"/>
        <s:textfield placeholder="Con que nombre te gustaría que te vean" name="nickName" size="100%"/>
        <s:textfield placeholder="Genero" name="gender" size="100%"/>
        <s:textfield placeholder="Estado" name="status" size="100%"/>
        <s:password placeholder="Contraseña" name="password"/>
        <s:submit value="Registrarme"/>
    </s:form>
</div>
</body>
</html>
