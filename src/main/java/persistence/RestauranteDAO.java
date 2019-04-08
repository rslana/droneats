package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;
import model.Proprietario;
import model.Restaurante;

/**
 *
 * @author raj
 */
public class RestauranteDAO {

    private static RestauranteDAO instance = new RestauranteDAO();

    public static RestauranteDAO getInstance() {
        return instance;
    }

    private RestauranteDAO() {
    }

    public void save(Restaurante restaurante) throws SQLException, ClassNotFoundException {

        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();

        try {

            String sql = "INSERT INTO restaurante (nome, cnpj, estado, cidade, "
                    + "cep, bairro, rua, numero, descricao, telefone, proprietario_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, restaurante.getNome());
            comando.setString(2, restaurante.getCnpj());
            comando.setString(3, restaurante.getEstado());
            comando.setString(4, restaurante.getCidade());
            comando.setString(5, restaurante.getCep());
            comando.setString(6, restaurante.getBairro());
            comando.setString(7, restaurante.getRua());
            comando.setString(8, restaurante.getNumero());
            comando.setString(9, restaurante.getDescricao());
            comando.setString(10, restaurante.getTelefone());
            comando.setInt(11, restaurante.getProprietario().getId());

            comando.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
    }

    public void deleteRestaurante(String email) throws SQLException, ClassNotFoundException {

        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("Delete from restaurante where email= '" + email + "'");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
    }

    public static Restaurante getRestaurante(int id) throws ClassNotFoundException, SQLException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        Restaurante restaurante = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM restaurante WHERE id = " + id);
            rs.first();
            restaurante = new Restaurante(
                    rs.getInt("id"),
                    rs.getString("cnpj"),
                    rs.getString("descricao"),
                    rs.getString("nome"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("bairro"),
                    rs.getString("rua"),
                    rs.getString("numero"),
                    rs.getString("cep"),
                    rs.getString("telefone"),
                    null
            );
            restaurante.setProprietarioId(rs.getInt("proprietario_id"));
            restaurante.setProprietario(Proprietario.getProprietario(rs.getInt("proprietario_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return restaurante;
    }
    
    public static Restaurante getRestaurantePedido(Pedido pedido) throws ClassNotFoundException, SQLException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        Restaurante restaurante = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM restaurante WHERE id = " + pedido.getRestauranteId());
            rs.first();
            restaurante = new Restaurante(
                    rs.getInt("id"),
                    rs.getString("cnpj"),
                    rs.getString("descricao"),
                    rs.getString("nome"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("bairro"),
                    rs.getString("rua"),
                    rs.getString("numero"),
                    rs.getString("cep"),
                    rs.getString("telefone"),
                    null,
                    pedido
            );
            restaurante.setProprietarioId(rs.getInt("proprietario_id"));
            restaurante.setProprietario(Proprietario.getProprietario(rs.getInt("proprietario_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return restaurante;
    }
    
    public static Restaurante getRestauranteProprrietario(Proprietario proprietario) throws ClassNotFoundException, SQLException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        Restaurante restaurante = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM restaurante WHERE id = " + proprietario.getId());
            rs.first();
            restaurante = new Restaurante(
                    rs.getInt("id"),
                    rs.getString("cnpj"),
                    rs.getString("descricao"),
                    rs.getString("nome"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("bairro"),
                    rs.getString("rua"),
                    rs.getString("numero"),
                    rs.getString("cep"),
                    rs.getString("telefone"),
                    null
            );
            restaurante.setProprietarioId(rs.getInt("proprietario_id"));
            restaurante.setProprietario(Proprietario.getProprietario(rs.getInt("proprietario_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return restaurante;
    }

    public static List<Restaurante> getRestaurantes() throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        List<Restaurante> restaurantes = new ArrayList<>();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM restaurante");
            while (rs.next()) {
                Restaurante restaurante = new Restaurante(
                        rs.getInt("id"),
                        rs.getString("cnpj"),
                        rs.getString("descricao"),
                        rs.getString("nome"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("bairro"),
                        rs.getString("rua"),
                        rs.getString("numero"),
                        rs.getString("cep"),
                        rs.getString("telefone"),
                        null
                );

                restaurante.setProprietarioId(rs.getInt("proprietario_id"));
                restaurante.setProprietario(Proprietario.getProprietario(rs.getInt("proprietario_id")));
                restaurantes.add(restaurante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return restaurantes;
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
