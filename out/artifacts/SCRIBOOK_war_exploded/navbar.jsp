<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Ragina
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
            <a class="navbar-brand" href="index.jsp"><img src="img/sb-logo.png" width="100" ></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">


                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Categorías <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <s:url var="en" action="challenge">
                                <s:param name="category.id" value="1"></s:param>
                                <s:param name="chAct" value="1"> < </s:param>
                            </s:url>
                            <s:a href="%{en}"> <s:text name="Aventura"/></s:a>
                        </li>

                        <li>
                            <s:url var="en" action="challenge">
                                <s:param name="category.id" value="2"></s:param>
                                <s:param name="chAct" value="1"> < </s:param>
                            </s:url>
                            <s:a href="%{en}"> <s:text name="Biografica"/></s:a>
                        </li>

                        <li>
                            <s:url var="en" action="challenge">
                                <s:param name="category.id" value="3"></s:param>
                                <s:param name="chAct" value="1"> < </s:param>
                            </s:url>
                            <s:a href="%{en}"> <s:text name="Ciencia Ficcion"/></s:a>
                        </li>

                        <li>
                            <s:url var="en" action="challenge">
                                <s:param name="category.id" value="4"></s:param>
                                <s:param name="chAct" value="1"> < </s:param>
                            </s:url>
                            <s:a href="%{en}"> <s:text name="Deportes"/></s:a>
                        </li>

                        <li>
                            <s:url var="en" action="challenge">
                                <s:param name="category.id" value="5"></s:param>
                                <s:param name="chAct" value="1"> < </s:param>
                            </s:url>
                            <s:a href="%{en}"> <s:text name="Erotica"/></s:a>
                        </li>

                        <li>
                            <s:url var="en" action="challenge">
                                <s:param name="category.id" value="6"></s:param>
                                <s:param name="chAct" value="1"> < </s:param>
                            </s:url>
                            <s:a href="%{en}"> <s:text name="Infantil"/></s:a>
                        </li>

                        <li>
                            <s:url var="en" action="challenge">
                                <s:param name="category.id" value="7"></s:param>
                                <s:param name="chAct" value="1"> < </s:param>
                            </s:url>
                            <s:a href="%{en}"> <s:text name="Investigacion"/></s:a>
                        </li>

                        <li>
                            <s:url var="en" action="challenge">
                                <s:param name="category.id" value="8"></s:param>
                                <s:param name="chAct" value="1"> < </s:param>
                            </s:url>
                            <s:a href="%{en}"> <s:text name="Policial"/></s:a>
                        </li>

                        <li>
                            <s:url var="en" action="challenge">
                                <s:param name="category.id" value="9"></s:param>
                                <s:param name="chAct" value="1"> < </s:param>
                            </s:url>
                            <s:a href="%{en}"> <s:text name="Romantica"/></s:a>
                        </li>

                        <li>
                            <s:url var="en" action="challenge">
                                <s:param name="category.id" value="10"></s:param>
                                <s:param name="chAct" value="1"> < </s:param>
                            </s:url>
                            <s:a href="%{en}"> <s:text name="Sociedad"/></s:a>
                        </li>


                        <li>
                            <s:url var="en" action="challenge">
                                <s:param name="category.id" value="11">Terror</s:param>
                                <s:param name="chAct" value="1"> < </s:param>
                            </s:url>
                            <s:a href="%{en}"> <s:text name="Terror"/></s:a>
                        </li>

                        <li>
                            <s:url var="en" action="challenge">
                                <s:param name="category.id" value="12"></s:param>
                                <s:param name="chAct" value="1"> < </s:param>
                            </s:url>
                            <s:a href="%{en}"> <s:text name="Viajes"/></s:a>
                        </li>

                        <li>
                            <s:url var="en" action="challenge">
                                <s:param name="category.id" value="13"></s:param>
                                <s:param name="chAct" value="1"> < </s:param>
                            </s:url>
                            <s:a href="%{en}"> <s:text name="Vampiros"/></s:a>
                        </li>

                        <li>
                            <s:url var="en" action="challenge">
                                <s:param name="category.id" value="14"></s:param>
                                <s:param name="chAct" value="1"> < </s:param>
                            </s:url>
                            <s:a href="%{en}"> <s:text name="Zombies"/></s:a>
                        </li>

                    </ul>
                </li>

                <s:form theme="simple" cssClass="navbar-form navbar-left form-horizontal"  action="serchstory">
                        <s:textfield  id="textbuscar" name="titleORStory" placeholder="Buscar historias...." cssClass="form-control"/>
                       <s:hidden name="chStory" value="6"/>
                        <s:submit class="buttonsearch" value="Buscar"></s:submit>
                </s:form>

            </ul>






            <s:if test="%{#session.userId>0}">


                <ul class="nav navbar-nav navbar-right">

                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#"> <b>Crear <span class="caret"></span> </b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <s:url var="cc" action="Createchallenge">
                                    <s:param name="chAct" value="3"> < </s:param>
                                </s:url>
                                <s:a href="%{cc}"> <s:text name="Nuevo reto"/></s:a>
                            </li>



                        </ul>
                    </li>



                    <li class="dropdown">
                       <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Hola, &nbsp; <s:property value="#session.userUserName"/> <span class="caret"></span></a>
                        <ul class="dropdown-menu">

                            <li><a href="profile.jsp">Perfil</a></li>

                            <li role="separator" class="divider"></li>


                            <li>
                                <s:url var="cs" action="user">
                                    <s:param name="acti" value="2"> < </s:param>
                                </s:url>
                                <s:a href="%{cs}"> <s:text name="Cerrar Session"/></s:a>
                            </li>



                        </ul>
                    </li>
                </ul>
            </s:if>


        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
