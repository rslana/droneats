<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel='stylesheet' href="http://localhost:8080/droneats/assets/bootstrap/css/bootstrap.css">
    <link rel="stylesheet/less" type="text/css" href="http://localhost:8080/droneats/assets/css/estilo.less">
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css"
        href="http://localhost:8080/droneats/assets/fontawesome-free-5.7.2-web/css/all.css">
    <!-- Less -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
    <script src="http://localhost:8080/droneats/assets/js/global.js"></script>
    <script src="http://localhost:8080/droneats/assets/js/form.js"></script>
    <script src="http://localhost:8080/droneats/assets/js/request.js"></script>
    <%@ include file = "../utils/config.jsp" %>
    <title>Finalizar Pedido</title>
</head>

<!-- Pegar ID e NOME do restaurante -->

<body onload="setRestaurante(`${restaurante.id}`,`${restaurante.nome}`)">
    <%@ include file = "../layout/menu.jsp" %>
    <div class='corpo-restaurante'>
        <div class='titulo-restaurante'>
            <h2>${restaurante.nome}</h2>
            <p>${restaurante.descricao}</p>
        </div>

        <div class='container' style="width: 90%">
            <div class='row'>
                <div class='corpo-form form-pagamento corpo-metodo-pagamento'>
                    <h2>Método de Pagamento</h2>
                    <div class='row'>
                        <div class='col-md-6 col-lg-3 normalize-grid'>
                            <label class='item-lista-restaurantes metodo-pagamento' for="cartao-credito"
                                id="label-cartao-credito">
                                <p class="p-icon">
                                    <img src='assets/images/credit-card.png' alt='Cartão de crédito' width="42" />
                                </p>
                                <p class="p-msg">
                                    Crédito
                                </p>
                            </label>
                            <input type='radio' id="cartao-credito" name="radio-metodo-pagamento" class="input-hidden"
                                onchange="changeMetodoPagamento(this)" value="cartao-credito" />
                        </div>
                        <div class='col-md-6 col-lg-3 normalize-grid'>
                            <label class='item-lista-restaurantes metodo-pagamento' for="cartao-debito"
                                id="label-cartao-debito">
                                <p class="p-icon">
                                    <img src='assets/images/debit-card.png' alt='Cartão de débito' width="42" />
                                </p>
                                <p class="p-msg">
                                    Débito
                                </p>
                            </label>
                            <input type='radio' id="cartao-debito" name="radio-metodo-pagamento" class="input-hidden"
                                onchange="changeMetodoPagamento(this)" value="cartao-debito" />
                        </div>
                        <div class='col-md-6 col-lg-3 normalize-grid'>
                            <label class='item-lista-restaurantes metodo-pagamento' for="boleto" id="label-boleto">
                                <p class="p-icon">
                                    <img src='assets/images/barcode.png' alt='Boleto' width="42" />
                                </p>
                                <p class="p-msg">
                                    Boleto
                                </p>
                            </label>
                            <input type='radio' id="boleto" name="radio-metodo-pagamento" class="input-hidden"
                                onchange="changeMetodoPagamento(this)" value="boleto" />
                        </div>
                        <div class='col-md-6 col-lg-3 normalize-grid'>
                            <label class='item-lista-restaurantes metodo-pagamento' for="paypal" id="label-paypal">
                                <p class="p-icon">
                                    <img src='assets/images/paypal.png' alt='Paypal' width="42" />
                                </p>
                                <p class="p-msg">
                                    Paypal
                                </p>
                            </label>
                            <input type='radio' id="paypal" name="radio-metodo-pagamento" class="input-hidden"
                                onchange="changeMetodoPagamento(this)" value="paypal" />
                        </div>
                    </div>
                    <div class='telas-metodo-pagamento'>
                        <div class='tela-metodo-pagamento metodo-ativo'>
                            <h4>Selecione um método de pagamento</h4>
                        </div>
                        <div class="tela-metodo-pagamento" id='tela-cartao-credito'>
                            <form id="form-cartao-credito">
                                <input type='hidden' name="metodo-pagamento" value="CartaoCredito" />
                                <div class='form-input'>
                                    <label for='numero-cartao-credito'>Número do cartão</label><br />
                                    <input type="text" name="numero-cartao-credito"
                                        oninput="formatNumeroCartao(this)" /><br />
                                </div>
                                <div class='form-input'>
                                    <label for='nome-titular-cartao-credito'>Nome do títular</label><br />
                                    <input type="text" name="nome-titular-cartao-credito"
                                        oninput="formatNomeTitularCartao(this)" /><br />
                                </div>
                                <div class='form-input form-input-left'>
                                    <label for='vencimento-cartao-credito'>Vencimento</label><br />
                                    <input type="text" name="vencimento-cartao-credito" /><br />
                                </div>
                                <div class='form-input form-input-right'>
                                    <label for='cvv-cartao-credito'>CVV</label><br />
                                    <input type="text" name="cvv-cartao-credito" /><br />
                                </div>
                                <button class="btn-1 btn-filanizar-pedido" id="btn-submit-cartao-credito"
                                    onclick="finalizarPedido()">Finalizar
                                    Pedido com Cartão de Crédito</button>
                            </form>
                        </div>

                        <div class="tela-metodo-pagamento" id='tela-cartao-debito'>
                            <form id="form-cartao-debito">
                                <div class='form-input'>
                                    <label for='numero-cartao-debito'>Número do cartão</label><br />
                                    <input type="text" name="numero-cartao-debito" /><br />
                                </div>
                                <div class='form-input'>
                                    <label for='nome-titular-cartao-debito'>Nome do títular</label><br />
                                    <input type="text" name="nome-titular-cartao-debito"
                                        oninput="formatNomeTitularCartao(this)" /><br />
                                </div>
                                <div class='form-input form-input-left'>
                                    <label for='vencimento-cartao-debito'>Vencimento</label><br />
                                    <input type="text" name="vencimento-cartao-debito" /><br />
                                </div>
                                <div class='form-input form-input-right'>
                                    <label for='cvv-cartao-debito'>CVV</label><br />
                                    <input type="text" name="cvv-cartao-debito" /><br />
                                </div>
                                <button class="btn-1 btn-filanizar-pedido" id="btn-submit-cartao-debito"
                                    onclick="finalizarPedido()">Finalizar
                                    Pedido com Cartão de Débito</button>
                            </form>
                        </div>

                        <div class="tela-metodo-pagamento" id='tela-boleto'>
                            <form id="form-boleto">
                                <h4>
                                    <img src='assets/images/barcode.png' alt='Boleto' width="128" />
                                    <br />
                                    Você terá 3 dias para pagar o boleto
                                </h4>
                                <button class="btn-1 btn-filanizar-pedido" id="btn-submit-boleto"
                                    onclick="finalizarPedido()">Finalizar
                                    Pedido com Boleto</button>
                            </form>
                        </div>

                        <div class="tela-metodo-pagamento" id='tela-paypal'>
                            <form id="form-paypal">
                                <h4>
                                    <img src='assets/images/paypal.png' alt='Paypal' width="84" />
                                    <br /><br />
                                    <i class="fas fa-shield-alt"></i> Você será redirecionado para o site do
                                    Paypal para confirmar sua conta
                                </h4>
                                <button class="btn-1 btn-filanizar-pedido" id="btn-submit-paypal"
                                    onclick="finalizarPedido()">Finalizar
                                    Pedido com Paypal</button>
                            </form>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class='cesta-compra'>
        <script>
            cesta.readOnly = true;
        </script>
        <form action='FrontController?route=pedido&action=CadastrarPedido' method="POST" id="formFinalizarPedido">
            <div class='corpo-cesta-compra'>
                <div id="restaurante-info-cesta-compra">
                    <h4>Pedido</h4>
                    <h3 id="nome-restaurante-cesta-compra"></h3>
                    <hr>
                </div>
                <div id="cesta-vazia" class="cesta-vazia">
                    <i class="fas fa-shopping-basket fa-4x"></i>
                    <br><br><br>
                    Sua cesta está vazia
                </div>
                <c:choose>
                    <c:when test="${error != null}">
                        <div class='item-lista-cesta-compra msg-erro' id="mensagemErro">
                            <p class="p-msg">&nbsp;&nbsp;${error}</p>
                        </div>
                        <script>
                            cesta.esvaziarCesta();
                        </script>
                    </c:when>
                </c:choose>
                <div id="cesta"></div>
                <hr>
                <div class='item-lista-cesta-compra'>
                    <p class="p-msg"><b>Total</b></p>
                    <p class="p-msg p-right">
                        <span>
                            <b>
                                R$
                                <span class="preco-produto" id="preco-total">
                                    0,00
                                </span>
                            </b>
                        </span>
                    </p>
                </div>
            </div>
            <!-- <button class="btn-1 btn-filanizar-pedido" id="btnFinalizarPedido" onclick="finalizarPedido()">Finalizar
                Pedido</button> -->
        </form>
    </div>
    <div class='mensagem-troca-restaurante' id="mensagem-troca-restaurante" style="display: none">
        <div class='bg-mensagem-troca-restaurante'></div>
        <div class='item-mensagem'>
            <h2>Você só pode adicionar itens de um restaurante por vez</h2>
            <p>Deseja esvaziar a cesta e adicionar este item?</p>
            <br>
            <button class="btn-1" onclick="esvaziarCestaAdicionarProduto()">Esvaziar cesta e adicionar</button>
            <button class="btn-1-secondary" onclick="fecharModal('mensagem-troca-restaurante')">Cancelar</button>
        </div>
    </div>
    <script src="assets/js/state.js"></script>
    <script>
        const buttons = Array.from(document.getElementsByClassName("btn-filanizar-pedido"));
        buttons.forEach(btn => {
            btn.addEventListener("click", function (event) {
                event.preventDefault()
            });
        });
        apagarMensagem('mensagemErro');
    </script>
</body>

</html>