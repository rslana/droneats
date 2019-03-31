const mudarPassoCadastroRestaurante = (passo) => {
  if (passo === 1) {
    document.getElementById("passo1").style.display = "block";
    document.getElementById("passo2").style.display = "none";
  } else if (passo === 2) {
    document.getElementById("passo1").style.display = "none";
    document.getElementById("passo2").style.display = "block";
  }
}

