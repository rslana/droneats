package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Proprietario;

/**
 *
 * @author raj
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
            proprietario = new Proprietario();
            proprietario.setId(rs.getInt("id"))
                    .setCpf(rs.getString("cpf"))
                    .setSenha(rs.getString("senha"))
                    .setNome(rs.getString("nome"))
                    .setEmail(rs.getString("email"))
                    .setCidade(rs.getString("cidade"))
                    .setEstado(rs.getString("estado"))
                    .setBairro(rs.getString("bairro"))
                    .setRua(rs.getString("rua"))
                    .setNumero(rs.getString("numero"))
                    .setCep(rs.getString("cep"))
                    .setTelefone(rs.getString("telefone"));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, comando);
        }
        return proprietario;
    }

    public Proprietario getProprietario(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        String sql = "SELECT * FROM proprietario WHERE id = " + id;
        PreparedStatement comando = conn.prepareStatement(sql);
        Proprietario proprietario = null;
        try {
            ResultSet rs = comando.executeQuery();

            rs.first();
            proprietario = new Proprietario();
            proprietario.setId(rs.getInt("id"))
                    .setCpf(rs.getString("cpf"))
                    .setSenha(rs.getString("senha"))
                    .setNome(rs.getString("nome"))
                    .setEmail(rs.getString("email"))
                    .setCidade(rs.getString("cidade"))
                    .setEstado(rs.getString("estado"))
                    .setBairro(rs.getString("bairro"))
                    .setRua(rs.getString("rua"))
                    .setNumero(rs.getString("numero"))
                    .setCep(rs.getString("cep"))
                    .setTelefone(rs.getString("telefone"));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, comando);
        }
        return proprietario;
    }

    public Proprietario login(String email, String senha) throws ClassNotFoundException, SQLException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Proprietario proprietario = null;
        PreparedStatement comando = null;
        try {
            String sql = "SELECT * FROM proprietario WHERE email = ? AND senha = ?";
            comando = conn.prepareStatement(sql);
            comando.setString(1, email);
            comando.setString(2, senha);
            ResultSet rs = comando.executeQuery();
            if (rs.first()) {
                proprietario = new Proprietario();
                proprietario.setId(rs.getInt("id"))
                        .setCpf(rs.getString("cpf"))
                        .setSenha(rs.getString("senha"))
                        .setNome(rs.getString("nome"))
                        .setEmail(rs.getString("email"))
                        .setCidade(rs.getString("cidade"))
                        .setEstado(rs.getString("estado"))
                        .setBairro(rs.getString("bairro"))
                        .setRua(rs.getString("rua"))
                        .setNumero(rs.getString("numero"))
                        .setCep(rs.getString("cep"))
                        .setTelefone(rs.getString("telefone"));
            }
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
