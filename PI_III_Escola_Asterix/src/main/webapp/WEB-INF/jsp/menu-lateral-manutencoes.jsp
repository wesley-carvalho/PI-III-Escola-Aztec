<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
    <div class="list-group">
        <a href="${pageContext.request.contextPath}/manutencao-alunos" class="list-group-item">Manutenção de Cadastro de Alunos</a>
        <a href="${pageContext.request.contextPath}/manutencao-cursos" class="list-group-item">Manutenção de Cadastro de Cursos</a>
        <a href="${pageContext.request.contextPath}/manutencao-funcionarios" class="list-group-item">Manutenção de Cadastro de Funcionários</a>
        <a href="${pageContext.request.contextPath}/manutencao-matriculas" class="list-group-item">Manutenção de Cadastro de Matrículas</a>
        <a href="${pageContext.request.contextPath}/manutencao-unidades" class="list-group-item">Manutenção de Cadastro de Unidades</a>
    </div>
</div><!--/.sidebar-offcanvas-->
