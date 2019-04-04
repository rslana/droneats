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
    <%@ include file = "../utils/config.jsp" %>
    <title>Cadastrar Categoria</title>
</head>

<body>
    <%@ include file = "../layout/menu.jsp" %>
    <div class='corpo-home'>
        <div class='container'>
            <div class='row'>
                <div class='col-12 col-md-6 col-md-offset-3 form-crud'>
                    <%@ include file = "../layout/mensagem.jsp" %>
                    <div class='corpo-form'>
                        <form action='FrontController?route=categoria&action=CadastrarCategoria' method="POST">
                            <h2><i class="fas fa-tags"></i></i> &nbsp;Cadastro de Categoria</h2>
                            <c:choose>
                                <c:when test="${mensagem != null}">
                                    <div class='msg-alert-negative'>
                                        <span>
                                            <c:out value="${mensagem}" />
                                        </span>
                                    </div>
                                </c:when>
                            </c:choose>

                            <div class='form-input'>
                                <label for='nome'>Nome</label><br />
                                <input type="text" name="nome" /><br />
                            </div>
                            <button type="submit" class="btn-1">Cadastrar Categoria</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>