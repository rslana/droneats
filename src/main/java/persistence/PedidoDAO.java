/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Cliente;
import model.Pedido;
import model.Restaurante;

/**
 *
 * @author raj
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
            st.execute("DELETE FROM pedido WHERE id= '" + id + "'");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
    }

    public static Pedido getPedido(int id) throws ClassNotFoundException, SQLException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        Pedido pedido = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM pedido WHERE id = " + id);
            rs.first();
            pedido = new Pedido(
                    rs.getInt("id"),
                    rs.getString("data_pedido"),
                    rs.getString("hora_pedido"),
                    rs.getString("data_pagamento"),
                    rs.getDouble("valor"),
                    rs.getBoolean("pago"),
                    null,
                    null
            );
            pedido.setRestauranteId(rs.getInt("restaurante_id"));
            pedido.setRestaurante(Restaurante.getRestaurante(rs.getInt("restaurante_id")));

            pedido.setClienteId(rs.getInt("cliente_id"));
            pedido.setCliente(Cliente.getCliente(rs.getInt("cliente_id")));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return pedido;
    }

    public static void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {

        }

    }

}
