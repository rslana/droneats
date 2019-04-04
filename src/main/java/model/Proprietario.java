/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.ProprietarioDAO;

/**
 *
 * @author raj
 */
public class Proprietario extends Usuario {

    public Proprietario(int id, String cpf, String senha, String nome, String email, String cidade, String estado, String bairro, String rua, String numero, String cep, String telefone) {
        super(cpf, senha, id, nome, email, cidade, estado, bairro, rua, numero, cep, telefone);
    }

    public Proprietario(String nome, String email, String senha, String cpf, String telefone) {
        super(cpf, senha, nome, email, telefone);
    }

    public Proprietario(int id, String nome, String email, String senha, String cpf, String telefone) {
        super(id, cpf, senha, nome, email, telefone);
    }

    public static Proprietario getProprietario(int id) throws ClassNotFoundException {
        try {
            return ProprietarioDAO.getProprietario(id);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
