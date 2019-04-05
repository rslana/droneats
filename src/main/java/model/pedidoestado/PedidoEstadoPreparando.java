package model.pedidoestado;

import model.Pedido;

/**
 *
 * @author raj
 */
public class PedidoEstadoPreparando implements PedidoEstado {

    @Override
    public String setProcessando(Pedido pedido) {
        return "Pedido em preparação, não é possível alterar para processando";
    }

    @Override
    public String setPreparando(Pedido pedido) {
        return "Pedido em preparação, não é possível alterar para preparando";
    }

    @Override
    public String setEntregando(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoEntregando());
        return "Pedido saiu para a entrega";
    }

    @Override
    public String setEntregue(Pedido pedido) {
        return "Pedido em preparação, não é possível alterar entregue";
    }

    @Override
    public String setCancelado(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoCancelado());
        return "Pedido Cancelado";
    }

    @Override
    public String getEstado() {
        return "Preparando";
    }

    @Override
    public String getEstadoMensagem() {
        return "Pedido Preparando";
    }

}
