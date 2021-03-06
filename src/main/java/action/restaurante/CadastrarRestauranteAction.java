package action.restaurante;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Proprietario;
import model.Restaurante;
import persistence.ProprietarioDAO;
import persistence.RestauranteDAO;

/**
 *
 * @author raj
 */
public class CadastrarRestauranteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException {
        //Prorpietario
        String nomeProprietario = request.getParameter("nomeProprietario");
        String emailProprietario = request.getParameter("emailProprietario");
        String senhaProprietario = request.getParameter("senhaProprietario");
        String cpfProprietario = request.getParameter("cpfProprietario");
        String telefoneProprietario = request.getParameter("telefoneProprietario");

        //Restaurante
        String nomeRestaurante = request.getParameter("nomeRestaurante");
        String cnpjRestaurante = request.getParameter("cnpjRestaurante");
        String telefoneRestaurante = request.getParameter("telefoneRestaurante");
        String estadoRestaurante = request.getParameter("estadoRestaurante");
        String cidadeRestaurante = request.getParameter("cidadeRestaurante");
        String cepRestaurante = request.getParameter("cepRestaurante");
        String bairroRestaurante = request.getParameter("bairroRestaurante");
        String ruaRestaurante = request.getParameter("ruaRestaurante");
        String numeroRestaurante = request.getParameter("numeroRestaurante");
        String descricaoRestaurante = request.getParameter("descricaoRestaurante");

        if (nomeProprietario.equals("") || emailProprietario.equals("") || senhaProprietario.equals("") || cpfProprietario.equals("") || telefoneProprietario.equals("")) {
            try {
                request.setAttribute("mensagemErro", "Você deve preencher todos os campos");
                RequestDispatcher view = request.getRequestDispatcher("/auth/cadastroRestaurante.jsp");
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(CadastrarRestauranteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Proprietario proprietario = new Proprietario();
                proprietario.setNome(nomeProprietario)
                        .setEmail(emailProprietario)
                        .setSenha(senhaProprietario)
                        .setCpf(cpfProprietario)
                        .setTelefone(telefoneProprietario);
                ProprietarioDAO.getInstance().save(proprietario);

                proprietario.setId(ProprietarioDAO.getInstance().getLastProprietario().getId());
                
                Restaurante restaurante = new Restaurante(cnpjRestaurante,descricaoRestaurante,
                        nomeRestaurante,cidadeRestaurante,estadoRestaurante,bairroRestaurante,ruaRestaurante,
                        numeroRestaurante,cepRestaurante,telefoneRestaurante,proprietario);
                
                RestauranteDAO.getInstance().save(restaurante);
                
                request.setAttribute("mensagemSucesso", "Cadastro efetuado com sucesso!");
                RequestDispatcher view = request.getRequestDispatcher("/auth/cadastroRestaurante.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                try {
                    Logger.getLogger(CadastrarRestauranteAction.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("mensagemErro", "Erro ao tentar efetuar cadastro como restaurante");
                    RequestDispatcher view = request.getRequestDispatcher("/auth/cadastroRestaurante.jsp");
                    view.forward(request, response);
                } catch (ServletException ex1) {
                    Logger.getLogger(CadastrarRestauranteAction.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } catch (ClassNotFoundException | ServletException ex) {
                Logger.getLogger(CadastrarRestauranteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
