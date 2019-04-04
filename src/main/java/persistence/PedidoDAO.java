/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import model.Pedido;
import static persistence.RestauranteDAO.closeResources;

/**
 *
 * @author ariel
 */
public class PedidoDAO {
    
    private static PedidoDAO instance = new PedidoDAO();

    private PedidoDAO() {
    }

    public static PedidoDAO getInstance() {
        return instance;
    }

    public void save(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();

        try {
            String sql = "INSERT INTO pedido (data_pedido, hora_pedido, valor, pago,"
                    + "data_pagamento, restaurante_id, cliente_id) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, pedido.getDataPedido());
            comando.setString(2, pedido.getHorarioPedido());
            comando.setDouble(3, pedido.getValor());
            comando.setBoolean(4, pedido.isPago());
            comando.setString(5, pedido.getDataPagamento());
            comando.setInt(6, pedido.getRestaurante().getId());
            comando.setInt(7, pedido.getCliente().getId());

            comando.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
        public void deletePedido(int id) throws SQLException, ClassNotFoundException {

        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("Delete from pedido where id= '" + id + "'");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
    }
    
}
