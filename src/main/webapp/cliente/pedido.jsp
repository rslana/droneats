<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel='stylesheet' href='../assets/bootstrap/css/bootstrap.css'>
    <link rel="stylesheet/less" type="text/css" href="../assets/css/estilo.less">
    <link rel="stylesheet/less" type="text/css" href="../assets/css/usuario.less">
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css" href="../assets/fontawesome-free-5.7.2-web/css/all.css">
    <!-- Less -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
    <script src="../assets/js/global.js"></script>
    <%@ include file = "../utils/config.jsp" %>
    <title>Pedido</title>
</head>

<body>
    <%@ include file = "../layout/menu.jsp" %>
    <div class='corpo-usuario'>
        <div class='container'>
            <c:choose>
                <c:when test="${mensagem != null}">
                    <div class='row'>
                        <div class='col-md-10 col-md-offset-1'>
                            <div class='msg-sucesso sucesso-pedido'>
                                <p class="p-icon"><i class="fa fa-check" aria-hidden="true"></i></p>
                                <p class="p-msg">
                                    <b>Pedido realizado com sucesso</b><br>
                                    <span>Acompanhe seu pedido clicando <a href='index.jsp'>aqui</a></span>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:when test="${pedido == null}">
                    <div class='row'>
                        <div class='col-md-6 col-md-offset-3 normalize-grid'>
                            <h2 class="pedido-titulo">Pedido</h2>
                        </div>
                        <div class='col-md-6 col-md-offset-3 normalize-grid'>
                            <div class='detalhe-pedido'>
                                <a class="nome-restaurante-pedido" href="restaurante/restaurante.jsp">
                                    Nome do Restaurante
                                </a>
                                <hr>
                                <div class='item-lista-cesta-compra'>
                                    <p class="p-msg"><i class="fas fa-shipping-fast"></i></p>
                                    <p class="p-msg p-right">
                                        <span>Estado do Pedido</span>
                                    </p>
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
                </c:when>
            </c:choose>
        </div>
    </div>
    <script>
        atualizarStateLinkCesta();
    </script>
</body>

</html>