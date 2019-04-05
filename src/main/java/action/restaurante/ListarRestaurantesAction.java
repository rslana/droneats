/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import persistence.RestauranteDAO;

/**
 *
 * @author raj
 */
public class ListarRestaurantesAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {          
            request.setAttribute("restaurantes", RestauranteDAO.getRestaurantes());
            RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
            view.forward(request, response);
        } catch (ServletException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListarRestaurantesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
