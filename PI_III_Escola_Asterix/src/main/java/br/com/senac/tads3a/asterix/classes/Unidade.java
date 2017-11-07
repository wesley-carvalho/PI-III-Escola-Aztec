package br.com.senac.tads3a.asterix.classes;

import java.sql.Date;

public class Unidade {

    private int id;
    private String nome;
    private String endereco;
    private String cidade;
    private String estado;
    private String email;
    private String telefone1;
    private String telefone2;
    private Date cadastro;

    public Unidade() {
    }

    public Unidade(String nome, String endereco, String cidade,
            String estado, String email, String telefone1, String telefone2) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
    }

    public Unidade(int id, String nome, String endereco, String cidade, String estado, String email, String telefone1, String telefone2, Date cadastro) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.cadastro = cadastro;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }
}
