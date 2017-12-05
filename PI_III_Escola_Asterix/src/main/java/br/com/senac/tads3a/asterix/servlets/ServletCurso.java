package br.com.senac.tads3a.asterix.servlets;

import br.com.senac.tads3a.asterix.classes.Curso;
import br.com.senac.tads3a.asterix.servicos.ServicoCurso;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCurso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String context = request.getServletPath();
        RequestDispatcher rd;
        
        int cursoID;
        Curso curso;
        List cursos;

        switch (context) {
            case "/curso_inserir":
                ServicoCurso.inserir(request, response);
                break;
            case "/curso_atualizar":
                ServicoCurso.atualizar(request, response);
                break;
            case "/curso_alterar":
                cursoID = Integer.parseInt(request.getParameter("cursoId"));
                
                curso = ServicoCurso.obter(cursoID);
                
                if(curso != null){
                    request.setAttribute("curso", curso);
                }else{
                    response.sendRedirect(request.getContextPath() + "/error");
                }
                
                rd = request.getRequestDispatcher("/WEB-INF/jsp/alterar-curso.jsp");
                rd.forward(request, response);
                break;
            case "/curso_buscar":
                String nomeCurso = request.getParameter("nome");

                cursos = ServicoCurso.procurar(nomeCurso);

                if (cursos != null) {
                    request.setAttribute("cursos", cursos);
                } else {
                    request.setAttribute("msgErro", "Sua busca não gerou resultados!");
                }

                rd = request.getRequestDispatcher("/WEB-INF/jsp/manutencao-cursos.jsp");
                rd.forward(request, response);
                break;
            case "/curso_listar":
                cursos = ServicoCurso.listar();

                if (cursos != null) {
                    request.setAttribute("cursos", cursos);
                } else {
                    request.setAttribute("msgErro", "Sua busca não gerou resultados!");
                }

                rd = request.getRequestDispatcher("/WEB-INF/jsp/manutencao-cursos.jsp");
                rd.forward(request, response);
                break;
            case "/curso_excluir":
                cursoID = Integer.parseInt(request.getParameter("id"));

                boolean resp = ServicoCurso.excluir(cursoID);

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
