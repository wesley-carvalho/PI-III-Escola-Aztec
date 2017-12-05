<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Excluir</title>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <c:import url="cabecalho.jsp" />

        <div class="jumbotron">
            <div class="container">
                <h1><spam class="glyphicon glyphicon-trash"></spam> Excluir!</h1>
                <p class="navbar-left">Deseja proseguir com a operação?</p>                              
                <div class="form-row col-md-4 navbar-right">                                
                    <div class="btn-group btn-group-justified" role="group" aria-label="...">
                        <div class="btn-group" role="group">
                            <form action="${pageContext.request.contextPath}<c:out value="${way}" />" method="post">                    
                                <input type="hidden" name="id" value="<c:out value="${id}" />">                                             
                                <button type="submit" class="btn btn-warning">Continuar</button>
                            </form>                            
                        </div>
                        <div class="btn-group" role="group">
                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/home">Cancelar</a>
                        </div>                        
                    </div>
                </div>
            </div><!--/.container-->            
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    </body>
</html>
