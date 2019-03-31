<nav class='menu'>
  <div class='corpo-menu'>
    <div class="logo">
      <h3><a href='index.jsp' class="droneats">Dron<span>eats</span></a></h3>
    </div>
    <div class='itens-right'>
      <a href='auth/login.jsp' class="menu-item"><i class="fas fa-sign-in-alt"></i>Login</a>
      <a href='auth/cadastro.jsp' class="menu-item"> <i class="far fa-user"></i>Cadastre-se</a>
      <a class="menu-item" id="link-cesta">
        <i class="fas fa-shopping-basket"></i>Cesta
        <span class="qtd-item-cesta" id="qtd-produtos-cesta">
          <script>
            inserirConteudo("qtd-produtos-cesta", cesta.quantidadeProdutos())
          </script>
        </span>
      </a>
    </div>
  </div>
</nav>
<div class='menu-normalize'></div>