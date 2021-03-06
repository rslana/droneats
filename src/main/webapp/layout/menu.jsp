<nav class='menu'>
  <div class='corpo-menu'>
    <div class="logo">
      <h3><a href='index.jsp' class="droneats">Dron<span>eats</span></a></h3>
    </div>
    <c:choose>
      <c:when test="${permissao == 'Cliente'}">
        <div class='itens-right'>
          <a href='cliente/perfil.jsp' class="menu-item"><i class="far fa-user"></i>
            <script>
              document.write(getPrimeiroNome('${usuario.nome}'))
            </script>
          </a>
          <a href='FrontController?route=cliente&action=ListarPedidos' class="menu-item"><i
              class="fas fa-parachute-box"></i>Pedidos</a>
          <a class="menu-item" id="link-cesta">
            <i class="fas fa-shopping-basket"></i>Cesta
            <span class="qtd-item-cesta" id="qtd-produtos-cesta">
              <script>
                inserirConteudo("qtd-produtos-cesta", cesta.quantidadeProdutos())
              </script>
            </span>
          </a>
          <a href='FrontController?route=usuario&action=Logout' class="menu-item"><i
              class="fas fa-sign-out-alt"></i>Sair</a>
        </div>
      </c:when>
      <c:when test="${permissao == 'Proprietario'}">
        <div class='itens-right'>
          <a href='restaurante/perfil.jsp' class="menu-item"><i class="fas fa-store-alt"></i>Perfil</a>
          <a href='FrontController?route=restaurante&action=ListarPedidos' class="menu-item"><i
              class="fas fa-parachute-box"></i>Pedidos</a>
          <a href='FrontController?route=produto&action=ListarProdutos' class="menu-item"><i
              class="fas fa-utensils"></i>Produtos</a>
          <a href='FrontController?route=categoria&action=ListarCategorias' class="menu-item"><i
              class="fas fa-tags"></i></i>Categorias</a>
          <a href='FrontController?route=usuario&action=Logout' class="menu-item"><i
              class="fas fa-sign-out-alt"></i>Sair</a>
        </div>
      </c:when>
      <c:otherwise>
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
      </c:otherwise>
    </c:choose>
  </div>
</nav>
<div class='menu-normalize'></div>