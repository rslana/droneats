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
    <title>Produtos</title>
</head>

<body>
    <%@ include file = "../layout/menu.jsp" %>
    <div class='corpo-usuario'>
        <div class='container'>
            <div class='row'>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <div class='row div-titulo-lista'>
                        <div class='col-md-6'>
                            <h2 class="pedido-titulo">Produtos</h2>
                        </div>
                        <div class='col-md-6 div-btn-right'>
                            <a href="restaurante/cadastrarProduto.jsp" class="btn-1 btn-right">Criar Produto</a>
                        </div>
                    </div>
                </div>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <div class='item-lista-produtos' id="div-produto2">
                        <p class="p-icon" style="background-image: url(assets/images/produtos/hamburger.png)"></p>
                        <p class="p-msg">
                            <span class="nome-produto">X-Burger</span><br>
                            <span style="display: inline-block; margin: 3px 0px 4px 0px">
                                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis. Lorem ipsum
                                dolor sit amet consectetur.</span><br><br>
                            <a href='FrontController?route=produto&action=EditarProduto&id=1' class="btn-1 btn-right">
                                Editar
                            </a>&nbsp;
                            <a href='FrontController?route=produto&action=ExcluirProduto&id=1'
                                class="btn-1-secondary btn-right">
                                Excluir
                            </a>
                        </p>
                    </div>
                </div>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <div class='item-lista-produtos' id="div-produto2">
                        <p class="p-icon" style="background-image: url(assets/images/produtos/pizza.jpg)"></p>
                        <p class="p-msg">
                            <span class="nome-produto">Pizza de Calabresa</span><br>
                            <span style="display: inline-block; margin: 3px 0px 4px 0px">
                                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis. Lorem ipsum
                                dolor sit amet consectetur. Lorem ipsum dolor sit amet consectetur adipisicing elit.
                                Nobis, excepturi.</span><br><br>
                            <a href='FrontController?route=produto&action=EditarProduto&id=2' class="btn-1 btn-right">
                                Editar
                            </a>&nbsp;
                            <a href='FrontController?route=produto&action=ExcluirProduto&id=2'
                                class="btn-1-secondary btn-right">
                                Excluir
                            </a>
                        </p>
                    </div>
                </div>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <div class='item-lista-produtos' id="div-produto2">
                        <p class="p-icon" style="background-image: url(assets/images/produtos/feijoada.jpg)"></p>
                        <p class="p-msg">
                            <span class="nome-produto">Feijoada da Boa</span><br>
                            <span style="display: inline-block; margin: 3px 0px 4px 0px">
                                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis.</span><br><br>
                            <a href='FrontController?route=produto&action=EditarProduto&id=3' class="btn-1 btn-right">
                                Editar
                            </a>&nbsp;
                            <a href='FrontController?route=produto&action=ExcluirProduto&id=3'
                                class="btn-1-secondary btn-right">
                                Excluir
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>