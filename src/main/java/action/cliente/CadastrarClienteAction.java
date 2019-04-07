package action.cliente;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import persistence.ClienteDAO;

/**
 *
 * @author raj
 */
public class CadastrarClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
//        String cidade = request.getParameter("cidade");
//        String estado = request.getParameter("estado");
//        String bairro = request.getParameter("bairro");
//        String rua = request.getParameter("rua");
//        String numero = request.getParameter("numero");
//        String cep = request.getParameter("cep");

        if (nome.equals("") || email.equals("") || senha.equals("") || cpf.equals("") || telefone.equals("")) {
            try {
                request.setAttribute("mensagemErro", "Você deve preencher todos os campos");
                RequestDispatcher view = request.getRequestDispatcher("/auth/cadastroCliente.jsp");
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(CadastrarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Cliente cliente = new Cliente(nome, email, senha, cpf, telefone);

            try {
                ClienteDAO.getInstance().save(cliente);
                request.setAttribute("mensagemSucesso", "Cadastro efetuado com sucesso!");
                RequestDispatcher view = request.getRequestDispatcher("/auth/cadastroCliente.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                try {
                    Logger.getLogger(CadastrarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("mensagemErro", "Erro ao tentar efetuar cadastro como cliente");
                    RequestDispatcher view = request.getRequestDispatcher("/auth/cadastroCliente.jsp");
                    view.forward(request, response);
                } catch (ServletException ex1) {
                    Logger.getLogger(CadastrarClienteAction.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } catch (ClassNotFoundException | ServletException ex) {
                Logger.getLogger(CadastrarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
