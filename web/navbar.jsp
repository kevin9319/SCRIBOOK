<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Junior Cabrera
  Date: 11/11/2017
  Time: 08:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">SCRIBOOK</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <jsp:useBean id="service" class="pe.edu.utp.scribookwebprofile.models.ScService"/>


                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Categorías <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <c:forEach var="category" items="${service.findAllCategories()}">
                            <li><c:out value="${category.description}"/></li>
                            <li role="separator" class="divider"></li>
                        </c:forEach>
                    </ul>
                </li>
                <li><a href="#">Link</a></li>
            </ul>


            <s:if test="%{#session.userId>0}">


                <ul class="nav navbar-nav navbar-right">

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Hola,&nbsp; <s:property value="#session.userUserName"/> <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="profile.jsp" class="btn btn-default">Perfil</a></li>
                            <li role="separator" class="divider"></li>
                            <s:form action="user">
                                <s:hidden name="acti" value="2"/>
                            <li>
                                <s:submit value="Cerrar Sesión" cssClass="btn btn-default"/>
                            </li></s:form>
                        </ul>
                    </li>
                </ul>
            </s:if>


        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

