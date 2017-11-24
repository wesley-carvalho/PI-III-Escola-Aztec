package br.com.senac.tads3a.asterix.servicos;

import br.com.senac.tads3a.asterix.classes.Funcionario;
import br.com.senac.tads3a.asterix.dao.DaoFuncionario;
import br.com.senac.tads3a.asterix.validadores.ValidadorFuncionario;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServicoFuncionario {

    public static void inserir(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String nome = request.getParameter("nome");
            String documento = request.getParameter("documento");
            String dtNascimento = request.getParameter("dtNascimento");
            String endereco = request.getParameter("endereco");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String email = request.getParameter("email");
            String cargo = request.getParameter("cargo");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date nascimento = new Date(sdf.parse(dtNascimento).getTime());

            Funcionario funcionario = new Funcionario(nome, documento, nascimento, endereco, cidade, estado, email, cargo, username, password);

            ValidadorFuncionario.validar(funcionario);

            DaoFuncionario.inserir(funcionario);

            response.sendRedirect(request.getContextPath() + "/success");
        } catch (ClassNotFoundException | IllegalArgumentException | SQLException | ParseException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    public static void atualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String documento = request.getParameter("documento");
            String dtNascimento = request.getParameter("dtNascimento");
            String endereco = request.getParameter("endereco");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String email = request.getParameter("email");
            String cargo = request.getParameter("cargo");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String dtCadastro = request.getParameter("cadastro");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date nascimento = new Date(sdf.parse(dtNascimento).getTime());
            Date cadastro = new Date(sdf.parse(dtCadastro).getTime());

            Funcionario funcionario = new Funcionario(id, nome, documento, nascimento, endereco, cidade, estado, email, cargo, username, password, cadastro);

            ValidadorFuncionario.validar(funcionario);

            DaoFuncionario.atualizar(funcionario);

            response.sendRedirect(request.getContextPath() + "/success");
        } catch (ClassNotFoundException | IllegalArgumentException | SQLException | ParseException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    public static List<Funcionario> procurar(String nomeFunc) {
        try {
            return DaoFuncionario.procurar(nomeFunc);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Funcionario> listar() {
        try {
            return DaoFuncionario.listar();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Funcionario obter(int id) {
        try {
            return DaoFuncionario.obter(id);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Funcionario obterUser(String username) {
        try {
            return DaoFuncionario.obterUser(username);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean excluir(int id) {
        try {
            DaoFuncionario.excluir(id);

            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
