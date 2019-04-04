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
public class Produto {

    private int id;
    private String descricao;
    private Double preco;
    private String imagem;

    private int restaurante_id;
    private Restaurante restaurante;
    private int promocao_id;
    private Promocao promocao;

    public Produto(String descricao, Double preco, String imagem, int restaurante_id, int promocao_id) {
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
        this.restaurante_id = restaurante_id;
        this.promocao_id = promocao_id;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

}
