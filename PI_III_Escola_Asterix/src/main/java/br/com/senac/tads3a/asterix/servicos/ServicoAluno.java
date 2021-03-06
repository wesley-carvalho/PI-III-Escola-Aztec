package br.com.senac.tads3a.asterix.servicos;

import br.com.senac.tads3a.asterix.classes.Aluno;
import br.com.senac.tads3a.asterix.dao.DaoAluno;
import br.com.senac.tads3a.asterix.validadores.ValidadorAluno;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServicoAluno {

    public static void inserir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nome = request.getParameter("nome");
            String documento = request.getParameter("documento");
            String dtNascimento = request.getParameter("dtNascimento");
            String endereco = request.getParameter("endereco");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            String celular = request.getParameter("celular");
            String cadastradoPor = request.getParameter("cadastradoPor");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date data = new Date(sdf.parse(dtNascimento).getTime());

            Aluno aluno = new Aluno(nome, documento, data, endereco, cidade,
                    estado, email, telefone, celular, cadastradoPor);

            ValidadorAluno.validar(aluno);

            DaoAluno.inserir(aluno);

            response.sendRedirect(request.getContextPath() + "/success");
        } catch (ClassNotFoundException | IllegalArgumentException | SQLException | ParseException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    public static void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String documento = request.getParameter("documento");
            String dtNascimento = request.getParameter("dtNascimento");
            String endereco = request.getParameter("endereco");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            String celular = request.getParameter("celular");
            String cadastradoPor = request.getParameter("cadastradoPor");            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date nascimento = new Date(sdf.parse(dtNascimento).getTime());            

            Aluno aluno = new Aluno(id, nome, documento, nascimento, endereco, 
                    cidade, estado, email, telefone, celular, cadastradoPor);

            ValidadorAluno.validar(aluno);

            DaoAluno.atualizar(aluno);

            response.sendRedirect(request.getContextPath() + "/success");            
        } catch (ClassNotFoundException | IllegalArgumentException | SQLException | ParseException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    public static List<Aluno> procurar(String nomeAluno) {
        try {
            return DaoAluno.procurar(nomeAluno);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Aluno> listar() {
        try {
            return DaoAluno.listar();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Aluno obter(int id) {
        try {
            return DaoAluno.obter(id);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean excluir(int id) {
        try {
            DaoAluno.excluir(id);

            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
