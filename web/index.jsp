<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
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
    <base href="http://localhost:8080/Droneats/">
    <title>Home</title>
</head>

<body>
    <%@ include file = "layout/menu.jsp" %>
    <div class='corpo-home'>
        <div class='titulo-home'>
            <h1>Restaurantes</h1>
        </div>

        <div class='container'>
            <div class='row lista-restaurantes'>
                <div class='col-12 col-md-6 col-lg-4 normalize-grid'>
                    <a class='item-lista-restaurantes' href="restaurante/restaurante.jsp">
                        <p class="p-icon"><img src='assets/images/store.svg' alt='Logo do Restaurante' width="48" />
                        </p>
                        <p class="p-msg">
                            <b>Nome do Restaurante</b><br>
                            <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis.</span>
                        </p>
                    </a>
                </div>
                <div class='col-12 col-md-6 col-lg-4 normalize-grid'>
                    <a class='item-lista-restaurantes' href="restaurante/restaurante.jsp">
                        <p class="p-icon"><img src='assets/images/store.svg' alt='Logo do Restaurante' width="48" />
                        </p>
                        <p class="p-msg">
                            <b>Nome do Restaurante</b><br>
                            <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis.</span>
                        </p>
                    </a>
                </div>
                <div class='col-12 col-md-6 col-lg-4 normalize-grid'>
                    <a class='item-lista-restaurantes' href="restaurante/restaurante.jsp">
                        <p class="p-icon"><img src='assets/images/store.svg' alt='Logo do Restaurante' width="48" />
                        </p>
                        <p class="p-msg">
                            <b>Nome do Restaurante</b><br>
                            <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis.</span>
                        </p>
                    </a>
                </div>
                <div class='col-12 col-md-6 col-lg-4 normalize-grid'>
                    <a class='item-lista-restaurantes' href="restaurante/restaurante.jsp">
                        <p class="p-icon"><img src='assets/images/store.svg' alt='Logo do Restaurante' width="48" />
                        </p>
                        <p class="p-msg">
                            <b>Nome do Restaurante</b><br>
                            <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis. </span>
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