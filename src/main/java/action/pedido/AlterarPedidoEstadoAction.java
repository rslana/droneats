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
public class AlterarPedidoEstadoAction implements Action {
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));
        String estado = request.getParameter("estadoPedido");
        
        try {
            if (Proprietario.isLogado(session)) {
                Proprietario proprietario = (Proprietario) session.getAttribute("usuario");
                Restaurante restaurante = RestauranteDAO.getRestauranteProprrietario(proprietario);
                
                Pedido pedido = PedidoDAO.getPedidoRestaurante(pedidoId, restaurante);
                
                if (pedido != null) {
                    String mensagem;
                    switch (estado) {
                        case "Processando":
                            mensagem = pedido.setProcessando(pedido);
                            break;
                        case "Preparando":
                            mensagem = pedido.setPreparando(pedido);
                            break;
                        case "Entregando":
                            mensagem = pedido.setEntregando(pedido);
                            break;
                        case "Entregue":
                            mensagem = pedido.setEntregue(pedido);
                            break;
                        case "Cancelado":
                            mensagem = pedido.setCancelado(pedido);
                            break;
                        default:
                            mensagem = null;
                    }
                    
                    Pedido novoPedido = Pedido.getPedido(pedidoId);
                    ArrayList<PedidoProduto> produtos;
                    produtos = PedidoProdutoDAO.listProdutosPedido(novoPedido);
                    
                    novoPedido.setProdutos(produtos);
                    
                    request.setAttribute("mensagem", mensagem);
                    request.setAttribute("pedido", novoPedido);
                    RequestDispatcher view = request.getRequestDispatcher("/restaurante/editarPedido.jsp");
                    view.forward(request, response);
                } else {
                    response.sendRedirect("FrontController?route=restaurante&action=ListarPedidos");
                }
            }
        } catch (ClassNotFoundException | SQLException | ServletException ex) {
            Logger.getLogger(AlterarPedidoEstadoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
