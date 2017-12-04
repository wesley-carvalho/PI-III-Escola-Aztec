package br.com.senac.tads3a.asterix.dao;

import br.com.senac.tads3a.asterix.classes.Aluno;
import br.com.senac.tads3a.asterix.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DaoAluno {

    public static void inserir(Aluno aluno)
            throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO aluno (nome, documento, dtNascimento, endereco, "
                + "cidade, estado, email, telefone, celular, cadastradoPor, cadastradoEm, enabled) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setString(2, aluno.getDocumento());
            preparedStatement.setTimestamp(3, new Timestamp(aluno.getNascimento().getTime()));
            preparedStatement.setString(4, aluno.getEndereco());
            preparedStatement.setString(5, aluno.getCidade());
            preparedStatement.setString(6, aluno.getEstado());
            preparedStatement.setString(7, aluno.getEmail());
            preparedStatement.setString(8, aluno.getTelefone());
            preparedStatement.setString(9, aluno.getCelular());
            preparedStatement.setString(10, aluno.getCadastradoPor());
            preparedStatement.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setBoolean(12, true);

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

    public static void atualizar(Aluno aluno)
            throws SQLException, ClassNotFoundException {
        String sql = "UPDATE aluno SET nome=?, documento=?, dtNascimento=?, "
                + "endereco=?, cidade=?, estado=?, email=?, telefone=?, "
                + "celular=?, cadastradoPor=?, cadastradoEm=? WHERE (aluno.id=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setString(2, aluno.getDocumento());
            preparedStatement.setTimestamp(3, new Timestamp(aluno.getNascimento().getTime()));
            preparedStatement.setString(4, aluno.getEndereco());
            preparedStatement.setString(5, aluno.getCidade());
            preparedStatement.setString(6, aluno.getEstado());
            preparedStatement.setString(7, aluno.getEmail());
            preparedStatement.setString(8, aluno.getTelefone());
            preparedStatement.setString(9, aluno.getCelular());
            preparedStatement.setString(10, aluno.getCadastradoPor());
            preparedStatement.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setInt(12, aluno.getId());

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

    public static List<Aluno> procurar(String nomeAluno)
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM aluno WHERE ((UPPER(aluno.nome)"
                + " LIKE UPPER(?)) AND enabled=?)";

        List<Aluno> listaAlunos = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "%" + nomeAluno + "%");
            preparedStatement.setBoolean(2, true);

            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (listaAlunos == null) {
                    listaAlunos = new LinkedList<>();
                }
                Aluno aluno = new Aluno();
                aluno.setId(result.getInt("id"));
                aluno.setNome(result.getString("nome"));
                aluno.setDocumento(result.getString("documento"));
                aluno.setNascimento(new Date(result.getTimestamp("dtNascimento").getTime()));
                aluno.setEndereco(result.getString("endereco"));
                aluno.setCidade(result.getString("cidade"));
                aluno.setEstado(result.getString("estado"));
                aluno.setEmail(result.getString("email"));
                aluno.setTelefone(result.getString("telefone"));
                aluno.setCelular(result.getString("celular"));
                aluno.setCadastradoPor(result.getString("cadastradoPor"));
                aluno.setCadastradoEm(new Date(result.getTimestamp("cadastradoEm").getTime()));

                listaAlunos.add(aluno);
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
        return listaAlunos;
    }

    public static List<Aluno> listar()
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM aluno WHERE (enabled=?)";

        List<Aluno> listaAlunos = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setBoolean(1, true);

            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (listaAlunos == null) {
                    listaAlunos = new LinkedList<>();
                }
                Aluno aluno = new Aluno();
                aluno.setId(result.getInt("id"));
                aluno.setNome(result.getString("nome"));
                aluno.setDocumento(result.getString("documento"));
                aluno.setNascimento(new Date(result.getTimestamp("dtNascimento").getTime()));
                aluno.setEndereco(result.getString("endereco"));
                aluno.setCidade(result.getString("cidade"));
                aluno.setEstado(result.getString("estado"));
                aluno.setEmail(result.getString("email"));
                aluno.setTelefone(result.getString("telefone"));
                aluno.setCelular(result.getString("celular"));
                aluno.setCadastradoPor(result.getString("cadastradoPor"));
                aluno.setCadastradoEm(new Date(result.getTimestamp("cadastradoEm").getTime()));

                listaAlunos.add(aluno);
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

        return listaAlunos;
    }

    public static Aluno obter(int id)
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM aluno WHERE (aluno.id=? AND enabled=?)";

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
                Aluno aluno = new Aluno();
                aluno.setId(result.getInt("id"));
                aluno.setNome(result.getString("nome"));
                aluno.setDocumento(result.getString("documento"));
                aluno.setNascimento(new Date(result.getTimestamp("dtNascimento").getTime()));
                aluno.setEndereco(result.getString("endereco"));
                aluno.setCidade(result.getString("cidade"));
                aluno.setEstado(result.getString("estado"));
                aluno.setEmail(result.getString("email"));
                aluno.setTelefone(result.getString("telefone"));
                aluno.setCelular(result.getString("celular"));
                aluno.setCadastradoPor(result.getString("cadastradoPor"));
                aluno.setCadastradoEm(new Date(result.getTimestamp("cadastradoEm").getTime()));

                return aluno;
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
        String sql = "UPDATE aluno SET enabled=? WHERE (aluno.id=?)";

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
