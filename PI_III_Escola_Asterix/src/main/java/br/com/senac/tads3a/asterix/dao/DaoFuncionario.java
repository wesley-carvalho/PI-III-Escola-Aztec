package br.com.senac.tads3a.asterix.dao;

import br.com.senac.tads3a.asterix.classes.Funcionario;
import br.com.senac.tads3a.asterix.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DaoFuncionario {

    public static void inserir(Funcionario funcionario)
            throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO funcionario (nome, documento, dtNascimento, "
                + "endereco, cidade, estado, email, cargo, username, hashsenha, "
                + "dtCadastro, enabled) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getDocumento());
            preparedStatement.setDate(3, new Date(funcionario.getNascimento().getTime()));
            preparedStatement.setString(4, funcionario.getEndereco());
            preparedStatement.setString(5, funcionario.getCidade());
            preparedStatement.setString(6, funcionario.getEstado());
            preparedStatement.setString(7, funcionario.getEmail());
            preparedStatement.setString(8, funcionario.getCargo());            
            preparedStatement.setString(9, funcionario.getUsername());
            preparedStatement.setString(10, funcionario.getHashSenha());
            preparedStatement.setDate(11, new Date(System.currentTimeMillis()));
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

    public static void atualizar(Funcionario funcionario)
            throws SQLException, ClassNotFoundException {
        String sql = "UPDATE funcionario SET nome=?, documento=?, dtNascimento=?, "
                + "endereco=?, cidade=?, estado=?, email=?, cargo=?, username=?, "
                + "hashsenha=? WHERE (funcionario.id=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getDocumento());
            preparedStatement.setDate(3, new Date(funcionario.getNascimento().getTime()));
            preparedStatement.setString(4, funcionario.getEndereco());
            preparedStatement.setString(5, funcionario.getCidade());
            preparedStatement.setString(6, funcionario.getEstado());
            preparedStatement.setString(7, funcionario.getEmail());
            preparedStatement.setString(8, funcionario.getCargo());            
            preparedStatement.setString(9, funcionario.getUsername());
            preparedStatement.setString(10, funcionario.getHashSenha());
            preparedStatement.setLong(11, funcionario.getId());

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
    
    public static LinkedList<Funcionario> procurar(String nomeFuncionario) 
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM funcionario WHERE ((UPPER(funcionario.nome)"
                + " LIKE UPPER(?)) AND enabled=?)";

        LinkedList<Funcionario> listaFuncionarios = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, "%" + nomeFuncionario + "%");            
            preparedStatement.setBoolean(2, true);

            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (listaFuncionarios == null) {
                    listaFuncionarios = new LinkedList<>();
                }
                Funcionario funcionario = new Funcionario();
                funcionario.setId(result.getInt("id"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setDocumento(result.getString("documento"));
                funcionario.setNascimento(result.getDate("dtNascimento"));
                funcionario.setEndereco(result.getString("endereco"));
                funcionario.setCidade(result.getString("cidade"));
                funcionario.setEstado(result.getString("estado"));
                funcionario.setEmail(result.getString("email"));
                funcionario.setCargo(result.getString("cargo"));                
                funcionario.setUsername(result.getString("username"));
                funcionario.setHashSenha(result.getString("hashsenha"));
                funcionario.setCadastro(result.getDate("dtCadastro"));

                listaFuncionarios.add(funcionario);
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
        return listaFuncionarios;
    }
    
    public static LinkedList<Funcionario> listar() 
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM funcionario WHERE (enabled=?)";

        LinkedList<Funcionario> listaFuncionarios = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);            
            
            preparedStatement.setBoolean(1, true);

            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (listaFuncionarios == null) {
                    listaFuncionarios = new LinkedList<>();
                }
                Funcionario funcionario = new Funcionario();
                funcionario.setId(result.getInt("id"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setDocumento(result.getString("documento"));
                funcionario.setNascimento(result.getDate("dtNascimento"));
                funcionario.setEndereco(result.getString("endereco"));
                funcionario.setCidade(result.getString("cidade"));
                funcionario.setEstado(result.getString("estado"));
                funcionario.setEmail(result.getString("email"));
                funcionario.setCargo(result.getString("cargo"));                
                funcionario.setUsername(result.getString("username"));
                funcionario.setHashSenha(result.getString("hashsenha"));
                funcionario.setCadastro(result.getDate("dtCadastro"));

                listaFuncionarios.add(funcionario);
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
        return listaFuncionarios;
    }

    public static Funcionario obter(int id)
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM funcionario WHERE (funcionario.id=? AND enabled=?)";

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
                Funcionario funcionario = new Funcionario();
                funcionario.setId(result.getInt("id"));
                funcionario.setNome(result.getString("nome")); 
                funcionario.setDocumento(result.getString("documento"));
                funcionario.setNascimento(result.getDate("dtNascimento"));
                funcionario.setEndereco(result.getString("endereco"));
                funcionario.setCidade(result.getString("cidade"));
                funcionario.setEstado(result.getString("estado"));
                funcionario.setEmail(result.getString("email"));
                funcionario.setCargo(result.getString("cargo"));                
                funcionario.setUsername(result.getString("username"));
                funcionario.setHashSenha(result.getString("hashsenha"));
                funcionario.setCadastro(result.getDate("dtCadastro"));

                return funcionario;
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
    
    public static Funcionario obterUser(String username)
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM funcionario WHERE (funcionario.username=? AND enabled=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, username);
            preparedStatement.setBoolean(2, true);

            result = preparedStatement.executeQuery();
            if (result.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(result.getInt("id"));
                funcionario.setNome(result.getString("nome")); 
                funcionario.setDocumento(result.getString("documento"));
                funcionario.setNascimento(result.getDate("dtNascimento"));
                funcionario.setEndereco(result.getString("endereco"));
                funcionario.setCidade(result.getString("cidade"));
                funcionario.setEstado(result.getString("estado"));
                funcionario.setEmail(result.getString("email"));
                funcionario.setCargo(result.getString("cargo"));                
                funcionario.setUsername(result.getString("username"));
                funcionario.setHashSenha(result.getString("hashsenha"));
                funcionario.setCadastro(result.getDate("dtCadastro"));

                return funcionario;
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
        String sql = "UPDATE funcionario SET enabled=? WHERE (funcionario.id=?)";

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
