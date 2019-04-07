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
import model.Categoria;
import model.Restaurante;
import persistence.CategoriaDAO;

/**
 *
 * @author raj
 */
public class PrepararCadastrarProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Restaurante restaurante = Restaurante.getRestaurante(999);
            ArrayList<Categoria> categorias = CategoriaDAO.listCategoriasRestaurante(restaurante);
            
            request.setAttribute("categorias", categorias);
            
            RequestDispatcher view = request.getRequestDispatcher("/restaurante/cadastrarProduto.jsp");
            view.forward(request, response);
            
        } catch (ClassNotFoundException | SQLException | ServletException ex) {
            Logger.getLogger(PrepararCadastrarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
}
