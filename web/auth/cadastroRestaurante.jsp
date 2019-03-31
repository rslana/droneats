<!-- <%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> -->
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet/less" type="text/css" href="../assets/css/estilo.less">
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css" href="../assets/fontawesome-free-5.7.2-web/css/all.css">
    <!-- Less -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
    <script src="../assets/js/restaurante.js"></script>
    <base href="http://localhost:8080/Droneats/">
    <title>Cadastro Restaurante</title>
</head>

<body>
    <div class='corpo-login'>
        <div class='div-centro-cadastro'>
            <div class='titulo-login'>
                <h1><a href='index.jsp' class="droneats">Dron<span>eats</span></a></h1>
            </div>
        </div>
        <div class='form-login form-cadastro form-restaurante'>
            <form action="FrontController?action=Cadastrar" method="post">
                <h2>Cadastro de Restaurante</h2>
                <div id="passo1">
                    <h3><i class="fas fa-user"></i><br><br> Sobre o dono do restaurante</h3>
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
                    <button type="div" class="btn-1" id="btnContinuar"
                        onclick="mudarPassoCadastroRestaurante(2)">Continuar</button>
                </div>

                <div id="passo2">
                    <h3><i class="fas fa-utensils"></i><br><br>Agora sobre o restaurante</h3>
                    <div class='form-input'>
                        <label for='nome'>Nome</label><br />
                        <input type="text" name="nome" /><br />
                    </div>
                    <div class='form-input form-input-left'>
                        <label for='cpf'>CNPJ</label><br />
                        <input type="text" name="cpf" /><br />
                    </div>
                    <div class='form-input form-input-right'>
                        <label for='telefone'>Telefone</label><br />
                        <input type="text" name="telefone" /><br />
                    </div>
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
                    <div class='form-input'>
                        <label for='descricao'>Descrição</label><br />
                        <textarea name='descricao' id='' cols='30' rows='5'></textarea><br />
                    </div>
                    <button type="div" class="btn-1" id="btnCadastrar">Finalizar Cadastro</button>
                    <div onclick="mudarPassoCadastroRestaurante(1)" class="btn-voltar">
                        <i class="fas fa-arrow-left"></i> Voltar
                    </div>
                </div>
            </form>
        </div>
        <div class='rodape-form-login'>
            <span>
                Já tem uma conta? <a href='auth/login.jsp'>Entrar</a>
            </span>
        </div>
    </div>
</body>
<script>
    document.getElementById("btnContinuar").addEventListener("click", function (event) {
        event.preventDefault()
    });
</script>

</html>