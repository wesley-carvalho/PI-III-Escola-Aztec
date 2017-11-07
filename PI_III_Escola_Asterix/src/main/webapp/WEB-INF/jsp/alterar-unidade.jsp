<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Alterar Unidade</title>
        <link href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    </head>
    <body>
        <c:import url="cabecalho.jsp" />

        <div class="container">
            <div class="row row-offcanvas row-offcanvas-right">
                <div class="col-xs-12 col-sm-9">
                    <div class="jumbotron">
                        <h1>Alterar unidade</h1>
                    </div>

                    <c:if test="${not empty unidade}">
                        <div class="row">
                            <form data-toggle="validator" action="${pageContext.request.contextPath}/unidade_atualizar" method="post">
                                <input type="hidden" name="id" value="<c:out value="${unidade.id}" />">
                                <input type="hidden" name="cadastro" value="<c:out value="${unidade.cadastro}" />">

                                <div class="form-group col-md-12">
                                    <label for="nome" class="col-form-label">Nome:* </label>
                                    <input type="text" name="nome" class="form-control" placeholder="Nome" value="<c:out value="${unidade.nome}" />" required>
                                </div>

                                <div class="form-group col-md-12">
                                    <label for="endereco">Endereço:* </label>
                                    <input type="text" name="endereco" class="form-control" placeholder="Rua Abacaxi Natal, 123" value="<c:out value="${unidade.endereco}" />" required>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="cidade" class="col-form-label">Cidade:* </label>
                                        <input type="text" name="cidade" class="form-control" placeholder="Cidade" value="<c:out value="${unidade.cidade}" />" required>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="estado" class="col-form-label">Estado:* </label>
                                        <input type="text" name="estado" class="form-control" placeholder="Estado" value="<c:out value="${unidade.estado}" />" required>
                                    </div>
                                </div>

                                <div class="form-group col-md-12">
                                    <label for="email">Email:* </label>
                                    <input type="email" name="email" class="form-control" placeholder="email@email.com" value="<c:out value="${unidade.email}" />" required>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="telefone1">Telefone 1:* </label>
                                        <input type="tel" name="telefone1" class="form-control" placeholder="(11)1234-1234" value="<c:out value="${unidade.telefone1}" />" required>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="telefone2">Telefone 2:* </label>
                                        <input type="tel" name="telefone2" class="form-control" placeholder="(11)12345-1234" value="<c:out value="${unidade.telefone2}" />" required>
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
                    </c:if>
                </div><!--/.col-xs-12.col-sm-9-->

                <c:import url="menu-lateral-manutencoes.jsp" />
            </div><!--/row-->
        </div><!--/.container-->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/program.js" type="text/javascript"></script>
    </body>
</html>
