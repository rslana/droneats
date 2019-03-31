<!-- <%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> -->
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet/less" type="text/css" href="assets/css/estilo.less">
    <link rel="stylesheet/less" type="text/css" href="assets/css/dashboard.less">
    <link rel="stylesheet/less" type="text/css" href="assets/css/menu.less">
    <link rel="stylesheet/less" type="text/css" href="assets/css/home.less">
    <!-- Font Awesome -->
    <link rel="stylesheet/less" type="text/css" href="assets/fontawesome-free-5.7.2-web/css/all.less">
    <title>Home</title>
</head>

<body>
    <nav class='menu'>
        <div class='corpo-menu'>
            <div class="logo">
                <h3><a href='index.jsp' class="droneats">Dron<span>eats</span></a></h3>
            </div>
            <div class='itens-right'>
                <a href='auth/login.jsp' class="menu-item"><i class="fas fa-sign-in-alt"></i>Login</a>
                <a href='auth/cadastro.jsp' class="menu-item"> <i class="far fa-user"></i>Cadastre-se</a>

            </div>
        </div>
    </nav>
    <div class='menu-normalize'></div>
    <div class='corpo-home'>
        <div class='titulo-home'>
            <h1>Restaurantes</h1>
        </div>
        <div class='lista-restaurantes'>
            <a class='item-lista-restaurantes' href="index.jsp">
                <p class="p-icon"><img src='assets/images/store.svg' alt='Logo do Restaurante' width="48px" /></p>
                <p class="p-msg">
                    <b>Nome do Restaurante</b><br>
                    <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis.</span>
                </p>
            </a>
            <a class='item-lista-restaurantes' href="index.jsp">
                <p class="p-icon"><img src='assets/images/store.svg' alt='Logo do Restaurante' width="48px" /></p>
                <p class="p-msg">
                    <b>Nome do Restaurante</b><br>
                    <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis.</span>
                </p>
            </a>
            <a class='item-lista-restaurantes' href="index.jsp">
                <p class="p-icon"><img src='assets/images/store.svg' alt='Logo do Restaurante' width="48px" /></p>
                <p class="p-msg">
                    <b>Nome do Restaurante</b><br>
                    <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis.</span>
                </p>
            </a>
            <a class='item-lista-restaurantes' href="index.jsp">
                <p class="p-icon"><img src='assets/images/store.svg' alt='Logo do Restaurante' width="48px" /></p>
                <p class="p-msg">
                    <b>Nome do Restaurante</b><br>
                    <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis.</span>
                </p>
            </a>
            <a class='item-lista-restaurantes' href="index.jsp">
                <p class="p-icon"><img src='assets/images/store.svg' alt='Logo do Restaurante' width="48px" /></p>
                <p class="p-msg">
                    <b>Nome do Restaurante</b><br>
                    <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam, omnis.</span>
                </p>
            </a>

        </div>
    </div>
</body>

</html>