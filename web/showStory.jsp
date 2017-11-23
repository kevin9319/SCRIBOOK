<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 08/11/2017
  Time: 02:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cuentos</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<jsp:include page="navbar.jsp"/>
<h1>Cuentos:</h1>
<h2>Titulo: <s:property value="challenge.title"/></h2>
<h2>Descripción: <s:property value="challenge.description"/></h2>
<s:if test="%{#session.userId>0}">
    <s:form action="Createstory">
        <s:hidden name="chStory" value="3"/>
        <s:hidden name="challenge.id" value="%{challenge.id}"/>
        <s:submit value="Crear Nuevo Cuento" type="button" cssClass="btn btn-default"/>
    </s:form>
</s:if>


<div class="row">

        <s:iterator value="stories" status="sto" var="stor">

                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <h3><s:property value="title"/></h3>
                        </div>
                        <div class="panel-footer">
                            <s:label value="Descripción:"/>
                            <s:property value="description"/>
                            <s:label value="Fecha Creación del Cuento:"/>
                            <s:property value="createDate"/>
                            <s:label value="Usuario:"/>
                            <s:property value="user.userName"/>
                            <s:label value="Puntaje:"/>
                            <s:property value="scoreTotal"/>

                            <s:if test="%{#session.userId>0}">
                            <s:form action="scorestory">
                                <s:hidden name="chStory" value="4"/>
                                <s:hidden name="user.id" value="%{#session.userId}"/>
                                <s:hidden name="story.id" value="%{#stor.id}"/>
                                <s:hidden name="challenge.id" value="%{#stor.challenge.id}"/>
                                <s:submit value="Me gusta" Class="btn btn-default"/>
                            </s:form>
                            </s:if>

                        </div>

                    </div>
                </div>
        </s:iterator>


</div>







<jsp:include page="footer.jsp"/>




<script src="js/index.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
</body>
</html>
