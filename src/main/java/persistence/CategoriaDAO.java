package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Categoria;
import model.Restaurante;

/**
 *
 * @author raj
 */
public class CategoriaDAO {

    private static CategoriaDAO instance = new CategoriaDAO();

    public static CategoriaDAO getInstance() {
        return instance;
    }

    private CategoriaDAO() {
    }

    public void save(Categoria categoria) throws SQLException, ClassNotFoundException {

        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();

        try {
            String sql = "INSERT INTO categoria (nome, restaurante_id) VALUES (?,?)";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, categoria.getNome());
            comando.setInt(2, categoria.getRestaurante().getId());
            comando.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void apagarCategoria(String email) throws SQLException, ClassNotFoundException {

        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM categoria WHERE email= '" + email + "'");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
    }

    public static Categoria getCategoria(int id) throws ClassNotFoundException, SQLException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        Categoria categoria = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM categoria WHERE id = " + id);
            rs.first();
            categoria = new Categoria(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    null
            );
            categoria.setRestauranteId(rs.getInt("restaurante_id"));
            categoria.setRestaurante(Restaurante.getRestaurante(rs.getInt("restaurante_id")));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return categoria;
    }

    public static ArrayList<Categoria> listCategoriasRestaurante(Restaurante restaurante) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        ArrayList<Categoria> categorias = new ArrayList<>();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM categoria WHERE restaurante_id = " + restaurante.getId());
            while (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        null
                );
                categoria.setRestauranteId(rs.getInt("restaurante_id"));
                categoria.setRestaurante(Restaurante.getRestaurante(rs.getInt("restaurante_id")));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return categorias;
    }

    public int countCategoriasRestaurante(Restaurante restaurante) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        String sql = "SELECT count(*) as quantidade FROM categoria WHERE restaurante_id = " + restaurante.getId();
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
