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
public abstract class Pessoa extends Usuario {

    private String cpf;
    private String senha;

    public Pessoa(String cpf, String senha, int id, String nome, String email, String cidade, String estado, String bairro, String rua, String numero, String cep, String telefone) {
        super(id, nome, email, cidade, estado, bairro, rua, numero, cep, telefone);
        this.cpf = cpf;
        this.senha = senha;
    }

    public Pessoa(String cpf, String senha, String nome, String email, String telefone) {
        super(nome, email, telefone);
        this.cpf = cpf;
        this.senha = senha;
    }

    public Pessoa(String cpf, String senha, int id, String nome, String email, String telefone) {
        super(id, nome, email, telefone);
        this.cpf = cpf;
        this.senha = senha;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
