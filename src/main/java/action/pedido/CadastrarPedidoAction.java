package action.pedido;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
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

            Pedido pedido = new Pedido(0.00, cliente, restaurante);
            PedidoDAO.getInstance().save(pedido);

            pedido.setId(PedidoDAO.getInstance().getLastPedido().getId());

            JSONArray produtosJSON = pedidoJSON.getJSONArray("produtos");

            PedidoProduto pedidoProduto = null;

            Produto produto = new Produto();

            for (int i = 0; i < produtosJSON.length(); i++) {
                int id = Integer.parseInt(produtosJSON.getJSONObject(i).getString("id"));
                int quantidade = produtosJSON.getJSONObject(i).getInt("quantidade");
                double preco = Double.parseDouble(produtosJSON.getJSONObject(i).getString("preco"));

                produto.setId(id);
                pedidoProduto = new PedidoProduto(pedido, produto, quantidade, preco);

                PedidoProdutoDAO.getInstance().save(pedidoProduto);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
