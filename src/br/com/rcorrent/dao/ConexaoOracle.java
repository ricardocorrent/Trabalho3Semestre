
package br.com.rcorrent.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rcorrent
 */
public abstract class ConexaoOracle {

    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:cdb1";
    private static final String USUARIO = "C##TRABALHO3S";
    private static final String SENHA = "trabalho3s";
    private static Connection conexao;
    public ResultSet resultSet;
    public Statement statement;
    
    /*Construtor*/
    public ConexaoOracle(){
        conectar();
    }
    
    /*Método*/
    private static void conectar() {
        try {
            if(conexao == null || conexao.isClosed()){
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
                System.out.println("Conexão efetuada com sucesso");
            }else{
                System.out.println("Conexão recuperada com sucesso");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar!!" + e);
        }
        
    }
    public static void desconectar(){
        try{
            if(conexao != null){
                conexao.close();
                System.out.println("Conexão fechada com sucesso");
            }else{
                System.out.println("Não existe conexão");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    public void executeSQL(String sql) {
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            resultSet = null;
        }
    }
    
    public void executeUpdate(String update) {
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(update);
        } catch (SQLException ex) {
            ex.printStackTrace();
            resultSet = null;
        }
    }

    public void executeDelete(String delete) {
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(delete);
        } catch (SQLException ex) {
            ex.printStackTrace();
            resultSet = null;
        }
    }

    public void fecharCursores() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();            
            }
        } catch (SQLException ex) {
        }
    }
    
    public void fecharCursores(PreparedStatement ps) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();            
            }
            if(ps != null){
                ps.close();
            }
        } catch (SQLException ex) {
        }
    }
    
    public static Connection getConexao() {
        return conexao;
    }

    public static void setConexao(Connection conexao) {
        ConexaoOracle.conexao = conexao;
    }

}

