package br.com.senac.tads3a.asterix.utils;

import br.com.senac.tads3a.asterix.classes.Funcionario;

public class Authorization {

    public static boolean autorizacao(Funcionario funcionario, String funcionalidade) {
        switch (funcionalidade) {
            case "/cadastrar-aluno":
                if (funcionario.temPapel("assistente de vendas")) {
                    return true;
                }
                break;
            case "/cadastrar-curso":
                if (funcionario.temPapel("assistente de retaguarda")) {
                    return true;
                }
                break;
            case "/cadastrar-funcionario":
                if (funcionario.temPapel("assistente de ti")) {
                    return true;
                }
                break;
            case "/cadastrar-unidade":
                if (funcionario.temPapel("assistente de retaguarda")) {
                    return true;
                }
                break;
            case "/aluno_alterar":
                if (funcionario.temPapel("gerente de vendas")) {
                    return true;
                }
                break;
            case "/curso_alterar":
                if (funcionario.temPapel("gerente de retaguarda")) {
                    return true;
                }
                break;
            case "/funcionario_alterar":
                if (funcionario.temPapel("gerente de ti")) {
                    return true;
                }
                break;
            case "/matricula_alterar":
                if (funcionario.temPapel("gerente de ti")
                        || funcionario.temPapel("gerente de vendas")
                        || funcionario.temPapel("gerente de retaguarda")) {
                    return true;
                }
                break;
            case "/unidade_alterar":
                if (funcionario.temPapel("gerente de retaguarda")) {
                    return true;
                }
                break;
            case "/aluno_excluir":
                if (funcionario.temPapel("gerente de vendas")) {
                    return true;
                }
                break;
            case "/curso_excluir":
                if (funcionario.temPapel("gerente de retaguarda")) {
                    return true;
                }
                break;
            case "/funcionario_excluir":
                if (funcionario.temPapel("gerente de ti")) {
                    return true;
                }
                break;
            case "/matricula_excluir":
                if (funcionario.temPapel("gerente de ti")
                        || funcionario.temPapel("gerente de vendas")
                        || funcionario.temPapel("gerente de retaguarda")) {
                    return true;
                }
                break;
            case "/unidade_excluir":
                if (funcionario.temPapel("gerente de retaguarda")) {
                    return true;
                }
                break;
            case "/manutencao-alunos":
                if (funcionario.temPapel("assistente de vendas")) {
                    return true;
                }
                break;
            case "/manutencao-cursos":
                if (funcionario.temPapel("assistente de retaguarda")) {
                    return true;
                }
                break;
            case "/manutencao-funcionarios":
                if (funcionario.temPapel("assistente de ti")) {
                    return true;
                }
                break;
            case "/manutencao-matriculas":
                if (funcionario.temPapel("gerente de vendas")
                        || funcionario.temPapel("gerente de ti")) {
                    return true;
                }
                break;
            case "/manutencao-unidades":
                if (funcionario.temPapel("assistente de retaguarda")) {
                    return true;
                }
                break;
            case "/matricular":
                if (funcionario.temPapel("assistente de vendas")) {
                    return true;
                }
                break;
            case "/relatorio":
                if (funcionario.temPapel("gerente de ti")
                        || funcionario.temPapel("gerente de vendas")
                        || funcionario.temPapel("gerente de retaguarda")) {
                    return true;
                }
                break;
        }
        return false;
    }
}
