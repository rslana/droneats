package model;

import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import persistence.ClienteDAO;

/**
 *
 * @author raj
 */
public class Cliente extends Usuario implements Observer {

    public Cliente(int id, String cpf, String senha, String nome, String email, String cidade, String estado, String bairro, String rua, String numero, String cep, String telefone) {
        super(cpf, senha, id, nome, email, cidade, estado, bairro, rua, numero, cep, telefone);
    }

    public Cliente(int id, String cpf, String senha, String nome, String email, String cidade, String estado, String bairro, String rua, String numero, String cep, String telefone, Observable pedido) {
        super(cpf, senha, id, nome, email, cidade, estado, bairro, rua, numero, cep, telefone);
        pedido.addObserver(this);
    }

    public Cliente(String nome, String email, String senha, String cpf, String telefone) {
        super(cpf, senha, nome, email, telefone);
    }

    public Cliente(int id, String cpf, String senha, String nome, String email, String telefone) {
        super(id, cpf, senha, nome, email, telefone);
    }

    public Cliente() {

    }

    public static Cliente getCliente(int id) throws ClassNotFoundException {
        try {
            return ClienteDAO.getCliente(id);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Cliente login(String email, String senha) {
        try {
            return ClienteDAO.login(email, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static boolean isLogado(HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("usuario");
        return cliente != null;
    }

    @Override
    public void update(Observable pedidoSubject, Object arg) {
        String novoEstado;
        if (pedidoSubject instanceof Pedido) {
            Pedido pedido = (Pedido) pedidoSubject;
            novoEstado = pedido.getEstado().getEstadoMensagem();
            String msg = "Olá, " + getNome() + ", o estado do seu pedido mudou. " + novoEstado + ".";
            System.out.println(msg);
            
            String msgEmail = "<h2 style='text-align:center; padding: 50px 20px'>Olá, " + getNome() + " </h2>";
            msgEmail += "<h3 style='text-align:center;'>O estado do seu pedido mudou.</h3><br/>";
            msgEmail += "<h2 style='text-align:center;'>" + novoEstado + "</h2>";
            Email email = new Email(this.getEmail(), "Status do Pedido " + pedido.getId(), msgEmail);
            email.enviarEmail();
        }
    }
}
