package br.com.senac.tads3a.asterix.classes;

import java.math.BigDecimal;
import java.sql.Date;

public class Curso {

    private int id;
    private String nome;
    private String categoria;
    private String descricao;
    private BigDecimal valor;
    private Date cadastro;

    public Curso() {

    }

    public Curso(String nome, String categoria, String descricao,
            BigDecimal valor) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Curso(int id, String nome, String categoria, String descricao, BigDecimal valor, Date cadastro) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }
}
