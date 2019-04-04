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
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css" href="../assets/fontawesome-free-5.7.2-web/css/all.css">
    <!-- Less -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
    <script src="../assets/js/global.js"></script>
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
                        <form action='FrontController?route=restaurante&action=CadastrarProduto' method="POST">
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
                                <label for='nome'>Preço</label><br />
                                <input type="number" name="preco" /><br />
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
                                    <option value="${categoria.id}">
                                        Combo Grande
                                    </option>
                                    <option value="${categoria.id}">
                                        Combo Médio
                                    </option>
                                    <option value="${categoria.id}">
                                        Sanduíches com bife de hamburguer
                                    </option>
                                </select>
                            </div>
                            <button type="submit" class="btn-1">Cadastrar Produto</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>