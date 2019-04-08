<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet/less" type="text/css" href="http://localhost:8080/droneats/assets/css/estilo.less">
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css"
        href="http://localhost:8080/droneats/assets/fontawesome-free-5.7.2-web/css/all.css">
    <!-- Less -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
    <%@ include file = "../utils/config.jsp" %>
    <title>Login</title>
</head>

<body>
    <div class='corpo-login'>
        <div class='div-centro-login'>
            <div class='titulo-login'>
                <h1><a href='index.jsp' class="droneats">Dron<span>eats</span></a></h1>
            </div>
        </div>
        <%@ include file = "../layout/mensagem.jsp" %> <br>
        <div class='corpo-form'>
            <form action="FrontController?route=usuario&action=LoginRestaurante" method="post">
                <h2>Entrar como Restaurante</h2>
                <c:choose>
                    <c:when test="${mensagem != null}">
                        <div class='msg-alert-negative'>
                            <span>
                                <c:out value="${mensagem}" />
                            </span>
                        </div>
                    </c:when>
                </c:choose>
                <div class='form-input'>
                    <label for='email'>E-mail</label><br />
                    <input type="email" name="email" /><br />
                </div>
                <div class='form-input'>
                    <label for='senha'>Senha</label>
                    <input type="password" name="senha" /><br />
                </div>
                <button type="submit" class="btn-1">Entrar</button>
            </form>
        </div>
        <div class='rodape-corpo-form'>
            <span>
                Não tem uma conta ainda? <a href='auth/cadastro.jsp'>Cadastre-se</a>
            </span>
        </div>
    </div>
</body>

</html>