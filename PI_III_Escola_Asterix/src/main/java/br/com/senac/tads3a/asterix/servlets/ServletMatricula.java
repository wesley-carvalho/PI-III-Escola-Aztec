package br.com.senac.tads3a.asterix.servlets;

import br.com.senac.tads3a.asterix.classes.Matricula;
import br.com.senac.tads3a.asterix.servicos.ServicoMatricula;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletMatricula extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String context = request.getServletPath();
        RequestDispatcher rd;
        
        int matriculaID;
        Matricula matricula;
        List matriculas;

        switch (context) {
            case "/matricula_inserir":
                ServicoMatricula.inserir(request, response);
                break;
            case "/matricula_atualizar":
                ServicoMatricula.atualizar(request, response);
                break;
            case "/matricula_alterar":
                matriculaID = Integer.parseInt(request.getParameter("matriculaId"));

                matricula = ServicoMatricula.obter(matriculaID);

                if (matricula != null) {
                    request.setAttribute("matricula", matricula);
                } else {
                    response.sendRedirect(request.getContextPath() + "/error");
                }

                rd = request.getRequestDispatcher("/WEB-INF/jsp/alterar-matricula.jsp");
                rd.forward(request, response);
                break;
            case "/matricula_buscar":
                matriculaID = Integer.parseInt(request.getParameter("alunoId"));

                matriculas = ServicoMatricula.procurar(matriculaID);

                if (matriculas != null) {
                    request.setAttribute("matriculas", matriculas);
                } else {
                    request.setAttribute("msgErro", "Sua busca não gerou resultados!");
                }

                rd = request.getRequestDispatcher("/WEB-INF/jsp/manutencao-matriculas.jsp");
                rd.forward(request, response);
                break;                
            case "/matricula_listar":
                matriculas = ServicoMatricula.listar();

                if (matriculas != null) {
                    request.setAttribute("matriculas", matriculas);
                } else {
                    request.setAttribute("msgErro", "Sua busca não gerou resultados!");
                }

                rd = request.getRequestDispatcher("/WEB-INF/jsp/manutencao-matriculas.jsp");
                rd.forward(request, response);
                break;                
            case "/matricula_excluir":
                matriculaID = Integer.parseInt(request.getParameter("matriculaId"));

                boolean resp = ServicoMatricula.excluir(matriculaID);

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
