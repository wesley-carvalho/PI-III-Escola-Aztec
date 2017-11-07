<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Aztec - Login</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/singin.css">
    </head>
    <body>
        <div class="container">
            <form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
                <h2 class="form-signin-heading">Login</h2>

                <c:if test="${not empty msgErro}">
                    <h2><c:out value="${msgErro}" /></h2>
                </c:if>
                <c:if test="${not empty msgLogout}">
                    <h2><c:out value="${msgLogout}" /></h2>
                </c:if>

                <div>
                    <label for="username" class="sr-only">Username</label>
                    <input type="text" name="username" id="username" class="form-control" placeholder="Username" required autofocus>
                </div>
                <div>
                    <label for="password" class="sr-only">Password</label>
                    <input type="password" name="senha" id="password" class="form-control" placeholder="Password" required> 
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
            </form>
        </div> <!-- /container -->
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>