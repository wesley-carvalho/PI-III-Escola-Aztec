package br.com.senac.tads3a.asterix.servicos;

import br.com.senac.tads3a.asterix.classes.Unidade;
import br.com.senac.tads3a.asterix.dao.DaoUnidade;
import br.com.senac.tads3a.asterix.validadores.ValidadorUnidade;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServicoUnidade {
    public static void inserir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String email = request.getParameter("email");
            String telefone1 = request.getParameter("telefone1");
            String telefone2 = request.getParameter("telefone2");
            
            Unidade unidade = new Unidade(nome, endereco, cidade, estado, email, telefone1, telefone2);
            
            ValidadorUnidade.validar(unidade);

            DaoUnidade.inserir(unidade);
            
            response.sendRedirect(request.getContextPath() + "/success");
        } catch (ClassNotFoundException | IllegalArgumentException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    public static void atualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String email = request.getParameter("email");
            String telefone1 = request.getParameter("telefone1");
            String telefone2 = request.getParameter("telefone2");
            String dtCadastro = request.getParameter("cadastro");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date cadastro = new Date(sdf.parse(dtCadastro).getTime());

            Unidade unidade = new Unidade(id, nome, endereco, cidade, estado, email, telefone1, telefone2, cadastro);
            
            ValidadorUnidade.validar(unidade);

            DaoUnidade.atualizar(unidade);
            
            response.sendRedirect(request.getContextPath() + "/success");
        } catch (ClassNotFoundException | IllegalArgumentException | SQLException | ParseException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    public static List<Unidade> procurar(String nomeUnidade) {
        try {
            return DaoUnidade.procurar(nomeUnidade);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<Unidade> listar(){
        try {
            return DaoUnidade.listar();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Unidade obter(int id) {
        try {
            return DaoUnidade.obter(id);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean excluir(int id) {
        try {
            DaoUnidade.excluir(id);
            
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
