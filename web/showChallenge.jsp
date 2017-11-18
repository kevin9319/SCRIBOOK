<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 08/11/2017
  Time: 02:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Retos</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<jsp:include page="navbar.jsp"/>

<h1>Retos</h1>
<s:if test="%{#session.userId>0}">
<a href="challenge.jsp">Crear Nuevo Reto</a>
</s:if>
<div class="row">



<s:iterator value="challenges" status="chall" var="challen">

    <div class="col-md-4">
        <div class="panel panel-default">
            <div class="panel-body">
                <h1><s:property value="title"/></h1>
            </div>
            <div class="panel-footer">
                <h3><s:property value="description"/></h3>
                <h3><s:property value="createDate"/></h3>
                <s:set var="user_id" value="id" scope="session"/>
                <s:form action="story">
                    <s:hidden name="chStory" value="1"/>
                    <s:hidden name="challenge.id" value="%{#challen.id}"/>
                    <s:submit value="Ir Historieta"/>
                </s:form>
            </div>

    </div>
    </div>
</s:iterator>





<jsp:include page="footer.jsp"/>




<script src="js/index.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>

</body>
</html>



<%
/*



<h1>Lista De Historietas:</h1>
<p>Product Titulo: <s:property value="Title"/></p>
<p>Product Descripción: <s:property value="Descripcion"/></p>

<div>
    <a href="showStory.jsp"><b>Ir story</b></a>
</div>


</body>
</html>

 */%>
