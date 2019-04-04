/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Cliente;
import model.Restaurante;

/**
 *
 * @author ariel
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
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into restaurante (nome, cnpj, estado, "
                    + "cidade, cep, bairro, rua, numero, descricao, "
                    + "telefone)"
                    + " values ('" + restaurante.getNome()
                    + "', '" + restaurante.getCnpj() + "', '" + restaurante.getEstado()
                    + "','" + restaurante.getCidade() + "', '" + restaurante.getCep()
                    + "', '" + restaurante.getBairro() + "','" + restaurante.getRua()
                    + "','" + restaurante.getNumero() + "', '" + restaurante.getDescricao()
                    + "', '" + restaurante.getTelefone() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
    }

    public void apagarRestaurante(String email) throws SQLException, ClassNotFoundException {

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
    
    public static Restaurante obterRestaurante(int id) throws ClassNotFoundException, SQLException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        Restaurante restaurante = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM cliente WHERE id = " + id);
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return restaurante;
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
