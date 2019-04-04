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
            <div class='row'>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <h2 class="pedido-titulo">Pedidos</h2>
                </div>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <a class='msg-sucesso sucesso-pedido' href='cliente/pedido.jsp'>
                        <p class="p-msg data-pedido">
                            <span>20</span>
                            <br>
                            <span>FEV</span>
                        </p>
                        <p class="p-msg">
                            <span class="nome-restaurante-lista-pedido">Nome do Restaurante</span><br>
                            <span class="descricao-pedido">Lorem ipsum dolor sit amet consectetur adipisicing elit.
                                Officia, reiciendis!</span>
                        </p>
                    </a>
                </div>
                <div class='col-md-6 col-md-offset-3  normalize-grid'>
                    <a class='msg-sucesso sucesso-pedido' href='cliente/pedido.jsp'>
                        <p class="p-msg data-pedido">
                            <span>03</span>
                            <br>
                            <span>JAN</span>
                        </p>
                        <p class="p-msg">
                            <span class="nome-restaurante-lista-pedido">Restaurante do Zé Maria</span><br>
                            <span class="descricao-pedido">Lorem ipsum dolor sit amet consectetur adipisicing elit.
                                Veritatis, reprehenderit voluptatum quas iste voluptate porro!</span>
                        </p>
                    </a>
                </div>
                <div class='col-md-6 col-md-offset-3  normalize-grid'>
                    <a class='msg-sucesso sucesso-pedido' href='cliente/pedido.jsp'>
                        <p class="p-msg data-pedido">
                            <span>20</span>
                            <br>
                            <span>FEV</span>
                        </p>
                        <p class="p-msg">
                            <span class="nome-restaurante-lista-pedido">Pizzaria LPV</span><br>
                            <span class="descricao-pedido">Lorem ipsum dolor sit amet consectetur adipisicing
                                elit.</span>
                        </p>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <script>
        atualizarStateLinkCesta();
    </script>
</body>

</html>