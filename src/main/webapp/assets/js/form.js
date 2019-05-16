const mudarPassoCadastro = (passo) => {
  if (passo === 1) {
    document.getElementById("passo1").style.display = "block";
    document.getElementById("passo2").style.display = "none";
  } else if (passo === 2) {
    document.getElementById("passo1").style.display = "none";
    document.getElementById("passo2").style.display = "block";
  }
}

const changeMetodoPagamento = (metodo) => {
  const inputsMetodoPagamento = document.getElementsByName('radio-metodo-pagamento');
  inputsMetodoPagamento.forEach(input => {
    const label = document.getElementById(`label-${input.id}`);
    label.style.transition = ".5s";
    if (input.id === metodo.id) {
      label.style.border = "solid 1px #F00";
      label.style.background = "rgba(211, 46, 40, 0.1)";
    } else {
      label.style.border = "solid 1px #FFF";
      label.style.background = "#FFF";
    }
  });
  changeTelaMetodoPagamento(metodo);
}

const changeTelaMetodoPagamento = (metodo) => {
  const novoMetodo = `tela-${metodo.id}`
  const telasMetodoPagamento = document.getElementsByClassName('tela-metodo-pagamento');
  const telas = Array.from(telasMetodoPagamento);
  telas.forEach(tela => {
    if (tela.id === novoMetodo)
      tela.classList.add('metodo-ativo');
    else
      tela.classList.remove('metodo-ativo');
  });
}

const formatNomeTitularCartao = input => input.value = input.value.toString().toUpperCase();
const formatNumeroCartao = input => {
  if (isNaN(input.value)) {
    input.value = input.value.substring(0, input.value.length - 1);
  }
}