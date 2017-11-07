package br.com.senac.tads3a.asterix.validadores;

import br.com.senac.tads3a.asterix.classes.Unidade;

public class ValidadorUnidade {

    public static void validar(Unidade unidade) throws IllegalArgumentException {
        if (unidade == null) {
            throw new IllegalArgumentException("Não foi informado uma unidade");
        }
        if (unidade.getNome() == null || unidade.getNome().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar "
                    + "o nome da unidade");
        }
        if (unidade.getEndereco() == null || unidade.getEndereco().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar um "
                    + "endereço válido");
        }
        if (unidade.getCidade() == null || unidade.getCidade().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar uma "
                    + "cidade válida");
        }
        if (unidade.getEstado() == null || unidade.getEstado().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar um "
                    + "Estado válido");
        }
        if (unidade.getEmail() == null || unidade.getEmail().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar um "
                    + "email válido");
        }
        if (unidade.getTelefone1() == null || unidade.getTelefone1().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar o "
                    + "telefone 1 da unidade");
        }
        if (unidade.getTelefone2() == null || unidade.getTelefone2().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar o "
                    + "telefone 2 da unidade");
        }
    }
}
