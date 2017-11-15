<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 11/11/2017
  Time: 02:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Retos</title>
    <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.7.2.custom.css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/jquery-ui.min.js"></script>
    <script type="text/javascript">
        jQuery(function($){
            $.datepicker.regional['es'] = {
                closeText: 'Cerrar',
                prevText: '<Ant',
                nextText: 'Sig>',
                currentText: 'Hoy',
                monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio',
                    'Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
                monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun',
                    'Jul','Ago','Sep','Oct','Nov','Dic'],
                dayNames: ['Domingo','Lunes','Martes','Miércoles','Jueves','Viernes','Sábado'],
                dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
                dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
                weekHeader: 'Sm',
                dateFormat: 'dd/mm/yy',
                firstDay: 1,
                isRTL: false,
                showMonthAfterYear: false,
                yearSuffix: ''};
            $.datepicker.setDefaults($.datepicker.regional['es']);
        });

        $(document).ready(function(){
            // obtenemos la fecha actual
            var date = new Date();
            var m = date.getMonth(), d = date.getDate(), y = date.getFullYear();


            $("#llegada").datepicker({
                showOn: 'button',
                buttonText: "Calendario",
                minDate: new Date(y, m, d),
                dateFormat: 'dd/mm/yy',
                maxDate: new Date(2013, 11, 31) });

            $("#salida").datepicker({
                showOn: 'button',
                buttonText: "Calendario",
                minDate: new Date(y, m, d),
                dateFormat: 'dd/mm/yy',
                maxDate: new Date(2013, 11, 31) });
        });
    </script>

</head>
<body>

<h1>Lista De Retos:</h1>

<s:form action="challenge">
    <s:textfield name="title" placeholder="Titulo" size="100%"/>
    <s:textfield name="description" placeholder="Descripcion" size="100%"/>
    <s:textfield name="user.id" placeholder="Descripcion" size="100%"/>
    <s:textfield name="category.id" placeholder="Descripcion" size="100%"/>

    <s:textfield name="lastDate" placeholder="Fecha" size="100%"/>
    <s:submit value="Ir al usuario Mostrar"/>


    <s:textfield name="lastDate" id="datepicker" placeholder="Seleccionar Fecha:"/>
    <s:submit value="Ir al usuario Mostrar"/>
</s:form>




<div>
    <a href="showChallenge.jsp"><b>Ir</b></a>
</div>

</body>
</html>
