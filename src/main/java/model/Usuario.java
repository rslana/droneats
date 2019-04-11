package model;

/**
 *
 * @author raj
 */
public abstract class Usuario {

    private int id;
    private String nome;
    private String email;
    private String cidade;
    private String estado;
    private String bairro;
    private String rua;
    private String numero;
    private String cep;
    private String telefone;
    private String senha;
    private String cpf;

    public Usuario() {

    }

    public int getId() {
        return id;
    }

    public Usuario setId(int id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Usuario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public Usuario setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public Usuario setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public Usuario setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getRua() {
        return rua;
    }

    public Usuario setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Usuario setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public Usuario setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Usuario setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Usuario setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public abstract String getTipo();

    public String getInformacaoUsuario() {
        return "Tipo: " + getTipo() + " - Nome: " + getNome();
    }
}
