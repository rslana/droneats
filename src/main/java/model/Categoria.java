package model;

import java.util.ArrayList;

/**
 *
 * @author raj
 */
public class Categoria {

    private int id;
    private String nome;
    private ArrayList<Produto> produtos;

    private int restauranteId;
    private Restaurante restaurante;

    public Categoria() {
    }

    public Categoria(int id, String nome, Restaurante restaurante) {
        this.id = id;
        this.nome = nome;
        this.restaurante = restaurante;
    }

    public Categoria(String nome, Restaurante restaurante) {
        this.nome = nome;
        this.restaurante = restaurante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(int restauranteId) {
        this.restauranteId = restauranteId;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
}
