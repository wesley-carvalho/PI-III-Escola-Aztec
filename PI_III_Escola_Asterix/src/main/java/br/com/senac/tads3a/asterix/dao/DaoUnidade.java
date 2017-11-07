package br.com.senac.tads3a.asterix.dao;

import br.com.senac.tads3a.asterix.classes.Unidade;
import br.com.senac.tads3a.asterix.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DaoUnidade {

    public static void inserir(Unidade unidade)
            throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO unidade (nome, endereco, cidade, estado, "
                + "email, telefone1, telefone2, dtCadastro, enabled) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, unidade.getNome());
            preparedStatement.setString(2, unidade.getEndereco());
            preparedStatement.setString(3, unidade.getCidade());
            preparedStatement.setString(4, unidade.getEstado());
            preparedStatement.setString(5, unidade.getEmail());
            preparedStatement.setString(6, unidade.getTelefone1());
            preparedStatement.setString(7, unidade.getTelefone2());            
            preparedStatement.setDate(8, new Date(System.currentTimeMillis()));
            preparedStatement.setBoolean(9, true);

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

    public static void atualizar(Unidade unidade)
            throws SQLException, ClassNotFoundException {
        String sql = "UPDATE unidade SET nome=?, endereco=?, cidade=?, estado=?,"
                + " email=?, telefone1=?, telefone2=? WHERE (unidade.id=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, unidade.getNome());
            preparedStatement.setString(2, unidade.getEndereco());
            preparedStatement.setString(3, unidade.getCidade());
            preparedStatement.setString(4, unidade.getEstado());
            preparedStatement.setString(5, unidade.getEmail());
            preparedStatement.setString(6, unidade.getTelefone1());
            preparedStatement.setString(7, unidade.getTelefone2());            
            preparedStatement.setInt(8, unidade.getId());

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

    public static LinkedList<Unidade> procurar(String nomeUnidade)
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM unidade WHERE ((UPPER(unidade.nome) "
                + "LIKE UPPER(?)) AND enabled=?)";

        LinkedList<Unidade> listaUnidades = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, "%" + nomeUnidade + "%");            
            preparedStatement.setBoolean(2, true);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (listaUnidades == null) {
                    listaUnidades = new LinkedList<>();
                }
                Unidade unidade = new Unidade();
                unidade.setId(result.getInt("id"));
                unidade.setNome(result.getString("nome"));
                unidade.setEndereco(result.getString("endereco"));
                unidade.setCidade(result.getString("cidade"));
                unidade.setEstado(result.getString("estado"));
                unidade.setEmail(result.getString("email"));
                unidade.setTelefone1(result.getString("telefone1"));
                unidade.setTelefone2(result.getString("telefone2"));              
                unidade.setCadastro(result.getDate("dtCadastro"));                

                listaUnidades.add(unidade);
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

        return listaUnidades;
    }
    
    public static LinkedList<Unidade> listar()
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM unidade WHERE (enabled=?)";

        LinkedList<Unidade> listaUnidades = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);            
            
            preparedStatement.setBoolean(1, true);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (listaUnidades == null) {
                    listaUnidades = new LinkedList<>();
                }
                Unidade unidade = new Unidade();
                unidade.setId(result.getInt("id"));
                unidade.setNome(result.getString("nome"));
                unidade.setEndereco(result.getString("endereco"));
                unidade.setCidade(result.getString("cidade"));
                unidade.setEstado(result.getString("estado"));
                unidade.setEmail(result.getString("email"));
                unidade.setTelefone1(result.getString("telefone1"));
                unidade.setTelefone2(result.getString("telefone2"));              
                unidade.setCadastro(result.getDate("dtCadastro"));                

                listaUnidades.add(unidade);
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

        return listaUnidades;
    }

    public static Unidade obter(int id)
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM unidade WHERE (unidade.id=? AND enabled=?)";

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
                Unidade unidade = new Unidade();
                unidade.setId(result.getInt("id"));
                unidade.setNome(result.getString("nome"));
                unidade.setEndereco(result.getString("endereco"));
                unidade.setCidade(result.getString("cidade"));
                unidade.setEstado(result.getString("estado"));
                unidade.setEmail(result.getString("email"));
                unidade.setTelefone1(result.getString("telefone1"));
                unidade.setTelefone2(result.getString("telefone2"));              
                unidade.setCadastro(result.getDate("dtCadastro"));                

                return unidade;
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
        String sql = "UPDATE unidade SET enabled=? WHERE (unidade.id=?)";

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
