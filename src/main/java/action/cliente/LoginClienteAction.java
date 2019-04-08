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
import javax.servlet.http.HttpSession;
import model.Cliente;
import persistence.ClienteDAO;

/**
 *
 * @author raj
 */
public class LoginClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException {
        try {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            Cliente cliente = ClienteDAO.login(email, senha);
            if (cliente != null) {
                session.setAttribute("cliente", cliente);
                session.setAttribute("usuario", "cliente");
                RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                view.forward(request, response);
            } else {
                request.setAttribute("mensagemErro", "Usuário não encontrado");
                RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
                view.forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException | ServletException ex) {
            Logger.getLogger(LoginClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
