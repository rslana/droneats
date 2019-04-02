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
    <title>Cadastrar Produto</title>
</head>

<body>
    <%@ include file = "../layout/menu.jsp" %>
    <div class='corpo-home'>
        <div class='container'>
            <div class='row'>
                <div class='col-12 col-md-8 col-md-offset-2 form-crud'>
                    <div class='corpo-form'>
                        <form action='FrontController?route=produto&action=CadastrarProduto' method="POST"
                            enctype="multipart/form-data" id="formCadastroProduto">
                            <h2><i class="fas fa-utensils"></i> &nbsp;Cadastro de Produto</h2>
                            <c:choose>
                                <c:when test="${mensagem != null}">
                                    <div class='msg-alert-negative'>
                                        <span>
                                            <c:out value="${mensagem}" />
                                        </span>
                                    </div>
                                </c:when>
                            </c:choose>
                            <div class='form-input form-input-left'>
                                <label for='cpf'>Nome</label><br />
                                <input type="text" name="nome" /><br />
                            </div>
                            <div class='form-input form-input-right'>
                                <label for='preco'>Preço</label><br />
                                <input type="number" name="preco" min="0" max="999" step="0.01" /><br />
                            </div>
                            <div class='form-input'>
                                <label for='descricao'>Descrição</label><br />
                                <textarea name='descricao' cols='30' rows='3'></textarea><br />
                            </div>
                            <div class='form-input form-input-left'>
                                <label for='imagem'>Imagem</label><br />
                                <input type="file" name="imagem" /><br />
                            </div>
                            <div class='form-input form-input-right'>
                                <label for='categoriaId'>Categoria</label><br>
                                <select name="categoriaId" required <c:if test="${operacao == 'Excluir'}"> disabled
                                    </c:if>>
                                    <c:forEach items="${categorias}" var="categoria">
                                        <option value="${categoria.id}">
                                            <c:out value="${categoria.nome}" />
                                        </option>
                                    </c:forEach>
                                    <option value="1${categoria.id}">
                                        Combo Grande
                                    </option>
                                    <option value="2${categoria.id}">
                                        Combo Médio
                                    </option>
                                    <option value="3${categoria.id}">
                                        Sanduíches com bife de hamburguer
                                    </option>
                                </select>
                            </div>
                            <button type="submit" class="btn-1" id="btnCadastrar"
                                onclick="submitWithLoading(this,'formCadastroProduto')">Cadastrar Produto</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        document.getElementById("btnCadastrar").addEventListener("click", function (event) {
            event.preventDefault()
        });
    </script>
</body>

</html>