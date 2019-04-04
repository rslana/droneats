package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;
import model.Restaurante;

/**
 *
 * @author rslana
 */
public class ProdutoDAO {

    private static ProdutoDAO instance = new ProdutoDAO();

    private ProdutoDAO() {
    }

    public static ProdutoDAO getInstance() {
        return instance;
    }

    public void save(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();

        try {
            String sql = "INSERT INTO produto (nome, descricao, preco, imagem, restaurante_id) VALUES (?,?,?,?,?)";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, produto.getNome());
            comando.setString(2, produto.getDescricao());
            comando.setDouble(3, produto.getPreco());
            comando.setString(4, produto.getImagem());
            comando.setInt(5, produto.getRestaurante().getId());

            comando.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public boolean deleteById(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        int deleted = 0;
        try {
            deleted = st.executeUpdate("DELETE FROM produto WHERE id=" + id);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return (deleted > 0);
    }

    public Produto read(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        Produto produto = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM produto WHERE id =" + id);
            rs.first();
            produto = new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getDouble("preco"),
                    rs.getString("imagem"),
                    null,
                    null
            );
            
            produto.setRestauranteId(rs.getInt("restaurante_id"));
            produto.setRestaurante(Restaurante.obterRestaurante(rs.getInt("restaurante_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return produto;
    }

    public static List<Produto> listProdutosRestaurante(Restaurante restaurante) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        List<Produto> produtos = new ArrayList<Produto>();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM produto WHERE restaurante_id = " + restaurante.getId());
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("preco"),
                        rs.getString("imagem"),
                        null,
                        null
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return produtos;
    }

    public static Produto obterProduto(int id) throws ClassNotFoundException, SQLException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        Produto produto = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM produto WHERE id = " + id);
            rs.first();
            produto = new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getDouble("preco"),
                    rs.getString("imagem"),
                    null,
                    null
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return produto;
    }

    public static void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
