/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pedidoestado;

import model.Pedido;

/**
 *
 * @author rslana
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
