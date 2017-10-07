/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.dao;

import br.com.rcorrent.model.Marca;
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
public class MarcaDao extends ConexaoOracle{
    
    private final StringBuilder SQL = new StringBuilder();
    private final UltimaSequencia sequencia = new UltimaSequencia();
    
    private Marca marca;
    
    private List<Marca> listaMarca;    

    public void inserirMarca(Marca marca){        
        //Declarando uma PreparedStatement
        PreparedStatement ps = null;        
        try {            
            //inserir codigo da marca automaticamente
            marca.setCodigoMarca(sequencia.getUltimaSequencia("CAD_MARCA", "CD_MARCA").longValue());                        
            //colocar NOME DA MARCA e ABREVIATURA em UPPERCASE
            marca.setNomeMarca(marca.getNomeMarca().toUpperCase());
            marca.setAbreviaturaMarca(marca.getAbreviaturaMarca().toUpperCase());            
            SQL.setLength(0);
            SQL.append("INSERT INTO CAD_MARCA( ");
            SQL.append("CD_MARCA, ");
            SQL.append("NM_MARCA, ");
            SQL.append("AB_MARCA ");
            SQL.append(") VALUES(?,?,?) ");            
            ps = super.getConexao().prepareStatement(SQL.toString());            
            ps.setLong(1, marca.getCodigoMarca());
            ps.setString(2, marca.getNomeMarca());
            ps.setString(3, marca.getAbreviaturaMarca());            
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }

    public void excluirMarca(Marca marca){
        PreparedStatement ps = null;        
        try {
            SQL.setLength(0);
            SQL.append("DELETE FROM CAD_MARCA ");
            SQL.append("WHERE CD_MARCA = ? ");            
            ps = super.getConexao().prepareStatement(SQL.toString());            
            ps.setLong(1, marca.getCodigoMarca());            
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }

    public void alterarMarca(Marca marca){        
        //Declarando uma PreparedStatement
        PreparedStatement ps = null;        
        try {                        
            //colocar NOME DA MARCA em UPPERCASE
            marca.setNomeMarca(marca.getNomeMarca().toUpperCase());
            marca.setAbreviaturaMarca(marca.getAbreviaturaMarca().toUpperCase());            
            SQL.setLength(0);
            SQL.append("UPDATE CAD_MARCA ");
            SQL.append("SET NM_MARCA = ?, ");
            SQL.append("AB_MARCA = ? ");
            SQL.append("WHERE CD_MARCA = ? ");            
            ps = super.getConexao().prepareStatement(SQL.toString());
            ps.setString(1, marca.getNomeMarca());
            ps.setString(2, marca.getAbreviaturaMarca());
            ps.setLong(3, marca.getCodigoMarca());            
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }

    public Marca getByIdMarca(Long codigoMarca){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT CD_MARCA, NM_MARCA, AB_MARCA ");
            SQL.append("FROM CAD_MARCA ");
            SQL.append("WHERE CD_MARCA = ?");            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);            
            ps.setObject(1, codigoMarca);            
            super.resultSet = ps.executeQuery();            
            super.resultSet.first();            
            marca = new Marca();            
            marca.setCodigoMarca(super.resultSet.getLong("CD_MARCA"));
            marca.setNomeMarca(super.resultSet.getString("NM_MARCA"));
            marca.setAbreviaturaMarca(super.resultSet.getString("AB_MARCA"));            
            return marca;
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores(ps);
        }
    }

    public List<Marca> getAllMarca(){
        try{
            SQL.setLength(0);
            SQL.append("SELECT CD_MARCA, NM_MARCA, AB_MARCA ");
            SQL.append("FROM CAD_MARCA ");
            SQL.append("ORDER BY CD_MARCA ");
            super.executeSQL(SQL.toString());
            listaMarca = new ArrayList<>();
            while(super.resultSet.next()){
                marca = new Marca();
                marca.setCodigoMarca(super.resultSet.getLong("CD_MARCA"));
                marca.setNomeMarca(super.resultSet.getString("NM_MARCA"));
                marca.setAbreviaturaMarca(super.resultSet.getString("AB_MARCA"));
                listaMarca.add(marca);
            }
            return listaMarca;
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }finally{
            super.fecharCursores();
        }
    }

    public ResultSet resultSetGetAllMarca(){
        try {
            SQL.setLength(0);
            SQL.append("SELECT CD_MARCA, NM_MARCA, AB_MARCA ");
            SQL.append("FROM CAD_MARCA ");
            SQL.append("ORDER BY CD_MARCA");            
            super.executeSQL(SQL.toString());            
            return resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet resultSetGetByIdMarca(Long codigoMarca){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT CD_MARCA, NM_MARCA, AB_MARCA FROM CAD_MARCA WHERE CD_MARCA = ?");            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);            
            ps.setObject(1, codigoMarca);            
            super.resultSet = ps.executeQuery();
            super.resultSet.first();            
            return super.resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet resultSetGetByNomeMarca(String nomeMarca){
        PreparedStatement ps = null;
        try {
            nomeMarca = nomeMarca.toUpperCase();
            SQL.setLength(0);
            SQL.append("SELECT CD_MARCA, NM_MARCA, AB_MARCA FROM CAD_MARCA WHERE NM_MARCA LIKE ?");            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);            
            ps.setObject(1, "%" + nomeMarca + "%");            
            super.resultSet = ps.executeQuery();            
            super.resultSet.first();            
            return super.resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet resultSetGetByAbreviaturaMarca(String abreviaturaMarca){
        PreparedStatement ps = null;
        try {
            //fazer pesquisa tudo em maiusculo
            abreviaturaMarca = abreviaturaMarca.toUpperCase();            
            SQL.setLength(0);
            SQL.append("SELECT ");
            SQL.append("CD_MARCA, ");
            SQL.append("NM_MARCA, ");
            SQL.append("AB_MARCA ");
            SQL.append("FROM CAD_MARCA ");
            SQL.append("WHERE AB_MARCA LIKE ?");            
            ps = getConexao().prepareStatement(SQL.toString(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);            
            ps.setObject(1, abreviaturaMarca);            
            super.resultSet = ps.executeQuery();            
            super.resultSet.first();            
            return super.resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
   
}
