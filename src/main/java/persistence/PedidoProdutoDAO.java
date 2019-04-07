package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;
import model.PedidoProduto;
import model.Produto;
import model.Restaurante;
import static persistence.ProdutoDAO.closeResources;

/**
 *
 * @author raj
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

    public static ArrayList<PedidoProduto> listProdutosPedido(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        ArrayList<PedidoProduto> produtos = new ArrayList<>();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM pedido_produto WHERE pedido_id = " + pedido.getId());
            while (rs.next()) {
                PedidoProduto pedidoProduto = new PedidoProduto(
                        null,
                        null,
                        rs.getInt("quantidade"),
                        rs.getDouble("preco")
                );

                pedidoProduto.setPedidoId(rs.getInt("pedido_id"));
                pedidoProduto.setPedido(Pedido.getPedido(rs.getInt("pedido_id")));
                pedidoProduto.setProdutoId(rs.getInt("produto_id"));
                pedidoProduto.setProduto(Produto.getProduto(rs.getInt("produto_id")));
                produtos.add(pedidoProduto);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return produtos;
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
