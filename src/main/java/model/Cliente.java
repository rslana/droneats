package model;

import java.util.Observable;
import java.util.Observer;
import javax.servlet.http.HttpSession;

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

    public Cliente(String nome, String email, String senha, String cpf, String cidade, String estado, String bairro, String rua, String numero, String cep, String telefone) {
        super(nome, email, senha, cpf, cidade, estado, bairro, rua, numero, cep, telefone);
    }

    public Cliente(int id, String cpf, String senha, String nome, String email, String telefone) {
        super(id, cpf, senha, nome, email, telefone);
    }

    public Cliente() {

    }

    public static boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("usuario") instanceof Cliente;
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

    @Override
    public String getTipo() {
        return "Cliente";
    }

}
