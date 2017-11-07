package br.com.senac.tads3a.asterix.validadores;

import br.com.senac.tads3a.asterix.classes.Funcionario;

public class ValidadorFuncionario {

    public static void validar(Funcionario funcionario) throws IllegalArgumentException {
        if (funcionario == null) {
            throw new IllegalArgumentException("Não foi informado um funcionário");
        }
        if (funcionario.getNome() == null || funcionario.getNome().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar "
                    + "o nome do funcionário");
        }
        if (funcionario.getDocumento() == null || funcionario.getDocumento().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar um "
                    + "número de documento válido");
        }
        if (funcionario.getNascimento() == null || funcionario.getNascimento().toString().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar a "
                    + "data de nascimento do funcionário");
        }
        if (funcionario.getEndereco() == null || funcionario.getEndereco().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar o "
                    + "endereço do funcionário");
        }
        if (funcionario.getCidade() == null || funcionario.getCidade().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar uma "
                    + "cidade válida");
        }
        if (funcionario.getEstado() == null || funcionario.getEstado().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar um "
                    + "estado válido");
        }
        if (funcionario.getEmail()== null || funcionario.getEmail().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar um "
                    + "endereço de email válido");
        }
        if (funcionario.getCargo()== null || funcionario.getCargo().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar um "
                    + "cargo válido");
        }
        if (funcionario.getUsername()== null || funcionario.getUsername().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar um "
                    + "username válido");
        }
        if (funcionario.getHashSenha()== null || funcionario.getHashSenha().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar um "
                    + "senha válida");
        }
    }
}
