/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ariel
 */
public class Categoria {

    private int id;
    private String nome;
    private ArrayList<Produto> ofertas;

    private int restaurante_id;
    private Restaurante restaurante;

    public Categoria() {
    }

    public Categoria(String nome, int restaurante_id) {
        this.nome = nome;
        this.restaurante_id = restaurante_id;
    }

    public int getRestaurante_id() {
        return restaurante_id;
    }

    public void setRestaurante_id(int restaurante_id) {
        this.restaurante_id = restaurante_id;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Produto> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Produto> ofertas) {
        this.ofertas = ofertas;
    }

}
