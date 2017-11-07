package br.com.senac.tads3a.asterix.validadores;

import br.com.senac.tads3a.asterix.classes.Curso;

public class ValidadorCurso {

    public static void validar(Curso curso) throws IllegalArgumentException {
        if (curso == null) {
            throw new IllegalArgumentException("Não foi informado um curso");
        }
        if (curso.getNome() == null || "".equals(curso.getNome())) {
            throw new IllegalArgumentException("É necessário informar um "
                    + "nome para o curso");
        }
        if (curso.getCategoria() == null || "".equals(curso.getCategoria())) {
            throw new IllegalArgumentException("É necessário informar uma "
                    + "categoria para o curso");
        }
        if (curso.getValor() == null || curso.getValor().toString().isEmpty()) {
            throw new IllegalArgumentException("É necessário informar um "
                    + "valor para o curso");
        }
    }
}
