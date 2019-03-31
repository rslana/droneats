/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.restaurante;

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
            System.out.println("Precço " + preco);
            if (nome.equals("") || preco < 0 || descricao.equals("") || categoriaId.equals("")) {
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

                String databaseURL_S3 = "https://s3.us-east-2.amazonaws.com/droneats/produtos/" + fileNameUpload;
                String databaseURL_LOCAL = path + File.separator + fileNameUpload;
                
                //Cria o produto e insere no banco
                Produto produto = null;

            }
        } catch (ServletException ex) {
            Logger.getLogger(CadastrarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String createFileNameUpload(String fileName) {
        Calendar hoje = Calendar.getInstance();
        String fileNameUpload = "PRODUTO-" + hoje.get(Calendar.YEAR)
                + "-" + (hoje.get(Calendar.MONTH) + 1)
                + "-" + hoje.get(Calendar.DAY_OF_MONTH)
                + "_" + hoje.get(Calendar.HOUR_OF_DAY)
                + "-" + hoje.get(Calendar.MINUTE)
                + "-" + hoje.get(Calendar.SECOND)
                + "_" + hoje.get(Calendar.MILLISECOND);

        fileNameUpload += "." + FilenameUtils.getExtension(fileName);

        return fileNameUpload;
    }
}
