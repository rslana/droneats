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
                    <h2 class="pedido-titulo">Pedido ${pedido.id}</h2>
                </div>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <div class='detalhe-pedido'>
                        <span class="nome-restaurante-pedido">
                            <b>Solictado por </b> ${pedido.cliente.nome}
                        </span>
                        <hr>
                        <div class='item-lista-cesta-compra barra-estado-pedido'>
                            <p class="p-msg"><i class="fas fa-box"></i></p>
                            <p class="p-msg">
                                <span>${pedido.estado.estadoMensagem}</span>
                            </p>
                            <p class="p-msg p-right" style="min-width:0px"></p>
                        </div>
                        <div class='steps' id="steps">
                            <div class='step'>
                                <div class='dot'></div>
                            </div>
                            <div class='step'>
                                <div class='dot'></div>
                            </div>
                            <div class='step'>
                                <div class='dot'></div>
                                <div class='dot last-dot'></div>
                            </div>
                        </div>
                        <c:choose>
                            <c:when test="${mensagem != null}">
                                <br><br>
                                <h4 class="text-center msg-pedido">
                                    <c:out value="${mensagem}" />
                                </h4>
                                <br>
                            </c:when>
                        </c:choose>
                        <br>
                        <div class='row equal'>
                            <form action='FrontController?route=pedido&action=AlterarPedidoEstado' method="POST"
                                id="formEditarPedido">
                                <input type='hidden' name="pedidoId" value="${pedido.id}" />
                                <div class='div-troca-estado-pedido'>
                                    <div class='col-md-12'>
                                        <label for="processando" class='item-troca-estado-pedido'>
                                            <input type="radio" id="processando" name="estadoPedido"
                                                value="Processando" />
                                            <span>
                                                Processando
                                            </span>
                                        </label>
                                    </div>
                                    <div class='col-md-12'>
                                        <label for="preparando" class='item-troca-estado-pedido'>
                                            <input type="radio" id="preparando" name="estadoPedido"
                                                value="Preparando" />
                                            <span>
                                                Preparando
                                            </span>
                                        </label>
                                    </div>
                                    <div class='col-md-12'>
                                        <label for="entregando" class='item-troca-estado-pedido'>
                                            <input type="radio" id="entregando" name="estadoPedido"
                                                value="Entregando" />
                                            <span>
                                                Entregando
                                            </span>
                                        </label>
                                    </div>
                                    <div class='col-md-12'>
                                        <label for="entregue" class='item-troca-estado-pedido'>
                                            <input type="radio" id="entregue" name="estadoPedido" value="Entregue" />
                                            <span>
                                                Entregue
                                            </span>
                                        </label>
                                    </div>
                                    <div class='col-md-12'>
                                        <label for="cancelado" class='item-troca-estado-pedido'>
                                            <input type="radio" id="cancelado" name="estadoPedido" value="Cancelado" />
                                            <span>
                                                Cancelado
                                            </span>
                                        </label>
                                    </div>
                                    <div class='col-md-12'>
                                        <button type="submit" class="btn-1" id="btnEditarEstado"
                                            onclick="submitWithLoading(this,'formEditarPedido')">Editar Estado</button>
                                    </div>
                                    <script>
                                        checkPedidoEstado('${pedido.estado.estado}')
                                    </script>
                                </div>
                            </form>
                        </div>
                        <hr>
                        <c:forEach items="${pedido.produtos}" var="produto">
                            <div class='item-lista-cesta-compra'>
                                <p class="p-msg"><b>${produto.quantidade}x</b></p>
                                <p class="p-msg">
                                    <span>${produto.produto.nome}</span>
                                </p>
                                <p class="p-msg p-right">
                                    <span>
                                        <b>
                                            R$
                                            <span class="preco-produto" id="produto${produto.produto.id}">
                                                <script>
                                                    getPrecoFormatado("${produto.preco}",
                                                        "produto${produto.produto.id}")
                                                </script>
                                            </span>
                                        </b>
                                    </span>
                                </p>
                            </div>
                        </c:forEach>
                        <div class='item-lista-cesta-compra msg-sucesso'>
                            <p class="p-msg"><b>Total</b></p>
                            <p class="p-msg p-right">
                                <span>
                                    <b>
                                        R$
                                        <span class="preco-produto" id="preco-total">
                                            <script>
                                                getPrecoFormatado("${pedido.valor}", "preco-total")
                                            </script>
                                        </span>
                                    </b>
                                </span>
                            </p>
                        </div>
                        <hr>
                        <div class="rodape-detalhe-pedido">
                            <span class="data-detalhe-pedido">
                                Data do pedido: ${pedido.dataPedido} - ${pedido.horarioPedido}
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        document.getElementById("btnEditarEstado").addEventListener("click", function (event) {
            event.preventDefault()
        });
        atualizarStep();
    </script>
</body>

</html>