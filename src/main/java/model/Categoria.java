/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.CategoriaDAO;

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

    public static Categoria getCategoria(int id) throws ClassNotFoundException {
        try {
            return CategoriaDAO.getCategoria(id);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
