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
    private double preco;

    public PedidoProduto(Pedido pedido, Produto produto, int quantidade, double preco) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public PedidoProduto(int pedidoId, int produtoId, Pedido pedido, Produto produto, int quantidade, double preco) {
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
