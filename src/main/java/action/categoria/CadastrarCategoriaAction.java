/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.categoria;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.Restaurante;
import persistence.CategoriaDAO;

/**
 *
 * @author rslana
 */
public class CadastrarCategoriaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");

        Categoria categoria = null;
        if (nome.equals("")) {
            response.sendRedirect("restaurante/cadastrarCategoria.jsp");
        } else {
            //Pegar ID do restaurante na sessão
            Restaurante restaurante = new Restaurante();
            restaurante.setId(1);
            categoria = new Categoria(nome, restaurante);
            
            try {
                CategoriaDAO.getInstance().save(categoria);
                request.setAttribute("mensagemSucesso", "Categoria criada com sucesso!");
                RequestDispatcher view = request.getRequestDispatcher("/restaurante/cadastrarCategoria.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {

                try {
                    request.setAttribute("mensagem", "Erro ao tentar criar categoria");
                    RequestDispatcher view = request.getRequestDispatcher("/mensagemErro.jsp");
                    view.forward(request, response);
                    ex.printStackTrace();
                } catch (ServletException ex1) {
                    Logger.getLogger(CadastrarCategoriaAction.class.getName()).log(Level.SEVERE, null, ex1);
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CadastrarCategoriaAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ServletException ex) {
                Logger.getLogger(CadastrarCategoriaAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
