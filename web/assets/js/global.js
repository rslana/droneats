class Cesta {
  constructor(produtos = []) {
    this.produtos = produtos;
  }

  atualizarState() {
    localStorage.setItem("cesta", JSON.stringify(this.produtos));
    inserirConteudo("qtd-produtos-cesta", cesta.quantidadeProdutos());
    if (this.produtos.length === 0)
      localStorage.removeItem("restaurante");
    atualizarCesta();
  }

  adicionarProduto(produto) {
    if (NOVO_RESTAURANTE.id) {
      abrirModal("mensagem-troca-restaurante");
      NOVO_PRODUTO = produto;
    } else {
      this.produtos.push(produto)
    }

    this.atualizarState();
  }

  esvaziarCesta() {
    this.produtos = [];
    this.atualizarState();
  }

  quantidadeProdutos() {
    return this.produtos.length
  }

  removerProduto(id) {
    this.produtos = this.produtos.filter(produto => id != produto);
    this.atualizarState();
    atualizarCesta();
  }

  getQuantidadeProdutos = (produtoId) => {
    const produtosFiltrado = this.produtos.filter(produto => produtoId == produto);
    return produtosFiltrado.length;
  }

  calcularTotal() {
    let precoTotal = 0.0;
    cesta.produtos.forEach(produto => {
      precoTotal += parseFloat(converterPreco(getPrecoProduto(produto).trim(), [",", "."]));
    });
    return precoTotal;
  }
}

const inserirConteudo = (id, conteudo) => {
  document.getElementById(id).innerHTML = conteudo;
}

const produtos = (localStorage.getItem("cesta")) ? JSON.parse(localStorage.getItem("cesta")) : [];
const cesta = new Cesta(produtos);

const getNomeProduto = (produtoId) => {
  const p = document.getElementById(`div-produto${produtoId}`);
  return (p) ? p.getElementsByClassName('nome-produto')[0].innerHTML : null;
}

const getPrecoProduto = (produtoId) => {
  const p = document.getElementById(`div-produto${produtoId}`);
  return (p) ? p.getElementsByClassName('preco-produto')[0].innerHTML : null;
}

const getQuantidadeProduto = (produtoId) => {
  produtosFiltrado = cesta.produtos.filter(produto => produtoId == produto);
  return produtosFiltrado.length;
}

const template = (produtoId) => {
  return `<div class='item-lista-cesta-compra'>
    <p class="p-msg"><b>${getQuantidadeProduto(produtoId)}x</b></p>
    <p class="p-msg">
      <span>${getNomeProduto(produtoId)}</span>
    </p>
    <p class="p-msg p-right">
      <span><b>R$ ${getPrecoProduto(produtoId)}</b></span>
      <span class="remover-produto-cesta" onclick="cesta.removerProduto(${produtoId})"><i
        class="far fa-trash-alt"></i></span>
    </p>
  </div>`;
}

const atualizarCesta = () => {
  let conteudo = "";
  var produtosCesta = removerDuplicados(cesta.produtos);

  produtosCesta.forEach(produto => {
    conteudo += template(produto);
  });

  document.getElementById("cesta-vazia").style.display = (conteudo) ? "none" : "block";
  document.getElementById("restaurante-info-cesta-compra").style.display = (conteudo) ? "block" : "none";
  document.getElementById("btn-finalizar-pedido").disabled = (conteudo) ? false : true;

  inserirConteudo("cesta", conteudo);
  inserirConteudo("preco-total", converterPreco(cesta.calcularTotal().toFixed(2)));

  const restaurante = JSON.parse(localStorage.getItem("restaurante"));
  if (restaurante)
    inserirConteudo("nome-restaurante-cesta-compra", restaurante.nome);

  atualizarStateLinkCesta();
}

/*
* String preco
* String id
* Array divisor [from,to]
*/
const converterPreco = (preco, divisor = [".", ","]) => {
  const re = /^[0-9]{1,}[.,]{0,1}[0-9]{0,}$/;
  if (preco.match(re)) {
    const precoFormatado = preco.replace(...divisor);
    return precoFormatado;
  }
}

const getPrecoFormatado = (preco, id, divisor = [".", ","]) => {
  document.getElementById(id).innerHTML = converterPreco(preco, divisor);
}

const removerDuplicados = (array) => array.filter((item, i) => array.indexOf(item) == i);

let NOVO_RESTAURANTE = {};
const setRestaurante = (id, nome) => {
  const restaurante = (localStorage.getItem("restaurante")) ? JSON.parse(localStorage.getItem("restaurante")) : null;
  if (restaurante && restaurante.id != id) {
    NOVO_RESTAURANTE = { id, nome };
  } else {
    localStorage.setItem("restaurante", JSON.stringify({ id, nome }));
  }
}

const atualizarStateLinkCesta = () => {
  const restaurante = (localStorage.getItem("restaurante")) ? JSON.parse(localStorage.getItem("restaurante")) : null;
  if (restaurante)
    document.getElementById("link-cesta").href = `restaurante/restaurante.jsp?restaurante=${restaurante.id}`;

  if (cesta.produtos.length === 0) document.getElementById("link-cesta").removeAttribute("href");
}

// MODAL

const fecharModal = (id) => {
  document.getElementById(id).style.display = "none";
}

const abrirModal = (id, produto) => {
  document.getElementById(id).style.display = "block";
}

let NOVO_PRODUTO = "";
const esvaziarCestaAdicionarProduto = () => {
  cesta.esvaziarCesta();
  setRestaurante(NOVO_RESTAURANTE.id, NOVO_RESTAURANTE.nome);
  NOVO_RESTAURANTE = {};
  cesta.adicionarProduto(NOVO_PRODUTO);
  fecharModal("mensagem-troca-restaurante");
}