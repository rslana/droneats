/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.PedidoDAO;

/**
 *
 * @author ariel
 */
public class Pedido {

    private int id;
    private Restaurante restaurante;
    private int restauranteId;
    private Cliente cliente;
    private int clienteId;

    private String dataPedido;
    private String horarioPedido;
    private String dataPagamento;
    private double valor;
    private boolean pago;
    ArrayList<PedidoProduto> produtos;

    private int pedidoEstadoId;
    private PedidoEstado estado;

    public Pedido(String horarioPedido, String dataPagamento, double valor, boolean pago, int pedidoEstadoId) {
        this.dataPedido = Calendar.DAY_OF_MONTH + "/" + (Calendar.MONTH + 1) + "/" + Calendar.YEAR;
        this.horarioPedido = Calendar.HOUR_OF_DAY + ":" + ((Calendar.MINUTE < 10) ? "0" + Calendar.MINUTE : Calendar.MINUTE);
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.pago = pago;
        this.pedidoEstadoId = pedidoEstadoId;
    }

    public Pedido(double valor, Cliente cliente, ArrayList<PedidoProduto> produtos) {
        this.dataPedido = Calendar.DAY_OF_MONTH + "/" + (Calendar.MONTH + 1) + "/" + Calendar.YEAR;
        this.horarioPedido = Calendar.HOUR_OF_DAY + ":" + ((Calendar.MINUTE < 10) ? "0" + Calendar.MINUTE : Calendar.MINUTE);
        this.valor = valor;
        this.pago = true;
        this.produtos = produtos;
        this.cliente = cliente;
    }

    public Pedido(int id, String dataPedido, String horarioPedido, String dataPagamento,
            double valor, boolean pago, Restaurante restaurante, Cliente cliente) {
        this.id = id;
        this.restaurante = restaurante;
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.horarioPedido = horarioPedido;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.pago = pago;
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

    public int getPedidoEstadoId() {
        return pedidoEstadoId;
    }

    public void setPedidoEstadoId(int pedidoEstadoId) {
        this.pedidoEstadoId = pedidoEstadoId;
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

    public int getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(int restauranteId) {
        this.restauranteId = restauranteId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public static Pedido getPedido(int id) throws ClassNotFoundException {
        try {
            return PedidoDAO.getPedido(id);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
