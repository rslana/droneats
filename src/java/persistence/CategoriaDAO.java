/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import model.Categoria;

/**
 *
 * @author ariel
 */
public class CategoriaDAO {
    private static CategoriaDAO instance = new CategoriaDAO();
    public static CategoriaDAO getInstance(){
        return instance;
    }
    private CategoriaDAO(){
    }
    public void save (Categoria categoria) throws SQLException, ClassNotFoundException{
        
    Connection conn = DatabaseLocator.getInstance().getConnection();  
        Statement st = conn.createStatement();
    
           
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
                st.execute("insert into categoria (nome, email, senha, telefone, cpf)" +
                        " values ('" + categoria.getNome() + 
                        "', '" + categoria.getEmail()+
                        "','"+categoria.getSenha()+
                        "','"+categoria.getTelefone()+
                        "','"+categoria.getCpf()+"')");
            } catch(SQLException e) {
                throw e;
            } finally {
               closeResources(conn,st);
                    
                }
    }

    public void apagarCategoria (String email) throws SQLException, ClassNotFoundException{
        
    Connection conn = DatabaseLocator.getInstance().getConnection();  
        Statement st = conn.createStatement();
    
           
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
                st.execute("Delete from categoria where email= '"+email+"'");
            } catch(SQLException e) {
                throw e;
            } finally {
               closeResources(conn,st);
                    
                }
            }

    public void closeResources(Connection conn, Statement st){
        try {
                    if(st!=null) st.close();
                    if(conn!=null) conn.close();
                    
                } catch(SQLException e) {
                    
                }
        
    }
}
