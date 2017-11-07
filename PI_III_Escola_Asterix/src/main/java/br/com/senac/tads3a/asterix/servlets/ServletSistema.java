package br.com.senac.tads3a.asterix.servlets;

import br.com.senac.tads3a.asterix.servicos.ServicoAluno;
import br.com.senac.tads3a.asterix.servicos.ServicoCurso;
import br.com.senac.tads3a.asterix.servicos.ServicoMatricula;
import br.com.senac.tads3a.asterix.servicos.ServicoUnidade;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletSistema extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String context = request.getServletPath();
        RequestDispatcher rd;

        switch (context) {
            case "/home":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/menu-principal.jsp");
                rd.forward(request, response);
                break;
            case "/cadastrar-aluno":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/cadastrar-aluno.jsp");
                rd.forward(request, response);
                break;
            case "/cadastrar-curso":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/cadastrar-curso.jsp");
                rd.forward(request, response);
                break;
            case "/cadastrar-funcionario":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/cadastrar-funcionario.jsp");
                rd.forward(request, response);
                break;
            case "/cadastrar-unidade":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/cadastrar-unidade.jsp");
                rd.forward(request, response);
                break;
            case "/manutencao-alunos":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/manutencao-alunos.jsp");
                rd.forward(request, response);
                break;
            case "/manutencao-cursos":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/manutencao-cursos.jsp");
                rd.forward(request, response);
                break;
            case "/manutencao-funcionarios":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/manutencao-funcionarios.jsp");
                rd.forward(request, response);
                break;
            case "/manutencao-matriculas":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/manutencao-matriculas.jsp");
                rd.forward(request, response);
                break;
            case "/manutencao-unidades":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/manutencao-unidades.jsp");
                rd.forward(request, response);
                break;
            case "/matricular":
                request.setAttribute("alunos", ServicoAluno.listar());
                request.setAttribute("unidades", ServicoUnidade.listar());
                request.setAttribute("cursos", ServicoCurso.listar());

                rd = request.getRequestDispatcher("/WEB-INF/jsp/matricular.jsp");
                rd.forward(request, response);
                break;
            case "/relatorio":
                request.setAttribute("matriculas", ServicoMatricula.listar());

                rd = request.getRequestDispatcher("/WEB-INF/jsp/relatorio.jsp");
                rd.forward(request, response);
                break;
            case "/success":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/success.jsp");
                rd.forward(request, response);
                break;
            case "/warning":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/warning.jsp");
                rd.forward(request, response);
                break;
            case "/blocked":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/blocked.jsp");
                rd.forward(request, response);
                break;
            case "/error":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
                rd.forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
