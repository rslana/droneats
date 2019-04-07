package action.cliente;

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
import model.Cliente;
import model.Pedido;
import persistence.PedidoDAO;

/**
 *
 * @author raj
 */
public class ListarPedidosAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Cliente cliente = Cliente.getCliente(999);
            ArrayList<Pedido> pedidos = PedidoDAO.listPedidosCliente(cliente);

            request.setAttribute("pedidos", pedidos);
            
            RequestDispatcher view = request.getRequestDispatcher("/cliente/pedidos.jsp");
            view.forward(request, response);
            
        } catch (ClassNotFoundException | SQLException | ServletException ex) {
            Logger.getLogger(ListarPedidosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
