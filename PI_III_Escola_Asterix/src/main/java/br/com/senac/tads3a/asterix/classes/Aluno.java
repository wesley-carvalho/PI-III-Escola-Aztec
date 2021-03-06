package br.com.senac.tads3a.asterix.classes;

import java.util.Date;

public class Aluno {

    private int id;
    private String nome;
    private String documento;
    private Date nascimento;
    private String endereco;
    private String cidade;
    private String estado;
    private String email;
    private String telefone;
    private String celular;
    private String cadastradoPor;
    private Date cadastradoEm;

    public Aluno() {

    }

    public Aluno(String nome, String documento, Date nascimento, String endereco, String cidade, String estado, String email, String telefone, String celular, String cadastradoPor) {
        this.nome = nome;
        this.documento = documento;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.cadastradoPor = cadastradoPor;
    }

    public Aluno(int id, String nome, String documento, Date nascimento, String endereco, String cidade, String estado, String email, String telefone, String celular, String cadastradoPor) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.cadastradoPor = cadastradoPor;        
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCadastradoPor() {
        return cadastradoPor;
    }

    public void setCadastradoPor(String cadastradoPor) {
        this.cadastradoPor = cadastradoPor;
    }

    public Date getCadastradoEm() {
        return cadastradoEm;
    }

    public void setCadastradoEm(Date cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
    }    
}
