class Cesta {
  constructor(produtos = []) {
    this.produtos = produtos;
  }

  atualizarState() {
    localStorage.setItem("cesta", JSON.stringify(this.produtos));
    inserirConteudo("qtd-produtos-cesta", cesta.quantidadeProdutos());
    // if (this.produtos.length === 0)
    // localStorage.removeItem("restaurante");
    atualizarCesta();
  }

  adicionarProduto(id, nome, preco) {
    const produto = { id, nome, preco, quantidade: 1 };
    if (NOVO_RESTAURANTE.id) {
      NOVO_PRODUTO = produto;
      if (cesta.produtos < 1) {
        esvaziarCestaAdicionarProduto();
      } else {
        abrirModal("mensagem-troca-restaurante");
      }
    } else {
      if (this.produtos.some(e => e.id === produto.id)) {
        this.produtos = this.produtos.map(p => (p.id === produto.id) ? { ...p, quantidade: p.quantidade + 1 } : p)
      } else {
        this.produtos.push(produto)
      }
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
    this.produtos = this.produtos.filter(produto => produto.id != id);
    this.atualizarState();
    atualizarCesta();
  }

  calcularTotal() {
    let precoTotal = 0.0;
    cesta.produtos.forEach(produto => {
      precoTotal += parseFloat(converterPreco((parseFloat(produto.preco) * produto.quantidade).toFixed(2), [",", "."]));
    });
    return precoTotal;
  }
}

const inserirConteudo = (id, conteudo) => {
  if (document.getElementById(id) !== null)
    document.getElementById(id).innerHTML = conteudo;
}

const produtos = (localStorage.getItem("cesta")) ? JSON.parse(localStorage.getItem("cesta")) : [];
const cesta = new Cesta(produtos);

const template = (produto) => {
  return `<div class='item-lista-cesta-compra'>
    <p class="p-msg"><b>${produto.quantidade}x</b></p>
    <p class="p-msg">
      <span>${produto.nome}</span>
    </p>
    <p class="p-msg p-right">
      <span><b>R$ ${converterPreco(parseFloat(produto.preco).toFixed(2))}</b></span>
      <span class="remover-produto-cesta" onclick="cesta.removerProduto(${produto.id})"><i
        class="far fa-trash-alt"></i></span>
    </p>
  </div>`;
}

const atualizarCesta = () => {
  let conteudo = "";

  cesta.produtos.forEach(produto => {
    conteudo += template(produto);
  });

  if (document.getElementById("cesta-vazia") !== null) {
    document.getElementById("cesta-vazia").style.display = (conteudo) ? "none" : "block";
    document.getElementById("restaurante-info-cesta-compra").style.display = (conteudo) ? "block" : "none";
    document.getElementById("btn-finalizar-pedido").disabled = (conteudo) ? false : true;

    inserirConteudo("cesta", conteudo);
    inserirConteudo("preco-total", converterPreco(cesta.calcularTotal().toFixed(2)));
  }

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
  preco = preco + "";
  const re = /^[0-9]{1,}[.,]{0,1}[0-9]{0,}$/;
  if (preco.match(re)) {
    const precoFormatado = preco.replace(...divisor);
    return precoFormatado;
  }
  return "00,00";
}

/*
* String preco
* String desconto (ex: 10 representa 10% de desconto)
*/
const getPrecoDesconto = (preco, id, desconto) => {
  preco = parseFloat(converterPreco(preco, [",", "."]));
  desconto = parseFloat(converterPreco(desconto, [",", "."]));

  document.getElementById(id).innerHTML = converterPreco((preco - preco * desconto / 100).toFixed(2));
}

const getPrecoFormatado = (preco, id, divisor = [".", ","]) => {
  document.getElementById(id).innerHTML = converterPreco(parseFloat(preco).toFixed(2), divisor);
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
  if (restaurante && document.getElementById("link-cesta"))
    document.getElementById("link-cesta").href = `FrontController?route=restaurante&action=ExibirRestaurante&id=${restaurante.id}`;

  if (cesta.produtos.length === 0 && document.getElementById("link-cesta"))
    document.getElementById("link-cesta").removeAttribute("href");
}

// MODAL

const fecharModal = (id) => {
  document.getElementById(id).style.display = "none";
}

const abrirModal = (id) => {
  document.getElementById(id).style.display = "block";
}

let NOVO_PRODUTO = "";
const esvaziarCestaAdicionarProduto = () => {
  cesta.esvaziarCesta();
  localStorage.removeItem("restaurante");
  setRestaurante(NOVO_RESTAURANTE.id, NOVO_RESTAURANTE.nome);
  NOVO_RESTAURANTE = {};
  cesta.adicionarProduto(NOVO_PRODUTO.id, NOVO_PRODUTO.nome, NOVO_PRODUTO.preco);
  fecharModal("mensagem-troca-restaurante");
}

// DATA

/*
* String date (dd/mm/aaaa)
*/
const getNumberMonth = (date) => {
  const date_array = date.split("/");
  return parseInt(date_array[1]) - 1;
}

const getNumberDay = (date) => {
  const date_array = date.split("/");
  return parseInt(date_array[0]);
}

const calendar = [
  { short_month: "JAN", month: "Janeiro" },
  { short_month: "FEV", month: "Fevereiro" },
  { short_month: "MAR", month: "Março" },
  { short_month: "ABR", month: "Abril" },
  { short_month: "MAI", month: "Maio" },
  { short_month: "JUN", month: "Junho" },
  { short_month: "JUL", month: "Julho" },
  { short_month: "AGO", month: "Agosto" },
  { short_month: "SET", month: "Setembro" },
  { short_month: "OUT", month: "Outubro" },
  { short_month: "NOV", month: "Novembro" },
  { short_month: "DEZ", month: "Dezembro" },
]

const getShortMonth = (date) => {
  return calendar[getNumberMonth(date)].short_month;
}

const getMonth = (date) => {
  return calendar[getNumberMonth(date)].short_month;
}

const getDescricaoFormatada = (descricao, id) => {
  if (descricao.length > 120) {
    document.getElementById(id).innerHTML = descricao.substring(0, 120) + "...";
  } else {
    document.getElementById(id).innerHTML = descricao;
  }
}

const apagarMensagem = (id) => {
  if (document.getElementById(id) !== null) {
    setTimeout(() => {
      document.getElementById(id).style.transition = '1.5s';
      document.getElementById(id).style.opacity = 0;
    }, 4000);
    setTimeout(() => {
      document.getElementById(id).style.display = 'none';
    }, 5500);
  }
}