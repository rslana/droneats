package action.usuario;

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
import model.Proprietario;
import model.Restaurante;
import persistence.ProprietarioDAO;
import persistence.RestauranteDAO;

/**
 *
 * @author raj
 */
public class LoginRestauranteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if (email.equals("") || senha.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                Proprietario proprietario = ProprietarioDAO.getInstance().login(email, senha);
                if (proprietario != null) {
                    Restaurante restaurante = RestauranteDAO.getInstance().getRestauranteProprietario(proprietario);
                    session.setAttribute("usuario", proprietario);
                    session.setAttribute("restaurante", restaurante);
                    session.setAttribute("permissao", proprietario.getClass().getSimpleName());
                    response.sendRedirect("FrontController?route=restaurante&action=Dashboard");
                } else {
                    request.setAttribute("mensagemErro", "Email ou senha inválido");
                    RequestDispatcher view = request.getRequestDispatcher("/auth/loginRestaurante.jsp");
                    view.forward(request, response);
                }
            } catch (ServletException ex) {
                Logger.getLogger(LoginClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginRestauranteAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LoginRestauranteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
