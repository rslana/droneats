package action.restaurante;

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
import persistence.CategoriaDAO;
import persistence.PedidoDAO;
import persistence.ProdutoDAO;
import persistence.RestauranteDAO;

/**
 *
 * @author raj
 */
public class DashboardAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        try {
            if (Proprietario.isLoggedIn(session)) {
                Proprietario proprietario = (Proprietario) session.getAttribute("usuario");
                Restaurante restaurante = RestauranteDAO.getInstance().getRestauranteProprietario(proprietario);
                int quantidadePedidos = PedidoDAO.getInstance().countPedidosRestaurante(restaurante);
                int quantidadeProdutos = ProdutoDAO.getInstance().countProdutosRestaurante(restaurante);
                int quantidadeCategorias = CategoriaDAO.getInstance().countCategoriasRestaurante(restaurante);
                
                request.setAttribute("quantidadePedidos", quantidadePedidos);
                request.setAttribute("quantidadeProdutos", quantidadeProdutos);
                request.setAttribute("quantidadeCategorias", quantidadeCategorias);
                RequestDispatcher view = request.getRequestDispatcher("/restaurante/dashboard.jsp");
                view.forward(request, response);
            } else {
                request.setAttribute("restaurantes", RestauranteDAO.getInstance().getRestaurantes());
                RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                view.forward(request, response);
            }
        } catch (ServletException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListarRestaurantesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
