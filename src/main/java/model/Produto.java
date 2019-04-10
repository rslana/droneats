package model;

import model.promocao.Promocao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.ProdutoDAO;

/**
 *
 * @author raj
 */
public class Produto {

    private int id;
    private String nome;
    private String descricao;
    private Double preco;
    private String imagem;

    private int restauranteId;
    private Restaurante restaurante;
    private int categoriaId;
    private Categoria categoria;

    private Promocao promocao;

    public Produto(String nome, String descricao, Double preco, String imagem, Restaurante restaurante, Promocao promocao, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
        this.restaurante = restaurante;
        this.promocao = promocao;
        this.categoria = categoria;
    }

    public Produto(int id, String nome, String descricao, Double preco, String imagem, Restaurante restaurante, Categoria categoria, Promocao promocao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
        this.restaurante = restaurante;
        this.categoria = categoria;
        this.promocao = promocao;
    }

    public Produto(int id, String nome, String descricao, Double preco, String imagem, Restaurante restaurante) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
        this.restaurante = restaurante;
    }

    public Produto() {

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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
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

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }
    
    public int obterDesconto() {
        return promocao.obterDesconto();
    }
    
    public String obterPromocao() {
        return promocao.obterPromocao();
    }

    public double calcularDesconto() {
        double desconto = (this.getPromocao() != null) ? this.getPromocao().obterDesconto() : 0;
        return this.getPreco() - this.getPreco() * desconto / 100;
    }
}
