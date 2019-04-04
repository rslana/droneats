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
    <title>Editar Pedido</title>
</head>

<body>
    <%@ include file = "../layout/menu.jsp" %>
    <div class='corpo-usuario'>
        <div class='container'>
            <div class='row'>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <h2 class="pedido-titulo">Pedido 99</h2>
                </div>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <div class='detalhe-pedido'>
                        <a class="nome-restaurante-pedido" href="restaurante/restaurante.jsp">
                            Nome do Cliente
                        </a>
                        <hr>
                        <div class='item-lista-cesta-compra'>
                            <p class="p-msg"><i class="fas fa-shipping-fast"></i></p>
                            <p class="p-msg p-right">
                                <span>Estado do Pedido: <b>Preparando</b></span>
                            </p>
                        </div>
                        <br>
                        <div class='row equal'>
                            <form action='FrontController?route=pedido&action=EditarPedidoEstado'>
                                <div class='div-troca-estado-pedido'>
                                    <div class='col-md-12'>
                                        <label for="processando" class='item-troca-estado-pedido'>
                                            <input type="radio" id="processando" name="estadoPedido"
                                                value="processando" />
                                            Processando
                                        </label>
                                    </div>
                                    <div class='col-md-12'>
                                        <label for="preparando" class='item-troca-estado-pedido'>
                                            <input type="radio" id="preparando" name="estadoPedido"
                                                value="preparando" />
                                            Preparando
                                        </label>
                                    </div>
                                    <div class='col-md-12'>
                                        <label for="entregando" class='item-troca-estado-pedido'>
                                            <input type="radio" id="entregando" name="estadoPedido"
                                                value="entregando" />
                                            Entregando
                                        </label>
                                    </div>
                                    <div class='col-md-12'>
                                        <label for="entregue" class='item-troca-estado-pedido'>
                                            <input type="radio" id="entregue" name="estadoPedido" value="entregue" />
                                            Entregue
                                        </label>
                                    </div>
                                    <div class='col-md-12'>
                                        <label for="cancelado" class='item-troca-estado-pedido'>
                                            <input type="radio" id="cancelado" name="estadoPedido" value="cancelado" />
                                            Cancelado
                                        </label>
                                    </div>
                                    <div class='col-md-12'>
                                        <button type="submit" class="btn-1">Editar Estado</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <hr>
                        <div class='item-lista-cesta-compra'>
                            <p class="p-msg"><b>2x</b></p>
                            <p class="p-msg">
                                <span>X-Bacon</span>
                            </p>
                            <p class="p-msg p-right">
                                <span>
                                    <b>
                                        R$
                                        <span class="preco-produto" id="produto1">
                                            <script>
                                                getPrecoFormatado("7.50", "produto1")
                                            </script>
                                        </span>
                                    </b>
                                </span>
                            </p>
                        </div>
                        <div class='item-lista-cesta-compra'>
                            <p class="p-msg"><b>1x</b></p>
                            <p class="p-msg">
                                <span>X-Tudo</span>
                            </p>
                            <p class="p-msg p-right">
                                <span>
                                    <b>
                                        R$
                                        <span class="preco-produto" id="produto2">
                                            <script>
                                                getPrecoFormatado("10.00", "produto2")
                                            </script>
                                        </span>
                                    </b>
                                </span>
                            </p>
                        </div>
                        <div class='item-lista-cesta-compra msg-sucesso'>
                            <p class="p-msg"><b>Total</b></p>
                            <p class="p-msg p-right">
                                <span>
                                    <b>
                                        R$
                                        <span class="preco-produto" id="preco-total">
                                            <script>
                                                getPrecoFormatado("25.00", "preco-total")
                                            </script>
                                        </span>
                                    </b>
                                </span>
                            </p>
                        </div>
                        <hr>
                        <div class="rodape-detalhe-pedido">
                            <span class="data-detalhe-pedido">
                                Data do pedido: 22/03/2019 - 16:58
                            </span>
                        </div>
                    </div>
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