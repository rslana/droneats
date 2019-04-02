/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.produto;

import controller.Action;
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
import javax.servlet.http.Part;
import model.Produto;
import model.Promocao;
import model.PromocaoCombo;
import model.PromocaoUnitario;
import model.Restaurante;
import org.apache.commons.io.FilenameUtils;
import persistence.ProdutoDAO;
import s3.UploadFileAwsS3;

/**
 *
 * @author rslana
 */
public class CadastrarProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String nome = request.getParameter("nome");
            double preco = Double.parseDouble((request.getParameter("preco").equals("")) ? "-1" : request.getParameter("preco"));
            String descricao = request.getParameter("descricao");
            String categoriaId = request.getParameter("categoriaId");
            Part filePart = request.getPart("imagem");
            String promocaoTipo = null; // unitario / combo / null

            if (nome.equals("") || preco < 0 || descricao.equals("") || categoriaId.equals("")) {
//                Redirecionar para página de erro
                response.sendRedirect("index.jsp");
            } else {
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                String fileNameUpload = createFileNameUpload(fileName);
                String path = "uploads/produtos";

                new File(path).mkdirs();

                File uploadPath = new File(request.getServletContext().getRealPath(path));
                File file = new File(uploadPath, fileNameUpload);
                try (InputStream input = filePart.getInputStream()) {
                    Files.copy(input, file.toPath());
                }

                String filePath = uploadPath.toString() + File.separator + fileNameUpload;

                UploadFileAwsS3 uploadAws = new UploadFileAwsS3("droneats/produtos", filePath, fileNameUpload);
                uploadAws.doUpload();

                String imagemS3 = "https://s3.us-east-2.amazonaws.com/droneats/produtos/" + fileNameUpload;
                String imagemLocal = path + File.separator + fileNameUpload;
                
                Promocao promocao = null;
                if (promocaoTipo.equals("unitario")) {
                    promocao = new PromocaoUnitario();
                } else if (promocaoTipo.equals("combo")) {
                    promocao = new PromocaoCombo();
                }

                //Pegar restaurante na sessão
                Restaurante restaurante = new Restaurante();
                restaurante.setId(1);
                
                Produto produto = new Produto(nome, descricao, preco, imagemLocal, restaurante, promocao);
                
                ProdutoDAO.getInstance().save(produto);
                
                request.setAttribute("mensagemSucesso", "Produto criado com sucesso!");
                RequestDispatcher view = request.getRequestDispatcher("/restaurante/cadastrarProduto.jsp");
                view.forward(request, response);
                
            }
        } catch (ServletException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String createFileNameUpload(String fileName) {
        String fileNameUpload = "PRODUTO-" + Calendar.YEAR
                + "-" + ((Calendar.MONTH < 9) ? "0" + (Calendar.MONTH + 1) : Calendar.MONTH + 1)
                + "-" + Calendar.DAY_OF_MONTH
                + "_" + Calendar.HOUR_OF_DAY
                + "-" + Calendar.MINUTE
                + "-" + Calendar.SECOND
                + "_" + Calendar.MILLISECOND;

        fileNameUpload += "." + FilenameUtils.getExtension(fileName);

        return fileNameUpload;
    }
}
