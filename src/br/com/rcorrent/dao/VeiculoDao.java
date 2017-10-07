/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.dao;

import br.com.rcorrent.model.Marca;
import br.com.rcorrent.model.Modelo;
import br.com.rcorrent.model.Veiculo;
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
public class VeiculoDao extends ConexaoOracle{
    
    private final StringBuilder SQL = new StringBuilder();
    private final UltimaSequencia sequencia = new UltimaSequencia();
    
    private final ModeloDao modeloDao = new ModeloDao();
    private final MarcaDao marcaDao = new MarcaDao();
    
    private Veiculo veiculo;
    private Modelo modelo;
    private Marca marca;
    
    private List<Veiculo> listaVeiculo;
    
    /**INSERIR VEICULO.
     * 
     */
    public void inserirVeiculo(Veiculo veiculo){
        //Declarando uma PreparedStatement
        PreparedStatement ps = null;
        
        try {
            SQL.setLength(0);
            SQL.append("INSERT INTO "
                    + "CAD_VEICULO(NR_PLACA,CD_MODELO,NR_CHASSI,NR_RENAVAN,NR_ANO_MODELO,NR_ANO_FABRICACAO,VL_CAPACIDADE_TON,QD_EIXO,VL_AUTONOMIA,VL_CONSUMO) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps = super.getConexao().prepareStatement(SQL.toString());
            
            System.out.println(SQL.toString());
            //colocar strings em UPPERCASE
            veiculo.setNumeroPlaca(veiculo.getNumeroPlaca().toUpperCase());
            veiculo.setNumeroChassi(veiculo.getNumeroChassi().toUpperCase());
            veiculo.setNumeroRenavan(veiculo.getNumeroRenavan().toUpperCase());
            
            //veiculo.setNumeroPlaca(veiculo.getNumeroPlaca().replace("-", ""));
            
            
            ps.setString(1, veiculo.getNumeroPlaca());
            ps.setLong(2, veiculo.getModelo().getCodigoModelo());
            ps.setString(3, veiculo.getNumeroChassi());
            ps.setString(4, veiculo.getNumeroRenavan());
            ps.setInt(5, veiculo.getAnoModelo());
            ps.setInt(6, veiculo.getAnoFabricacao());
            ps.setDouble(7, veiculo.getCapacidadeEmTonelada()); 
            ps.setInt(8, veiculo.getQuantidadeDeEixo());
            ps.setDouble(9, veiculo.getAutonomia());
            ps.setDouble(10, veiculo.getConsumoPorKm());
            
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    /**EXCLUIR VEICULO.
     * 
     */
    public void excluirVeiculo(Veiculo veiculo){
        PreparedStatement ps = null;  
        try {
            SQL.setLength(0);
            SQL.append("DELETE FROM CAD_VEICULO WHERE CD_VEICULO = ? ");
            
            ps = super.getConexao().prepareStatement(SQL.toString());
            
            ps.setString(1, veiculo.getNumeroPlaca());
            
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    /**ALTERAR VEICULO.
     * 
     */
    public void alterarVeiculo(Veiculo veiculo){
        //Declarando uma PreparedStatement
        PreparedStatement ps = null;
        
        try {
            SQL.setLength(0);
            SQL.append("UPDATE CAD_VEICULO ");
            SQL.append("SET NR_PLACA = ?, ");
            SQL.append("CD_MODELO = ?, ");
            SQL.append("NR_CHASSI = ?, ");
            SQL.append("NR_RENAVAN = ?, ");
            SQL.append("NR_ANO_MODELO = ?, ");
            SQL.append("NR_ANO_FABRICACAO = ?, ");
            SQL.append("VL_CAPACIDADE_TON = ?, ");
            SQL.append("QD_EIXO = ?, ");
            SQL.append("VL_AUTONOMIA = ?, ");
            SQL.append("VL_CONSUMO = ? ");
            SQL.append("WHERE NR_PLACA = ?");
            
            ps = super.getConexao().prepareStatement(SQL.toString());
            
            //colocar strings em UPPERCASE
            veiculo.setNumeroPlaca(veiculo.getNumeroPlaca().toUpperCase());
            veiculo.setNumeroChassi(veiculo.getNumeroChassi().toUpperCase());
            veiculo.setNumeroRenavan(veiculo.getNumeroRenavan().toUpperCase());
            
            ps.setString(1, veiculo.getNumeroPlaca());
            ps.setLong(2, veiculo.getModelo().getCodigoModelo());
            ps.setString(3, veiculo.getNumeroChassi());
            ps.setString(4, veiculo.getNumeroRenavan());
            ps.setInt(5, veiculo.getAnoModelo());
            ps.setInt(6, veiculo.getAnoFabricacao());
            ps.setDouble(7, veiculo.getCapacidadeEmTonelada());
            ps.setInt(8, veiculo.getQuantidadeDeEixo());
            ps.setDouble(9, veiculo.getAutonomia());
            ps.setDouble(10, veiculo.getConsumoPorKm());
            ps.setString(11, veiculo.getNumeroPlaca());
            
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    /**Retornar Objeto Veiculo pela PLACA.
     * 
     */    
    public Veiculo getByPlacaVeiculo(String numeroPlaca){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT VEI.NR_PLACA, ");
            SQL.append("VEI.NR_CHASSI, ");
            SQL.append("MOD.CD_MODELO, ");
            SQL.append("MOD.NM_MODELO, ");
            SQL.append("MAR.CD_MARCA AS CD_MARCA, ");
            SQL.append("MAR.NM_MARCA AS NM_MARCA, ");
            SQL.append("VEI.NR_RENAVAN, ");
            SQL.append("VEI.NR_ANO_MODELO, ");
            SQL.append("VEI.NR_ANO_FABRICACAO, ");
            SQL.append("VEI.VL_CAPACIDADE_TON, ");
            SQL.append("VEI.QD_EIXO, ");
            SQL.append("VEI.VL_AUTONOMIA, ");
            SQL.append("VEI.VL_CONSUMO ");
            SQL.append("FROM CAD_VEICULO VEI ");
            SQL.append("INNER JOIN CAD_MODELO MOD ON (VEI.CD_MODELO = MOD.CD_MODELO) ");
            SQL.append("INNER JOIN CAD_MARCA MAR ON (MAR.CD_MARCA = MOD.CD_MARCA) ");
            SQL.append("WHERE VEI.NR_PLACA LIKE ?");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, "%" + numeroPlaca + "%");
            
            super.resultSet = ps.executeQuery();
                                   
            super.resultSet.first();
            
            veiculo = new Veiculo();
            
            veiculo.setNumeroPlaca(super.resultSet.getString("NR_PLACA"));
            veiculo.setModelo((Modelo)modeloDao.getByIdModelo(super.resultSet.getLong("CD_MODELO")));
            veiculo.getModelo().setMarca((Marca) marcaDao.getByIdMarca(super.resultSet.getLong("CD_MARCA")));
            veiculo.setNumeroChassi(super.resultSet.getString("NR_CHASSI"));
            veiculo.setNumeroRenavan(super.resultSet.getString("NR_RENAVAN"));
            veiculo.setAnoModelo(super.resultSet.getInt("NR_ANO_MODELO"));
            veiculo.setAnoFabricacao(super.resultSet.getInt("NR_ANO_FABRICACAO"));
            veiculo.setCapacidadeEmTonelada(super.resultSet.getDouble("VL_CAPACIDADE_TON"));
            veiculo.setQuantidadeDeEixo(super.resultSet.getInt("QD_EIXO"));
            veiculo.setAutonomia(super.resultSet.getDouble("VL_AUTONOMIA"));
            veiculo.setConsumoPorKm(super.resultSet.getDouble("VL_CONSUMO"));
            
            return veiculo;            
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores();
        }
    }
    
    /**Retornar Objeto Todos os Veiculos.
     * 
     */    
    public List<Veiculo> getAllVeiculo(){
        try {
            SQL.setLength(0);
            SQL.append("SELECT NR_PLACA, ");
            SQL.append("CD_MODELO, ");
            SQL.append("NR_CHASSI, ");
            SQL.append("NR_RENAVAN, ");
            SQL.append("NR_ANO_MODELO, ");
            SQL.append("NR_ANO_FABRICACAO, ");
            SQL.append("VL_CAPACIDADE_TON, ");
            SQL.append("QD_EIXO, ");
            SQL.append("VL_AUTONOMIA, ");
            SQL.append("VL_CONSUMO ");
            SQL.append("FROM CAD_VEICULO ");
            SQL.append("ORDER BY NR_PLACA");
            
            super.executeSQL(SQL.toString());            
            
            listaVeiculo = new ArrayList<>();
            
            while(super.resultSet.next()){
                
                veiculo = new Veiculo();
                modelo = new Modelo();

                modelo = modeloDao.getByIdModelo(super.resultSet.getLong("CD_MODELO"));

                veiculo.setNumeroPlaca(super.resultSet.getString("NR_PLACA"));
                veiculo.setModelo(modelo);
                veiculo.setNumeroChassi(super.resultSet.getString("NR_CHASSI"));
                veiculo.setNumeroRenavan(super.resultSet.getString("NR_RENAVAN"));
                veiculo.setAnoModelo(super.resultSet.getInt("NR_ANO_MODELO"));
                veiculo.setAnoFabricacao(super.resultSet.getInt("NR_ANO_FABRICACAO"));
                veiculo.setCapacidadeEmTonelada(super.resultSet.getDouble("VL_CAPACIDADE_TON"));
                veiculo.setQuantidadeDeEixo(super.resultSet.getInt("QD_EIXO"));
                veiculo.setAutonomia(super.resultSet.getDouble("VL_AUTONOMIA"));
                veiculo.setConsumoPorKm(super.resultSet.getDouble("VL_CONSUMO"));
                
                listaVeiculo.add(veiculo);
            }
            
            return listaVeiculo;            
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores();
        }
    }
  
    public ResultSet resultSetGetAllVeiculo(Double peso){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT VEI.NR_PLACA AS NR_PLACA, ");
            SQL.append("VEI.NR_CHASSI AS NR_CHASSI, ");
            SQL.append("MOD.CD_MODELO AS CD_MODELO, ");
            SQL.append("MOD.NM_MODELO AS NM_MODELO, ");
            SQL.append("MAR.CD_MARCA AS CD_MARCA, ");
            SQL.append("MAR.NM_MARCA AS NM_MARCA, ");
            SQL.append("VEI.NR_RENAVAN AS NR_RENAVAN, ");
            SQL.append("VEI.NR_ANO_MODELO AS NR_ANO_MODELO, ");
            SQL.append("VEI.NR_ANO_FABRICACAO AS NR_ANO_FABRICACAO, ");
            SQL.append("VEI.VL_CAPACIDADE_TON AS VL_CAPACIDADE_TON, ");
            SQL.append("VEI.QD_EIXO AS QD_EIXO, ");
            SQL.append("VEI.VL_AUTONOMIA AS VL_AUTONOMIA, ");
            SQL.append("VEI.VL_CONSUMO AS VL_CONSUMO ");
            SQL.append("FROM CAD_VEICULO VEI ");
            SQL.append("INNER JOIN CAD_MODELO MOD ON (VEI.CD_MODELO = MOD.CD_MODELO) ");
            SQL.append("INNER JOIN CAD_MARCA MAR ON (MAR.CD_MARCA = MOD.CD_MARCA) ");
            SQL.append("WHERE VEI.VL_CAPACIDADE_TON >= ? ");
            SQL.append("ORDER BY VEI.NR_PLACA");
            System.out.println(SQL);
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, peso);
            
            super.resultSet = ps.executeQuery();
            return resultSet;            
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    /**@RETURN RESULTSET GET MARCA.
     * 
     */
    public ResultSet resultSetgetByMarcaVeiculo(String marcaVeiculo){
        PreparedStatement ps = null;
        try {
            marcaVeiculo = marcaVeiculo.toUpperCase();
            SQL.setLength(0);
            SQL.append("SELECT VEI.NR_PLACA AS NR_PLACA, ");
            SQL.append("VEI.NR_CHASSI AS NR_CHASSI, ");
            SQL.append("MOD.CD_MODELO AS CD_MODELO, ");
            SQL.append("MOD.NM_MODELO AS NM_MODELO, ");
            SQL.append("MAR.CD_MARCA AS CD_MARCA, ");
            SQL.append("MAR.NM_MARCA AS NM_MARCA, ");
            SQL.append("VEI.NR_RENAVAN AS NR_RENAVAN, ");
            SQL.append("VEI.NR_ANO_MODELO AS NR_ANO_MODELO, ");
            SQL.append("VEI.NR_ANO_FABRICACAO AS NR_ANO_FABRICACAO, ");
            SQL.append("VEI.VL_CAPACIDADE_TON AS VL_CAPACIDADE_TON, ");
            SQL.append("VEI.QD_EIXO AS QD_EIXO, ");
            SQL.append("VEI.VL_AUTONOMIA AS VL_AUTONOMIA, ");
            SQL.append("VEI.VL_CONSUMO AS VL_CONSUMO ");
            SQL.append("FROM CAD_VEICULO VEI ");
            SQL.append("INNER JOIN CAD_MODELO MOD ON (VEI.CD_MODELO = MOD.CD_MODELO) ");
            SQL.append("INNER JOIN CAD_MARCA MAR ON (MAR.CD_MARCA = MOD.CD_MARCA) ");
            SQL.append("WHERE MAR.NM_MARCA LIKE ?");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, "%" + marcaVeiculo + "%");
            
            super.resultSet = ps.executeQuery();
            
            
            return resultSet;            
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    /**@RETURN RESULTSET GET MODELO.
     * 
     */
    public ResultSet resultSetgetByModeloVeiculo(String modeloVeiculo){
        PreparedStatement ps = null;
        try {
            modeloVeiculo = modeloVeiculo.toUpperCase();
            SQL.setLength(0);
            SQL.append("SELECT VEI.NR_PLACA AS NR_PLACA, ");
            SQL.append("VEI.NR_CHASSI AS NR_CHASSI, ");
            SQL.append("MOD.CD_MODELO AS CD_MODELO, ");
            SQL.append("MOD.NM_MODELO AS NM_MODELO, ");
            SQL.append("MAR.CD_MARCA AS CD_MARCA, ");
            SQL.append("MAR.NM_MARCA AS NM_MARCA, ");
            SQL.append("VEI.NR_RENAVAN AS NR_RENAVAN, ");
            SQL.append("VEI.NR_ANO_MODELO AS NR_ANO_MODELO, ");
            SQL.append("VEI.NR_ANO_FABRICACAO AS NR_ANO_FABRICACAO, ");
            SQL.append("VEI.VL_CAPACIDADE_TON AS VL_CAPACIDADE_TON, ");
            SQL.append("VEI.QD_EIXO AS QD_EIXO, ");
            SQL.append("VEI.VL_AUTONOMIA AS VL_AUTONOMIA, ");
            SQL.append("VEI.VL_CONSUMO AS VL_CONSUMO ");
            SQL.append("FROM CAD_VEICULO VEI ");
            SQL.append("INNER JOIN CAD_MODELO MOD ON (VEI.CD_MODELO = MOD.CD_MODELO) ");
            SQL.append("INNER JOIN CAD_MARCA MAR ON (MAR.CD_MARCA = MOD.CD_MARCA) ");
            SQL.append("WHERE MOD.NM_MODELO LIKE ? ");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, "%" + modeloVeiculo + "%");
            
            super.resultSet = ps.executeQuery();
            
            return resultSet;            
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    /**@RETURN RESULTSET GET BY PLACA.
     * 
     */
    public ResultSet resultSetgetByPlacaVeiculo(String placaVeiculo){
        PreparedStatement ps = null;
        try {
            placaVeiculo = placaVeiculo.toUpperCase();
            SQL.setLength(0);
            SQL.append("SELECT VEI.NR_PLACA AS NR_PLACA, ");
            SQL.append("VEI.NR_CHASSI AS NR_CHASSI, ");
            SQL.append("MOD.CD_MODELO AS CD_MODELO, ");
            SQL.append("MOD.NM_MODELO AS NM_MODELO, ");
            SQL.append("MAR.CD_MARCA AS CD_MARCA, ");
            SQL.append("MAR.NM_MARCA AS NM_MARCA, ");
            SQL.append("VEI.NR_RENAVAN AS NR_RENAVAN, ");
            SQL.append("VEI.NR_ANO_MODELO AS NR_ANO_MODELO, ");
            SQL.append("VEI.NR_ANO_FABRICACAO AS NR_ANO_FABRICACAO, ");
            SQL.append("VEI.VL_CAPACIDADE_TON AS VL_CAPACIDADE_TON, ");
            SQL.append("VEI.QD_EIXO AS QD_EIXO, ");
            SQL.append("VEI.VL_AUTONOMIA AS VL_AUTONOMIA, ");
            SQL.append("VEI.VL_CONSUMO AS VL_CONSUMO ");
            SQL.append("FROM CAD_VEICULO VEI ");
            SQL.append("INNER JOIN CAD_MODELO MOD ON (VEI.CD_MODELO = MOD.CD_MODELO) ");
            SQL.append("INNER JOIN CAD_MARCA MAR ON (MAR.CD_MARCA = MOD.CD_MARCA) ");
            SQL.append("WHERE VEI.NR_PLACA LIKE ?");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, "%" + placaVeiculo + "%");
            
            super.resultSet = ps.executeQuery();
            
            return resultSet;            
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    /**@RETURN RESULTSET GET BY ANO MODELO/FABRICACAO.
     * 
     */
    public ResultSet resultSetgetByAnoVeiculo(Integer anoVeiculo){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT VEI.NR_PLACA AS NR_PLACA, ");
            SQL.append("VEI.NR_CHASSI AS NR_CHASSI, ");
            SQL.append("MOD.CD_MODELO AS CD_MODELO, ");
            SQL.append("MOD.NM_MODELO AS NM_MODELO, ");
            SQL.append("MAR.CD_MARCA AS CD_MARCA, ");
            SQL.append("MAR.NM_MARCA AS NM_MARCA, ");
            SQL.append("VEI.NR_RENAVAN AS NR_RENAVAN, ");
            SQL.append("VEI.NR_ANO_MODELO AS NR_ANO_MODELO, ");
            SQL.append("VEI.NR_ANO_FABRICACAO AS NR_ANO_FABRICACAO, ");
            SQL.append("VEI.VL_CAPACIDADE_TON AS VL_CAPACIDADE_TON, ");
            SQL.append("VEI.QD_EIXO AS QD_EIXO, ");
            SQL.append("VEI.VL_AUTONOMIA AS VL_AUTONOMIA, ");
            SQL.append("VEI.VL_CONSUMO AS VL_CONSUMO ");
            SQL.append("FROM CAD_VEICULO VEI ");
            SQL.append("INNER JOIN CAD_MODELO MOD ON (VEI.CD_MODELO = MOD.CD_MODELO) ");
            SQL.append("INNER JOIN CAD_MARCA MAR ON (MAR.CD_MARCA = MOD.CD_MARCA) ");
            SQL.append("WHERE VEI.NR_ANO_MODELO LIKE ? ");
            SQL.append("OR NR_ANO_FABRICACAO LIKE ? ");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, "%" + anoVeiculo + "%");
            ps.setObject(2, "%" + anoVeiculo + "%");
            
            super.resultSet = ps.executeQuery();
            
            return resultSet;            
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    
    /**@RETURN RESULTSET GET BY ANO MODELO/FABRICACAO.
     * 
     */
    public ResultSet resultSetgetByEixoVeiculo(Integer eixoVeiculo){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT VEI.NR_PLACA AS NR_PLACA, ");
            SQL.append("VEI.NR_CHASSI AS NR_CHASSI, ");
            SQL.append("MOD.CD_MODELO AS CD_MODELO, ");
            SQL.append("MOD.NM_MODELO AS NM_MODELO, ");
            SQL.append("MAR.CD_MARCA AS CD_MARCA, ");
            SQL.append("MAR.NM_MARCA AS NM_MARCA, ");
            SQL.append("VEI.NR_RENAVAN AS NR_RENAVAN, ");
            SQL.append("VEI.NR_ANO_MODELO AS NR_ANO_MODELO, ");
            SQL.append("VEI.NR_ANO_FABRICACAO AS NR_ANO_FABRICACAO, ");
            SQL.append("VEI.VL_CAPACIDADE_TON AS VL_CAPACIDADE_TON, ");
            SQL.append("VEI.QD_EIXO AS QD_EIXO, ");
            SQL.append("VEI.VL_AUTONOMIA AS VL_AUTONOMIA, ");
            SQL.append("VEI.VL_CONSUMO AS VL_CONSUMO ");
            SQL.append("FROM CAD_VEICULO VEI ");
            SQL.append("INNER JOIN CAD_MODELO MOD ON (VEI.CD_MODELO = MOD.CD_MODELO) ");
            SQL.append("INNER JOIN CAD_MARCA MAR ON (MAR.CD_MARCA = MOD.CD_MARCA) ");
            SQL.append("WHERE VEI.QD_EIXO = ?");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, eixoVeiculo);
            
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
