<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Relatório Semanal</title>
        <link href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    </head>
    <body>
        <c:import url="cabecalho.jsp" />

        <div class="container">
            <div class="row row-offcanvas row-offcanvas-right">
                <div class="col-xs-12 col-sm-9">

                    <div class="jumbotron">
                        <h1>Relatório Semanal de Matrículas</h1>
                    </div>

                    <h2 class="sub-header">Matrículas</h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Aluno</th>
                                    <th>Unidade</th>
                                    <th>Curso</th>
                                    <th>Inicio</th>
                                    <th>Pagamento</th>
                                    <th>Matriculado por</th>
                                    <th>Matriculado em</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${matriculas}" var="matr">                                
                                    <tr>
                                        <td><c:out value="${matr.id}" /></td>
                                        <td><c:out value="${matr.aluno.nome}" /></td>
                                        <td><c:out value="${matr.unidade.nome}" /></td>
                                        <td><c:out value="${matr.curso.nome}" /></td>                                        
                                        <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${matr.inicio}" /></td>
                                        <td><c:out value="${matr.pagamento}" /></td>
                                        <td><c:out value="${matr.cadastradoPor}" /></td>                                        
                                        <td><fmt:formatDate pattern = "dd/MM/yyyy HH:mm:ss" value = "${matr.cadastradoEm}" /></td>
                                    </tr>
                                </c:forEach>      
                            </tbody>
                        </table>
                    </div>
                </div><!--/.col-xs-12.col-sm-9-->

                <c:import url="menu-lateral-matriculas.jsp" />
            </div><!--/row-->
        </div><!--/.container-->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    </body>
</html>
