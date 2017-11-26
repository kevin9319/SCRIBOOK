<%--
  Created by IntelliJ IDEA.
  User: Kevin NA
  Date: 25/11/2017
  Time: 06:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Buscar Cuentos</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" type="text/css" href="css/style.css">



</head>
<body>
<jsp:include page="navbar.jsp"/>
<h3 class="bg-success"><s:property value="msgstory"/></h3>

<div class="container">


    <!-- Team Members Row -->
    <div class="row">
        <div class="col-lg-12">
            <h2 class="my-4">Equipo Scribook</h2>
        </div>
        <div class="col-lg-3 col-sm-6 text-center mb-4">
            <img class="rounded-circle img-fluid d-block mx-auto" src="img/f1.jpg" alt="" style="border-radius: 100px;">
            <h3>Navarro Alfaro, Kevin</h3>
            <p> 1220995@utp.edu.pe </p>
        </div>

        <div class="col-lg-3 col-sm-6 text-center mb-4">
            <img class="rounded-circle img-fluid d-block mx-auto" src="img/f2.jpg" alt="" style="border-radius: 100px;">
            <h3>Cabrera Sanchez, Junior </h3>
            <p>What does this team member to? Keep it short! This is also a great spot for social links!</p>
        </div>

        <div class="col-lg-3 col-sm-6 text-center mb-4">
            <img class="rounded-circle img-fluid d-block mx-auto" src="img/f3.jpg" alt="" style="border-radius: 100px;">
            <h3>Chuquillanqui Quito, Mery</h3>
            <p>What does this team member to? Keep it short! This is also a great spot for social links!</p>
        </div>

        <div class="col-lg-3 col-sm-6 text-center mb-4">
            <img class="rounded-circle img-fluid d-block mx-auto" src="img/f4.jpg" alt="" style="border-radius: 100px;">
            <h3>Conde Yangali, Anggelo</h3>
            <p>What does this team member to? Keep it short! This is also a great spot for social links!</p>
        </div>


    </div>




<jsp:include page="footer.jsp"/>




<script src="js/index.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
    $('.form_date').datetimepicker({
        language:  'es',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    $('.form_time').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
</script>
</body>
</html>
