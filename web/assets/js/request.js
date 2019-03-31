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
  console.log(restaurante);
  const hiddenRestaurante = document.createElement("input");
  hiddenRestaurante.setAttribute("type", "hidden");
  hiddenRestaurante.setAttribute("name", "restaurante");
  hiddenRestaurante.setAttribute("value", restaurante.id);

  form.appendChild(hiddenProdutos);
  form.appendChild(hiddenRestaurante);

  document.body.appendChild(form);
  form.submit();
}

const finalizarPedido = () => {
  post('ProdutoController');
}
