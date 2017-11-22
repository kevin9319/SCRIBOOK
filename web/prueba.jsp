<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Junior Cabrera
  Date: 22/11/2017
  Time: 04:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>mostrar</h1>
<h3><s:property value="category.id"/></h3>
<h3><s:property value="user.id"/></h3>
<h3><s:property value="title"/></h3>
<h3><s:property value="description"/></h3>
<h3><s:property value="lastDate"/></h3>
</body>
</html>
