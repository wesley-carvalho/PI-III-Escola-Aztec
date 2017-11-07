package br.com.senac.tads3a.asterix.dao;

import br.com.senac.tads3a.asterix.classes.Matricula;
import br.com.senac.tads3a.asterix.servicos.ServicoAluno;
import br.com.senac.tads3a.asterix.servicos.ServicoCurso;
import br.com.senac.tads3a.asterix.servicos.ServicoUnidade;
import br.com.senac.tads3a.asterix.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoMatricula {

    public static void inserir(Matricula matricula)
            throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO matricula (idAluno, idUnidade, idCurso, dtInicio, "
                + "pagamento, dtCadastro, enabled) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, matricula.getAluno().getId());
            preparedStatement.setInt(2, matricula.getUnidade().getId());
            preparedStatement.setInt(3, matricula.getCurso().getId());
            preparedStatement.setDate(4, new Date(matricula.getInicio().getTime()));
            preparedStatement.setString(5, matricula.getPagamento());
            preparedStatement.setDate(6, new Date(System.currentTimeMillis()));
            preparedStatement.setBoolean(7, true);

            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static void atualizar(Matricula matricula)
            throws SQLException, ClassNotFoundException {
        String sql = "UPDATE matricula SET idAluno=?, idUnidade=?, idCurso=?,"
                + " dtInicio=?, pagamento=? WHERE (matricula.idMatricula=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, matricula.getAluno().getId());
            preparedStatement.setInt(2, matricula.getUnidade().getId());
            preparedStatement.setInt(3, matricula.getCurso().getId());
            preparedStatement.setDate(4, new Date(matricula.getInicio().getTime()));
            preparedStatement.setString(5, matricula.getPagamento());
            preparedStatement.setInt(6, matricula.getId());

            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }   

    public static List<Matricula> procurar(int alunoID)
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM matricula WHERE (matricula.idAluno=? AND enabled=?)";

        List<Matricula> listaMatriculas = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, alunoID);
            preparedStatement.setBoolean(2, true);

            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (listaMatriculas == null) {
                    listaMatriculas = new LinkedList<>();
                }
                Matricula matricula = new Matricula();
                matricula.setId(result.getInt("idMatricula"));
                matricula.setAluno(ServicoAluno.obter(result.getInt("idAluno")));
                matricula.setUnidade(ServicoUnidade.obter(result.getInt("idUnidade")));
                matricula.setCurso(ServicoCurso.obter(result.getInt("idCurso")));
                matricula.setInicio(result.getDate("dtInicio"));
                matricula.setPagamento(result.getString("pagamento"));
                matricula.setCadastro(result.getDate("dtCadastro"));

                listaMatriculas.add(matricula);
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        return listaMatriculas;
    }
    
    public static List<Matricula> listar() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM matricula WHERE (enabled=?) ";

        List<Matricula> listaMatriculas = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);

            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (listaMatriculas == null) {
                    listaMatriculas = new LinkedList<>();
                }
                Matricula matricula = new Matricula();
                matricula.setId(result.getInt("idMatricula"));
                matricula.setAluno(ServicoAluno.obter(result.getInt("idAluno")));
                matricula.setUnidade(ServicoUnidade.obter(result.getInt("idUnidade")));
                matricula.setCurso(ServicoCurso.obter(result.getInt("idCurso")));
                matricula.setInicio(result.getDate("dtInicio"));
                matricula.setPagamento(result.getString("pagamento"));
                matricula.setCadastro(result.getDate("dtCadastro"));

                listaMatriculas.add(matricula);
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaMatriculas;
    }

    public static Matricula obter(int id)
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM matricula WHERE (matricula.idMatricula=? AND enabled=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            preparedStatement.setBoolean(2, true);

            result = preparedStatement.executeQuery();
            if (result.next()) {
                Matricula matricula = new Matricula();
                matricula.setId(result.getInt("idMatricula"));
                matricula.setAluno(ServicoAluno.obter(result.getInt("idAluno")));
                matricula.setUnidade(ServicoUnidade.obter(result.getInt("idUnidade")));
                matricula.setCurso(ServicoCurso.obter(result.getInt("idCurso")));
                matricula.setInicio(result.getDate("dtInicio"));
                matricula.setPagamento(result.getString("pagamento"));
                matricula.setCadastro(result.getDate("dtCadastro"));

                return matricula;
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return null;
    }

    public static void excluir(int id)
            throws SQLException, ClassNotFoundException {
        String sql = "UPDATE matricula SET enabled=? WHERE (matricula.idMatricula=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);

            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
