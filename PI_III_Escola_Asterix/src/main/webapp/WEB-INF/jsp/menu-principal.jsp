<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Menu Principal</title>        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/cabecalho.jsp" />

        <div class="container">
            <div class="jumbotron">
                <h1>Menu Principal</h1>
            </div>

            <div class="row">
                <div class="col-xs-6 col-lg-4">
                    <img class="img-circle" src="${pageContext.request.contextPath}/img/icone-cadastro.png" alt="cadastros" width="140" height="140">
                    <h2>Cadastros</h2>
                    <p><a href="${pageContext.request.contextPath}/cadastrar-aluno">Cadastro de Alunos</a></p>
                    <p><a href="${pageContext.request.contextPath}/cadastrar-curso">Cadastro de Cursos</a></p>
                    <p><a href="${pageContext.request.contextPath}/cadastrar-funcionario">Cadastro de Funcionários</a></p>
                    <p><a href="${pageContext.request.contextPath}/cadastrar-unidade">Cadastro de Unidades</a></p>
                </div><!-- /.col-lg-4 -->
                <div class="col-xs-6 col-lg-4">
                    <img class="img-circle" src="${pageContext.request.contextPath}/img/icone-parametrizacao.png" alt="manutencoes" width="140" height="140">
                    <h2>Buscas, Alterações e Exclusões</h2>
                    <p><a href="${pageContext.request.contextPath}/manutencao-alunos">Manutenção de Cadastro de Alunos</a></p>
                    <p><a href="${pageContext.request.contextPath}/manutencao-cursos">Manutenção de Cadastro de Cursos</a></p>
                    <p><a href="${pageContext.request.contextPath}/manutencao-funcionarios">Manutenção de Cadastro de Funcionários</a></p>
                    <p><a href="${pageContext.request.contextPath}/manutencao-matriculas">Manutenção de Cadastro de Matrículas</a></p>
                    <p><a href="${pageContext.request.contextPath}/manutencao-unidades">Manutenção de Cadastro de Unidades</a></p>
                </div><!-- /.col-lg-4 -->
                <div class="col-xs-6 col-lg-4">
                    <img class="img-circle" src="${pageContext.request.contextPath}/img/icone-relatorio.png" alt="matriculas" width="140" height="140">
                    <h2>Matrículas e Relatórios</h2>
                    <p><a href="${pageContext.request.contextPath}/matricular">Matrículas</a></p>
                    <p><a href="${pageContext.request.contextPath}/relatorio">Relatório de Matrículas</a></p>
                </div><!-- /.col-lg-4 -->
            </div><!--/row-->
        </div><!--/.container-->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    </body>
</html>

