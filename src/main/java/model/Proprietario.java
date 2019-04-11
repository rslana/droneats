package model;

import javax.servlet.http.HttpSession;


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

    public static boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("usuario") instanceof Proprietario;
    }

    @Override
    public String getTipo() {
        return "Proprietario";
    }
}
