package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.pedidoestado.PedidoEstado;
import model.pedidoestado.PedidoEstadoProcessando;
import persistence.PedidoDAO;

/**
 *
 * @author raj
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
        this.dataPedido = getDataAtualFormatada();
        this.horarioPedido = getHoraAtualFormatada();
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.pago = pago;
        this.pedidoEstadoId = pedidoEstadoId;
    }

    public Pedido(double valor, Cliente cliente, Restaurante restaurante, ArrayList<PedidoProduto> produtos) {
        this.dataPedido = getDataAtualFormatada();
        this.horarioPedido = getHoraAtualFormatada();
        this.valor = valor;
        this.pago = true;
        this.produtos = produtos;
        this.cliente = cliente;
        this.restaurante = restaurante;
    }

    public Pedido(double valor, Cliente cliente, Restaurante restaurante) {
        this.dataPedido = getDataAtualFormatada();
        this.horarioPedido = getHoraAtualFormatada();
        this.valor = valor;
        this.pago = true;
        this.estado = new PedidoEstadoProcessando();
        this.cliente = cliente;
        this.restaurante = restaurante;
    }

    public Pedido(int id, String dataPedido, String horarioPedido, String dataPagamento,
            double valor, boolean pago, PedidoEstado estado, Restaurante restaurante, Cliente cliente) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.horarioPedido = horarioPedido;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.pago = pago;
        this.estado = estado;
        this.restaurante = restaurante;
        this.cliente = cliente;
    }

    public Pedido() {
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

    public String getEstadoMensagem() {
        return estado.getEstadoMensagem();
    }

    public ArrayList<PedidoProduto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<PedidoProduto> produtos) {
        this.produtos = produtos;
    }
    

    public static String getDataAtualFormatada() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        return ((day < 10) ? "0" + day : day) + "/" + ((month < 9) ? "0" + (month + 1) : month + 1) + "/" + year;
    }
    
    public static String getHoraAtualFormatada() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        return hour + ":" + minute;
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
