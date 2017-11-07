package br.com.senac.tads3a.asterix.servicos;

import br.com.senac.tads3a.asterix.classes.Aluno;
import br.com.senac.tads3a.asterix.classes.Curso;
import br.com.senac.tads3a.asterix.classes.Matricula;
import br.com.senac.tads3a.asterix.classes.Unidade;
import br.com.senac.tads3a.asterix.dao.DaoMatricula;
import br.com.senac.tads3a.asterix.validadores.ValidadorMatricula;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServicoMatricula {

    public static void inserir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idAluno = Integer.parseInt(request.getParameter("aluno"));
            Aluno aluno = ServicoAluno.obter(idAluno);
            int idUnidade = Integer.parseInt(request.getParameter("unidade"));
            Unidade unidade = ServicoUnidade.obter(idUnidade);
            int idCurso = Integer.parseInt(request.getParameter("curso"));
            Curso curso = ServicoCurso.obter(idCurso);
            String dtInicio = request.getParameter("dtInicio");
            String pagamento = request.getParameter("pagamento");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date data = new Date(sdf.parse(dtInicio).getTime());
            
            Matricula matricula = new Matricula(aluno, unidade, curso, data, pagamento);
            
            ValidadorMatricula.validar(matricula);

            DaoMatricula.inserir(matricula);
            
            response.sendRedirect(request.getContextPath() + "/success");
        } catch (ClassNotFoundException | IllegalArgumentException | SQLException | ParseException e) {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    public static void atualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int idAluno = Integer.parseInt(request.getParameter("aluno"));
            Aluno aluno = ServicoAluno.obter(idAluno);
            int idUnidade = Integer.parseInt(request.getParameter("unidade"));
            Unidade unidade = ServicoUnidade.obter(idUnidade);
            int idCurso = Integer.parseInt(request.getParameter("curso"));
            Curso curso = ServicoCurso.obter(idCurso);
            String dtInicio = request.getParameter("dtInicio");
            String pagamento = request.getParameter("pagamento");
            String dtCadastro = request.getParameter("cadastro");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date inicio = new Date(sdf.parse(dtInicio).getTime());
            Date cadastro = new Date(sdf.parse(dtCadastro).getTime());
            
            Matricula matricula = new Matricula(id, aluno, unidade, curso, inicio, pagamento, cadastro);
            
            ValidadorMatricula.validar(matricula);

            DaoMatricula.atualizar(matricula);
            
            response.sendRedirect(request.getContextPath() + "/success");
        } catch (ClassNotFoundException | IllegalArgumentException | SQLException | ParseException e) {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }    

    public static List<Matricula> procurar(int alunoID) {
        try {
            return DaoMatricula.procurar(alunoID);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
    
    public static List<Matricula> listar() {
        try {
            return DaoMatricula.listar();
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public static Matricula obter(int id) {
        try {
            return DaoMatricula.obter(id);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public static boolean excluir(int id) {
        try {
            DaoMatricula.excluir(id);
            
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }
    }
}
