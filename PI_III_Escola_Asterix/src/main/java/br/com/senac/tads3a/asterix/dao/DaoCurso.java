package br.com.senac.tads3a.asterix.dao;

import br.com.senac.tads3a.asterix.classes.Curso;
import br.com.senac.tads3a.asterix.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DaoCurso {

    public static void inserir(Curso curso) 
            throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO curso (nome, categoria, descricao, valor, "
                + "cadastradoPor, cadastradoEm, enabled) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, curso.getNome());
            preparedStatement.setString(2, curso.getCategoria());
            preparedStatement.setString(3, curso.getDescricao());
            preparedStatement.setBigDecimal(4, curso.getValor());
            preparedStatement.setString(5, curso.getCadastradoPor());
            preparedStatement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
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

    public static void atualizar(Curso curso) 
            throws SQLException, ClassNotFoundException {
        String sql = "UPDATE curso SET nome=?, categoria=?, descricao=?,"
                + " valor=?, cadastradoPor=?, cadastradoEm=? WHERE (curso.id=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, curso.getNome());
            preparedStatement.setString(2, curso.getCategoria());
            preparedStatement.setString(3, curso.getDescricao());
            preparedStatement.setBigDecimal(4, curso.getValor());
            preparedStatement.setString(5, curso.getCadastradoPor());
            preparedStatement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setInt(7, curso.getId());

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

    public static List<Curso> procurar(String nomeCurso) 
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM curso WHERE ((UPPER(curso.nome) "
                + "LIKE UPPER(?)) AND enabled=?)";

        List<Curso> listaCursos = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, "%" + nomeCurso + "%");            
            preparedStatement.setBoolean(2, true);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (listaCursos == null) {
                    listaCursos = new LinkedList<>();
                }
                Curso curso = new Curso();                
                curso.setId(result.getInt("id"));
                curso.setNome(result.getString("nome"));
                curso.setCategoria(result.getString("categoria"));
                curso.setDescricao(result.getString("descricao"));
                curso.setValor(result.getBigDecimal("valor"));
                curso.setCadastradoPor(result.getString("cadastradoPor"));                
                curso.setCadastradoEm(new Date(result.getTimestamp("cadastradoEm").getTime()));                

                listaCursos.add(curso);
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

        return listaCursos;
    }
    
    public static List<Curso> listar() 
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM curso WHERE (enabled=?)";

        List<Curso> listaCursos = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);            
            
            preparedStatement.setBoolean(1, true);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (listaCursos == null) {
                    listaCursos = new LinkedList<>();
                }
                Curso curso = new Curso();                
                curso.setId(result.getInt("id"));
                curso.setNome(result.getString("nome"));
                curso.setCategoria(result.getString("categoria"));
                curso.setDescricao(result.getString("descricao"));
                curso.setValor(result.getBigDecimal("valor"));
                curso.setCadastradoPor(result.getString("cadastradoPor"));
                curso.setCadastradoEm(new Date(result.getTimestamp("cadastradoEm").getTime()));                    

                listaCursos.add(curso);
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
        return listaCursos;
    }

    public static Curso obter(long id) 
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM curso WHERE (curso.id=? AND enabled=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setLong(1, id);            
            preparedStatement.setBoolean(2, true);

            result = preparedStatement.executeQuery();
            if (result.next()) {
                Curso curso = new Curso();
                curso.setId(result.getInt("id"));
                curso.setNome(result.getString("nome"));
                curso.setCategoria(result.getString("categoria"));
                curso.setDescricao(result.getString("descricao"));
                curso.setValor(result.getBigDecimal("valor"));
                curso.setCadastradoPor(result.getString("cadastradoPor"));
                curso.setCadastradoEm(new Date(result.getTimestamp("cadastradoEm").getTime()));

                return curso;
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

    public static void excluir(long id) 
            throws SQLException, ClassNotFoundException {
        String sql = "UPDATE curso SET enabled=? WHERE (curso.id=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setBoolean(1, false);
            preparedStatement.setLong(2, id);

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
