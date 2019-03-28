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
public class Restaurante extends Usuario{
    private String cnpj;
    private String String;

    public Restaurante(String cnpj, String String, int id, String nome, String email, String senha, String cidade, String estado, String bairro, String rua, String numero, String cep, String telefone) {
        super(id, nome, email, senha, cidade, estado, bairro, rua, numero, cep, telefone);
        this.cnpj = cnpj;
        this.String = String;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getString() {
        return String;
    }

    public void setString(String String) {
        this.String = String;
    }
    
}
