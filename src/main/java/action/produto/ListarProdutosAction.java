package action.produto;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import model.Restaurante;
import persistence.ProdutoDAO;

/**
 *
 * @author raj
 */
public class ListarProdutosAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            // Pegar Restaurante da sessão
            Restaurante restaurante = Restaurante.getRestaurante(999);
            ArrayList<Produto> produtos = ProdutoDAO.listProdutosRestaurante(restaurante);
            
            request.setAttribute("produtos", produtos);

            RequestDispatcher view = request.getRequestDispatcher("/restaurante/produtos.jsp");
            view.forward(request, response);
            
        } catch (ClassNotFoundException | SQLException | ServletException ex) {
            Logger.getLogger(action.restaurante.ListarPedidosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
