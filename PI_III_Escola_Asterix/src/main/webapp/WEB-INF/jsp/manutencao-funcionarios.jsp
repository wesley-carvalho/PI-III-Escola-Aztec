<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Manutenção de Cadastro de Funcionários</title>
        <link href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    </head>
    <body>
        <c:import url="cabecalho.jsp" />

        <div class="container">
            <div class="row row-offcanvas row-offcanvas-right">
                <div class="col-xs-12 col-sm-9">

                    <div class="jumbotron">
                        <h1>Manutenção de Cadastro de Funcionários</h1>
                    </div>

                    <div class="jumbotron">
                        <form data-toggle="validator" action="${pageContext.request.contextPath}/funcionario_buscar" method="post">                            
                            <div class="input-group">
                                <input type="text" name="nome" class="form-control" placeholder="Digite aqui o nome do funcionário" required>
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="submit">Buscar</button>
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}/funcionario_listar">Listar</a>
                                </span>
                            </div><!-- /input-group -->
                        </form>
                    </div>

                    <c:if test="${not empty msgErro}">
                        <h2><c:out value="${msgErro}" /></h2>
                    </c:if>
                    <c:if test="${not empty funcionarios}">
                        <h2 class="sub-header">Funcionários</h2>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Nome</th>
                                        <th>Documento</th>
                                        <th>Nascimento</th>                                        
                                        <th>Cadastro</th>                                                                             
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${funcionarios}" var="funcionario">                                
                                        <tr>
                                            <td><c:out value="${funcionario.id}" /></td>
                                            <td><c:out value="${funcionario.nome}" /></td>
                                            <td><c:out value="${funcionario.documento}" /></td>
                                            <td><c:out value="${funcionario.nascimento}" /></td>
                                            <td><c:out value="${funcionario.cadastro}" /></td>
                                            <td>
                                                <form action="${pageContext.request.contextPath}/funcionario_alterar" method="post"> 
                                                    <input type="hidden" name="funcionarioId" value="<c:out value="${funcionario.id}" />">
                                                    
                                                    <button class="btn btn-xs btn-warning" type="submit"><spam class="glyphicon glyphicon-pencil"></spam></button>
                                                </form>                                                                                               
                                            </td>
                                            <td>
                                                <form action="${pageContext.request.contextPath}/funcionario_excluir" method="post">
                                                    <input type="hidden" name="funcionarioId" value="<c:out value="${funcionario.id}" />">
                                                    
                                                    <button class="btn btn-xs btn-danger" type="submit"><spam class="glyphicon glyphicon-remove"></spam></button>
                                                </form>
                                            </td>                                            
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                </div><!--/.col-xs-12.col-sm-9-->

                <c:import url="menu-lateral-manutencoes.jsp" />
            </div><!--/row-->
        </div><!--/.container-->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    </body>
</html>