/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pedidoestado;

import model.Pedido;

/**
 *
 * @author raj
 */
public class PedidoEstadoProcessando implements PedidoEstado {

    @Override
    public String setProcessando(Pedido pedido) {
        return "Pedido aguardando confirmação do restaurante, não é possível alterar para processando";
    }

    @Override
    public String setPreparando(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoPreparando());
        return "Pedido confirmado e em preparação";
    }

    @Override
    public String setEntregando(Pedido pedido) {
        return "Pedido está sendo processado, aguardando confirmação do restaurante, não é possível alterar para entregando";
    }

    @Override
    public String setEntregue(Pedido pedido) {
        return "Pedido está sendo processado, aguardando confirmação do restaurante, não é possível alterar para entregue";
    }

    @Override
    public String setCancelado(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoCancelado());
        return "Pedido Cancelado";
    }

    @Override
    public String getEstado() {
        return "Processando";
    }

    @Override
    public String getEstadoMensagem() {
        return "Pedido Processando";
    }
}
