/**
* sends a request to the specified url from a form. this will change the window location.
* @param {string} path the path to send the post request to
* @param {object} params the paramiters to add to the url
* @param {string} [method=post] the method to use on the form
*/
const post = (path, params, method = "post") => {
  // The rest of this code assumes you are not using a library.
  // It can be made less wordy if you use one.
  const form = document.createElement("form");
  form.setAttribute("method", method);
  form.setAttribute("action", path);

  const hiddenProdutos = document.createElement("input");
  hiddenProdutos.setAttribute("type", "hidden");
  hiddenProdutos.setAttribute("name", "produtos");
  hiddenProdutos.setAttribute("value", JSON.parse(localStorage.getItem('cesta')));

  const restaurante = JSON.parse(localStorage.getItem('restaurante'));

  const json = JSON.stringify(restaurante);
  const blob = new Blob([json], {
    type: 'application/json'
  });

  const hiddenRestaurante = document.createElement("input");
  hiddenRestaurante.setAttribute("type", "hidden");
  hiddenRestaurante.setAttribute("name", "restaurante");
  hiddenRestaurante.setAttribute("value", `{restaurante: "1", produtos: [{1:3,2:5,4:2}]}`);


  const novoArray = removerDuplicados(JSON.parse(localStorage.getItem('cesta')));

  const produtos = novoArray.map(produto => {
    return { id: produto, quantidade: cesta.getQuantidadeProdutos(produto) }
  })

  const pedido = {
    restaurante: restaurante.id,
    produtos
  }

  console.log(pedido)

  const hiddenPedido = document.createElement("input");
  hiddenPedido.setAttribute("type", "hidden");
  hiddenPedido.setAttribute("name", "pedido");
  hiddenPedido.setAttribute("value", JSON.stringify(pedido));

  form.append("document", blob);
  form.appendChild(hiddenProdutos);
  form.appendChild(hiddenRestaurante);
  form.appendChild(hiddenPedido);

  document.body.appendChild(form);
  form.submit();
}

const finalizarPedido = () => {
  post('FrontController?route=pedido&action=CadastrarPedido');
}


/**
* sets the button to a loading state of a form.
* @param {string} btn the button object to disabled
* @param {object} formId the form id that will be submitted
*/

const submitWithLoading = (btn, formId) => {
  const form = document.getElementById(formId);

  btn.disabled = true;
  btn.innerHTML = `<i class="fas fa-spinner fa-spin"></i> &nbsp;Cadastrando Produto`;

  form.submit();
}