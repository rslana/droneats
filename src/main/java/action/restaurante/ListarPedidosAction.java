package action.restaurante;

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
import javax.servlet.http.HttpSession;
import model.Pedido;
import model.PedidoProduto;
import model.Proprietario;
import model.Restaurante;
import persistence.PedidoDAO;
import persistence.PedidoProdutoDAO;
import persistence.RestauranteDAO;

/**
 *
 * @author raj
 */
public class ListarPedidosAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        try {
            if (Proprietario.isLoggedIn(session)) {
                Proprietario proprietario = (Proprietario) session.getAttribute("usuario");
                Restaurante restaurante = RestauranteDAO.getInstance().getRestauranteProprietario(proprietario);
                
                ArrayList<Pedido> pedidos = PedidoDAO.getInstance().listPedidosRestaurante(restaurante);
                ArrayList<PedidoProduto> produtos;
                for (Pedido pedido : pedidos) {
                    produtos = PedidoProdutoDAO.getInstance().listProdutosPedido(pedido);
                    pedido.setProdutos(produtos);
                }

                request.setAttribute("pedidos", pedidos);

                RequestDispatcher view = request.getRequestDispatcher("/restaurante/pedidos.jsp");
                view.forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException | ServletException ex) {
            Logger.getLogger(action.restaurante.ListarPedidosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
