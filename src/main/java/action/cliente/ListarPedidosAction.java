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
public class ListarPedidosAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        try {
            if (Cliente.isLoggedIn(session)) {
                Cliente cliente = (Cliente) session.getAttribute("usuario");
                ArrayList<Pedido> pedidos = PedidoDAO.listPedidosCliente(cliente);

                ArrayList<PedidoProduto> produtos;
                for (Pedido pedido : pedidos) {
                    produtos = PedidoProdutoDAO.listProdutosPedido(pedido);
                    pedido.setProdutos(produtos);
                }

                request.setAttribute("pedidos", pedidos);

                RequestDispatcher view = request.getRequestDispatcher("/cliente/pedidos.jsp");
                view.forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException | ServletException ex) {
            Logger.getLogger(ListarPedidosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
