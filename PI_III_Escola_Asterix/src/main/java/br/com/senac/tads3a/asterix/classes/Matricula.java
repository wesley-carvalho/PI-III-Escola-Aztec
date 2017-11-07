package br.com.senac.tads3a.asterix.classes;

import java.sql.Date;

public class Matricula {

    private Integer id;
    private Aluno aluno;
    private Unidade unidade;
    private Curso curso;
    private Date inicio;
    private String pagamento;
    private Date cadastro;

    public Matricula() {

    }

    public Matricula(Aluno aluno, Unidade unidade, Curso curso, Date inicio, String pagamento) {
        this.aluno = aluno;
        this.unidade = unidade;
        this.curso = curso;
        this.inicio = inicio;
        this.pagamento = pagamento;
    }

    public Matricula(Integer id, Aluno aluno, Unidade unidade, Curso curso, Date inicio, String pagamento, Date cadastro) {
        this.id = id;
        this.aluno = aluno;
        this.unidade = unidade;
        this.curso = curso;
        this.inicio = inicio;
        this.pagamento = pagamento;
        this.cadastro = cadastro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }    
}
