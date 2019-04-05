package model.pedidoestado;

import model.Pedido;

/**
 *
 * @author raj
 */
public class PedidoEstadoEntregue implements PedidoEstado {

    @Override
    public String setProcessando(Pedido pedido) {
        return "Pedido entregue, não é possível alterar para processando";
    }

    @Override
    public String setPreparando(Pedido pedido) {
        return "Pedido entregue, não é possível alterar para preparando";
    }

    @Override
    public String setEntregando(Pedido pedido) {
        return "Pedido entregue, não é possível alterar para entregando";
    }

    @Override
    public String setEntregue(Pedido pedido) {
        return "Pedido entregue, não é possível alterar para entregue";
    }

    @Override
    public String setCancelado(Pedido pedido) {
        return "Pedido entregue, não é possível cancelar";
    }

    @Override
    public String getEstado() {
        return "Entregue";
    }

    @Override
    public String getEstadoMensagem() {
        return "Pedido Entregue";
    }
}
