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
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" type="text/css" href="css/style.css">
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
<jsp:include page="navbar.jsp"/>
<h1>Crear Reto:</h1>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <s:form action="challenge">
                <div class="form-group">
                    <s:label value="Titulo" class="control-label col-sm-2"></s:label>
                    <div class="col-sm-10">
                        <s:textfield name="title" placeholder="Titulo" size="100%" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <s:label value="Descripcion"></s:label>
                    <s:textfield name="description" placeholder="Descripcion" size="100%" class="form-control"/>
                </div>
                <div class="form-group">
                    <s:label value="Categoria"></s:label>
                    <s:textfield name="category.id" placeholder="Descripcion" size="100%" class="form-control"/>
                </div>
                <s:textfield name="user.id" placeholder="Descripcion" size="100%"/>
                <div class="form-group">
                    <s:label value="Fecha Fin"></s:label>
                    <s:textfield name="lastDate" placeholder="Fecha" class="form-control"/>
                </div>
                <br>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <s:submit value="Guardar" class="btn btn-primary btn-lg"/>
                    </div>
                </div>
            </s:form>
        </div>
    </div>
</div>


<jsp:include page="footer.jsp"/>




<script src="js/index.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>

</body>
</html>
