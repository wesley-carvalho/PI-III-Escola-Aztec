package br.com.senac.tads3a.asterix.validadores;

import br.com.senac.tads3a.asterix.classes.Aluno;

public class ValidadorAluno {

    public static void validar(Aluno aluno) throws IllegalArgumentException {
        if (aluno == null) {
            throw new IllegalArgumentException("Não foi informado um aluno");
        }
        if (aluno.getNome() == null || aluno.getNome().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar "
                    + "o nome do aluno");
        }
        if (aluno.getDocumento() == null || aluno.getDocumento().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar um "
                    + "número de documento válido");
        }
        if (aluno.getNascimento() == null || aluno.getNascimento().toString().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar a "
                    + "data de nascimento do aluno");
        }
        if (aluno.getEndereco() == null || aluno.getEndereco().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar o "
                    + "endereço do aluno");
        }
        if (aluno.getCidade() == null || aluno.getCidade().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar uma "
                    + "cidade válida");
        }
        if (aluno.getEstado() == null || aluno.getEstado().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar um "
                    + "estado válido");
        }
        if (aluno.getEmail()== null || aluno.getEmail().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar o "
                    + "email do aluno");
        }
        if (aluno.getTelefone() == null || aluno.getTelefone().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar o "
                    + "telefone do aluno");
        }
    }
}
