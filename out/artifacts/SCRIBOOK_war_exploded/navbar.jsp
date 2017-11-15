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
<s:if test="%{id==0}">
    <s:set var="user_id" value="id" scope="session"/>
    <s:set var="user_name" value="userName" scope="session"/>
</s:if>


<h1>SCRIBOOK</h1>

<s:if test="%{#session.user_id==null || #session.user_id==0}">
    <li>¿Ya tienes una cuenta?</li>
    <li>
        <a href="#"><b>Ingresa:</b></a>
        Iniciar Sesión:
                        <s:form action="user">
                            <s:textfield  name="userName" placeholder="Usuario" size="100%"/>
                            <s:password name="password" placeholder="Contraseña" size="100%"/>
                            <s:hidden name="acti" value="1"/>
                            <s:submit value="Iniciar sesión"/>
                        </s:form>
                    </div>
                    <div>
                        <a href="signup.jsp"><b>Regístrate</b></a>
                    </div>
                </div>
            </li>
        </ul>
    </li>
</s:if>
<s:if test="%{#session.user_id>0}">
    <li><p>Hola, <s:property value="#session.user_name"/> </p></li>
    <s:form action="user">
        <s:hidden name="acti" value="2"/>
        <s:submit value="Salir"/>
    </s:form>

</s:if>