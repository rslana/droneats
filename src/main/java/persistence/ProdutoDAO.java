package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;
import model.Produto;
import model.Restaurante;
import model.promocao.Promocao;
import model.promocao.PromocaoFactory;

/**
 *
 * @author raj
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
            String sql = "INSERT INTO produto (nome, descricao, preco, imagem, promocao, restaurante_id, categoria_id) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, produto.getNome());
            comando.setString(2, produto.getDescricao());
            comando.setDouble(3, produto.getPreco());
            comando.setString(4, produto.getImagem());
            comando.setString(5, (produto.getPromocao() != null) ? produto.getPromocao().obterClasse() : null);
            comando.setInt(6, produto.getRestaurante().getId());
            comando.setInt(7, produto.getCategoria().getId());
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
                    null,
                    null
            );

            produto.setRestauranteId(rs.getInt("restaurante_id"));
            produto.setRestaurante(Restaurante.getRestaurante(rs.getInt("restaurante_id")));
            produto.setCategoriaId(rs.getInt("categoria_id"));
            produto.setCategoria(Categoria.getCategoria(rs.getInt("categoria_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return produto;
    }

    public static ArrayList<Produto> listProdutosRestaurante(Restaurante restaurante) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        ArrayList<Produto> produtos = new ArrayList<>();
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
                        null,
                        null
                );
                produto.setRestauranteId(rs.getInt("restaurante_id"));
                produto.setRestaurante(Restaurante.getRestaurante(rs.getInt("restaurante_id")));
                produto.setCategoriaId(rs.getInt("categoria_id"));
                produto.setCategoria(Categoria.getCategoria(rs.getInt("categoria_id")));
                Promocao promocao = PromocaoFactory.create(rs.getString("promocao"));
                produto.setPromocao(promocao);
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return produtos;
    }

    public static HashMap<Integer, ArrayList<Produto>> listProdutosRestauranteByCategoria(Restaurante restaurante) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        HashMap<Integer, ArrayList<Produto>> produtosByCategoria = new HashMap<>();
        ArrayList<Categoria> categorias = CategoriaDAO.listCategoriasRestaurante(restaurante);

        try {
            for (Categoria categoria : categorias) {
                ArrayList<Produto> produtos = new ArrayList<>();
                ResultSet rs = st.executeQuery("SELECT * FROM produto WHERE restaurante_id = " + restaurante.getId() + " AND categoria_id = " + categoria.getId());
                while (rs.next()) {
                    Produto produto = new Produto(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("descricao"),
                            rs.getDouble("preco"),
                            rs.getString("imagem"),
                            null,
                            null,
                            null
                    );
                    produto.setRestauranteId(rs.getInt("restaurante_id"));
                    produto.setRestaurante(Restaurante.getRestaurante(rs.getInt("restaurante_id")));
                    produto.setCategoriaId(rs.getInt("categoria_id"));
                    produto.setCategoria(Categoria.getCategoria(rs.getInt("categoria_id")));
                    Promocao promocao = PromocaoFactory.create(rs.getString("promocao"));
                    produto.setPromocao(promocao);
                    produtos.add(produto);
                }
                produtosByCategoria.put(categoria.getId(), produtos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return produtosByCategoria;
    }

    public static Produto getProduto(int id) throws ClassNotFoundException, SQLException {
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
                    null,
                    null
            );
            produto.setRestauranteId(rs.getInt("restaurante_id"));
            produto.setRestaurante(Restaurante.getRestaurante(rs.getInt("restaurante_id")));
            produto.setCategoriaId(rs.getInt("categoria_id"));
            produto.setCategoria(Categoria.getCategoria(rs.getInt("categoria_id")));
            Promocao promocao = PromocaoFactory.create(rs.getString("promocao"));
            produto.setPromocao(promocao);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return produto;
    }

    public int countProdutosRestaurante(Restaurante restaurante) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        String sql = "SELECT count(*) as quantidade FROM produto WHERE restaurante_id = " + restaurante.getId();
        PreparedStatement comando = conn.prepareStatement(sql);

        try {
            ResultSet rs = comando.executeQuery();
            rs.first();

            return rs.getInt("quantidade");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, comando);
        }
    }

    public static Produto getProdutoRestaurante(int id,Restaurante restaurante) throws ClassNotFoundException, SQLException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        Produto produto = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM produto WHERE id = " + id + " AND restaurante_id = " + restaurante.getId());
            rs.first();
            produto = new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getDouble("preco"),
                    rs.getString("imagem"),
                    null,
                    null,
                    null
            );
            produto.setRestauranteId(rs.getInt("restaurante_id"));
            produto.setRestaurante(Restaurante.getRestaurante(rs.getInt("restaurante_id")));
            produto.setCategoriaId(rs.getInt("categoria_id"));
            produto.setCategoria(Categoria.getCategoria(rs.getInt("categoria_id")));
            Promocao promocao = PromocaoFactory.create(rs.getString("promocao"));
            produto.setPromocao(promocao);
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
