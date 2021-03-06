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
    <title>Pedidos</title>
</head>

<body>
    <%@ include file = "../layout/menu.jsp" %>
    <div class='corpo-usuario'>
        <div class='container'>
            <div class='row'>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <h2 class="pedido-titulo">Pedidos</h2>
                </div>
                <c:forEach items="${pedidos}" var="pedido">
                    <div class='col-md-6 col-md-offset-3 normalize-grid'>
                        <a class='msg-sucesso sucesso-pedido'
                            href='FrontController?route=pedido&action=PrepararAlterarPedido&id=${pedido.id}'>
                            <p class="p-msg data-pedido">
                                <span>
                                    <script>
                                        document.write(getNumberDay('${pedido.dataPedido}'))
                                    </script>
                                </span>
                                <br>
                                <span>
                                    <script>
                                        document.write(getShortMonth('${pedido.dataPedido}'))
                                    </script>
                                </span>
                            </p>
                            <p class="p-msg">
                                <span class="nome-restaurante-lista-pedido">
                                    ${pedido.estado.estado}
                                </span><br>
                                <span class="descricao-pedido">
                                    <c:forEach items="${pedido.produtos}" var="produto">
                                        ${produto.quantidade}x ${produto.produto.nome} •
                                    </c:forEach>
                                </span>
                            </p>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>

</html>