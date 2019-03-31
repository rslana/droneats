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
    <title>Perfil</title>
</head>

<body>
    <%@ include file = "../layout/menu.jsp" %>
    <div class='corpo-usuario'>
        <div class='container'>
            <div class='row'>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <h2 class="pedido-titulo">Perfil</h2>
                </div>
                <div class='col-md-6 col-md-offset-3 normalize-grid'>
                    <div class='detalhe-pedido detalhe-perfil'>
                        <div class='col-md-6 normalize-grid'>
                            <p>
                                <b>Nome</b><br>
                                João Maria da Silva
                            </p>
                            <p>
                                <b>CPF</b><br>
                                123******00
                            </p>
                            <p>
                                <b>Telefone</b><br>
                                (32) 99999-8888
                            </p>
                            <p>
                                <b>E-mail</b><br>
                                joaomaria@email.com
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        atualizarStateLinkCesta();
    </script>
</body>

</html>