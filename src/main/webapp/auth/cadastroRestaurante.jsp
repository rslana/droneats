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
    <!-- Less -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
    <script src="http://localhost:8080/droneats/assets/js/restaurante.js"></script>
    <%@ include file = "../utils/config.jsp" %>
    <title>Cadastro Restaurante</title>
</head>

<body>
    <div class='corpo-login'>
        <div class='div-centro-cadastro'>
            <div class='titulo-login'>
                <h1><a href='index.jsp' class="droneats">Dron<span>eats</span></a></h1>
            </div>
        </div>
        <%@ include file = "../layout/mensagem.jsp" %> <br>
        <div class='corpo-form form-cadastro form-restaurante'>
            <form action="FrontController?route=restaurante&action=CadastrarRestaurante" method="post">
                <h2>Cadastro de Restaurante</h2>
                <div id="passo1">
                    <h3><i class="fas fa-user"></i><br><br> Sobre o dono do restaurante</h3>
                    <div class='form-input'>
                        <label for='nomeProprietario'>Nome</label><br />
                        <input type="text" name="nomeProprietario" /><br />
                    </div>
                    <div class='form-input form-input-left'>
                        <label for='cpfProprietario'>CPF</label><br />
                        <input type="text" name="cpfProprietario" /><br />
                    </div>
                    <div class='form-input form-input-right'>
                        <label for='telefoneProprietario'>Telefone</label><br />
                        <input type="text" name="telefoneProprietario" /><br />
                    </div>
                    <div class='form-input form-input-left'>
                        <label for='emailProprietario'>E-mail</label><br />
                        <input type="email" name="emailProprietario" /><br />
                    </div>
                    <div class='form-input form-input-right'>
                        <label for='senhaProprietario'>Senha</label>
                        <input type="password" name="senhaProprietario" /><br />
                    </div>
                    <button type="div" class="btn-1" id="btnContinuar"
                        onclick="mudarPassoCadastroRestaurante(2)">Continuar</button>
                </div>

                <div id="passo2">
                    <h3><i class="fas fa-utensils"></i><br><br>Agora sobre o restaurante</h3>
                    <div class='form-input'>
                        <label for='nomeRestaurante'>Nome</label><br />
                        <input type="text" name="nomeRestaurante" /><br />
                    </div>
                    <div class='form-input form-input-left'>
                        <label for='cnpjRestaurante'>CNPJ</label><br />
                        <input type="text" name="cnpjRestaurante" /><br />
                    </div>
                    <div class='form-input form-input-right'>
                        <label for='telefoneRestaurante'>Telefone</label><br />
                        <input type="text" name="telefoneRestaurante" /><br />
                    </div>
                    <div class='form-input form-input-left'>
                        <label for='estadoRestaurante'>Estado</label><br />
                        <input type="text" name="estadoRestaurante" /><br />
                    </div>
                    <div class='form-input form-input-right'>
                        <label for='cidadeRestaurante'>Cidade</label><br />
                        <input type="text" name="cidadeRestaurante" /><br />
                    </div>
                    <div class='form-input form-input-left'>
                        <label for='cepRestaurante'>CEP</label><br />
                        <input type="text" name="cepRestaurante" /><br />
                    </div>
                    <div class='form-input form-input-right'>
                        <label for='bairroRestaurante'>Bairro</label><br />
                        <input type="text" name="bairroRestaurante" /><br />
                    </div>
                    <div class='form-input form-input-left'>
                        <label for='ruaRestaurante'>Rua</label><br />
                        <input type="text" name="ruaRestaurante" /><br />
                    </div>
                    <div class='form-input form-input-right'>
                        <label for='numeroRestaurante'>Número</label><br />
                        <input type="text" name="numeroRestaurante" /><br />
                    </div>
                    <div class='form-input'>
                        <label for='descricaoRestaurante'>Descrição</label><br />
                        <textarea name='descricaoRestaurante' id='' cols='30' rows='5'></textarea><br />
                    </div>
                    <button type="div" class="btn-1" id="btnCadastrar">Finalizar Cadastro</button>
                    <div onclick="mudarPassoCadastroRestaurante(1)" class="btn-voltar">
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