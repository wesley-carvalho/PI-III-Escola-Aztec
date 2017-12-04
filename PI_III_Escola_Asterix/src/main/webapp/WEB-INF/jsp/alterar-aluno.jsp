<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Alterar Aluno</title>
        <link href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    </head>
    <body>
        <c:import url="cabecalho.jsp" />

        <div class="container">
            <div class="row row-offcanvas row-offcanvas-right">

                <div class="col-xs-12 col-sm-9">
                    <div class="jumbotron">
                        <h1>Alterar aluno</h1>
                    </div>

                    <c:if test="${not empty aluno}">
                        <div class="row">
                            <form data-toggle="validator" action="${pageContext.request.contextPath}/aluno_atualizar" method="post">
                                <input type="hidden" name="id" value="<c:out value="${aluno.id}" />">
                                <input type="hidden" name="cadastradoPor" value="<c:out value="${sessionScope.funcionario.username}" />">
                                <input type="hidden" name="cadastradoEm" value="<c:out value="${aluno.cadastradoEm}" />">                                

                                <div class="form-group col-md-12">
                                    <label for="nome" class="col-form-label">Nome Completo:* </label>
                                    <input type="text" name="nome" class="form-control" placeholder="Nome Completo" maxlength="255" value="<c:out value="${aluno.nome}" />" required>
                                </div>                            

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="documento" class="col-form-label">Documento:* </label>
                                        <input type="text" name="documento" class="form-control" placeholder="Documento" maxlength="255" value="<c:out value="${aluno.documento}" />" required>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="dtNascimento" class="col-form-label">Data de Nascimento:* </label>
                                        <input type="date" name="dtNascimento" class="form-control" min="1901-01-01" max="2017-12-31" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${aluno.nascimento}" />" required>
                                    </div>
                                </div>

                                <div class="form-group col-md-12">
                                    <label for="endereco">Endereço:* </label>
                                    <input type="text" name="endereco" class="form-control" placeholder="Rua Abacaxi Natal, 123" maxlength="255" value="<c:out value="${aluno.endereco}" />"required>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="cidade" class="col-form-label">Cidade:* </label>
                                        <input type="text" name="cidade" class="form-control" placeholder="Cidade" maxlength="255" value="<c:out value="${aluno.cidade}" />" required>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="estado" class="col-form-label">Estado:* </label>
                                        <input type="text" name="estado" class="form-control" placeholder="Estado" maxlength="255" value="<c:out value="${aluno.estado}" />" required>
                                    </div>
                                </div>

                                <div class="form-group col-md-12">
                                    <label for="email">Email:* </label>
                                    <input type="email" name="email" class="form-control" placeholder="email@email.com" maxlength="255" value="<c:out value="${aluno.email}" />" required>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="telefone">Telefone:* </label>
                                        <input type="tel" name="telefone" class="form-control" placeholder="(11)1234-1234" maxlength="255" value="<c:out value="${aluno.telefone}" />" required>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="celular">Celular: </label>
                                        <input type="tel" name="celular" class="form-control" placeholder="(11)12345-1234" maxlength="255" value="<c:out value="${aluno.celular}" />">
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

