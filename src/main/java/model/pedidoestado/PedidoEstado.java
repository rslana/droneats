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
public interface PedidoEstado {

    public String setProcessando(Pedido pedido);

    public String setPreparando(Pedido pedido);

    public String setEntregando(Pedido pedido);

    public String setEntregue(Pedido pedido);

    public String setCancelado(Pedido pedido);

    /**
     *
     * @return Estado atual do pedido
     */
    public String getEstado();

    public String getEstadoMensagem();
}
