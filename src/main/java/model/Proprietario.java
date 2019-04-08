package model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import persistence.ProprietarioDAO;

/**
 *
 * @author raj
 */
public class Proprietario extends Usuario {

    public Proprietario(int id, String cpf, String senha, String nome, String email, String cidade, String estado, String bairro, String rua, String numero, String cep, String telefone) {
        super(cpf, senha, id, nome, email, cidade, estado, bairro, rua, numero, cep, telefone);
    }

    public Proprietario(String nome, String email, String senha, String cpf, String telefone) {
        super(cpf, senha, nome, email, telefone);
    }

    public Proprietario(int id, String nome, String email, String senha, String cpf, String telefone) {
        super(id, cpf, senha, nome, email, telefone);
    }
    
    public static Proprietario login(String email, String senha) {
        try {
            return ProprietarioDAO.login(email, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Proprietario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static boolean isLogado(HttpSession session) {
        Proprietario proprietario = (Proprietario) session.getAttribute("usuario");
        return proprietario != null;
    }

    public static Proprietario getProprietario(int id) throws ClassNotFoundException {
        try {
            return ProprietarioDAO.getProprietario(id);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
