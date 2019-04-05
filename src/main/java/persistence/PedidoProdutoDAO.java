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
import model.PedidoProduto;
//import model.Cliente;
//import model.Pedido;
//import model.Restaurante;

/**
 *
 * @author rslana
 */
public class PedidoProdutoDAO {
      private static PedidoProdutoDAO instance = new PedidoProdutoDAO();

    private PedidoProdutoDAO() {
    }

    public static PedidoProdutoDAO getInstance() {
        return instance;
    }

    public void save(PedidoProduto pedidoProduto) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();

        try {
            String sql = "INSERT INTO pedido_produto (pedido_id, produto_id, quantidade, preco) VALUES (?,?,?,?)";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1, pedidoProduto.getPedido().getId());
            comando.setInt(2, pedidoProduto.getProduto().getId());
            comando.setInt(3, pedidoProduto.getQuantidade());
            comando.setDouble(4, pedidoProduto.getPreco());

            comando.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
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
