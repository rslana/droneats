package model.pedidoestado;

import model.Pedido;

/**
 *
 * @author raj
 */
public class PedidoEstadoCancelado implements PedidoEstado {

    @Override
    public String setProcessando(Pedido pedido) {
        return "Pedido Cancelado, não é possível alterar seu estado";
    }

    @Override
    public String setPreparando(Pedido pedido) {
        return "Pedido Cancelado, não é possível alterar seu estado";
    }

    @Override
    public String setEntregando(Pedido pedido) {
        return "Pedido Cancelado, não é possível alterar seu estado";
    }

    @Override
    public String setEntregue(Pedido pedido) {
        return "Pedido Cancelado, não é possível alterar seu estado";
    }

    @Override
    public String setCancelado(Pedido pedido) {
        return "Pedido Cancelado, não é possível alterar seu estado";
    }

    @Override
    public String getEstado() {
        return "Cancelado";
    }

    @Override
    public String getEstadoMensagem() {
        return "Pedido Cancelado";
    }

}
