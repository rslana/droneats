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
    <link rel="stylesheet/less" type="text/css" href="http://localhost:8080/droneats/assets/css/usuario.less">
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css"
        href="http://localhost:8080/droneats/assets/fontawesome-free-5.7.2-web/css/all.css">
    <!-- Less -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
    <script src="http://localhost:8080/droneats/assets/js/global.js"></script>
    <script src="http://localhost:8080/droneats/assets/js/request.js"></script>
    <%@ include file = "../utils/config.jsp" %>
    <title>Editar Produto</title>
</head>

<body>
    <%@ include file = "../layout/menu.jsp" %>
    <div class='corpo-usuario'>
        <div class='container'>
            <div class='row'>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <h2 class="pedido-titulo">Pedidos</h2>
                </div>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <a class='msg-sucesso sucesso-pedido' href='restaurante/editarPedido.jsp'>
                        <p class="p-msg data-pedido">
                            <span>20</span>
                            <br>
                            <span>FEV</span>
                        </p>
                        <p class="p-msg">
                            <span class="nome-restaurante-lista-pedido">
                                <i class="fas fa-shipping-fast"></i>&nbsp;&nbsp;Processando
                            </span><br>
                            <span class="descricao-pedido">
                                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                                Officia, reiciendis!
                            </span>
                        </p>
                    </a>
                </div>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <a class='msg-sucesso sucesso-pedido'
                        href='FrontController?route=pedido&actionPrepararEditarPedidoEstado&id=1'>
                        <p class="p-msg data-pedido">
                            <span>20</span>
                            <br>
                            <span>FEV</span>
                        </p>
                        <p class="p-msg">
                            <span class="nome-restaurante-lista-pedido">
                                <i class="fas fa-shipping-fast"></i>&nbsp;&nbsp;Preparando
                            </span><br>
                            <span class="descricao-pedido">
                                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                                Officia, reiciendis!
                            </span>
                        </p>
                    </a>
                </div>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <a class='msg-sucesso sucesso-pedido'
                        href='FrontController?route=pedido&actionPrepararEditarPedidoEstado&id=1'>
                        <p class="p-msg data-pedido">
                            <span>20</span>
                            <br>
                            <span>FEV</span>
                        </p>
                        <p class="p-msg">
                            <span class="nome-restaurante-lista-pedido">
                                <i class="fas fa-shipping-fast"></i>&nbsp;&nbsp;Entregando
                            </span><br>
                            <span class="descricao-pedido">
                                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                                Officia, reiciendis!
                            </span>
                        </p>
                    </a>
                </div>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <a class='msg-sucesso sucesso-pedido'
                        href='FrontController?route=pedido&actionPrepararEditarPedidoEstado&id=1'>
                        <p class="p-msg data-pedido">
                            <span>20</span>
                            <br>
                            <span>FEV</span>
                        </p>
                        <p class="p-msg">
                            <span class="nome-restaurante-lista-pedido">
                                <i class="fas fa-shipping-fast"></i>&nbsp;&nbsp;Entregue
                            </span><br>
                            <span class="descricao-pedido">
                                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                                Officia, reiciendis!
                            </span>
                        </p>
                    </a>
                </div>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <a class='msg-sucesso sucesso-pedido'
                        href='FrontController?route=pedido&actionPrepararEditarPedidoEstado&id=1'>
                        <p class="p-msg data-pedido">
                            <span>20</span>
                            <br>
                            <span>FEV</span>
                        </p>
                        <p class="p-msg">
                            <span class="nome-restaurante-lista-pedido">
                                <i class="fas fa-shipping-fast"></i>&nbsp;&nbsp;Cancelado
                            </span><br>
                            <span class="descricao-pedido">
                                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                                Officia, reiciendis!
                            </span>
                        </p>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <script>
        document.getElementById("btnCadastrar").addEventListener("click", function (event) {
            event.preventDefault()
        });
    </script>
</body>

</html>