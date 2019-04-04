package action.pedido;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Pedido;
import model.Produto;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.PedidoDAO;

/**
 *
 * @author rslana
 */
public class CadastrarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pedido = request.getParameter("pedido");

        System.out.println("Pedido: " + pedido);

        JSONObject pedidoJSON = new JSONObject(pedido);

        HashMap<Integer, Integer> produtos = new HashMap<>();
        JSONArray produtosJSON = pedidoJSON.getJSONArray("produtos");
        for (int i = 0; i < produtosJSON.length(); i++) {
            produtos.put(produtosJSON.getJSONObject(i).getInt("id"), produtosJSON.getJSONObject(i).getInt("quantidade"));
        }
        
        System.out.println("Produtos: " + produtos);
        System.out.println("Restaurante ID: " + pedidoJSON.getInt("restaurante"));

//        try {
//            int clienteId = Integer.parseInt(request.getParameter("clienteId"));
//            Cliente cliente = Cliente.obterCliente(clienteId);

            Cliente cliente = new Cliente("123", "Senha", "Joaquim", "joaquim@gmail.com", "32999998888");

            for (Integer produtoId : produtos.keySet()) {
                int quantidade = produtos.get(produtoId);
                System.out.println("Produto " + produtoId + " quantidade: " + quantidade);

//                Produto produto = Produto.obterProduto(produtoId);
            }

//            Pedido pedido = new Pedido(44.55, cliente, produtos);
//            try {
//                PedidoDAO.getInstance().save(pedido);
//                request.setAttribute("mensagem", "Pedido realizado com sucesso!");
//                RequestDispatcher view = request.getRequestDispatcher("/mensagemSucesso.jsp");
//                view.forward(request, response);
//            } catch (SQLException ex) {
//                try {
//                    request.setAttribute("mensagem", "Erro ao tentar criar pedido");
//                    RequestDispatcher view = request.getRequestDispatcher("/mensagemErro.jsp");
//                    view.forward(request, response);
//                    ex.printStackTrace();
//                } catch (ServletException ex1) {
//                    Logger.getLogger(LerPedidoAction.class.getName()).log(Level.SEVERE, null, ex1);
//                }
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(GravarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ServletException ex) {
//                Logger.getLogger(GravarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(GravarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
