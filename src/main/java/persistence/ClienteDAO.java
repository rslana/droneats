package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Cliente;
import model.Pedido;

/**
 *
 * @author raj
 */
public class ClienteDAO {

    private static ClienteDAO instance = new ClienteDAO();

    public static ClienteDAO getInstance() {
        return instance;
    }

    private ClienteDAO() {
    }

    public void save(Cliente cliente) throws SQLException, ClassNotFoundException {

        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();

        try {
            String sql = "INSERT INTO cliente (nome, email, senha, telefone, cpf)"
                    + " VALUES (?,?,?,?,?)";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setString(3, cliente.getSenha());
            comando.setString(4, cliente.getTelefone());
            comando.setString(5, cliente.getCpf());

            comando.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void deleteCliente(String email) throws SQLException, ClassNotFoundException {

        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM cliente WHERE email= '" + email + "'");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
    }

    public Cliente getCliente(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        String sql = "SELECT * FROM cliente WHERE id = '" + id + "'";
        PreparedStatement comando = conn.prepareStatement(sql);
        Cliente cliente = null;
        try {
            ResultSet rs = comando.executeQuery();

            rs.first();
            cliente = new Cliente();
            cliente.setId(rs.getInt("id"))
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
        return cliente;
    }

    public Cliente getClientePedido(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        String sql = "SELECT * FROM cliente WHERE id = '" + pedido.getClienteId() + "'";
        PreparedStatement comando = conn.prepareStatement(sql);
        Cliente cliente = null;
        try {
            ResultSet rs = comando.executeQuery();

            rs.first();
            cliente = new Cliente(pedido);
            cliente.setId(rs.getInt("id"))
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
        return cliente;
    }

    public Cliente login(String email, String senha) throws ClassNotFoundException, SQLException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Cliente cliente = null;
        PreparedStatement comando = null;
        try {
            String sql = "SELECT * FROM cliente WHERE email = ? AND senha = ?";
            comando = conn.prepareStatement(sql);
            comando.setString(1, email);
            comando.setString(2, senha);
            ResultSet rs = comando.executeQuery();
            if (rs.first()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"))
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
        return cliente;
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
