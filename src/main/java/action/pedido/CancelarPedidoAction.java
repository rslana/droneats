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
import model.Cliente;
import model.Pedido;
import model.PedidoProduto;
import persistence.PedidoDAO;
import persistence.PedidoProdutoDAO;

/**
 *
 * @author raj
 */
public class CancelarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));

        try {
            if (Cliente.isLoggedIn(session)) {
                Cliente cliente = (Cliente) session.getAttribute("usuario");

                Pedido pedido = PedidoDAO.getInstance().getPedidoCliente(pedidoId, cliente);

                String mensagem = pedido.setCancelado(pedido);

                Pedido novoPedido = PedidoDAO.getInstance().getPedido(pedidoId);
                ArrayList<PedidoProduto> produtos;
                produtos = PedidoProdutoDAO.getInstance().listProdutosPedido(novoPedido);

                novoPedido.setProdutos(produtos);

                request.setAttribute("mensagem", mensagem);
                request.setAttribute("pedido", novoPedido);
                RequestDispatcher view = request.getRequestDispatcher("/cliente/pedido.jsp");
                view.forward(request, response);
            }

        } catch (ClassNotFoundException | SQLException | ServletException ex) {
            Logger.getLogger(AlterarPedidoEstadoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
