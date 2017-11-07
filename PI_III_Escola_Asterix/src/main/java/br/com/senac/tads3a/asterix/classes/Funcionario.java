package br.com.senac.tads3a.asterix.classes;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public final class Funcionario {

    private int id;
    private String nome;
    private String documento;
    private Date nascimento;
    private String endereco;
    private String cidade;
    private String estado;
    private String email;
    private String cargo;
    private String username;
    private String hashSenha;
    private Date cadastro;

    public Funcionario() {
    }

    public Funcionario(String nome, String cargo, String username, String senha) {
        this.nome = nome;
        this.cargo = cargo;
        this.username = username;
        setSenha(senha);
    }

    public Funcionario(String nome, String documento, Date nascimento, 
            String endereco, String cidade, String estado, String email, 
            String cargo, String username, String senha) {
        this.nome = nome;
        this.documento = documento;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.cargo = cargo;
        this.username = username;
        setSenha(senha);
    }

    public Funcionario(int id, String nome, String documento, Date nascimento, 
            String endereco, String cidade, String estado, String email, 
            String cargo, String username, String senha, Date cadastro) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.cargo = cargo;
        this.username = username;
        setSenha(senha);
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(String hashSenha) {
        this.hashSenha = hashSenha;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    public void setSenha(String senhaAberta) {
        this.hashSenha = BCrypt.hashpw(senhaAberta, BCrypt.gensalt());
    }

    public boolean verificarSenha(String senhaAberta) {
        return BCrypt.checkpw(senhaAberta, hashSenha);
    }

    public boolean temPapel(String papel) {
        List<String> papeis = null;
        switch (this.cargo) {
            case "assistente de retaguarda":
                papeis = Arrays.asList("assistente de retaguarda");
                break;
            case "assistente de vendas":
                papeis = Arrays.asList("assistente de vendas");
                break;
            case "assistente de ti":
                papeis = Arrays.asList("assistente de ti");
                break;
            case "gerente de retaguarda":
                papeis = Arrays.asList("assistente de retaguarda", 
                                        "gerente de retaguarda");
                break;
            case "gerente de vendas":
                papeis = Arrays.asList("assistente de vendas", 
                                        "gerente de vendas");
                break;
            case "gerente de ti":
                papeis = Arrays.asList("assistente de ti", 
                                        "gerente de ti");
                break;
            case "diretor":
                papeis = Arrays.asList("assistente de retaguarda", 
                                        "assistente de vendas", 
                                        "assistente de ti", 
                                        "gerente de retaguarda", 
                                        "gerente de vendas", 
                                        "gerente de ti", 
                                        "diretor");
                break;
        }
        return papeis.contains(papel);
    }
}
