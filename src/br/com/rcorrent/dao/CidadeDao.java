/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.dao;

import br.com.rcorrent.model.Cidade;
import br.com.rcorrent.model.Uf;
import br.com.rcorrent.tools.UltimaSequencia;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rcorrent
 */
public class CidadeDao extends ConexaoOracle{
    
    private final StringBuilder SQL = new StringBuilder();
    private final UltimaSequencia sequencia = new UltimaSequencia();
    
    private final UfDao ufDao = new UfDao();
    
    private Cidade cidade;
    private Uf uf;
    
    private List<Cidade> listaCidade;
    
    public void inserirTodasAsCidades(String cidade){
        try {                        
            //colocar NOME DA CIDADE em UPPERCASE
            cidade = cidade.toUpperCase();
            
            SQL.setLength(0);
            SQL.append("INSERT INTO CAD_CIDADE(CD_CIDADE,CD_UF,NM_CIDADE) VALUES" + cidade);
            
            super.executeSQL(SQL.toString());
            //printar o comando SQL
            System.out.println(SQL);
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores();
        }
        
    }
    
    
    /**INSERIR CIDADE.
     * 
     */
    public void inserirCidade(Cidade cidade){
        //Declarando uma PreparedStatement
        PreparedStatement ps = null;
        
        try {            
            //inserir codigo da cidade automaticamente
            cidade.setCodigoCidade(sequencia.getUltimaSequencia("CAD_CIDADE", "CD_CIDADE").longValue());
                        
            //colocar NOME DA CIDADE em UPPERCASE
            cidade.setNomeCidade(cidade.getNomeCidade().toUpperCase());
            
            SQL.setLength(0);
            SQL.append("INSERT INTO CAD_CIDADE(CD_CIDADE,NM_CIDADE,CD_UF) VALUES(?,?,?)");
            
            ps = super.getConexao().prepareStatement(SQL.toString());
            
            ps.setLong(1, cidade.getCodigoCidade());
            ps.setString(2, cidade.getNomeCidade());
            ps.setLong(3, cidade.getUf().getCodigoUf());
            
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    /**EXCLUIR CIDADE.
     * 
     */
    public void excluirCidade(Cidade cidade){
        PreparedStatement ps = null;
        
        try {
            SQL.setLength(0);
            SQL.append("DELETE FROM CAD_CIDADE WHERE CD_CIDADE = ? ");
            
            ps = super.getConexao().prepareStatement(SQL.toString());
            
            ps.setLong(1, cidade.getCodigoCidade());
            
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    /**ALTERAR CIDADE.
     * 
     */
    public void alterarCidade(Cidade cidade){
        //Declarando uma PreparedStatement
        PreparedStatement ps = null;
        
        try {
            //colocar NOME DA CIDADE em UPPERCASE
            cidade.setNomeCidade(cidade.getNomeCidade().toUpperCase());
            
            SQL.setLength(0);
            SQL.append("UPDATE CAD_CIDADE ");
            SQL.append("SET NM_CIDADE = ?, ");
            SQL.append("CD_UF = ? ");
            SQL.append("WHERE CD_CIDADE = ? ");
            
            ps = super.getConexao().prepareStatement(SQL.toString());
            
            ps.setString(1, cidade.getNomeCidade());
            ps.setLong(2, cidade.getUf().getCodigoUf());
            ps.setLong(3, cidade.getCodigoCidade());
            
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    public Uf getUfByIdCidade(Long codigoCidade){
        PreparedStatement ps = null;        
        try {
            SQL.setLength(0);
            SQL.append("SELECT CID.CD_CIDADE, "
                    + "CID.NM_CIDADE, "
                    + "CID.CD_UF,"
                    + "EST.NM_UF,"
                    + "EST.SG_UF ");
            SQL.append("FROM CAD_CIDADE CID ");
            SQL.append("INNER JOIN CAD_UF EST ON (CID.CD_UF = EST.CD_UF) ");
            SQL.append("WHERE CID.CD_CIDADE = ? ");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                      
            ps.setObject(1, codigoCidade);
            
            super.resultSet = ps.executeQuery();
            
            super.resultSet.first();
            
            uf = new Uf();
            uf.setCodigoUf(super.resultSet.getLong("CD_UF"));
            uf.setNomeUf(super.resultSet.getString("NM_UF"));
            uf.setSiglaUf(super.resultSet.getString("SG_UF"));
            
            return uf;
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores();
        }
    }
    
    /**Retornar Objeto Cidade.
     * 
     */
    public Cidade getByIdCidade(Long codigoCidade){
        PreparedStatement ps = null;        
        try {
            SQL.setLength(0);
            SQL.append("SELECT ");
            SQL.append("CID.CD_CIDADE, ");
            SQL.append("CID.NM_CIDADE, ");
            SQL.append("EST.CD_UF, ");
            SQL.append("EST.NM_UF, ");
            SQL.append("EST.SG_UF ");
            SQL.append("FROM CAD_CIDADE CID ");
            SQL.append("INNER JOIN CAD_UF EST ON(CID.CD_UF = EST.CD_UF) ");
            SQL.append("WHERE CD_CIDADE = ? ");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                      
            ps.setObject(1, codigoCidade);
            
            super.resultSet = ps.executeQuery();
            
            super.resultSet.first();
            
            cidade = new Cidade();
            uf = new Uf();
            uf = ufDao.getById(super.resultSet.getLong("CD_UF"));            
            cidade.setCodigoCidade(super.resultSet.getLong("CD_CIDADE"));
            cidade.setNomeCidade(super.resultSet.getString("NM_CIDADE"));
            cidade.setUf(uf);
            return cidade;
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores();
        }
    }
    
        public Cidade getByCidadeUf(String nomeCidade, String siglaUf){
        PreparedStatement ps = null;        
        try {
            SQL.setLength(0);
            SQL.append("SELECT CID.CD_CIDADE, ");
            SQL.append("CID.NM_CIDADE, ");
            SQL.append("EST.CD_UF, ");
            SQL.append("EST.NM_UF, ");
            SQL.append("EST.SG_UF ");
            SQL.append("FROM CAD_CIDADE CID ");
            SQL.append("INNER JOIN CAD_UF EST ON(CID.CD_UF = EST.CD_UF) ");
            SQL.append("WHERE CID.NM_CIDADE LIKE ? AND EST.SG_UF LIKE ?");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                      
            ps.setObject(1, nomeCidade);
            ps.setObject(2, siglaUf);
            
            super.resultSet = ps.executeQuery();
            
            super.resultSet.first();
            
            cidade = new Cidade();
            uf = new Uf();
            uf = ufDao.getById(super.resultSet.getLong("CD_UF"));
            
            cidade.setCodigoCidade(super.resultSet.getLong("CD_CIDADE"));
            cidade.setNomeCidade(super.resultSet.getString("NM_CIDADE"));
            cidade.setUf(uf);
            return cidade;
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores();
        }
    }
    
    
    /**Retornar Objeto Todas as Cidades.
     * 
     */
    public List<Cidade> getAllCidade(){
        try {
            SQL.setLength(0);
            SQL.append("SELECT CD_CIDADE, NM_CIDADE, CD_UF ");
            SQL.append("FROM CAD_CIDADE ");
            SQL.append("ORDER BY CD_CIDADE");
            
            super.executeSQL(SQL.toString());
            
            listaCidade = new ArrayList<>();
            
            /**Gravar a lista de cidades
             * Método que percore o retorno do DB
             * e insere na 'cidade'
             */
            while(super.resultSet.next()){
                cidade = new Cidade();
                uf = ufDao.getById(super.resultSet.getLong("CD_UF"));
                
                cidade.setCodigoCidade(super.resultSet.getLong("CD_CIDADE"));
                cidade.setNomeCidade(super.resultSet.getString("NM_CIDADE"));
                cidade.setUf(uf);

                listaCidade.add(cidade);
            }
            return listaCidade;            
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }finally{
            super.fecharCursores();
        }
    }
    
    /**@return RESULTSET GET ALL.
     * 
     */
    public ResultSet resultSetGetAllCidade(){
        try {
            SQL.setLength(0);
            SQL.append("SELECT CID.CD_CIDADE, CID.NM_CIDADE, UF.CD_UF, UF.NM_UF ");
            SQL.append("FROM CAD_CIDADE CID ");
            SQL.append("INNER JOIN CAD_UF UF ON(CID.CD_UF = UF.CD_UF) ");
            SQL.append("ORDER BY CID.NM_CIDADE");
            
            super.executeSQL(SQL.toString());
            
            return resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    /**@RETURN RESULTSET GET BY ID.
     * 
     */
    public ResultSet resultSetGetByIdCidade(Long codigoCidade){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT ");
            SQL.append("CID.CD_CIDADE AS CD_CIDADE, ");
            SQL.append("CID.NM_CIDADE AS NM_CIDADE, ");
            SQL.append("CID.CD_UF AS CD_UF, ");
            SQL.append("UF.SG_UF AS SG_UF, ");
            SQL.append("UF.NM_UF AS NM_UF ");
            SQL.append("FROM CAD_CIDADE CID ");
            SQL.append("INNER JOIN CAD_UF UF ON(CID.CD_UF = UF.CD_UF) ");
            SQL.append("WHERE CID.CD_CIDADE = ? ");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                      
            ps.setLong(1, codigoCidade);
            super.resultSet = ps.executeQuery();
            
            return super.resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    /**@retunr RESEULTSET GET BY NOME
     * 
     */
    public ResultSet resultSetGetByNomeCidade(String nomeCidade){
        PreparedStatement ps = null;
        try {
            nomeCidade = nomeCidade.toUpperCase();
            SQL.setLength(0);
            SQL.append("SELECT CID.CD_CIDADE AS CD_CIDADE, CID.NM_CIDADE AS NM_CIDADE, UF.CD_UF AS CD_UF, UF.NM_UF AS NM_UF ");
            SQL.append("FROM CAD_CIDADE CID ");
            SQL.append("INNER JOIN CAD_UF UF ON(CID.CD_UF = UF.CD_UF) ");
            SQL.append("WHERE CID.NM_CIDADE LIKE ? ");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                      
            ps.setString(1, "%" + nomeCidade + "%");
            
            super.resultSet = ps.executeQuery();
            
            return super.resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    /**@retunr RESEULTSET GET BY NOME UF
     * 
     */
    public ResultSet resultSetGetByNomeUf(String nomeUf){
        PreparedStatement ps = null;
        try {
            nomeUf = nomeUf.toUpperCase();
            SQL.setLength(0);
            SQL.append("SELECT CID.CD_CIDADE AS CD_CIDADE, CID.NM_CIDADE AS NM_CIDADE, UF.CD_UF AS CD_UF, UF.NM_UF AS NM_UF ");
            SQL.append("FROM CAD_CIDADE CID ");
            SQL.append("INNER JOIN CAD_UF UF ON(CID.CD_UF = UF.CD_UF) ");
            SQL.append("WHERE UF.NM_UF LIKE ?");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                      
            ps.setObject(1, "%" + nomeUf + "%");
            
            super.resultSet = ps.executeQuery();
            
            return super.resultSet;
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    
    /**
     * cadastrar todas as cidades do Brasil
    public static void main(String[] args) {
        
        CidadeDao cdao = new CidadeDao();
        
        FileReader fileRead = null;
        try {
            File file = new File("/home/rcorrent/Downloads/sql_todas_as_cidade.txt");
            fileRead = new FileReader(file);
            BufferedReader ler = new BufferedReader(fileRead);
            
            String linha;
            while(ler.ready()){
                linha = new String();
                linha = ler.readLine().concat("\n");
                linha = linha.replace(",\n", "\n");
                linha = linha.replace(";\n", "\n");
                System.out.printf(linha);
                cdao.inserirTodasAsCidades(linha);
            }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileRead.close();
            } catch (IOException ex) {
                Logger.getLogger(CidadeDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    */
}
