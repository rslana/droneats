/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ariel
 */
public class Pedido {
    private Restaurante restaurante;
    private Cliente cliente;
    private String dataPedido;
    private String horarioPedido;
    
    private int pedidoEstado_id;
    private PedidoEstado estado;

    public Pedido(Restaurante restaurante, Cliente cliente, String dataPedido, String horarioPedido, int pedidoEstado_id, PedidoEstado estado) {
        this.restaurante = restaurante;
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.horarioPedido = horarioPedido;
        this.pedidoEstado_id = pedidoEstado_id;
        this.estado = estado;
    }

    public int getPedidoEstado_id() {
        return pedidoEstado_id;
    }

    public void setPedidoEstado_id(int pedidoEstado_id) {
        this.pedidoEstado_id = pedidoEstado_id;
    }



    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getHorarioPedido() {
        return horarioPedido;
    }

    public void setHorarioPedido(String horarioPedido) {
        this.horarioPedido = horarioPedido;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    
    
    
}
