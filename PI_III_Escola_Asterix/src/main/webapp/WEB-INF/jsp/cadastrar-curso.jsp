<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Cadastrar Curso</title>
        <link href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    </head>
    <body>
        <c:import url="cabecalho.jsp" />

        <div class="container">
            <div class="row row-offcanvas row-offcanvas-right">

                <div class="col-xs-12 col-sm-9">
                    <div class="jumbotron">
                        <h1>Cadastrar curso</h1>
                    </div>

                    <div class="row">
                        <form data-toggle="validator"  action="${pageContext.request.contextPath}/curso_inserir" method="post">
                            <div class="form-group col-md-12">
                                <label for="nome" class="col-form-label">Nome:* </label>
                                <input type="text" name="nome" class="form-control" placeholder="Nome" required>
                            </div>

                            <div class="form-group col-md-12">
                                <label for="descrição" class="col-form-label">Descrição: </label>
                                <textarea rows="3" name="descricao" class="form-control" placeholder="Descrição"></textarea>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="categoria" class="col-form-label">Categoria:* </label>
                                    <select class="form-control" name="categoria" required>
                                        <option value="curso tecnico">Curso Técnico</option>
                                        <option value="profissionalizante">Profissionalizante</option>
                                        <option value="educacao a distancia">Educação a distância</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="valor" class="col-form-label">Valor:* </label>
                                    <div class="input-group">
                                        <span class="input-group-addon">R$</span>
                                        <input type="text" name="valor" class="form-control" placeholder="1234,00" required>
                                    </div>
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

                <c:import url="menu-lateral-cadastros.jsp" />
            </div><!--/row-->
        </div><!--/.container-->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>        
    </body>
</html>
