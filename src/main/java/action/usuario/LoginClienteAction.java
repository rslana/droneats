package action.usuario;

import controller.Action;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;

/**
 *
 * @author rslana
 */
public class LoginClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if (email.equals("") || senha.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                Cliente cliente = Cliente.login(email, senha);
                if (cliente != null) {
                    session.setAttribute("usuario", cliente);
                    session.setAttribute("permissao", cliente.getClass().getSimpleName());
                    response.sendRedirect("index.jsp");
                } else {
                    request.setAttribute("mensagemErro", "Email ou senha inválido");
                    RequestDispatcher view = request.getRequestDispatcher("/auth/loginCliente.jsp");
                    view.forward(request, response);
                }
            } catch (ServletException ex) {
                Logger.getLogger(LoginClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
