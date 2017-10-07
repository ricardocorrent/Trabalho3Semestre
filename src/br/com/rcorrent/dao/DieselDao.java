/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.dao;

import br.com.rcorrent.model.Diesel;
import br.com.rcorrent.tools.DataUtils;
import br.com.rcorrent.tools.UltimaSequencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rcorrent
 */
public class DieselDao extends ConexaoOracle{
    
    private final StringBuilder SQL = new StringBuilder();
    private final UltimaSequencia sequencia = new UltimaSequencia();
    private final DataUtils dataUtils = new DataUtils();
    
    private Diesel diesel;
    
    private List<Diesel> listaDiesel;
    
    /**INSERIR DIESEL.
     * 
     */
    public void inserirDiesel(Diesel diesel){
        //Declarando uma PreparedStatement
        PreparedStatement ps = null;        
        try {
            SQL.setLength(0);
            SQL.append("INSERT INTO ");
            SQL.append("CAD_DIESEL(DT_PRECO, VL_PRECO) ");
            SQL.append("VALUES(?,?)");
            ps = super.getConexao().prepareStatement(SQL.toString());
            
            ps.setString(1, DataUtils.dateTimeToString(diesel.getDataPreco()));
            ps.setDouble(2, diesel.getValorDiesel());
            
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    /**EXCLUIR DIESEL.
     * 
     */
    public void excluirDiesel(Diesel diesel){
        PreparedStatement ps = null;  
        try {
            SQL.setLength(0);
            SQL.append("DELETE FROM CAD_DIESEL WHERE DT_PRECO LIKE ? ");
            
            ps = super.getConexao().prepareStatement(SQL.toString());
            
            ps.setString(1, DataUtils.dateTimeToStringYY(diesel.getDataPreco()) + "%");
            
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    /**ALTERAR DIESEL.
     * 
     */
    public void alterarDiesel(Diesel diesel, Date novaData){
        //Declarando uma PreparedStatement
        PreparedStatement ps = null;
        
        try {
            SQL.setLength(0);
            SQL.append("UPDATE CAD_DIESEL ");
            SQL.append("SET DT_PRECO = ?, ");
            SQL.append("VL_PRECO = ? ");
            SQL.append("WHERE DT_PRECO LIKE ?");
            ps = super.getConexao().prepareStatement(SQL.toString());
            
            //ps.setString(1, DataUtils.dateTimeToStringYY(diesel.getDataPreco()));
            ps.setString(1, DataUtils.dateTimeToString(novaData));
            ps.setDouble(2, diesel.getValorDiesel());
            ps.setString(3, DataUtils.dateTimeToStringYY(diesel.getDataPreco()) + "%");
            
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }
        
    /**Retornar Objeto DIESEL pela DATA.
     * 
     */
    public Diesel getByIdDiesel(String dataDiesel){
        PreparedStatement ps = null;
        try {
            System.out.println("dataDiesel " + dataDiesel);
            SQL.setLength(0);
            SQL.append("SELECT TO_CHAR(DT_PRECO,'DD/MM/YY HH24:MI:SS') AS DT_PRECO, VL_PRECO FROM CAD_DIESEL WHERE DT_PRECO LIKE ?");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, dataDiesel + "%");
            super.resultSet = ps.executeQuery();
            super.resultSet.first();
            
            diesel = new Diesel();
            
            diesel.setDataPreco(DataUtils.stringToDateTimeYY(super.resultSet.getString("DT_PRECO")));
            diesel.setValorDiesel(super.resultSet.getDouble("VL_PRECO"));
            
            return diesel;
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    public Diesel getByDataFrete(String dataFrete){
        PreparedStatement ps = null;
        try {
            
            SQL.setLength(0);
            SQL.append("SELECT ");
            SQL.append("TO_CHAR(DT_PRECO, 'DD/MM/YY HH24:MI:SS') AS DT_PRECO, ");
            SQL.append("VL_PRECO ");
            SQL.append("FROM CAD_DIESEL ");
            SQL.append("WHERE TO_CHAR(DT_PRECO, 'DD/MM/YY HH24:MI:SS') = (SELECT MAX(DT_PRECO) AS DATA ");
            SQL.append("FROM CAD_DIESEL ");
            SQL.append("WHERE DT_PRECO <= ? )");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            System.out.println("dataFrete no getByDataFrete " + dataFrete);
            
            ps.setString(1, dataFrete);
            super.resultSet = ps.executeQuery();
            super.resultSet.first();
            
            diesel = new Diesel();
            diesel.setDataPreco(DataUtils.stringToDateTimeYY(super.resultSet.getString("DT_PRECO")));
            diesel.setValorDiesel(super.resultSet.getDouble("VL_PRECO"));
            
            System.out.println("Printando o diesel no getByDataFrete ");
            System.out.println("Data: " + diesel.getDataPreco());
            System.out.println("Valor: " + diesel.getValorDiesel());
            return diesel;
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    /**Retornar Objeto Todos os Diesel.
     * 
     */ 
    public List<Diesel> getAllDiesel(){
        try {
            SQL.setLength(0);
            SQL.append("SELECT DT_PRECO, VL_PRECO FROM CAD_DIESEL ORDER BY DT_PRECO ");
            super.executeSQL(SQL.toString());
            
            listaDiesel = new ArrayList<>();
            
            while(super.resultSet.next()){
                diesel = new Diesel();
                diesel.setDataPreco(super.resultSet.getDate("DT_PRECO"));
                diesel.setValorDiesel(super.resultSet.getDouble("VL_PRECO"));
                listaDiesel.add(diesel);
            }
            return listaDiesel;
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores();
        }
    }
    
    /**Retornar RESULTSET GET ALL.
     * 
     */
    public ResultSet resultSetGetAllDiesel(){
        try {
            SQL.setLength(0);
            SQL.append("SELECT ");
            SQL.append("TO_CHAR(DT_PRECO, 'DD/MM/YY HH24:MI:SS') AS DT_PRECO, ");
            SQL.append("TO_CHAR(DT_PRECO, 'YYYY/MM/DD HH24:MI:SS') AS DT_PRECO_INVERTIDA, ");
            SQL.append("VL_PRECO ");
            SQL.append("FROM CAD_DIESEL ");
            SQL.append("ORDER BY DT_PRECO_INVERTIDA ");
            super.executeSQL(SQL.toString());
            return resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } 
    }
    
    public ResultSet resultSetGetByData(String data){
        System.out.println("data " + data);
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT ");
            SQL.append("TO_CHAR(DT_PRECO, 'DD/MM/YY HH24:MI:SS') AS DT_PRECO, ");
            SQL.append("TO_CHAR(DT_PRECO, 'YYYY/MM/DD HH24:MI:SS') AS DT_PRECO_INVERTIDA, ");
            SQL.append("VL_PRECO ");
            SQL.append("FROM CAD_DIESEL ");
            SQL.append("WHERE DT_PRECO LIKE ?");
            
            ps = super.getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setString(1, data + "%");
            
            super.resultSet = ps.executeQuery();
            return resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet resultSetGetByPreco(Double preco){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT ");
            SQL.append("TO_CHAR(DT_PRECO, 'DD/MM/YY HH24:MI:SS') AS DT_PRECO, ");
            SQL.append("TO_CHAR(DT_PRECO, 'YYYY/MM/DD HH24:MI:SS') AS DT_PRECO_INVERTIDA, ");
            SQL.append("VL_PRECO ");
            SQL.append("FROM CAD_DIESEL ");
            SQL.append("WHERE VL_PRECO = ?");
            
            ps = super.getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setDouble(1, preco);
            
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
