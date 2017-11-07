package br.com.senac.tads3a.asterix.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletLogout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession(false); // Nao cria uma sessao nova
        sessao.invalidate(); // Invalida a sessao atual

        // Cria uma nova sessao para mostrar mensagem para usuario
        sessao = request.getSession(true);
        sessao.setAttribute("msgLogout", "Você saiu do sistema!");
        response.sendRedirect(request.getContextPath() + "/login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
