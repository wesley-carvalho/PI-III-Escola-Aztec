package br.com.senac.tads3a.asterix.utils;

import br.com.senac.tads3a.asterix.classes.Funcionario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterUtils implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // NAO FAZ NADA
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession sessao = httpRequest.getSession();

        // Verifica se o usuario esta logado no sistema
        if (sessao != null && sessao.getAttribute("funcionario") != null) {

            String paginaAcessada = httpRequest.getRequestURI();
            String funcionalidade = paginaAcessada.replace(httpRequest.getContextPath(), "");

            Funcionario funcionario = (Funcionario) sessao.getAttribute("funcionario");
            
            // Verificacao se usuario tem papel pra acessar funcionalidade
            if (Authorization.autorizacao(funcionario, funcionalidade)) {
                chain.doFilter(request, response); // Deixa a requisicao pelo filtro
            } else {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/blocked");
            }
        } else {
            // Usuario nao esta logado
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
        }
    }

    @Override
    public void destroy() {
        // NAO FAZ NADA
    }
}
