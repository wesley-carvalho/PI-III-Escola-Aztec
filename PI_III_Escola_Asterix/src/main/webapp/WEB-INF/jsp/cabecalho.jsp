<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Menu Principal</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">            
            <form class="navbar-form navbar-right" action="${pageContext.request.contextPath}/logout">            
                <button type="submit" class="btn btn-danger">Logout</button>
            </form>
            <p class="navbar-text navbar-right"><c:out value="${sessionScope.funcionario.cargo}" /> logado: <c:out value="${sessionScope.funcionario.nome}" /></p>
        </div><!--/.navbar-collapse -->
    </div><!-- /.container -->
</nav><!-- /.navbar -->
