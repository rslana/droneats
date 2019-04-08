<c:choose>
  <c:when test="${mensagemSucesso != null}">
    <div class='msg msg-sucesso'>
      <p class="p-icon"><i class="fa fa-check" aria-hidden="true"></i></p>
      <p class="p-msg">
        <b>Sucesso</b><br>
        <c:out value="${mensagemSucesso}" />
      </p>
    </div>
  </c:when>
  <c:when test="${mensagemErro != null}">
    <div class='msg msg-erro'>
      <p class="p-msg">
        <b>Erro</b><br>
        <c:out value="${mensagemErro}" />
      </p>
    </div>
  </c:when>
</c:choose>