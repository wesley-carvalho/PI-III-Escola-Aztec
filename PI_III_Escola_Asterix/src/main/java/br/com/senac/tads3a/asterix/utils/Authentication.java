package br.com.senac.tads3a.asterix.utils;

import br.com.senac.tads3a.asterix.classes.Funcionario;
import br.com.senac.tads3a.asterix.servicos.ServicoFuncionario;
import java.util.LinkedHashMap;
import java.util.Map;

public class Authentication {

    private static final Map<String, Funcionario> USUARIOS_CADASTRADOS;

    static {
        USUARIOS_CADASTRADOS = new LinkedHashMap<>();
        USUARIOS_CADASTRADOS.put("admin", new Funcionario("admin", "diretor", "admin", "admin"));
    }

    public static Funcionario autenticar(String username, String senha) {

        Funcionario funcionario;

        // 1) Verifica se username existe no banco de dados
        if ((funcionario = ServicoFuncionario.obterUser(username)) != null) {
            // 2) Verifica se senha esta correta
            if (senha != null && funcionario.verificarSenha(senha)) {
                return funcionario;
            }
        } // 1) Verifica se username existe na memoria
        else if ((funcionario = USUARIOS_CADASTRADOS.get(username)) != null) {
            // 2) Verifica se senha esta correta
            if (senha != null && funcionario.verificarSenha(senha)) {
                return funcionario;
            }
        }
        // Usuario nao existe ou senha esta incorreta
        return null;
    }
}
