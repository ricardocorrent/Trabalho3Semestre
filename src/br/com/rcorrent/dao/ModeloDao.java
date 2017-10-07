/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.dao;

import br.com.rcorrent.model.Marca;
import br.com.rcorrent.model.Modelo;
import br.com.rcorrent.tools.UltimaSequencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rcorrent
 */
public class ModeloDao extends ConexaoOracle{
    
    private final StringBuilder SQL = new StringBuilder();
    private final UltimaSequencia sequencia = new UltimaSequencia();    
    private final MarcaDao marcaDao = new MarcaDao();
    
    private Modelo modelo;
    
    private List<Modelo> listaModelo;

    public void inserirModelo(Modelo modelo){
        //Declarando uma PreparedStatement
        PreparedStatement ps = null;        
        try {
            SQL.setLength(0);
            SQL.append("INSERT INTO CAD_MODELO( ");
            SQL.append("CD_MODELO, ");
            SQL.append("NM_MODELO, ");
            SQL.append("CD_MARCA) ");
            SQL.append("VALUES(?,?,?) ");            
            ps = super.getConexao().prepareStatement(SQL.toString());            
            //inserir codigo do modelo automaticamente
            modelo.setCodigoModelo(sequencia.getUltimaSequencia("CAD_MODELO", "CD_MODELO"));
            //colocar NOME DO MODELO em UPPERCASE
            modelo.setNomeModelo(modelo.getNomeModelo().toUpperCase());            
            ps.setLong(1, modelo.getCodigoModelo());
            ps.setString(2, modelo.getNomeModelo());
            ps.setLong(3, modelo.getMarca().getCodigoMarca());            
            ps.execute();            
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }

    public void excluirModelo(Modelo modelo){        
        PreparedStatement ps = null;        
        try {
            SQL.setLength(0);
            SQL.append("DELETE FROM CAD_MODELO WHERE CD_MODELO = ? ");            
            ps = super.getConexao().prepareStatement(SQL.toString());            
            ps.setLong(1, modelo.getCodigoModelo());            
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }

    public void alterarModelo(Modelo modelo){
        //Declarando uma PreparedStatement
        PreparedStatement ps = null;        
        try {
            //colocar NOME DO MODELO em UPPERCASE
            modelo.setNomeModelo(modelo.getNomeModelo().toUpperCase());            
            SQL.setLength(0);
            SQL.append("UPDATE CAD_MODELO ");
            SQL.append("SET NM_MODELO = ?, ");
            SQL.append("CD_MARCA = ? ");
            SQL.append("WHERE CD_MODELO = ? ");            
            ps = super.getConexao().prepareStatement(SQL.toString());            
            ps.setString(1, modelo.getNomeModelo());
            ps.setLong(2, modelo.getMarca().getCodigoMarca());                        
            ps.setLong(3, modelo.getCodigoModelo());
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }

    public Modelo getByIdModelo(Long codigoModelo){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT MOD.CD_MODELO AS CD_MODELO, ");
            SQL.append("  MOD.NM_MODELO AS NM_MODELO, ");
            SQL.append("  MAR.CD_MARCA AS CD_MARCA, ");
            SQL.append("  MAR.NM_MARCA AS NM_MARCA ");
            SQL.append("  FROM CAD_MODELO MOD ");
            SQL.append("  INNER JOIN CAD_MARCA MAR ON (MOD.CD_MARCA = MAR.CD_MARCA) ");
            SQL.append("  WHERE CD_MODELO = ?");            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);            
            ps.setLong(1, codigoModelo);            
            super.resultSet = ps.executeQuery();
            super.resultSet.first();            
            modelo = new Modelo();            
            modelo.setCodigoModelo(super.resultSet.getLong("CD_MODELO"));
            modelo.setNomeModelo(super.resultSet.getString("NM_MODELO"));
            modelo.setMarca((Marca) marcaDao.getByIdMarca(super.resultSet.getLong("CD_MARCA")));
            return modelo;            
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores(ps);
        }
    }

    public List<Modelo> getAllModelo(){
        try {
            SQL.setLength(0);
            SQL.append("SELECT CD_MODELO, NM_MODELO, CD_MARCA ");
            SQL.append("FROM CAD_MODELO ");
            SQL.append("ORDER BY CD_MODELO");                                    
            super.executeSQL(SQL.toString());   
            listaModelo = new ArrayList<>();            
            while(super.resultSet.next()){
                modelo = new Modelo();
                modelo.setCodigoModelo(super.resultSet.getLong("CD_MODELO"));
                modelo.setNomeModelo(super.resultSet.getString("NM_MODELO"));
                modelo.setMarca((Marca) marcaDao.getByIdMarca(super.resultSet.getLong("CD_MARCA")));                
                listaModelo.add(modelo);
            }
            return listaModelo;
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores();
        }
    }

    public List<Modelo> getModelosByIdMarca(Long codigoMarca){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT ");
            SQL.append("CD_MODELO, ");
            SQL.append("CD_MARCA, ");
            SQL.append("NM_MODELO ");
            SQL.append("FROM CAD_MODELO ");
            SQL.append("WHERE CD_MARCA = ?");            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);            
            ps.setObject(1, codigoMarca);            
            super.resultSet = ps.executeQuery();
            listaModelo = new ArrayList<>();            
            while(super.resultSet.next()){
                modelo = new Modelo();                
                modelo.setCodigoModelo(super.resultSet.getLong("CD_MODELO"));
                modelo.setNomeModelo(super.resultSet.getString("NM_MODELO"));
                modelo.setMarca((Marca) marcaDao.getByIdMarca(super.resultSet.getLong("CD_MARCA")));                
                listaModelo.add(modelo);
            }
            return listaModelo;
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores();
            super.fecharCursores(ps);
        }
    }
    
    /**@return RESULTSET GET ALL.
     * 
     */
    public ResultSet resultSetGetAllModelo(){
        try {
            SQL.setLength(0);
            SQL.append("SELECT MOD.CD_MODELO AS CD_MODELO, ");
            SQL.append("MOD.NM_MODELO AS NM_MODELO, ");
            SQL.append("MAR.CD_MARCA AS CD_MARCA, ");
            SQL.append("MAR.NM_MARCA AS NM_MARCA ");
            SQL.append("FROM CAD_MODELO MOD ");
            SQL.append("INNER JOIN CAD_MARCA MAR ");
            SQL.append("ON (MOD.CD_MARCA = MAR.CD_MARCA) ");
            SQL.append("ORDER BY MOD.CD_MODELO");            
            super.executeSQL(SQL.toString());            
            return resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    /**RETURN RESULTSET GET BY ID.
     * 
     */
    public ResultSet resultSetGetByIdModelo(Long codigoModelo){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT MOD.CD_MODELO, ");
            SQL.append("MOD.NM_MODELO, ");
            SQL.append("MAR.CD_MARCA, ");
            SQL.append("MAR.NM_MARCA ");
            SQL.append("FROM CAD_MODELO MOD ");
            SQL.append("INNER JOIN CAD_MARCA MAR ");
            SQL.append("ON (MOD.CD_MARCA = MAR.CD_MARCA) ");
            SQL.append("WHERE MOD.CD_MODELO = ?");            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);            
            ps.setObject(1, codigoModelo);            
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
    public ResultSet resultSetGetByNomeModelo(String nomeModelo){
        PreparedStatement ps = null;
        try {
            nomeModelo = nomeModelo.toUpperCase();
            SQL.setLength(0);
            SQL.append("SELECT MOD.CD_MODELO, ");
            SQL.append("MOD.NM_MODELO, ");
            SQL.append("MAR.CD_MARCA, ");
            SQL.append("MAR.NM_MARCA ");
            SQL.append("FROM CAD_MODELO MOD ");
            SQL.append("INNER JOIN CAD_MARCA MAR ");
            SQL.append("ON (MOD.CD_MARCA = MAR.CD_MARCA) ");
            SQL.append("WHERE MOD.NM_MODELO LIKE ?");            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);            
            ps.setObject(1, "%" + nomeModelo + "%");            
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
    public ResultSet resultSetGetByNomeMarca(String nomeMarca){
        PreparedStatement ps = null;
        try {
            nomeMarca = nomeMarca.toUpperCase();
            SQL.setLength(0);
            SQL.append("SELECT MOD.CD_MODELO, ");
            SQL.append("MOD.NM_MODELO, ");
            SQL.append("MAR.CD_MARCA, ");
            SQL.append("MAR.NM_MARCA ");
            SQL.append("FROM CAD_MODELO MOD ");
            SQL.append("INNER JOIN CAD_MARCA MAR ");
            SQL.append("ON (MOD.CD_MARCA = MAR.CD_MARCA) ");
            SQL.append("WHERE MAR.NM_MARCA LIKE ?");            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);            
            ps.setObject(1, "%" + nomeMarca + "%");            
            super.resultSet = ps.executeQuery();            
            return super.resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
}
