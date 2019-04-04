package action.usuario;

import controller.Action;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rslana
 */
public class LoginAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if (email.equals("") || senha.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                if (true) {
//                usuario = usuario.findByEmailAndSenha(email, senha);
//                session.setAttribute("usuario", usuario);
//                session.setAttribute("permissao", "ADMIN");
                } else {

                    request.setAttribute("msgErro", "Email ou senha inválido");
                    RequestDispatcher view = request.getRequestDispatcher("/lerCliente.jsp");
                    view.forward(request, response);

                }
            } catch (ServletException ex) {
                Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
