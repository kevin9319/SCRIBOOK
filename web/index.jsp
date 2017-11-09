<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <title>Product Information</title>
</head>
<body>
<h1>Product Information</h1>
<s:form action="product">
    <s:label for="name" value="Product Name"/>
    <s:textfield id="name" name="name"/>
    <s:label for="description" value="Product Description"/>
    <s:textfield id="description" name="description"/>
    <s:label for="price" value="Product Price"/>
    <s:textfield id="price" name="price"/>
    <s:label for="supplierEmail" value="Supplier Email"/>
    <s:textfield id="supplierEmail" name="supplierEmail"/>
    <s:submit value="Save"/>
</s:form>
</body>
</html>
