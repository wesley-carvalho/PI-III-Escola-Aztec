package br.com.senac.tads3a.asterix.servlets;

import br.com.senac.tads3a.asterix.classes.Aluno;
import br.com.senac.tads3a.asterix.servicos.ServicoAluno;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAluno extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String context = request.getServletPath();
        RequestDispatcher rd;

        int alunoID;
        Aluno aluno;
        List alunos;

        switch (context) {
            case "/aluno_inserir":
                ServicoAluno.inserir(request, response);
                break;
            case "/aluno_atualizar":
                ServicoAluno.atualizar(request, response);
                break;
            case "/aluno_alterar":
                alunoID = Integer.parseInt(request.getParameter("alunoId"));

                aluno = ServicoAluno.obter(alunoID);

                if (aluno != null) {
                    request.setAttribute("aluno", aluno);
                } else {
                    response.sendRedirect(request.getContextPath() + "/error");
                }

                rd = request.getRequestDispatcher("/WEB-INF/jsp/alterar-aluno.jsp");
                rd.forward(request, response);
                break;
            case "/aluno_buscar":
                String alunoNome = request.getParameter("nome");

                alunos = ServicoAluno.procurar(alunoNome);

                if (alunos != null) {
                    request.setAttribute("alunos", alunos);
                } else {
                    request.setAttribute("msgErro", "Sua busca não gerou resultados!");
                }

                rd = request.getRequestDispatcher("/WEB-INF/jsp/manutencao-alunos.jsp");
                rd.forward(request, response);
                break;
            case "/aluno_listar":
                alunos = ServicoAluno.listar();

                if (alunos != null) {
                    request.setAttribute("alunos", alunos);
                } else {
                    request.setAttribute("msgErro", "Sua busca não gerou resultados!");
                }

                rd = request.getRequestDispatcher("/WEB-INF/jsp/manutencao-alunos.jsp");
                rd.forward(request, response);
                break;
            case "/aluno_excluir":
                alunoID = Integer.parseInt(request.getParameter("alunoId"));

                boolean resp = ServicoAluno.excluir(alunoID);

                if (resp) {
                    response.sendRedirect(request.getContextPath() + "/success");
                } else {
                    response.sendRedirect(request.getContextPath() + "/error");
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }
}
