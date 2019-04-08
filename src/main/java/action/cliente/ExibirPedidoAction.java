package action.cliente;

import action.pedido.PrepararAlterarPedidoAction;
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
public class ExibirPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        int pedidoId = Integer.parseInt(request.getParameter("id"));

        try {
            if (Cliente.isLogado(session)) {
                Cliente cliente = (Cliente) session.getAttribute("usuario");
                Pedido pedido = PedidoDAO.getPedidoCliente(pedidoId, cliente);

                if (pedido != null) {
                    ArrayList<PedidoProduto> produtos;
                    produtos = PedidoProdutoDAO.listProdutosPedido(pedido);

                    pedido.setProdutos(produtos);
                    request.setAttribute("pedido", pedido);

                    RequestDispatcher view = request.getRequestDispatcher("/cliente/pedido.jsp");
                    view.forward(request, response);
                } else {
                    response.sendRedirect("FrontController?route=cliente&action=ListarPedidos");
                }

            }
        } catch (ClassNotFoundException | SQLException | ServletException ex) {
            Logger.getLogger(PrepararAlterarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
