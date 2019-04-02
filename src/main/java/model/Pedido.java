/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author ariel
 */
public class Pedido {

    private int id;
    private Restaurante restaurante;
    private Cliente cliente;
    private String dataPedido;
    private String horarioPedido;
    private String dataPagamento;
    private double valor;
    private boolean pago;
    HashMap<Produto, Integer> produtos;

    private int pedidoEstado_id;
    private PedidoEstado estado;

    public Pedido(String horarioPedido, String dataPagamento, double valor, boolean pago, int pedidoEstado_id) {
        Calendar hoje = Calendar.getInstance();
        this.dataPedido = hoje.get(Calendar.DAY_OF_MONTH) + "/" + (hoje.get(Calendar.MONTH) + 1) + "/" + hoje.get(Calendar.YEAR);
        this.horarioPedido = horarioPedido;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.pago = pago;
        this.pedidoEstado_id = pedidoEstado_id;
    }

    public Pedido(double valor,Cliente cliente, HashMap<Produto,Integer> produtos) {
        this.dataPedido = Calendar.DAY_OF_MONTH + "/" + (Calendar.MONTH + 1) + "/" + Calendar.YEAR;
        this.horarioPedido = Calendar.HOUR_OF_DAY + ":" + ((Calendar.MINUTE < 10) ? "0" + Calendar.MINUTE : Calendar.MINUTE);
        this.valor = valor;
        this.pago = true;
        this.produtos = produtos;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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