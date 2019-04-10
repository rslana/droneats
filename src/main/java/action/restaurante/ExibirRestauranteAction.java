package action.restaurante;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Produto;
import model.Proprietario;
import model.Restaurante;
import persistence.ProdutoDAO;
import persistence.RestauranteDAO;

/**
 *
 * @author raj
 */
public class ExibirRestauranteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        try {
            if (Proprietario.isLoggedIn(session)) {
                response.sendRedirect("FrontController?route=restaurante&action=Dashboard");
            } else {
                int restauranteId = Integer.parseInt(request.getParameter("id"));
                Restaurante restaurante = RestauranteDAO.getInstance().getRestaurante(restauranteId);
                request.setAttribute("restaurante", restaurante);

                List<Produto> produtos = ProdutoDAO.getInstance().listProdutosRestaurante(restaurante);
                
                HashMap<Integer, ArrayList<Produto>> produtosByCategoria = ProdutoDAO.getInstance().listProdutosRestauranteByCategoria(restaurante);
                
                request.setAttribute("produtos", produtos);
                request.setAttribute("produtosByCategoria", produtosByCategoria);

                RequestDispatcher view = request.getRequestDispatcher("/restaurante/restaurante.jsp");
                view.forward(request, response);
            }
        } catch (ServletException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListarRestaurantesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
