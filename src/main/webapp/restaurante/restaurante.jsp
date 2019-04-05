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
    <script src="http://localhost:8080/droneats/assets/js/request.js"></script>
    <%@ include file = "../utils/config.jsp" %>
    <title>Restaurante</title>
</head>

<!-- Pegar ID e NOME do restaurante -->

<body onload="setRestaurante('${restaurante.id}','${restaurante.nome}')">
    <%@ include file = "../layout/menu.jsp" %>
    <div class='corpo-restaurante'>
        <div class='titulo-restaurante'>
            <h2>${restaurante.nome}</h2>
            <p>
                ${restaurante.descricao}
            </p>
        </div>

        <div class='container'>
            <div class='row lista-produtos equal'>
                <c:choose>
                    <c:when test="${produtos[0] == null}">
                        <div class='text-center'>
                            <h3>Esse restaurante não possuí produtos cadastrados</h3>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${produtos}" var="produto">
                            <div class='col-12 col-md-6 col-lg-6 col-xl-4 normalize-grid'>
                                <div class='item-lista-produtos' id="div-produto${produto.id}">
                                    <p class="p-icon" style="background-image: url(${produto.imagem})">
                                    </p>
                                    <p class="p-msg">
                                        <span class="nome-produto">${produto.nome}</span><br>
                                        <span>${produto.descricao}</span><br>
                                        <button type="submit" class="btn-adicionar-produto"
                                            onclick="cesta.adicionarProduto('${produto.id}','${produto.nome}','${produto.preco}')">
                                            Adicionar
                                            <span class="item-preco-produto">
                                                R$
                                                <span class="preco-produto" id="produto${produto.id}">
                                                    <script>
                                                        getPrecoDesconto('${produto.preco}', "produto${produto.id}",
                                                            "0")
                                                    </script>
                                                </span>
                                            </span>
                                        </button>
                                    </p>
                                    <!-- <span class="desconto-produto">
                                        R$
                                        <span id='desconto-produto1'>
                                            <script>
                                                getPrecoFormatado('${produto.preco}',
                                                    "desconto-produto${produto.id}")
                                            </script>
                                        </span>
                                    </span> -->
                                </div>
                            </div>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
    <div class='cesta-compra'>
        <form action='FrontController?route=pedido&action=CadastrarPedido' method="POST">
            <div class='corpo-cesta-compra'>
                <div id="restaurante-info-cesta-compra">
                    <h4>Pedido</h4>
                    <h3 id="nome-restaurante-cesta-compra"></h3>
                    <hr>
                </div>
                <div id="cesta-vazia" class="cesta-vazia">
                    <i class="fas fa-shopping-basket fa-4x"></i>
                    <br><br><br>
                    Sua cesta está vazia
                </div>
                <div id="cesta"></div>
                <hr>
                <div class='item-lista-cesta-compra'>
                    <p class="p-msg"><b>Total</b></p>
                    <p class="p-msg p-right">
                        <span>
                            <b>
                                R$
                                <span class="preco-produto" id="preco-total">
                                    0,00
                                </span>
                            </b>
                        </span>
                    </p>
                </div>
            </div>
            <button class="btn-1 btn-filanizar-pedido" id="btn-finalizar-pedido" onclick="finalizarPedido()">
                Finalizar Pedido
            </button>
        </form>
    </div>
    <div class='mensagem-troca-restaurante' id="mensagem-troca-restaurante" style="display: none">
        <div class='bg-mensagem-troca-restaurante'></div>
        <div class='item-mensagem'>
            <h2>Você só pode adicionar itens de um restaurante por vez</h2>
            <p>Deseja esvaziar a cesta e adicionar este item?</p>
            <br>
            <button class="btn-1" onclick="esvaziarCestaAdicionarProduto()">Esvaziar cesta e adicionar</button>
            <button class="btn-1-secondary" onclick="fecharModal('mensagem-troca-restaurante')">Cancelar</button>
        </div>
    </div>
    <script src="assets/js/state.js"></script>
    <script>
        document.getElementById("btn-finalizar-pedido").addEventListener("click", function (event) {
            event.preventDefault()
        });
    </script>
</body>

</html>