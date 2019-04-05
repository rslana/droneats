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
    <%@ include file = "../utils/config.jsp" %>
    <title>Pedido</title>
</head>

<body>
    <%@ include file = "../layout/menu.jsp" %>
    <div class='corpo-usuario'>
        <div class='container'>
            <c:choose>
                <c:when test="${mensagemSucesso != null}">
                    <div class='row' id="mensagemSucesso">
                        <div class='col-md-10 col-md-offset-1'>
                            <div class='msg-sucesso sucesso-pedido'>
                                <p class="p-icon"><i class="fa fa-check" aria-hidden="true"></i></p>
                                <p class="p-msg">
                                    <span>${mensagemSucesso}</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <script>
                        cesta.esvaziarCesta();
                    </script>
                </c:when>
            </c:choose>
            <c:choose>
                <c:when test="${pedido != null}">
                    <div class='row'>
                        <div class='col-md-6 col-md-offset-3 normalize-grid'>
                            <h2 class="pedido-titulo">Pedido</h2>
                        </div>
                        <div class='col-md-6 col-md-offset-3 normalize-grid'>
                            <div class='detalhe-pedido'>
                                <a class="nome-restaurante-pedido"
                                    href="FrontController?route=restaurante&action=ExibirRestaurante&id=${pedido.restaurante.id}">
                                    ${pedido.restaurante.nome}
                                </a>
                                <hr>
                                <div class='item-lista-cesta-compra barra-estado-pedido'>
                                    <p class="p-msg"><i class="fas fa-box"></i></p>
                                    <p class="p-msg">
                                        <span>${pedido.estado.estadoMensagem}</span>
                                    </p>
                                    <p class="p-msg p-right" style="min-width: 100px;">
                                        <button class="btn-1 btn-right">Cancelar</button>
                                    </p>
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
                                                            getPrecoFormatado('${produto.preco}',
                                                                'produto${produto.produto.id}')
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
                                                        getPrecoFormatado('${pedido.valor}', "preco-total")
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
                </c:when>
            </c:choose>
        </div>
    </div>
    <script>
        atualizarStateLinkCesta();
        apagarMensagem('mensagemSucesso');
    </script>
</body>

</html>