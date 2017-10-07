/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.dao;

import br.com.rcorrent.model.Cidade;
import br.com.rcorrent.model.Endereco;
import br.com.rcorrent.tools.UltimaSequencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author rcorrent
 */
public class EnderecoDao extends ConexaoOracle{
    
    private final StringBuilder SQL = new StringBuilder();
    private final UltimaSequencia sequencia = new UltimaSequencia();
    private final CidadeDao cidadeDao = new CidadeDao();
    
    private Endereco endereco;
    private Cidade cidade;
    
    private List<Endereco> listaEndereco;
    
    /**INSERIR ENDERECO.
     * 
     */
    public void inserirEndereco(Endereco endereco){
        //Declarando uma PreparedStatement
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("INSERT INTO ");
            SQL.append("CAD_ENDERECO(CD_ENDERECO, CD_CIDADE, NR_CEP, NR_ENDERECO, NM_LOGRADOURO, NM_BAIRRO, COMPLEMENTO) ");
            SQL.append("VALUES(?,?,?,?,?,?,?)");
            
            ps = super.getConexao().prepareStatement(SQL.toString());
            
            endereco.setCodigoEndereco(sequencia.getUltimaSequencia("CAD_ENDERECO", "CD_ENDERECO"));
            //colocar strings em UPPERCASE
            endereco.setLogradouro(endereco.getLogradouro().toUpperCase());
            endereco.setBairro(endereco.getBairro().toUpperCase());
            endereco.setComplemento(endereco.getComplemento().toUpperCase());                
            
            
            ps.setLong(1, endereco.getCodigoEndereco());
            ps.setLong(2, endereco.getCidade().getCodigoCidade());
            ps.setString(3, endereco.getCep());
            ps.setString(4, endereco.getNumero());
            ps.setString(5, endereco.getLogradouro());
            ps.setString(6, endereco.getBairro());
            ps.setString(7, endereco.getComplemento());
            
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    /**EXCLUIR ENDERECO.
     * 
     */
    public void excluirEndereco(Endereco endereco){
        //Declarando uma PreparedStatement
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("DELETE FROM CAD_ENDERECO WHERE CD_ENDERECO = ?");
            
            ps = super.getConexao().prepareStatement(SQL.toString());
            
            ps.setLong(1, endereco.getCodigoEndereco());
            
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    /**ALTERAR ENDERECO.
     * 
     */
    public void alterarEndereco(Endereco endereco){
        //Declarando uma PreparedStatement
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("UPDATE CAD_ENDERECO ");
            SQL.append("SET CD_ENDERECO = ?, ");
            SQL.append("CD_CIDADE = ?, ");
            SQL.append("NR_CEP = ?, ");
            SQL.append("NR_ENDERECO = ?, ");
            SQL.append("NM_LOGRADOURO = ?, ");
            SQL.append("NM_BAIRRO = ?, ");
            SQL.append("COMPLEMENTO = ? ");
            SQL.append("WHERE CD_ENDERECO = ?");
            
            ps = super.getConexao().prepareStatement(SQL.toString());
            //colocar strings em UPPERCASE
            endereco.setLogradouro(endereco.getLogradouro().toUpperCase());
            endereco.setBairro(endereco.getBairro().toUpperCase());
            endereco.setComplemento(endereco.getComplemento().toUpperCase());
            
            ps.setLong(1, endereco.getCodigoEndereco());
            ps.setLong(2, endereco.getCidade().getCodigoCidade());
            ps.setString(3, endereco.getCep());
            ps.setString(4, endereco.getNumero());
            ps.setString(5, endereco.getLogradouro());
            ps.setString(6, endereco.getBairro());
            ps.setString(7, endereco.getComplemento());
            ps.setLong(8, endereco.getCodigoEndereco());
            
            ps.execute();
        } catch (SQLException e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    public Endereco getById(Long codigoEndereco){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT END.CD_ENDERECO, ");
            SQL.append("CID.CD_CIDADE AS CD_CIDADE, ");
            SQL.append("CID.NM_CIDADE, ");
            SQL.append("END.NR_CEP, ");
            SQL.append("END.NR_ENDERECO, ");
            SQL.append("END.NM_LOGRADOURO, ");
            SQL.append("END.NM_BAIRRO, ");
            SQL.append("END.COMPLEMENTO ");
            SQL.append("FROM CAD_ENDERECO END ");
            SQL.append("INNER JOIN CAD_CIDADE CID ON(END.CD_CIDADE = CID.CD_CIDADE) ");
            SQL.append("WHERE END.CD_ENDERECO = ? ");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, codigoEndereco);
            
            super.resultSet = ps.executeQuery();
            super.resultSet.first();
            
            endereco = new Endereco();
            cidade = new Cidade();
            
            cidade = (Cidade) cidadeDao.getByIdCidade(Long.valueOf(super.resultSet.getString("CD_CIDADE")));
            
            endereco.setCodigoEndereco(super.resultSet.getLong("CD_ENDERECO"));
            endereco.setCidade(cidade);
            endereco.setCep(super.resultSet.getString("NR_CEP"));
            endereco.setNumero(super.resultSet.getString("NR_ENDERECO"));
            endereco.setLogradouro(super.resultSet.getString("NM_LOGRADOURO"));
            endereco.setBairro(super.resultSet.getString("NM_BAIRRO"));
            endereco.setComplemento(super.resultSet.getString("COMPLEMENTO"));
            
            return endereco;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        } finally {
            super.fecharCursores();
            
        }
    }
    
    
    
    public ResultSet resultSetGetById(Long codigoEndereco){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT END.CD_ENDERECO, ");
            SQL.append("CID.CD_CIDADE, ");
            SQL.append("CID.NM_CIDADE, ");
            SQL.append("EST.SG_UF, ");
            SQL.append("EST.NM_UF, ");
            SQL.append("EST.CD_UF, ");
            SQL.append("END.NR_CEP, ");
            SQL.append("END.NR_ENDERECO, ");
            SQL.append("END.NM_LOGRADOURO, ");
            SQL.append("END.NM_BAIRRO, ");
            SQL.append("END.COMPLEMENTO ");
            SQL.append("FROM CAD_ENDERECO END ");
            SQL.append("INNER JOIN CAD_CIDADE CID ON(END.CD_CIDADE = CID.CD_CIDADE) ");
            SQL.append("INNER JOIN CAD_UF EST ON (CID.CD_UF = EST.CD_UF) ");
            SQL.append("WHERE END.CD_ENDERECO = ? ");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, codigoEndereco);
            
            super.resultSet = ps.executeQuery();
            return resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet resultSetGetByCidade(String nomeCidade){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT END.CD_ENDERECO, ");
            SQL.append("CID.CD_CIDADE, ");
            SQL.append("CID.NM_CIDADE, ");
            SQL.append("EST.SG_UF, ");
            SQL.append("EST.NM_UF, ");
            SQL.append("EST.CD_UF, ");
            SQL.append("END.NR_CEP, ");
            SQL.append("END.NR_ENDERECO, ");
            SQL.append("END.NM_LOGRADOURO, ");
            SQL.append("END.NM_BAIRRO, ");
            SQL.append("END.COMPLEMENTO ");
            SQL.append("FROM CAD_ENDERECO END ");
            SQL.append("INNER JOIN CAD_CIDADE CID ON(END.CD_CIDADE = CID.CD_CIDADE) ");
            SQL.append("INNER JOIN CAD_UF EST ON (CID.CD_UF = EST.CD_UF) ");
            SQL.append("WHERE CID.NM_CIDADE LIKE ? ");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, "%" + nomeCidade + "%");
            
            super.resultSet = ps.executeQuery();
            return resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet resultSetGetByLogradouro(String nomeLogradouro){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT END.CD_ENDERECO, ");
            SQL.append("CID.CD_CIDADE, ");
            SQL.append("CID.NM_CIDADE, ");
            SQL.append("EST.SG_UF, ");
            SQL.append("EST.NM_UF, ");
            SQL.append("EST.CD_UF, ");
            SQL.append("END.NR_CEP, ");
            SQL.append("END.NR_ENDERECO, ");
            SQL.append("END.NM_LOGRADOURO, ");
            SQL.append("END.NM_BAIRRO, ");
            SQL.append("END.COMPLEMENTO ");
            SQL.append("FROM CAD_ENDERECO END ");
            SQL.append("INNER JOIN CAD_CIDADE CID ON(END.CD_CIDADE = CID.CD_CIDADE) ");
            SQL.append("INNER JOIN CAD_UF EST ON (CID.CD_UF = EST.CD_UF) ");
            SQL.append("WHERE END.NM_LOGRADOURO LIKE ? ");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, "%" + nomeLogradouro + "%");
            
            super.resultSet = ps.executeQuery();
            return resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet resultSetGetByCep(String cep){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT END.CD_ENDERECO, ");
            SQL.append("CID.CD_CIDADE, ");
            SQL.append("CID.NM_CIDADE, ");
            SQL.append("EST.SG_UF, ");
            SQL.append("EST.NM_UF, ");
            SQL.append("EST.CD_UF, ");
            SQL.append("END.NR_CEP, ");
            SQL.append("END.NR_ENDERECO, ");
            SQL.append("END.NM_LOGRADOURO, ");
            SQL.append("END.NM_BAIRRO, ");
            SQL.append("END.COMPLEMENTO ");
            SQL.append("FROM CAD_ENDERECO END ");
            SQL.append("INNER JOIN CAD_CIDADE CID ON(END.CD_CIDADE = CID.CD_CIDADE) ");
            SQL.append("INNER JOIN CAD_UF EST ON (CID.CD_UF = EST.CD_UF) ");
            SQL.append("WHERE END.NR_CEP LIKE ? ");
            
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, "%" + cep + "%");
            
            super.resultSet = ps.executeQuery();
            return resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet resultSetGetAll(Long codigo){
        PreparedStatement ps = null;
        try {
            if(codigo == null){
                codigo = Long.parseLong("0");
            }
            SQL.setLength(0);
            SQL.append("SELECT END.CD_ENDERECO, ");
            SQL.append("CID.CD_CIDADE, ");
            SQL.append("CID.NM_CIDADE, ");
            SQL.append("EST.SG_UF, ");
            SQL.append("EST.NM_UF, ");
            SQL.append("EST.CD_UF, ");
            SQL.append("END.NR_CEP, ");
            SQL.append("END.NR_ENDERECO, ");
            SQL.append("END.NM_LOGRADOURO, ");
            SQL.append("END.NM_BAIRRO, ");
            SQL.append("END.COMPLEMENTO ");
            SQL.append("FROM CAD_ENDERECO END ");
            SQL.append("INNER JOIN CAD_CIDADE CID ON(END.CD_CIDADE = CID.CD_CIDADE) ");
            SQL.append("INNER JOIN CAD_UF EST ON (CID.CD_UF = EST.CD_UF) ");
            SQL.append("WHERE END.CD_ENDERECO <> ? ");
            SQL.append("ORDER BY END.CD_ENDERECO ");
            ps = getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);            
            ps.setObject(1, codigo);
            System.out.println("codigo " + codigo);
            System.out.println(SQL);
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
