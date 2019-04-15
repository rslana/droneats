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
import model.Email;
import model.Pedido;
import model.PedidoProduto;
import model.Produto;
import model.Restaurante;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.PedidoDAO;
import persistence.PedidoProdutoDAO;
import persistence.ProdutoDAO;
import persistence.RestauranteDAO;

/**
 *
 * @author raj
 */
public class CadastrarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        try {
            if (Cliente.isLoggedIn(session)) {
                Cliente cliente = (Cliente) session.getAttribute("usuario");
                String pedidoJS = request.getParameter("pedido");
                JSONObject pedidoJSON = new JSONObject(pedidoJS);
                int restauranteId = Integer.parseInt(pedidoJSON.getString("restaurante"));

                Restaurante restaurante = RestauranteDAO.getInstance().getRestaurante(restauranteId);

                JSONArray produtosJSON = pedidoJSON.getJSONArray("produtos");

                double valorTotal = 0;
                PedidoProduto pedidoProduto;
                Produto produto;
                ArrayList<PedidoProduto> produtos = new ArrayList<>();
                for (int i = 0; i < produtosJSON.length(); i++) {
                    int quantidade = produtosJSON.getJSONObject(i).getInt("quantidade");
                    int produtoId = Integer.parseInt(produtosJSON.getJSONObject(i).getString("id"));

                    produto = ProdutoDAO.getInstance().getProdutoRestaurante(produtoId, restaurante);

                    if (produto == null) {
                        request.setAttribute("error", "Ocorreu um erro. Não foi possível concluir seu pedido.");
                        RequestDispatcher view = request.getRequestDispatcher("FrontController?route=restaurante&action=ExibirRestaurante&id="+restauranteId);
                        view.forward(request, response);
                    }

                    valorTotal += (quantidade * produto.calcularDesconto());
                    pedidoProduto = new PedidoProduto(null, produto, quantidade, produto.calcularDesconto());
                    produtos.add(pedidoProduto);
                }
                
                Pedido pedido = new Pedido(valorTotal, cliente, restaurante);
                PedidoDAO.getInstance().save(pedido);
                pedido.setId(PedidoDAO.getInstance().getLastPedido().getId());

                for(PedidoProduto pD : produtos) {
                    pD.setPedido(pedido);
                    PedidoProdutoDAO.getInstance().save(pD);
                }

                pedido.setProdutos(produtos);
                
                String msgEmail = "<h2 style='text-align:center; padding: 50px 20px'>Olá, " + cliente.getNome() + " </h2>";
                msgEmail += "<h3 style='text-align:center;'>Você acabou de fazer um pedido no Droneats.</h3><br/>";
                msgEmail += "<h2 style='text-align:center;'>" + pedido.getEstado().getEstadoMensagem() + "</h2>";
                Email email = new Email(cliente.getEmail(), "Status do Pedido " + pedido.getId(), msgEmail);
                email.enviarEmail();

                request.setAttribute("mensagemSucesso", "Pedido realizado com sucesso!");
                request.setAttribute("pedido", pedido);

                RequestDispatcher view = request.getRequestDispatcher("/cliente/pedido.jsp");
                view.forward(request, response);
            } else {
                request.setAttribute("mensagemErro", "Você precisa estar logado para fazer um pedido!");
                RequestDispatcher view = request.getRequestDispatcher("/auth/loginCliente.jsp");
                view.forward(request, response);
            }

        } catch (ClassNotFoundException | SQLException | ServletException ex) {
            Logger.getLogger(CadastrarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
