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
import model.Produto;
import model.Proprietario;

/**
 *
 * @author ariel
 */
public class ProprietarioDAO {

    private static ProprietarioDAO instance = new ProprietarioDAO();

    public static ProprietarioDAO getInstance() {
        return instance;
    }

    private ProprietarioDAO() {
    }

    public void save(Proprietario proprietario) throws SQLException, ClassNotFoundException {

        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into proprietario (nome, email, senha, telefone, cpf)"
                    + " values ('" + proprietario.getNome() + "', '" + proprietario.getEmail() + "','" + proprietario.getSenha() + "','" + proprietario.getTelefone() + "','" + proprietario.getCpf() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
    }

    public void deleteProprietario(String email) throws SQLException, ClassNotFoundException {

        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("Delete from proprietario where email= '" + email + "'");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
    }

    public Proprietario getLastProprietario() throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        String sql = "SELECT * FROM proprietario ORDER BY id DESC LIMIT 1";
        PreparedStatement comando = conn.prepareStatement(sql);
        Proprietario proprietario = null;
        try {
            ResultSet rs = comando.executeQuery();

            rs.first();
            proprietario = new Proprietario(
                    rs.getInt("id"),
                    rs.getString("cpf"),
                    rs.getString("senha"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("telefone")
            );
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, comando);
        }
        return proprietario;
    }

    public void closeResources(Connection conn, Statement st) {
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
