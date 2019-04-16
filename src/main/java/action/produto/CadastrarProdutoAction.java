package action.produto;

import config.Config;
import controller.Action;
import controller.MainFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Categoria;
import model.Produto;
import model.Proprietario;
import model.promocao.Promocao;
import model.Restaurante;
import org.apache.commons.io.FilenameUtils;
import persistence.CategoriaDAO;
import persistence.ProdutoDAO;
import persistence.RestauranteDAO;
import s3.UploadFileAwsS3;

/**
 *
 * @author raj
 */
public class CadastrarProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        try {
            String nome = request.getParameter("nome");
            double preco = Double.parseDouble((request.getParameter("preco").equals("")) ? "-1" : request.getParameter("preco"));
            String descricao = request.getParameter("descricao");
            int categoriaId = Integer.parseInt(request.getParameter("categoriaId"));
            Part filePart = request.getPart("imagem");
            String promocaoTipo = request.getParameter("promocao"); // PromocaoUnitario / PromocaoCombo / vazio

            if (nome.equals("") || preco < 0 || descricao.equals("") || categoriaId <= 0) {
//                Redirecionar para página de erro
                response.sendRedirect("/restaurante/cadastrarProduto.jsp");
            } else {
                if (Proprietario.isLoggedIn(session)) {
                    Proprietario proprietario = (Proprietario) session.getAttribute("usuario");
                    Restaurante restaurante = RestauranteDAO.getInstance().getRestauranteProprietario(proprietario);
                    
                    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                    String fileNameUpload = createFileNameUpload(fileName);
                    String path = "uploads/produtos";

                    new File(path).mkdirs();

                    File uploadPath = new File(request.getServletContext().getRealPath(path));
                    File file = new File(uploadPath, fileNameUpload);
                    try (InputStream input = filePart.getInputStream()) {
                        Files.copy(input, file.toPath());
                    }

                    String imagemUrl;
                    if (Config.UPLOAD_WITH_AWS) {
                        String filePath = uploadPath.toString() + File.separator + fileNameUpload;
                        UploadFileAwsS3 uploadAws = new UploadFileAwsS3("droneats/produtos", filePath, fileNameUpload);
                        uploadAws.doUpload();
                        imagemUrl = "https://s3.us-east-2.amazonaws.com/droneats/produtos/" + fileNameUpload;
                    } else {
                        imagemUrl = path + File.separator + fileNameUpload;
                    }
                    
                    Promocao promocao = (Promocao) MainFactory.create(Promocao.class.getPackage().getName() + "." + promocaoTipo);
                    Categoria categoria = CategoriaDAO.getInstance().getCategoria(categoriaId);

                    Produto produto = new Produto(nome, descricao, preco, imagemUrl, restaurante, promocao, categoria);
                    ProdutoDAO.getInstance().save(produto);

                    request.setAttribute("mensagemSucesso", "Produto criado com sucesso!");
                    RequestDispatcher view = request.getRequestDispatcher("/restaurante/cadastrarProduto.jsp");
                    view.forward(request, response);
                }
            }
        } catch (ServletException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String createFileNameUpload(String fileName) {
        Calendar cal = Calendar.getInstance();
        String fileNameUpload = "PRODUTO-" + cal.get(Calendar.YEAR)
                + "-" + ((cal.get(Calendar.MONTH) < 9) ? "0" + (cal.get(Calendar.MONTH) + 1) : cal.get(Calendar.MONTH) + 1)
                + "-" + cal.get(Calendar.DAY_OF_MONTH)
                + "_" + cal.get(Calendar.HOUR_OF_DAY)
                + "-" + cal.get(Calendar.MINUTE)
                + "-" + cal.get(Calendar.SECOND)
                + "_" + cal.get(Calendar.MILLISECOND);

        fileNameUpload += "." + FilenameUtils.getExtension(fileName);

        return fileNameUpload;
    }
}
