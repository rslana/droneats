package action.pedido;

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
import model.Pedido;
import model.PedidoProduto;
import persistence.PedidoProdutoDAO;

/**
 *
 * @author raj
 */
public class PrepararAlterarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int pedidoId = Integer.parseInt(request.getParameter("id"));
        
        try {
            Pedido pedido = Pedido.getPedido(pedidoId);
            
            ArrayList<PedidoProduto> produtos;
            produtos = PedidoProdutoDAO.listProdutosPedido(pedido);
            
            pedido.setProdutos(produtos);
            request.setAttribute("pedido", pedido);
            
            RequestDispatcher view = request.getRequestDispatcher("/restaurante/editarPedido.jsp");
            view.forward(request, response);
            
        } catch (ClassNotFoundException | SQLException | ServletException ex) {
            Logger.getLogger(PrepararAlterarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
