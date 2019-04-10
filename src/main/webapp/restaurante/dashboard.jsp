<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel='stylesheet' href='http://localhost:8080/droneats/assets/bootstrap/css/bootstrap.css'>
    <link rel="stylesheet/less" type="text/css" href="http://localhost:8080/droneats/assets/css/estilo.less">
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css"
        href="http://localhost:8080/droneats/assets/fontawesome-free-5.7.2-web/css/all.css">
    <!-- Less -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
    <script src="http://localhost:8080/droneats/assets/js/global.js"></script>
    <%@ include file = "../utils/config.jsp" %>
    <title>Dashboard</title>
</head>

<body>
    <%@ include file = "../layout/menu.jsp" %>
    <div class='corpo-home'>
        <div class='titulo-home'>
            <h1>${restaurante.nome}</h1>
        </div>
        <div class='container'>
            <div class='row lista-restaurantes equal'>
                <div class='col-sm-4 col-lg-4 normalize-grid'>
                    <a class='item-lista-restaurantes' href="FrontController?route=restaurante&action=ListarPedidos">
                        <p class="p-msg text-center">
                            <br>
                            <i class="fas fa-parachute-box"></i>
                            <br><br>
                            <b>${quantidadePedidos}</b>
                            <br><br>
                            <span>Pedidos</span>
                            <br><br>
                        </p>
                    </a>
                </div>
                <div class='col-sm-4 col-lg-4 normalize-grid'>
                    <a class='item-lista-restaurantes' href="FrontController?route=produto&action=ListarProdutos">
                        <p class="p-msg text-center">
                            <br>
                            <i class="fas fa-utensils"></i>
                            <br><br>
                            <b>${quantidadeProdutos}</b>
                            <br><br>
                            <span>Produtos</span>
                            <br><br>
                        </p>
                    </a>
                </div>
                <div class='col-sm-4 col-lg-4 normalize-grid'>
                    <a class='item-lista-restaurantes' href="FrontController?route=categoria&action=ListarCategorias">
                        <p class="p-msg text-center">
                            <br>
                            <i class="fas fa-tags"></i>
                            <br><br>
                            <b>${quantidadeCategorias}</b>
                            <br><br>
                            <span>Categorias</span>
                            <br><br>
                        </p>
                    </a>
                </div>
            </div>
        </div>
    </div>
</body>

</html>