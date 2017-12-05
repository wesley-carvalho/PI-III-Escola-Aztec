package br.com.senac.tads3a.asterix.servlets;

import br.com.senac.tads3a.asterix.classes.Unidade;
import br.com.senac.tads3a.asterix.servicos.ServicoUnidade;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUnidade extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String context = request.getServletPath();
        RequestDispatcher rd;
        
        int unidadeID;
        Unidade unidade;
        List unidades;

        switch (context) {
            case "/unidade_inserir":
                ServicoUnidade.inserir(request, response);
                break;
            case "/unidade_atualizar":
                ServicoUnidade.atualizar(request, response);
                break;
            case "/unidade_alterar":
                unidadeID = Integer.parseInt(request.getParameter("unidadeId"));
                
                unidade = ServicoUnidade.obter(unidadeID);
                
                if(unidade != null){
                    request.setAttribute("unidade", unidade);
                }else{
                    response.sendRedirect(request.getContextPath() + "/error");
                }
                
                rd = request.getRequestDispatcher("/WEB-INF/jsp/alterar-unidade.jsp");
                rd.forward(request, response);
                break;
            case "/unidade_buscar":
                String nomeUnidade = request.getParameter("nome");

                unidades = ServicoUnidade.procurar(nomeUnidade);

                if (unidades != null) {
                    request.setAttribute("unidades", unidades);
                } else {
                    request.setAttribute("msgErro", "Sua busca não gerou resultados!");
                }

                rd = request.getRequestDispatcher("/WEB-INF/jsp/manutencao-unidades.jsp");
                rd.forward(request, response);
                break;
            case "/unidade_listar":
                unidades = ServicoUnidade.listar();

                if (unidades != null) {
                    request.setAttribute("unidades", unidades);
                } else {
                    request.setAttribute("msgErro", "Sua busca não gerou resultados!");
                }

                rd = request.getRequestDispatcher("/WEB-INF/jsp/manutencao-unidades.jsp");
                rd.forward(request, response);
                break;
            case "/unidade_excluir":
                unidadeID = Integer.parseInt(request.getParameter("id"));

                boolean resp = ServicoUnidade.excluir(unidadeID);

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
