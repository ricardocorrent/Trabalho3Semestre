/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.dao;

import static br.com.rcorrent.dao.ConexaoOracle.getConexao;
import br.com.rcorrent.model.Frete;
import br.com.rcorrent.model.Pedagio;
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
public class PedagioDao extends ConexaoOracle{
    
    private final StringBuilder SQL = new StringBuilder();
    private final UltimaSequencia sequencia = new UltimaSequencia();
    private final FreteDao freteDao = new FreteDao();
    
    private Pedagio pedagio;
    private Frete frete;
    
    private List<Pedagio> listaPedagio;
    
    
    public void inserirPedagio(Pedagio pedagio){
        //Declarando uma PreparedStatement
        PreparedStatement ps = null;        
        try {
            SQL.setLength(0);
            SQL.append("INSERT INTO ");
            SQL.append("CAD_PEDAGIO(CD_PEDAGIO, NR_DOCUMENTO, VL_PEDAGIO, QT_PEDAGIO) ");
            SQL.append("VALUES(?,?,?,?)");
            
            ps = super.getConexao().prepareStatement(SQL.toString());
            
            pedagio.setCodigoPedagio(Long.valueOf(sequencia.getUltimaSequencia("CAD_PEDAGIO", "CD_PEDAGIO")));
            
            ps.setLong(1, pedagio.getCodigoPedagio());
            ps.setLong(2, pedagio.getFrete().getCodigoFrete());
            ps.setDouble(3, pedagio.getValorPedagio());
            ps.setDouble(4, pedagio.getQuantidadePedagio());
                        
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    public void deletarPedagio(Pedagio pedagio){
        //Declarando uma PreparedStatement
        PreparedStatement ps = null;        
        try {
            SQL.setLength(0);
            SQL.append("DELETE FROM CAD_PEDAGIO WHERE CD_PEDAGIO = ?");
            ps = super.getConexao().prepareStatement(SQL.toString());
            
            System.out.println(SQL.toString());
            
            ps.setLong(1, pedagio.getCodigoPedagio());
                        
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    public void alterarPedagio(Pedagio pedagio){
        //Declarando uma PreparedStatement
        PreparedStatement ps = null;        
        try {
            SQL.setLength(0);
            SQL.append("UPDATE CAD_PEDAGIO ");
            SQL.append("SET NR_DOCUMENTO = ?, ");
            SQL.append("VL_PEDAGIO = ?, ");
            SQL.append("QT_PEDAGIO = ? ");
            SQL.append("WHERE CD_PEDAGIO = ?");
            
            ps = super.getConexao().prepareStatement(SQL.toString());
            
            ps.setLong(1, pedagio.getFrete().getCodigoFrete());
            ps.setDouble(2, pedagio.getValorPedagio());
            ps.setDouble(3, pedagio.getQuantidadePedagio());
            ps.setLong(4, pedagio.getCodigoPedagio());
                        
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    } 
    
    public Pedagio getById(Long codigoPedagio){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT ");
            SQL.append("CD_PEDAGIO, NR_DOCUMENTO, VL_PEDAGIO, QT_PEDAGIO ");
            SQL.append("FROM CAD_PEDAGIO ");
            SQL.append("WHERE CD_PEDAGIO = ? ");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, codigoPedagio);
            
            super.resultSet = ps.executeQuery();
                                   
            super.resultSet.first();
            
            pedagio = new Pedagio();
            
            pedagio.setCodigoPedagio(super.resultSet.getLong("CD_PEDAGIO"));
            pedagio.setFrete(freteDao.getById(super.resultSet.getLong("NR_DOCUMENTO")));
            pedagio.setValorPedagio(super.resultSet.getDouble("VL_PEDAGIO"));
            pedagio.setQuantidadePedagio(super.resultSet.getLong("QT_PEDAGIO"));
            
            return pedagio;
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores();
        }
    }
    
    public Pedagio getByIdFrete(Long codigoFrete){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT ");
            SQL.append("CD_PEDAGIO, NR_DOCUMENTO, VL_PEDAGIO, QT_PEDAGIO ");
            SQL.append("FROM CAD_PEDAGIO ");
            SQL.append("WHERE NR_DOCUMENTO = ? ");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, codigoFrete);
            
            super.resultSet = ps.executeQuery();
                                   
            super.resultSet.first();
            
            pedagio = new Pedagio();
            
            pedagio.setCodigoPedagio(super.resultSet.getLong("CD_PEDAGIO"));
            pedagio.setFrete(freteDao.getById(super.resultSet.getLong("NR_DOCUMENTO")));
            pedagio.setValorPedagio(super.resultSet.getDouble("VL_PEDAGIO"));
            pedagio.setQuantidadePedagio(super.resultSet.getLong("QT_PEDAGIO"));
            
            return pedagio;
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores();
        }
    }
    
    public List<Pedagio> getAll(){
        try {
            SQL.setLength(0);
            SQL.append("SELECT ");
            SQL.append("CD_PEDAGIO, NR_DOCUMENTO, VL_PEDAGIO, QT_PEDAGIO ");
            SQL.append("FROM CAD_PEDAGIO ");
            SQL.append("ORDER BY CD_PEDAGIO ");
                        
            super.executeSQL(SQL.toString());
            
            listaPedagio = new ArrayList<>();
            
            while(super.resultSet.next()){
                pedagio = new Pedagio();
                
                pedagio.setCodigoPedagio(super.resultSet.getLong("CD_PEDAGIO"));
                pedagio.setFrete(freteDao.getById(super.resultSet.getLong("NR_DOCUMENTO")));
                pedagio.setValorPedagio(super.resultSet.getDouble("VL_PEDAGIO"));
                pedagio.setQuantidadePedagio(super.resultSet.getLong("QT_PEDAGIO"));
                listaPedagio.add(pedagio);
            }
            return listaPedagio;
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores();
        }
    }
    
    public ResultSet resultSetGetAll(){
        try {
            SQL.setLength(0);
            SQL.append("SELECT ");
            SQL.append("CD_PEDAGIO, NR_DOCUMENTO, VL_PEDAGIO, QT_PEDAGIO ");
            SQL.append("FROM CAD_PEDAGIO ");
            SQL.append("ORDER BY CD_PEDAGIO ");
            
            super.executeSQL(SQL.toString());
            
            return resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } 
    }
    
    public ResultSet resultSetGetById(Long codigoPedagio){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT ");
            SQL.append("CD_PEDAGIO, NR_DOCUMENTO, VL_PEDAGIO, QT_PEDAGIO ");
            SQL.append("FROM CAD_PEDAGIO ");
            SQL.append("WHERE CD_PEDAGIO = ?");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, codigoPedagio);
            
            super.resultSet = ps.executeQuery();
            
            return resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } 
    }
    
    public ResultSet resultSetGetByIdFrete(Long codigoFrete){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT ");
            SQL.append("CD_PEDAGIO, NR_DOCUMENTO, VL_PEDAGIO, QT_PEDAGIO ");
            SQL.append("FROM CAD_PEDAGIO ");
            SQL.append("WHERE NR_DOCUMENTO = ?");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, codigoFrete);
            
            super.resultSet = ps.executeQuery();
            
            return resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } 
    }
    
}
