/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.Pedido;
import model.PedidoProduto;
import model.pedidoestado.PedidoEstado;
import model.pedidoestado.PedidoEstadoFactory;
import persistence.PedidoDAO;
import persistence.PedidoProdutoDAO;

/**
 *
 * @author raj
 */
public class AlterarPedidoEstadoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));
        String estado = request.getParameter("estadoPedido");

        try {
            Pedido pedido = Pedido.getPedido(pedidoId);

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

            PedidoDAO.getInstance().updateEstado(pedido);
            
            Pedido novoPedido = Pedido.getPedido(pedidoId);
            ArrayList<PedidoProduto> produtos;
            produtos = PedidoProdutoDAO.listProdutosPedido(novoPedido);
            
            novoPedido.setProdutos(produtos);
//            
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("pedido", novoPedido);
            RequestDispatcher view = request.getRequestDispatcher("/restaurante/editarPedido.jsp");
            view.forward(request, response);

        } catch (ClassNotFoundException | SQLException | ServletException ex) {
            Logger.getLogger(AlterarPedidoEstadoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
