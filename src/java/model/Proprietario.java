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
public class Proprietario extends Pessoa {

    public Proprietario(String cpf, int id, String nome, String email, String senha, String cidade, String estado, String bairro, String rua, String numero, String cep, String telefone) {
        super(cpf, id, nome, email, senha, cidade, estado, bairro, rua, numero, cep, telefone);
    }
    
}
