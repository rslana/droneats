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

<body onload="setRestaurante(2,'Restaurante da Esquina')">
    <%@ include file = "../layout/menu.jsp" %>
    <div class='corpo-restaurante'>
        <div class='titulo-restaurante'>
            <h2>Nome do Restaurante</h2>
            <p>
                Lorem ipsum dolor sit, amet consectetur adipisicing elit. Veritatis, doloribus. Lorem ipsum dolor
                sitamet.
            </p>
        </div>

        <div class='container'>
            <div class='row lista-produtos'>
                <div class='col-12 col-md-6 col-lg-6 col-xl-4 normalize-grid'>
                    <div class='item-lista-produtos' id="div-produto1">
                        <p class="p-icon" style="background-image: url(assets/images/produtos/pizza.jpg)"></p>
                        <p class="p-msg">
                            <span class="nome-produto">Pizza Calabresa</span><br>
                            <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis. Lorem ipsum
                                dolor sit amet consectetur.</span><br>
                            <button type="submit" class="btn-adicionar-produto" onclick="cesta.adicionarProduto(1)">
                                Adicionar <span class="item-preco-produto">R$ <span class="preco-produto" id="produto1">
                                        <script>
                                            getPrecoFormatado("25.90", "produto1")
                                        </script>
                                    </span></span>
                            </button>
                        </p>
                    </div>
                </div>
                <div class='col-12 col-md-6 col-lg-6 col-xl-4 normalize-grid'>
                    <div class='item-lista-produtos' id="div-produto2">
                        <p class="p-icon" style="background-image: url(assets/images/produtos/hamburger.png)"></p>
                        <p class="p-msg">
                            <span class="nome-produto">X-Burger</span><br>
                            <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis. Lorem ipsum
                                dolor sit amet consectetur.</span><br>
                            <button type="submit" class="btn-adicionar-produto" onclick="cesta.adicionarProduto(2)">
                                Adicionar <span class="item-preco-produto">R$ <span class="preco-produto" id="produto2">
                                        <script>
                                            getPrecoFormatado("8.90", "produto2")
                                        </script>
                                    </span></span>
                            </button>
                        </p>
                    </div>
                </div>
                <div class='col-12 col-md-6 col-lg-6 col-xl-4 normalize-grid'>
                    <div class='item-lista-produtos' id="div-produto3">
                        <p class="p-icon" style="background-image: url(assets/images/produtos/feijoada.jpg)"></p>
                        <p class="p-msg">
                            <span class="nome-produto">Prato de Feijoada</span><br>
                            <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis. Lorem ipsum
                                dolor sit amet consectetur.</span><br>
                            <button type="submit" class="btn-adicionar-produto" onclick="cesta.adicionarProduto(3)">
                                Adicionar <span class="item-preco-produto">R$ <span class="preco-produto" id="produto3">
                                        <script>
                                            getPrecoFormatado("22.90", "produto3")
                                        </script>
                                    </span></span>
                            </button>
                        </p>
                    </div>
                </div>
                <div class='col-12 col-md-6 col-lg-6 col-xl-4 normalize-grid'>
                    <div class='item-lista-produtos' id="div-produto4">
                        <p class="p-icon" style="background-image: url(assets/images/produtos/hamburger.png)"></p>
                        <p class="p-msg">
                            <span class="nome-produto">Nome do Produto</span><br>
                            <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis. Lorem ipsum
                                dolor sit amet consectetur.</span><br>
                            <button type="submit" class="btn-adicionar-produto" onclick="cesta.adicionarProduto(4)">
                                Adicionar <span class="item-preco-produto">R$ <span class="preco-produto" id="produto4">
                                        <script>
                                            getPrecoFormatado("7.25", "produto4")
                                        </script>
                                    </span></span>
                            </button>
                        </p>
                    </div>
                </div>
                <div class='col-12 col-md-6 col-lg-6 col-xl-4 normalize-grid'>
                    <div class='item-lista-produtos' id="div-produto5">
                        <p class="p-icon" style="background-image: url(assets/images/produtos/feijoada.jpg)"></p>
                        <p class="p-msg">
                            <span class="nome-produto">Nome do Produto</span><br>
                            <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis. Lorem ipsum
                                dolor sit amet consectetur.</span><br>
                            <button type="submit" class="btn-adicionar-produto" onclick="cesta.adicionarProduto(5)">
                                Adicionar <span class="item-preco-produto">R$ <span class="preco-produto" id="produto5">
                                        <script>
                                            getPrecoFormatado("30.00", "produto5")
                                        </script>
                                    </span></span>
                            </button>
                        </p>
                    </div>
                </div>
                <div class='col-12 col-md-6 col-lg-6 col-xl-4 normalize-grid'>
                    <div class='item-lista-produtos' id="div-produto6">
                        <p class="p-icon" style="background-image: url(assets/images/produtos/pizza.jpg)"></p>
                        <p class="p-msg">
                            <span class="nome-produto">Nome do Produto</span><br>
                            <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis. Lorem ipsum
                                dolor sit amet consectetur.</span><br>
                            <button type="submit" class="btn-adicionar-produto" onclick="cesta.adicionarProduto(6)">
                                Adicionar <span class="item-preco-produto">R$ <span class="preco-produto" id="produto6">
                                        <script>
                                            getPrecoFormatado("18.50", "produto6")
                                        </script>
                                    </span></span>
                            </button>
                        </p>
                    </div>
                </div>
                <div class='col-12 col-md-6 col-lg-6 col-xl-4 normalize-grid'>
                    <div class='item-lista-produtos' id="div-produto7">
                        <p class="p-icon" style="background-image: url(assets/images/produtos/pizza.jpg)"></p>
                        <p class="p-msg">
                            <span class="nome-produto">Nome do Produto</span><br>
                            <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis. Lorem ipsum
                                dolor sit amet consectetur.</span><br>
                            <button type="submit" class="btn-adicionar-produto" onclick="cesta.adicionarProduto(7)">
                                Adicionar <span class="item-preco-produto">R$ <span class="preco-produto" id="produto7">
                                        <script>
                                            getPrecoFormatado("8.00", "produto7")
                                        </script>
                                    </span></span>
                            </button>
                        </p>
                    </div>
                </div>
                <div class='col-12 col-md-6 col-lg-6 col-xl-4 normalize-grid'>
                    <div class='item-lista-produtos' id="div-produto8">
                        <p class="p-icon" style="background-image: url(assets/images/produtos/hamburger.png)"></p>
                        <p class="p-msg">
                            <span class="nome-produto">Nome do Produto</span><br>
                            <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis. Lorem ipsum
                                dolor sit amet consectetur.</span><br>
                            <button type="submit" class="btn-adicionar-produto" onclick="cesta.adicionarProduto(8)">
                                Adicionar <span class="item-preco-produto">R$ <span class="preco-produto" id="produto8">
                                        <script>
                                            getPrecoFormatado("6.50", "produto8")
                                        </script>
                                    </span></span>
                            </button>
                        </p>
                    </div>
                </div>
                <div class='col-12 col-md-6 col-lg-6 col-xl-4 normalize-grid'>
                    <div class='item-lista-produtos' id="div-produto9">
                        <p class="p-icon" style="background-image: url(assets/images/produtos/pizza.jpg)"></p>
                        <p class="p-msg">
                            <span class="nome-produto">Nome do Produto</span><br>
                            <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis. Lorem ipsum
                                dolor sit amet consectetur.</span><br>
                            <button type="submit" class="btn-adicionar-produto" onclick="cesta.adicionarProduto(9)">
                                Adicionar <span class="item-preco-produto">R$ <span class="preco-produto" id="produto9">
                                        <script>
                                            getPrecoFormatado("28.90", "produto9")
                                        </script>
                                    </span></span>
                            </button>
                        </p>
                    </div>
                </div>
                <div class='col-12 col-md-6 col-lg-6 col-xl-4 normalize-grid'>
                    <div class='item-lista-produtos' id="div-produto10">
                        <p class="p-icon" style="background-image: url(assets/images/produtos/hamburger.png)"></p>
                        <p class="p-msg">
                            <span class="nome-produto">Nome do Produto dasdasd asd asdas asdas</span><br>
                            <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis. Lorem ipsum
                                dolor sit amet consectetur.</span><br>
                            <button type="submit" class="btn-adicionar-produto" onclick="cesta.adicionarProduto(10)">
                                Adicionar <span class="item-preco-produto">R$ <span class="preco-produto"
                                        id="produto10">
                                        <script>
                                            getPrecoFormatado("7.50", "produto10")
                                        </script>
                                    </span></span>
                            </button>
                        </p>
                    </div>
                </div>
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