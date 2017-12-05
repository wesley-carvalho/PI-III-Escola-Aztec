package br.com.senac.tads3a.asterix.servlets;

import br.com.senac.tads3a.asterix.classes.Funcionario;
import br.com.senac.tads3a.asterix.servicos.ServicoFuncionario;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletFuncionario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String context = request.getServletPath();
        RequestDispatcher rd;

        int funcionarioID;
        Funcionario funcionario;
        List funcionarios;

        switch (context) {
            case "/funcionario_inserir":
                ServicoFuncionario.inserir(request, response);
                break;
            case "/funcionario_atualizar":
                ServicoFuncionario.atualizar(request, response);
                break;
            case "/funcionario_alterar":
                funcionarioID = Integer.parseInt(request.getParameter("funcionarioId"));
                
                funcionario = ServicoFuncionario.obter(funcionarioID);
                
                if(funcionario != null){
                    request.setAttribute("funcionario", funcionario);
                }else{
                    response.sendRedirect(request.getContextPath() + "/error");
                }
                
                rd = request.getRequestDispatcher("/WEB-INF/jsp/alterar-funcionario.jsp");
                rd.forward(request, response);
                break;
            case "/funcionario_buscar":
                String nomeFuncionario = request.getParameter("nome");

                funcionarios = ServicoFuncionario.procurar(nomeFuncionario);

                if (funcionarios != null) {
                    request.setAttribute("funcionarios", funcionarios);
                } else {
                    request.setAttribute("msgErro", "Sua busca não gerou resultados!");
                }

                rd = request.getRequestDispatcher("/WEB-INF/jsp/manutencao-funcionarios.jsp");
                rd.forward(request, response);
                break;
            case "/funcionario_listar":
                funcionarios = ServicoFuncionario.listar();

                if (funcionarios != null) {
                    request.setAttribute("funcionarios", funcionarios);
                } else {
                    request.setAttribute("msgErro", "Sua busca não gerou resultados!");
                }

                rd = request.getRequestDispatcher("/WEB-INF/jsp/manutencao-funcionarios.jsp");
                rd.forward(request, response);
                break;
            case "/funcionario_excluir":
                funcionarioID = Integer.parseInt(request.getParameter("id"));

                boolean resp = ServicoFuncionario.excluir(funcionarioID);

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
