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
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Pedido;
import model.Restaurante;
import model.pedidoestado.PedidoEstado;
import model.pedidoestado.PedidoEstadoFactory;

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
                    + "data_pagamento, estado, restaurante_id, cliente_id) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, pedido.getDataPedido());
            comando.setString(2, pedido.getHorarioPedido());
            comando.setDouble(3, pedido.getValor());
            comando.setBoolean(4, pedido.isPago());
            comando.setString(5, pedido.getDataPagamento());
            comando.setString(6, pedido.getEstado().getEstado());
            comando.setInt(7, pedido.getRestaurante().getId());
            comando.setInt(8, pedido.getCliente().getId());

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

            PedidoEstado pedidoEstado = PedidoEstadoFactory.create(rs.getString("estado"));

            pedido = new Pedido(
                    rs.getInt("id"),
                    rs.getString("data_pedido"),
                    rs.getString("hora_pedido"),
                    rs.getString("data_pagamento"),
                    rs.getDouble("valor"),
                    rs.getBoolean("pago"),
                    pedidoEstado,
                    null,
                    null
            );
            pedido.setRestauranteId(rs.getInt("restaurante_id"));
            pedido.setRestaurante(Restaurante.getRestaurante(rs.getInt("restaurante_id")));

            pedido.setClienteId(rs.getInt("cliente_id"));
            pedido.setCliente(ClienteDAO.getClientePedido(pedido));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return pedido;
    }

    public Pedido getLastPedido() throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        String sql = "SELECT * FROM pedido ORDER BY id DESC LIMIT 1";
        PreparedStatement comando = conn.prepareStatement(sql);
        Pedido pedido = null;
        try {
            ResultSet rs = comando.executeQuery();
            rs.first();

            PedidoEstado pedidoEstado = PedidoEstadoFactory.create(rs.getString("estado"));

            pedido = new Pedido(
                    rs.getInt("id"),
                    rs.getString("data_pedido"),
                    rs.getString("hora_pedido"),
                    rs.getString("data_pagamento"),
                    rs.getDouble("valor"),
                    rs.getBoolean("pago"),
                    pedidoEstado,
                    null,
                    null
            );
            pedido.setRestauranteId(rs.getInt("restaurante_id"));
            pedido.setRestaurante(Restaurante.getRestaurante(rs.getInt("restaurante_id")));

            pedido.setClienteId(rs.getInt("cliente_id"));
            pedido.setCliente(Cliente.getCliente(rs.getInt("cliente_id")));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, comando);
        }
        return pedido;
    }

    public void updateEstado(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();

        try {
            String sql = "UPDATE pedido SET estado = ? WHERE id = ?";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, pedido.getEstado().getEstado());
            comando.setInt(2, pedido.getId());
            comando.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public static ArrayList<Pedido> listPedidosCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM pedido WHERE cliente_id = " + cliente.getId());
            while (rs.next()) {

                PedidoEstado pedidoEstado = PedidoEstadoFactory.create(rs.getString("estado"));

                Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        rs.getString("data_pedido"),
                        rs.getString("hora_pedido"),
                        rs.getString("data_pagamento"),
                        rs.getDouble("valor"),
                        rs.getBoolean("pago"),
                        pedidoEstado,
                        null,
                        null
                );
                pedido.setRestauranteId(rs.getInt("restaurante_id"));
                pedido.setRestaurante(Restaurante.getRestaurante(rs.getInt("restaurante_id")));

                pedido.setClienteId(rs.getInt("cliente_id"));
                pedido.setCliente(Cliente.getCliente(rs.getInt("cliente_id")));
                
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return pedidos;
    }
    
    public static ArrayList<Pedido> listPedidosRestaurante(Restaurante restaurante) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM pedido WHERE restaurante_id = " + restaurante.getId());
            while (rs.next()) {

                PedidoEstado pedidoEstado = PedidoEstadoFactory.create(rs.getString("estado"));

                Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        rs.getString("data_pedido"),
                        rs.getString("hora_pedido"),
                        rs.getString("data_pagamento"),
                        rs.getDouble("valor"),
                        rs.getBoolean("pago"),
                        pedidoEstado,
                        null,
                        null
                );
                pedido.setRestauranteId(rs.getInt("restaurante_id"));
                pedido.setRestaurante(Restaurante.getRestaurante(rs.getInt("restaurante_id")));

                pedido.setClienteId(rs.getInt("cliente_id"));
                pedido.setCliente(Cliente.getCliente(rs.getInt("cliente_id")));
                
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return pedidos;
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
