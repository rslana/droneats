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
 * @author raj
 */
public class CadastrarCategoriaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        Categoria categoria;

        if (nome.equals("")) {
            try {
                request.setAttribute("mensagemErro", "Você deve preencher todos os campos");
                RequestDispatcher view = request.getRequestDispatcher("/restaurante/cadastrarCategoria.jsp");
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(CadastrarCategoriaAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                //Pegar restaurante na sessão
                Restaurante restaurante = Restaurante.getRestaurante(999);
                categoria = new Categoria(nome, restaurante);

                CategoriaDAO.getInstance().save(categoria);
                request.setAttribute("mensagemSucesso", "Categoria criada com sucesso!");
                RequestDispatcher view = request.getRequestDispatcher("/restaurante/cadastrarCategoria.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                try {
                    request.setAttribute("mensagemErro", "Erro ao tentar criar categoria");
                    RequestDispatcher view = request.getRequestDispatcher("/restaurante/cadastrarCategoria.jsp");
                    view.forward(request, response);
                } catch (ServletException ex1) {
                    Logger.getLogger(CadastrarCategoriaAction.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } catch (ClassNotFoundException | ServletException ex) {
                Logger.getLogger(CadastrarCategoriaAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
