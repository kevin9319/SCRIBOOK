<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Junior Cabrera
  Date: 13/11/2017
  Time: 05:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>


<h1><s:property value="id" /></h1>
<h1><s:property value="description" /></h1>


<s:iterator value="categories">
    <li><s:property value="id"/>- - -<s:property value="description"/>- - -<s:property value="shortDescription"/></li>
</s:iterator>


<li><s:property value="id"/>
<li><s:property value="userName"/>


</body>
</html>
