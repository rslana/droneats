/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.restaurante;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import model.Restaurante;
import persistence.ProdutoDAO;
import persistence.RestauranteDAO;

/**
 *
 * @author rslana
 */
public class ExibirRestauranteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {      
            int restauranteId = Integer.parseInt(request.getParameter("id"));
            Restaurante restaurante = RestauranteDAO.getRestaurante(restauranteId);
            request.setAttribute("restaurante", restaurante);
            
            List<Produto> produtos = ProdutoDAO.listProdutosRestaurante(restaurante);
            request.setAttribute("produtos", produtos);
            
            RequestDispatcher view = request.getRequestDispatcher("/restaurante/restaurante.jsp");
            view.forward(request, response);
        } catch (ServletException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListarRestaurantesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
