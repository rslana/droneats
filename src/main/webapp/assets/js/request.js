/**
* sends a request to the specified url from a form. this will change the window location.
* @param {string} path the path to send the post request to
* @param {object} params the paramiters to add to the url
* @param {string} [method=post] the method to use on the form
*/
const post = (path, params, method = "post") => {
  // const form = document.createElement("form");

  const metodosPagamento = Array.from(document.getElementsByName('radio-metodo-pagamento'));
  const metodo = metodosPagamento.filter(input => input.checked);
  const form = document.getElementById(`form-${metodo[0].id}`);

  form.setAttribute("method", method);
  form.setAttribute("action", path);

  const restaurante = JSON.parse(localStorage.getItem('restaurante'));
  const produtos = JSON.parse(localStorage.getItem('cesta'));

  const pedido = {
    restaurante: restaurante.id,
    produtos
  }

  const hiddenPedido = document.createElement("input");
  hiddenPedido.setAttribute("type", "hidden");
  hiddenPedido.setAttribute("name", "pedido");
  hiddenPedido.setAttribute("value", JSON.stringify(pedido));

  form.appendChild(hiddenPedido);
  console.log(form)
  submitWithLoading(document.getElementById(`btn-submit-${metodo[0].id}`), form.id)
  // document.body.appendChild(form);
  // form.submit();
}

const finalizarPedido = () => {
  // document.getElementById('btnFinalizarPedido').disabled = true;
  // document.getElementById('btnFinalizarPedido').innerHTML = `<i class="fas fa-spinner fa-spin"></i>`;
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
  btn.innerHTML = `<i class="fas fa-spinner fa-spin"></i>`;

  form.submit();
}