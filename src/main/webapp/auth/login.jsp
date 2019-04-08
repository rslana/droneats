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
    <script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
    <%@ include file = "../utils/config.jsp" %>
    <title>Login</title>
</head>

<body>
    <div class='corpo-login'>
        <div class='div-centro-cadastro'>
            <div class='titulo-login'>
                <h1><a href='index.jsp' class="droneats">Dron<span>eats</span></a></h1>
            </div>
        </div>
        <div class='cards-cadastro'>
            <h1>Entrar como</h1>
            <a class='card-cadastro' href="auth/loginCliente.jsp">
                <i class="fas fa-user fa-3x"></i>
                <h2>Cliente</h2>
            </a>
            <a class='card-cadastro' href="auth/loginRestaurante.jsp">
                <i class="fas fa-utensils fa-3x"></i>
                <h2>Restaurante</h2>
            </a>
        </div>
    </div>
</body>

</html>