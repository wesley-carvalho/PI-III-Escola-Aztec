package br.com.senac.tads3a.asterix.validadores;

import br.com.senac.tads3a.asterix.classes.Matricula;

public class ValidadorMatricula {

    public static void validar(Matricula matricula) throws IllegalArgumentException {
        if (matricula.getAluno() == null) {
            throw new IllegalArgumentException("Não foi informado um aluno");
        }
        if (matricula.getUnidade() == null) {
            throw new IllegalArgumentException("Não foi informado uma unidade");
        }
        if (matricula.getCurso() == null) {
            throw new IllegalArgumentException("Não foi informado um curso");
        }
        if (matricula.getInicio() == null || matricula.getInicio().toString().isEmpty()) {
            throw new IllegalArgumentException("Não foi informado uma data de inicio");
        }
        if (matricula.getPagamento() == null || matricula.getPagamento().isEmpty()) {
            throw new IllegalArgumentException("Não foi informado uma forma de pagamento");
        }
    }
}
