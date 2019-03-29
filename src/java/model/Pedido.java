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
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private Restaurante restaurante;
    private Cliente cliente;
    private String dataPedido;
    private String horarioPedido;
    private String dataPagamento;
    private double valor;
    private boolean pago;
    
    private int pedidoEstado_id;
    private PedidoEstado estado;

    public Pedido(String dataPedido, String horarioPedido, String dataPagamento, double valor, boolean pago, int pedidoEstado_id) {
        this.dataPedido = dataPedido;
        this.horarioPedido = horarioPedido;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.pago = pago;
        this.pedidoEstado_id = pedidoEstado_id;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
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
