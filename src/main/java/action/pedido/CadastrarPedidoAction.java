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
import model.Cliente;
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
 * @author rslana
 */
public class CadastrarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String pedidoJS = request.getParameter("pedido");
//            System.out.println("Pedido: " + pedidoJS);

            JSONObject pedidoJSON = new JSONObject(pedidoJS);

            Cliente cliente = new Cliente();
            cliente.setId(999);

            int restauranteId = Integer.parseInt(pedidoJSON.getString("restaurante"));

            Restaurante restaurante = RestauranteDAO.getRestaurante(restauranteId);

            JSONArray produtosJSON = pedidoJSON.getJSONArray("produtos");

            double valorTotal = 0;
            for (int i = 0; i < produtosJSON.length(); i++) {
                int quantidade = produtosJSON.getJSONObject(i).getInt("quantidade");
                double preco = Double.parseDouble(produtosJSON.getJSONObject(i).getString("preco"));
                valorTotal += (quantidade * preco);
            }

            Pedido pedido = new Pedido(valorTotal, cliente, restaurante);
            PedidoDAO.getInstance().save(pedido);

            pedido.setId(PedidoDAO.getInstance().getLastPedido().getId());
            PedidoProduto pedidoProduto = null;

            Produto produto = null;

            ArrayList<PedidoProduto> produtos = new ArrayList<>();
            for (int i = 0; i < produtosJSON.length(); i++) {
                int id = Integer.parseInt(produtosJSON.getJSONObject(i).getString("id"));
                int quantidade = produtosJSON.getJSONObject(i).getInt("quantidade");
                double preco = Double.parseDouble(produtosJSON.getJSONObject(i).getString("preco"));
                produto = ProdutoDAO.getProduto(id);
                pedidoProduto = new PedidoProduto(pedido, produto, quantidade, preco);
                produtos.add(pedidoProduto);
                PedidoProdutoDAO.getInstance().save(pedidoProduto);
            }

            pedido.setProdutos(produtos);

            request.setAttribute("mensagemSucesso", "Pedido realizado com sucesso!");
            request.setAttribute("pedido", pedido);

//            response.sendRedirect('FrontController');
            
            RequestDispatcher view = request.getRequestDispatcher("/cliente/pedido.jsp");
            view.forward(request, response);

        } catch (ClassNotFoundException | SQLException | ServletException ex) {
            Logger.getLogger(CadastrarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
