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
public class Restaurante extends Usuario {
    private int id;
    private String cnpj;
    private String descricao;

    private int proprietario_id;
    private Proprietario proprietario;

    public Restaurante(String cnpj, String descricao, int proprietario_id, int id, String nome, String email, String cidade, String estado, String bairro, String rua, String numero, String cep, String telefone) {
        super(id, nome, email, cidade, estado, bairro, rua, numero, cep, telefone);
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.proprietario_id = proprietario_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getProprietario_id() {
        return proprietario_id;
    }

    public void setProprietario_id(int proprietario_id) {
        this.proprietario_id = proprietario_id;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
