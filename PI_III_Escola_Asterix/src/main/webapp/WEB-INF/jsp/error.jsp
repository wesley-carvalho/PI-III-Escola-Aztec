<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Erro</title>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <c:import url="cabecalho.jsp" />

        <div class="jumbotron">
            <div class="container">
                <h1><spam class="glyphicon glyphicon-remove-circle"></spam> Erro!</h1>
                <p class="navbar-left">Retornar ao menu principal</p>
                <p class="navbar-right form-row col-md-2"><a class="btn btn-primary btn-group-justified" href="${pageContext.request.contextPath}/home" role="button">ok</a></p>
            </div><!--/.container-->            
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    </body>
</html>
