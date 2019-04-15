package action.pedido;

import controller.Action;
import controller.MethodFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
public class AlterarPedidoEstadoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));
        String estado = request.getParameter("estadoPedido");

        try {
            if (Proprietario.isLoggedIn(session)) {
                Proprietario proprietario = (Proprietario) session.getAttribute("usuario");
                Restaurante restaurante = RestauranteDAO.getInstance().getRestauranteProprietario(proprietario);

                Pedido pedido = PedidoDAO.getInstance().getPedidoRestaurante(pedidoId, restaurante);

                if (pedido != null) {
                    Method method = MethodFactory.create("set" + estado, pedido);
                    String mensagem = (String) method.invoke(pedido, pedido);

                    Pedido novoPedido = PedidoDAO.getInstance().getPedido(pedidoId);
                    ArrayList<PedidoProduto> produtos;
                    produtos = PedidoProdutoDAO.getInstance().listProdutosPedido(novoPedido);

                    novoPedido.setProdutos(produtos);

                    request.setAttribute("mensagem", mensagem);
                    request.setAttribute("pedido", novoPedido);
                    RequestDispatcher view = request.getRequestDispatcher("/restaurante/editarPedido.jsp");
                    view.forward(request, response);
                } else {
                    response.sendRedirect("FrontController?route=restaurante&action=ListarPedidos");
                }
            }
        } catch (ClassNotFoundException | SQLException | ServletException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(AlterarPedidoEstadoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
