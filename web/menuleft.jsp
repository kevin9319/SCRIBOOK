<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Junior Cabrera
  Date: 22/11/2017
  Time: 09:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="sidebar-wrapper">
    <ul class="sidebar-nav">
        <li class="sidebar-brand">
            <a href="">
                <h4>Usuario: <s:property value="#session.userUserName"/></h4>
            </a>
        </li>
        <li>
            <a href="profile.jsp">Datos del Usuario</a>
        </li>

        <li data-toggle="collapse" data-target="#stock" class="collapsed">
            <s:url var="cc" action="showchallenge">
                <s:param name="chAct" value="4"> < </s:param>
                <s:param name="user.id" value="#session.userId"> < </s:param>
            </s:url>
            <s:a href="%{cc}"> <s:text name="Retos Creados"/></s:a>
        </li>

        <li data-toggle="collapse" data-target="#stock" class="collapsed">
            <s:url var="cc" action="showstory">
                <s:param name="chStory" value="5"> < </s:param>
                <s:param name="user.id" value="#session.userId"> < </s:param>
            </s:url>
            <s:a href="%{cc}"> <s:text name="Cuentos Creados"/></s:a>
        </li>



    </ul>
</div>



<a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Ir al Menú</a>