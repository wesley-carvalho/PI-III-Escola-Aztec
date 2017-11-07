package br.com.senac.tads3a.asterix.servlets;

import br.com.senac.tads3a.asterix.classes.Funcionario;
import br.com.senac.tads3a.asterix.utils.Authentication;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Verifica se usuario ja esta logado
        HttpSession sessao = request.getSession();
        Funcionario usuario = (Funcionario) sessao.getAttribute("funcionario");
        if (usuario != null) {
            // Usuario já está logado - redireciona para tela inicial
            response.sendRedirect(request.getContextPath() + "/home");
            return; // Forca a saida do método doGet
        }

        // Usuario nao logado
        // Antes verifica se tem msg do logout na sessao
        String msgLogout = (String) sessao.getAttribute("msgLogout");
        sessao.removeAttribute("msgLogout");
        if (msgLogout != null) {
            request.setAttribute("msgLogout", msgLogout);
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");
        
        Funcionario funcionario = Authentication.autenticar(username, senha);

        if (funcionario != null) {
            // Sucesso - usuario autenticado
            HttpSession sessao = request.getSession();
            sessao.setAttribute("funcionario", funcionario);
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            // Erro - reapresenta tela de login
            request.setAttribute("msgErro", "Erro no login!");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
