<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet/less" type="text/css" href="http://localhost:8080/droneats/assets/css/estilo.less">
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css"
        href="http://localhost:8080/droneats/assets/fontawesome-free-5.7.2-web/css/all.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
    <script src="http://localhost:8080/droneats/assets/js/form.js"></script>
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
                <div id='passo1'>
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
                    <button type="submit" class="btn-1" id="btnContinuar"
                        onclick="mudarPassoCadastro(2)">Próximo</button>
                </div>
                <div id="passo2">
                    <h3><i class="fas fa-utensils"></i><br><br>Seu endereço principal</h3>
                    <div class='form-input form-input-left'>
                        <label for='estado'>Estado</label><br />
                        <input type="text" name="estado" /><br />
                    </div>
                    <div class='form-input form-input-right'>
                        <label for='cidade'>Cidade</label><br />
                        <input type="text" name="cidade" /><br />
                    </div>
                    <div class='form-input form-input-left'>
                        <label for='cep'>CEP</label><br />
                        <input type="text" name="cep" /><br />
                    </div>
                    <div class='form-input form-input-right'>
                        <label for='bairro'>Bairro</label><br />
                        <input type="text" name="bairro" /><br />
                    </div>
                    <div class='form-input form-input-left'>
                        <label for='rua'>Rua</label><br />
                        <input type="text" name="rua" /><br />
                    </div>
                    <div class='form-input form-input-right'>
                        <label for='numero'>Número</label><br />
                        <input type="text" name="numero" /><br />
                    </div>
                    <button type="div" class="btn-1" id="btnCadastrar">Finalizar Cadastro</button>
                    <div onclick="mudarPassoCadastro(1)" class="btn-voltar">
                        <i class="fas fa-arrow-left"></i> Voltar
                    </div>
                </div>
            </form>
        </div>
        <div class='rodape-corpo-form'>
            <span>
                Já tem uma conta? <a href='auth/login.jsp'>Entrar</a>
            </span>
        </div>
    </div>
    <script>
        document.getElementById("btnContinuar").addEventListener("click", function (event) {
            event.preventDefault()
        });
    </script>
</body>

</html>