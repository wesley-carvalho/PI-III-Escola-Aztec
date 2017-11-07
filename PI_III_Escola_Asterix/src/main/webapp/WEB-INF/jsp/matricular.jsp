<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Matrícular Aluno</title>
        <link href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    </head>
    <body>
        <c:import url="cabecalho.jsp" />

        <div class="container">
            <div class="row row-offcanvas row-offcanvas-right">

                <div class="col-xs-12 col-sm-9">
                    <div class="jumbotron">
                        <h1>Matrícular aluno</h1>
                    </div>

                    <div class="row">
                        <form data-toggle="validator" action="${pageContext.request.contextPath}/matricula_inserir" method="post">
                            <div class="form-group col-md-12">
                                <label for="aluno" class="col-form-label">Nome do aluno:* </label>
                                <select class="form-control" name="aluno" required>
                                    <c:forEach items="${alunos}" var="alun">
                                        <option value="<c:out value="${alun.id}" />">
                                            <c:out value="${alun.nome}" />
                                        </option>                                            
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="unidade" class="col-form-label">Unidade:* </label>
                                    <select class="form-control" name="unidade" required>
                                        <c:forEach items="${unidades}" var="unid">
                                            <option value="<c:out value="${unid.id}" />">
                                                <c:out value="${unid.nome}" />
                                            </option>                                            
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="curso" class="col-form-label">Curso:* </label>
                                    <select class="form-control" name="curso" required>
                                        <c:forEach items="${cursos}" var="curs">
                                            <option value="<c:out value="${curs.id}" />">
                                                <c:out value="${curs.nome}" />
                                            </option>                                           
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="dtInicio" class="col-form-label">Data de inicio:* </label>
                                    <input type="date" name="dtInicio" class="form-control" min="2017-01-01" max="2018-12-31" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="pagamento" class="col-form-label">Pagamento:* </label>
                                    <select class="form-control" name="pagamento" required>
                                        <option value="true">Pago</option>
                                        <option value="false">Pendente</option>                                        
                                    </select>
                                </div>
                            </div>

                            <div class="form-row col-md-6">                                
                                <div class="btn-group btn-group-justified" role="group" aria-label="...">
                                    <div class="btn-group" role="group">                                        
                                        <button type="submit" class="btn btn-success">Salvar</button>                                        
                                    </div>
                                    <div class="btn-group" role="group">
                                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/home">Cancelar</a>
                                    </div>
                                    <div class="btn-group" role="group">
                                        <button type="reset" class="btn btn-info">Limpar</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div><!--/row-->
                </div><!--/.col-xs-12.col-sm-9-->

                <c:import url="menu-lateral-matriculas.jsp" />
            </div><!--/row-->
        </div><!--/.container-->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>        
    </body>
</html>
