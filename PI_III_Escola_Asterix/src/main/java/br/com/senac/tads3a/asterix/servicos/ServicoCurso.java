package br.com.senac.tads3a.asterix.servicos;

import br.com.senac.tads3a.asterix.classes.Curso;
import br.com.senac.tads3a.asterix.dao.DaoCurso;
import br.com.senac.tads3a.asterix.validadores.ValidadorCurso;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServicoCurso {

    public static void inserir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nome = request.getParameter("nome");
            String categoria = request.getParameter("categoria");
            String descricao = request.getParameter("descricao");
            String valor = request.getParameter("valor");
            String cadastradoPor = request.getParameter("cadastradoPor");

            Curso curso = new Curso(nome, categoria, descricao, new BigDecimal(valor), cadastradoPor);

            ValidadorCurso.validar(curso);

            DaoCurso.inserir(curso);

            response.sendRedirect(request.getContextPath() + "/success");
        } catch (ClassNotFoundException | IllegalArgumentException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    public static void atualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String categoria = request.getParameter("categoria");
            String descricao = request.getParameter("descricao");
            String valor = request.getParameter("valor");
            String cadastradoPor = request.getParameter("cadastradoPor");            

            Curso curso = new Curso(id, nome, categoria, descricao, new BigDecimal(valor), cadastradoPor);

            ValidadorCurso.validar(curso);

            DaoCurso.atualizar(curso);

            response.sendRedirect(request.getContextPath() + "/success");
        } catch (ClassNotFoundException | IllegalArgumentException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    public static List<Curso> procurar(String nomeCurso) {
        try {
            return DaoCurso.procurar(nomeCurso);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Curso> listar() {
        try {
            return DaoCurso.listar();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Curso obter(int id) {
        try {
            return DaoCurso.obter(id);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean excluir(int id) {
        try {
            DaoCurso.excluir(id);

            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
