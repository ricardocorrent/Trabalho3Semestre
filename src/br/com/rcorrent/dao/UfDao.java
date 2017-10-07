package br.com.rcorrent.dao;

import static br.com.rcorrent.dao.ConexaoOracle.getConexao;
import br.com.rcorrent.model.Uf;
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
public class UfDao extends ConexaoOracle{
    
    private final StringBuilder SQL = new StringBuilder();
    private final UltimaSequencia sequencia = new UltimaSequencia();
    
    private Uf uf;
    
    private List<Uf> listaUf;
    
    public void inserir(Uf uf){
        PreparedStatement ps = null;
        try{
            //limpar a string
            SQL.setLength(0);            
            SQL.append("INSERT INTO CAD_UF(CD_UF,SG_UF,NM_UF) VALUES(?,?,?)");            
            //inserir codigo da cidade automaticamente
            uf.setCodigoUf(sequencia.getUltimaSequencia("CAD_UF", "CD_UF").longValue());                        
            //colocar NOME em UPPERCASE
            uf.setNomeUf(uf.getNomeUf().toUpperCase());
            uf.setSiglaUf(uf.getSiglaUf().toUpperCase());            
            ps = super.getConexao().prepareStatement(SQL.toString());            
            ps.setLong(1, uf.getCodigoUf());
            ps.setString(2, uf.getSiglaUf());
            ps.setString(3, uf.getNomeUf());            
            ps.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            super.fecharCursores(ps);
        }
    }
    
    public void excluir(Uf uf){
        PreparedStatement ps = null;
        try{
            //limpar a string
            SQL.setLength(0);            
            SQL.append("DELETE FROM CAD_UF WHERE CD_UF = ? ");                        
            ps = super.getConexao().prepareStatement(SQL.toString());            
            ps.setLong(1, uf.getCodigoUf());            
            ps.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            super.fecharCursores(ps);
        }
    }
    
    public void alterar(Uf uf){
        PreparedStatement ps = null;
        try{
            //limpar a string
            SQL.setLength(0);
            SQL.append("UPDATE CAD_UF ");
            SQL.append("SET ");
            SQL.append("SG_UF = ?, ");
            SQL.append("NM_UF = ?  ");
            SQL.append("WHERE CD_UF = ?");                                    
            //colocar NOME em UPPERCASE
            uf.setNomeUf(uf.getNomeUf().toUpperCase());
            uf.setSiglaUf(uf.getSiglaUf().toUpperCase());                        
            ps = super.getConexao().prepareStatement(SQL.toString());           
            ps.setString(1, uf.getSiglaUf());
            ps.setString(2, uf.getNomeUf());
            ps.setLong(3, uf.getCodigoUf());            
            ps.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            super.fecharCursores(ps);
        }
    }
    
    public Uf getById(Long codigoUf){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT CD_UF, NM_UF, SG_UF FROM CAD_UF WHERE CD_UF = ?");            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);            
            ps.setObject(1, codigoUf);           
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
            super.fecharCursores(ps);
        }
    }
    
    public List<Uf> getAll(){
        try {
            SQL.setLength(0);
            SQL.append("SELECT CD_UF, NM_UF, SG_UF FROM CAD_UF ORDER BY SG_UF");            
            super.executeSQL(SQL.toString());            
            listaUf = new ArrayList<>();            
            while(super.resultSet.next()){
                uf = new Uf();
                uf.setCodigoUf(super.resultSet.getLong("CD_UF"));
                uf.setNomeUf(super.resultSet.getString("NM_UF"));
                uf.setSiglaUf(super.resultSet.getString("SG_UF"));                
                listaUf.add(uf);
            }            
            return listaUf;
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
            SQL.append("CD_UF, ");
            SQL.append("SG_UF, ");
            SQL.append("NM_UF ");
            SQL.append("FROM CAD_UF ");
            SQL.append("ORDER BY NM_UF ");            
            super.executeSQL(SQL.toString());
            System.out.println(SQL);
            return super.resultSet;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet resultSetGetById(Long codigoUf){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT CD_UF, SG_UF, NM_UF FROM CAD_UF ");
            SQL.append("WHERE CD_UF = ?");                        
            ps = super.getConexao().prepareStatement(SQL.toString(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);            
            ps.setObject(1, codigoUf);            
            super.resultSet = ps.executeQuery();            
            return super.resultSet;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet resultSetGetByNomeUf(String nomeUf){
        PreparedStatement ps = null;
        try {
            nomeUf = nomeUf.toUpperCase();
            SQL.setLength(0);
            SQL.append("SELECT CD_UF, SG_UF, NM_UF FROM CAD_UF ");
            SQL.append("WHERE NM_UF LIKE ?");                        
            ps = super.getConexao().prepareStatement(SQL.toString(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);            
            ps.setObject(1, "%" + nomeUf + "%");            
            super.resultSet = ps.executeQuery();            
            return super.resultSet;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet resultSetGetBySiglaUf(String siglaUf){
        PreparedStatement ps = null;
        try {
            siglaUf = siglaUf.toUpperCase();
            SQL.setLength(0);
            SQL.append("SELECT CD_UF, SG_UF, NM_UF FROM CAD_UF ");
            SQL.append("WHERE SG_UF LIKE ?");                        
            ps = super.getConexao().prepareStatement(SQL.toString(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);            
            ps.setObject(1, "%" + siglaUf + "%");            
            super.resultSet = ps.executeQuery();            
            return super.resultSet;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
