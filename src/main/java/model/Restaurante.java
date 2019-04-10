package model;

import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.RestauranteDAO;

/**
 *
 * @author raj
 */
public class Restaurante implements Observer {

    private int id;
    private String cnpj;
    private String descricao;
    private String nome;
    private String cidade;
    private String estado;
    private String bairro;
    private String rua;
    private String numero;
    private String cep;
    private String telefone;

    private int proprietarioId;
    private Proprietario proprietario;

    public Restaurante() {
    }

    public Restaurante(int id, String cnpj, String descricao, String nome, String cidade, String estado, String bairro, String rua, String numero, String cep, String telefone, Proprietario proprietario) {
        this.id = id;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.telefone = telefone;
        this.proprietario = proprietario;
    }

    public Restaurante(int id, String cnpj, String descricao, String nome, String cidade, String estado, String bairro, String rua, String numero, String cep, String telefone, Proprietario proprietario,Observable pedido) {
        this.id = id;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.telefone = telefone;
        this.proprietario = proprietario;
        pedido.addObserver(this);
    }
    
    public Restaurante(String cnpj, String descricao, String nome, String cidade, String estado, String bairro, String rua, String numero, String cep, String telefone, Proprietario proprietario) {
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.telefone = telefone;
        this.proprietario = proprietario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getProprietarioId() {
        return proprietarioId;
    }

    public void setProprietarioId(int proprietarioId) {
        this.proprietarioId = proprietarioId;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public void update(Observable pedidoSubject, Object arg) {
        String novoEstado;
        if (pedidoSubject instanceof Pedido) {
            Pedido pedido = (Pedido) pedidoSubject;
            if (pedido.getEstado().getEstado().equals("Cancelado")) {
                novoEstado = pedido.getEstado().getEstadoMensagem();
                String msg = "Olá, " + getNome() + ", o cliente " + pedido.getCliente().getNome() + " alterou o estado do pedido " + pedido.getId() + " para " + novoEstado + ".";
                System.out.println(msg);
                String assunto = "Pedido " + pedido.getId() + " - " + pedido.getCliente().getNome();
                Email email = new Email(this.getProprietario().getEmail(), assunto, "<h2 style='text-align:center; padding: 50px 20px'>" + msg + "</h2>");
                email.enviarEmail();
            }
        }
    }
}
