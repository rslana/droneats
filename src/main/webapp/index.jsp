<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<script>
    if (window.location.pathname === "/droneats/index.jsp" || window.location.pathname === "/droneats/")
        window.location.replace("FrontController?route=restaurante&action=ListarRestaurantes");
</script>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel='stylesheet' href='assets/bootstrap/css/bootstrap.css'>
    <link rel="stylesheet/less" type="text/css" href="assets/css/estilo.less">
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css" href="assets/fontawesome-free-5.7.2-web/css/all.css">
    <!-- Less -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
    <script src="assets/js/global.js"></script>
    <%@ include file = "utils/config.jsp" %>
    <title>Home</title>
</head>

<body>
    <%@ include file = "layout/menu.jsp" %>
    <div class='corpo-home'>
        <div class='titulo-home'>
            <h1>Restaurantes</h1>
        </div>

        <div class='container'>
            <div class='row lista-restaurantes equal'>
                <c:choose>
                    <c:when test="${restaurantes[0] == null}">
                        <div class='text-center'>
                            <h3>Nenhum Restaurante Cadastrado</h3>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${restaurantes}" var="restaurante">
                            <div class='col-sm-6 col-lg-4 normalize-grid'>
                                <a class='item-lista-restaurantes'
                                    href="FrontController?route=restaurante&action=ExibirRestaurante&id=${restaurante.id}">
                                    <p class="p-icon"><img src='assets/images/store.svg' alt='Logo do Restaurante'
                                            width="48" />
                                    </p>
                                    <p class="p-msg">
                                        <b>
                                            <c:out value="${restaurante.nome}" /></b><br>
                                        <span>
                                            <c:out value="${restaurante.descricao}" /></span>
                                    </p>
                                </a>
                            </div>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
    <script>
        atualizarStateLinkCesta();
    </script>
</body>

</html>