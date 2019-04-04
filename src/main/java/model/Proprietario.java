/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ariel
 */
public class Proprietario extends Usuario {

    public Proprietario(String cpf, String senha, int id, String nome, String email, String cidade, String estado, String bairro, String rua, String numero, String cep, String telefone) {
        super(cpf, senha, id, nome, email, cidade, estado, bairro, rua, numero, cep, telefone);
    }

    public Proprietario(String nome, String email, String senha, String cpf, String telefone) {
        super(cpf, senha, nome, email, telefone);
    }
    
    public Proprietario(int id, String nome, String email, String senha, String cpf, String telefone) {
        super(id, cpf, senha, nome, email, telefone);
    }
}
