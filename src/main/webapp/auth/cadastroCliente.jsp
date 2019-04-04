<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet/less" type="text/css" href="../assets/css/estilo.less">
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css" href="../assets/fontawesome-free-5.7.2-web/css/all.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
    <%@ include file = "../utils/config.jsp" %>
    <title>Cadastro Cliente</title>
</head>

<body>
    <div class='corpo-login'>
        <div class='div-centro-cadastro'>
            <div class='titulo-login'>
                <h1><a href='index.jsp' class="droneats">Dron<span>eats</span></a></h1>
            </div>
        </div>
        <%@ include file = "../layout/mensagem.jsp" %> <br>
        <div class='corpo-form form-cadastro'>
            <form action="FrontController?route=cliente&action=CadastrarCliente" method="post">
                <h2>Cadastro de Cliente</h2>
                <div class='form-input'>
                    <label for='nome'>Nome</label><br />
                    <input type="text" name="nome" /><br />
                </div>
                <div class='form-input form-input-left'>
                    <label for='cpf'>CPF</label><br />
                    <input type="text" name="cpf" /><br />
                </div>
                <div class='form-input form-input-right'>
                    <label for='telefone'>Telefone</label><br />
                    <input type="text" name="telefone" /><br />
                </div>
                <div class='form-input form-input-left'>
                    <label for='email'>E-mail</label><br />
                    <input type="email" name="email" /><br />
                </div>
                <div class='form-input form-input-right'>
                    <label for='senha'>Senha</label>
                    <input type="password" name="senha" /><br />
                </div>
                <button type="submit" class="btn-1">Cadastrar</button>
            </form>
        </div>
        <div class='rodape-corpo-form'>
            <span>
                Já tem uma conta? <a href='auth/login.jsp'>Entrar</a>
            </span>
        </div>
    </div>
</body>

</html>