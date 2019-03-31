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
public class Cliente extends Pessoa{

    public Cliente(String cpf, String senha, int id, String nome, String email, String cidade, String estado, String bairro, String rua, String numero, String cep, String telefone) {
        super(cpf, senha, id, nome, email, cidade, estado, bairro, rua, numero, cep, telefone);
    }

    public Cliente(String cpf, String senha, String nome, String email, String telefone) {
        super(cpf, senha, nome, email, telefone);
    }

    public Cliente(String cpf, String senha, int id, String nome, String email, String telefone) {
        super(cpf, senha, id, nome, email, telefone);
    }
    
    
}
