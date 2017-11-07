<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
    <div class="list-group">
        <a href="${pageContext.request.contextPath}/cadastrar-aluno" class="list-group-item">Cadastrar Aluno</a>
        <a href="${pageContext.request.contextPath}/cadastrar-curso" class="list-group-item">Cadastrar Curso</a>
        <a href="${pageContext.request.contextPath}/cadastrar-funcionario" class="list-group-item">Cadastrar Funcionário</a>
        <a href="${pageContext.request.contextPath}/cadastrar-unidade" class="list-group-item">Cadastrar Unidade</a>
    </div>
</div><!--/.sidebar-offcanvas-->
