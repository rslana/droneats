package model;

/**
 *
 * @author rslana
 */
public class PedidoProduto {
    private int pedidoId;
    private Pedido pedido;
    private int produtoId;
    private Produto produto;
    private int quantidade;

    public PedidoProduto(int pedidoId, Pedido pedido, Produto produto) {
        this.pedidoId = pedidoId;
        this.pedido = pedido;
        this.produto = produto;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
