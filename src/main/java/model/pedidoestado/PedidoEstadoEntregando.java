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
public class PedidoEstadoEntregando implements PedidoEstado {

    @Override
    public String setProcessando(Pedido pedido) {
        return "O pedido já saiu para entrega, não é possível alterar para processando";
    }

    @Override
    public String setPreparando(Pedido pedido) {
        return "O pedido já saiu para entrega, não é possível alterar para preparando";
    }

    @Override
    public String setEntregando(Pedido pedido) {
        return "O pedido já saiu para entrega, não é possível alterar para entregando";
    }

    @Override
    public String setEntregue(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoEntregue());
        return "Pedido Entregue";
    }

    @Override
    public String setCancelado(Pedido pedido) {
        return "O pedido já saiu para entrega, não é possível cancelar";
    }

    @Override
    public String getEstado() {
        return "Entregando";
    }

    @Override
    public String getEstadoMensagem() {
        return "Pedido Entregando";
    }
}
