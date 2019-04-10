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
public class PrepararAlterarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        int pedidoId = Integer.parseInt(request.getParameter("id"));

        try {
            if (Proprietario.isLoggedIn(session)) {
                Proprietario proprietario = (Proprietario) session.getAttribute("usuario");
                Restaurante restaurante = RestauranteDAO.getInstance().getRestauranteProprietario(proprietario);

                Pedido pedido = PedidoDAO.getInstance().getPedidoRestaurante(pedidoId, restaurante);

                if (pedido != null) {
                    ArrayList<PedidoProduto> produtos;
                    produtos = PedidoProdutoDAO.getInstance().listProdutosPedido(pedido);

                    pedido.setProdutos(produtos);
                    request.setAttribute("pedido", pedido);
                    RequestDispatcher view = request.getRequestDispatcher("/restaurante/editarPedido.jsp");
                    view.forward(request, response);
                } else {
                    response.sendRedirect("FrontController?route=restaurante&action=ListarProdutos");
                }

            }
        } catch (ClassNotFoundException | SQLException | ServletException ex) {
            Logger.getLogger(PrepararAlterarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
