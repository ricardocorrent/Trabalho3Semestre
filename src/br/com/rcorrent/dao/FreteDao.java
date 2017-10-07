/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.dao;

import br.com.rcorrent.model.Diesel;
import br.com.rcorrent.model.Endereco;
import br.com.rcorrent.model.Frete;
import br.com.rcorrent.model.Veiculo;
import br.com.rcorrent.tools.DataUtils;
import br.com.rcorrent.tools.UltimaSequencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author rcorrent
 */
public class FreteDao extends ConexaoOracle{
    
    private final StringBuilder SQL = new StringBuilder();
    private final UltimaSequencia sequencia = new UltimaSequencia();
    
    private final VeiculoDao veiculoDao = new VeiculoDao();
    private final EnderecoDao enderecoDao = new EnderecoDao();
    private final DieselDao dieselDao = new DieselDao();
    
    private Frete frete;
    private Veiculo veiculo;
    private Endereco enderecoOrigem;
    private Endereco enderecoDestino;
    private Diesel diesel;
    
    public void inserirFrete(Frete frete){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("INSERT INTO FRETE(");
            SQL.append("NR_DOCUMENTO, ");
            SQL.append("NR_PLACA, ");
            SQL.append("DT_PRECO, ");
            SQL.append("CD_ENDERECO_ORIGEM, ");
            SQL.append("CD_ENDERECO_DESTINO, ");
            SQL.append("DT_FRETE, ");
            SQL.append("DS_PRODUTO, ");
            SQL.append("QT_PRODUTO, ");
            SQL.append("VL_PESO_TON, ");
            SQL.append("VL_FRETE, ");
            SQL.append("DISTANCIA) ");
            SQL.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            
            ps = super.getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            frete.setCodigoFrete(sequencia.getUltimaSequencia("FRETE", "NR_DOCUMENTO"));
            
            frete.setDescricaoProduto(frete.getDescricaoProduto().toUpperCase());
            
            ps.setLong(1, frete.getCodigoFrete());
            ps.setString(2, frete.getVeiculo().getNumeroPlaca());
            ps.setString(3, DataUtils.dateTimeToStringYY(frete.getPrecoDiesel().getDataPreco()));
            ps.setLong(4, frete.getEnderecoOrigem().getCodigoEndereco());
            ps.setLong(5, frete.getEnderecoDestino().getCodigoEndereco());
            ps.setString(6, DataUtils.dateTimeToStringYY(frete.getDataFrete()));
            ps.setString(7, frete.getDescricaoProduto());            
            ps.setDouble(8, frete.getQuantidadeProduto());
            ps.setDouble(9, frete.getValorPeso());
            ps.setDouble(10, frete.getValorFrete());
            ps.setDouble(11, frete.getDistancia());
            
            
            System.out.println("codigoFrete " + frete.getCodigoFrete());
            System.out.println("placa " + frete.getVeiculo().getNumeroPlaca());
            System.out.println("dataDiesel " + DataUtils.dateTimeToStringYY(frete.getPrecoDiesel().getDataPreco()));
            System.out.println("origem " + frete.getEnderecoOrigem().getCodigoEndereco());
            System.out.println("destino " +frete.getEnderecoDestino().getCodigoEndereco());
            System.out.println("dataFrete " + DataUtils.dateTimeToStringYY(frete.getDataFrete()));
            System.out.println("descriçãoProduto " + frete.getDescricaoProduto());            
            System.out.println("quantidadeProduto " + frete.getQuantidadeProduto());
            System.out.println("valorPeso " + frete.getValorPeso());
            System.out.println("valorFrete " + frete.getValorFrete());
            System.out.println("distancia " + frete.getDistancia());
            
            ps.execute();
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    public void alterarFrete(Frete frete){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("UPDATE FRETE ");
            SQL.append("SET NR_PLACA = ?, ");
            SQL.append("DT_PRECO = ?, ");
            SQL.append("CD_ENDERECO_ORIGEM = ?, ");
            SQL.append("CD_ENDERECO_DESTINO = ?, ");
            SQL.append("DT_FRETE = ?, ");
            SQL.append("DS_PRODUTO = ?, ");
            SQL.append("QT_PRODUTO = ?, ");
            SQL.append("VL_PESO_TON = ?, ");
            SQL.append("VL_FRETE = ?, ");
            SQL.append("DISTANCIA = ? ");
            SQL.append("WHERE NR_DOCUMENTO = ?");
            
            ps = super.getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            System.out.println("codigoFrete " + frete.getCodigoFrete());
            System.out.println("placa " + frete.getVeiculo().getNumeroPlaca());
            System.out.println("dataDiesel " + DataUtils.dateTimeToStringYY(frete.getPrecoDiesel().getDataPreco()));
            System.out.println("origem " + frete.getEnderecoOrigem().getCodigoEndereco());
            System.out.println("destino " +frete.getEnderecoDestino().getCodigoEndereco());
            System.out.println("dataFrete " + DataUtils.dateTimeToStringYY(frete.getDataFrete()));
            System.out.println("descriçãoProduto " + frete.getDescricaoProduto());            
            System.out.println("quantidadeProduto " + frete.getQuantidadeProduto());
            System.out.println("valorPeso " + frete.getValorPeso());
            System.out.println("valorFrete " + frete.getValorFrete());
            System.out.println("distancia " + frete.getDistancia());
            
            frete.setDescricaoProduto(frete.getDescricaoProduto().toUpperCase());
           
            ps.setString(1, frete.getVeiculo().getNumeroPlaca());
            ps.setString(2, DataUtils.dateTimeToStringYY(frete.getPrecoDiesel().getDataPreco()));
            ps.setLong(3, frete.getEnderecoOrigem().getCodigoEndereco());
            ps.setLong(4, frete.getEnderecoDestino().getCodigoEndereco());
            ps.setString(5, DataUtils.dateTimeToStringYY(frete.getDataFrete()));
            ps.setString(6, frete.getDescricaoProduto());            
            ps.setDouble(7, frete.getQuantidadeProduto());
            ps.setDouble(8, frete.getValorPeso());
            ps.setDouble(9, frete.getValorFrete());             
            ps.setDouble(10, frete.getDistancia());             
            ps.setLong(11, frete.getCodigoFrete());
            
            
            ps.execute();
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    public void excluirFrete(Frete frete){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("DELETE FROM FRETE WHERE NR_DOCUMENTO = ?");
            
            ps = super.getConexao().prepareStatement(SQL.toString());
            
            ps.setLong(1, frete.getCodigoFrete());
            
            ps.execute();
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
        } finally {
            super.fecharCursores(ps);
        }
    }
    
    public Frete getById(Long codigoFrete){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT NR_DOCUMENTO, ");
            SQL.append("NR_PLACA, ");
            SQL.append("TO_CHAR(DT_PRECO,'DD/MM/YY HH24:MI:SS') AS DT_PRECO, ");
            SQL.append("CD_ENDERECO_ORIGEM, ");
            SQL.append("CD_ENDERECO_DESTINO, ");
            SQL.append("TO_CHAR(DT_FRETE,'DD/MM/YY HH24:MI:SS') AS DT_FRETE, ");
            SQL.append("DS_PRODUTO, ");
            SQL.append("QT_PRODUTO, ");
            SQL.append("VL_PESO_TON, ");
            SQL.append("VL_FRETE, ");
            SQL.append("DISTANCIA ");
            SQL.append("FROM FRETE ");
            SQL.append("WHERE NR_DOCUMENTO = ?");
            
            
            ps = super.getConexao().prepareStatement(SQL.toString(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, codigoFrete);
            
            super.resultSet = ps.executeQuery();
            super.resultSet.first();
            
            System.out.println("CD_ENDERECO_ORIGEM = " + super.resultSet.getLong("CD_ENDERECO_ORIGEM"));
            
            frete = new Frete();
            frete.setCodigoFrete(super.resultSet.getLong("NR_DOCUMENTO"));
            veiculo = (Veiculo) veiculoDao.getByPlacaVeiculo(super.resultSet.getString("NR_PLACA"));
            diesel = (Diesel) dieselDao.getByIdDiesel(super.resultSet.getString("DT_PRECO"));
            
            enderecoOrigem = (Endereco) enderecoDao.getById(super.resultSet.getLong("CD_ENDERECO_ORIGEM"));
            enderecoDestino = (Endereco) enderecoDao.getById(super.resultSet.getLong("CD_ENDERECO_DESTINO"));
            
            frete.setVeiculo(veiculo);
            frete.setPrecoDiesel(diesel);
            frete.setEnderecoOrigem(enderecoOrigem);
            frete.setEnderecoDestino(enderecoDestino);
            frete.setDataFrete(DataUtils.stringToDateTimeYY(super.resultSet.getString("DT_FRETE")));
            frete.setDescricaoProduto(super.resultSet.getString("DS_PRODUTO"));
            frete.setQuantidadeProduto(super.resultSet.getDouble("QT_PRODUTO"));
            frete.setValorPeso(super.resultSet.getDouble("VL_PESO_TON"));
            frete.setValorFrete(super.resultSet.getDouble("VL_FRETE"));
            frete.setDistancia(super.resultSet.getDouble("DISTANCIA"));
            
            return frete;
        } catch (Exception e) {
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
            SQL.append("SELECT FRE.NR_DOCUMENTO AS NR_DOCUMENTO, ");
            SQL.append("VEI.NR_PLACA AS NR_PLACA, ");
            SQL.append("MOD.NM_MODELO AS NM_MODELO, ");
            SQL.append("MAR.NM_MARCA AS NM_MARCA, ");
            SQL.append("TO_CHAR(DIE.DT_PRECO, 'DD/MM/YY HH24:MI:SS') AS DT_PRECO, ");
            SQL.append("CIDO.NM_CIDADE AS CID_ORIGEM, ");
            SQL.append("CIDD.NM_CIDADE AS CID_DESTINO, ");
            SQL.append("TO_CHAR(FRE.DT_FRETE, 'DD/MM/YY HH24:MI:SS') AS DT_FRETE, ");
            SQL.append("FRE.DS_PRODUTO AS DS_PRODUTO, ");
            SQL.append("QT_PRODUTO, ");
            SQL.append("VL_PESO_TON, ");
            SQL.append("(VL_PESO_TON * QT_PRODUTO) AS VL_PRODUTO, ");
            SQL.append("VL_FRETE, ");
            SQL.append("DISTANCIA ");
            SQL.append("FROM FRETE FRE ");
            SQL.append("INNER JOIN CAD_VEICULO VEI ON(FRE.NR_PLACA = VEI.NR_PLACA) ");
            SQL.append("INNER JOIN CAD_MODELO MOD ON(VEI.CD_MODELO = MOD.CD_MODELO) ");
            SQL.append("INNER JOIN CAD_MARCA MAR ON(MOD.CD_MARCA = MAR.CD_MARCA) ");
            SQL.append("INNER JOIN CAD_DIESEL DIE ON(FRE.DT_PRECO = DIE.DT_PRECO) ");
            SQL.append("INNER JOIN CAD_ENDERECO ENDO ON(FRE.CD_ENDERECO_ORIGEM = ENDO.CD_ENDERECO) ");
            SQL.append("INNER JOIN CAD_CIDADE CIDO ON(ENDO.CD_CIDADE = CIDO.CD_CIDADE) ");
            SQL.append("INNER JOIN CAD_ENDERECO ENDD ON(FRE.CD_ENDERECO_DESTINO = ENDD.CD_ENDERECO) ");
            SQL.append("INNER JOIN CAD_CIDADE CIDD ON(ENDD.CD_CIDADE = CIDD.CD_CIDADE) ");
            SQL.append("ORDER BY 1 ");
            
            super.executeSQL(SQL.toString());
            
            return resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet resultSetGetById(Long numeroDocumento){
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT FRE.NR_DOCUMENTO AS NR_DOCUMENTO, ");
            SQL.append("VEI.NR_PLACA AS NR_PLACA, ");
            SQL.append("MOD.NM_MODELO AS NM_MODELO, ");
            SQL.append("MAR.NM_MARCA AS NM_MARCA, ");
            SQL.append("TO_CHAR(DIE.DT_PRECO, 'DD/MM/YY HH24:MI:SS') AS DT_PRECO, ");
            SQL.append("CIDO.NM_CIDADE AS CID_ORIGEM, ");
            SQL.append("CIDD.NM_CIDADE AS CID_DESTINO, ");
            SQL.append("TO_CHAR(FRE.DT_FRETE, 'DD/MM/YY HH24:MI:SS') AS DT_FRETE, ");
            SQL.append("FRE.DS_PRODUTO AS DS_PRODUTO, ");
            SQL.append("QT_PRODUTO, ");
            SQL.append("VL_PESO_TON, ");
            SQL.append("VL_FRETE, ");
            SQL.append("DISTANCIA ");
            SQL.append("FROM FRETE FRE ");
            SQL.append("INNER JOIN CAD_VEICULO VEI ON(FRE.NR_PLACA = VEI.NR_PLACA) ");
            SQL.append("INNER JOIN CAD_MODELO MOD ON(VEI.CD_MODELO = MOD.CD_MODELO) ");
            SQL.append("INNER JOIN CAD_MARCA MAR ON(MOD.CD_MARCA = MAR.CD_MARCA) ");
            SQL.append("INNER JOIN CAD_DIESEL DIE ON(FRE.DT_PRECO = DIE.DT_PRECO) ");
            SQL.append("INNER JOIN CAD_ENDERECO ENDO ON(FRE.CD_ENDERECO_ORIGEM = ENDO.CD_ENDERECO) ");
            SQL.append("INNER JOIN CAD_CIDADE CIDO ON(ENDO.CD_CIDADE = CIDO.CD_CIDADE) ");
            SQL.append("INNER JOIN CAD_ENDERECO ENDD ON(FRE.CD_ENDERECO_DESTINO = ENDD.CD_ENDERECO) ");
            SQL.append("INNER JOIN CAD_CIDADE CIDD ON(ENDD.CD_CIDADE = CIDD.CD_CIDADE) ");
            SQL.append("WHERE FRE.NR_DOCUMENTO = ? ");
            
            ps = super.getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, numeroDocumento);
            
            super.resultSet = ps.executeQuery();
            
            return super.resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet resultSetGetByOrigem(String origem){
        origem = origem.toUpperCase();
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT FRE.NR_DOCUMENTO AS NR_DOCUMENTO, ");
            SQL.append("VEI.NR_PLACA AS NR_PLACA, ");
            SQL.append("MOD.NM_MODELO AS NM_MODELO, ");
            SQL.append("MAR.NM_MARCA AS NM_MARCA, ");
            SQL.append("TO_CHAR(DIE.DT_PRECO, 'DD/MM/YY HH24:MI:SS') AS DT_PRECO, ");
            SQL.append("CIDO.NM_CIDADE AS CID_ORIGEM, ");
            SQL.append("CIDD.NM_CIDADE AS CID_DESTINO, ");
            SQL.append("TO_CHAR(FRE.DT_FRETE, 'DD/MM/YY HH24:MI:SS') AS DT_FRETE, ");
            SQL.append("FRE.DS_PRODUTO AS DS_PRODUTO, ");
            SQL.append("QT_PRODUTO, ");
            SQL.append("VL_PESO_TON, ");
            SQL.append("VL_FRETE, ");
            SQL.append("DISTANCIA ");
            SQL.append("FROM FRETE FRE ");
            SQL.append("INNER JOIN CAD_VEICULO VEI ON(FRE.NR_PLACA = VEI.NR_PLACA) ");
            SQL.append("INNER JOIN CAD_MODELO MOD ON(VEI.CD_MODELO = MOD.CD_MODELO) ");
            SQL.append("INNER JOIN CAD_MARCA MAR ON(MOD.CD_MARCA = MAR.CD_MARCA) ");
            SQL.append("INNER JOIN CAD_DIESEL DIE ON(FRE.DT_PRECO = DIE.DT_PRECO) ");
            SQL.append("INNER JOIN CAD_ENDERECO ENDO ON(FRE.CD_ENDERECO_ORIGEM = ENDO.CD_ENDERECO) ");
            SQL.append("INNER JOIN CAD_CIDADE CIDO ON(ENDO.CD_CIDADE = CIDO.CD_CIDADE) ");
            SQL.append("INNER JOIN CAD_ENDERECO ENDD ON(FRE.CD_ENDERECO_DESTINO = ENDD.CD_ENDERECO) ");
            SQL.append("INNER JOIN CAD_CIDADE CIDD ON(ENDD.CD_CIDADE = CIDD.CD_CIDADE) ");
            SQL.append("WHERE CIDO.NM_CIDADE LIKE ? ");
            
            ps = super.getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, "%" + origem + "%");
            
            super.resultSet = ps.executeQuery();
            
            return super.resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet resultSetGetByDestino(String destino){
        destino = destino.toUpperCase();
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT FRE.NR_DOCUMENTO AS NR_DOCUMENTO, ");
            SQL.append("VEI.NR_PLACA AS NR_PLACA, ");
            SQL.append("MOD.NM_MODELO AS NM_MODELO, ");
            SQL.append("MAR.NM_MARCA AS NM_MARCA, ");
            SQL.append("TO_CHAR(DIE.DT_PRECO, 'DD/MM/YY HH24:MI:SS') AS DT_PRECO, ");
            SQL.append("CIDO.NM_CIDADE AS CID_ORIGEM, ");
            SQL.append("CIDD.NM_CIDADE AS CID_DESTINO, ");
            SQL.append("TO_CHAR(FRE.DT_FRETE, 'DD/MM/YY HH24:MI:SS') AS DT_FRETE, ");
            SQL.append("FRE.DS_PRODUTO AS DS_PRODUTO, ");
            SQL.append("QT_PRODUTO, ");
            SQL.append("VL_PESO_TON, ");
            SQL.append("VL_FRETE, ");
            SQL.append("DISTANCIA ");
            SQL.append("FROM FRETE FRE ");
            SQL.append("INNER JOIN CAD_VEICULO VEI ON(FRE.NR_PLACA = VEI.NR_PLACA) ");
            SQL.append("INNER JOIN CAD_MODELO MOD ON(VEI.CD_MODELO = MOD.CD_MODELO) ");
            SQL.append("INNER JOIN CAD_MARCA MAR ON(MOD.CD_MARCA = MAR.CD_MARCA) ");
            SQL.append("INNER JOIN CAD_DIESEL DIE ON(FRE.DT_PRECO = DIE.DT_PRECO) ");
            SQL.append("INNER JOIN CAD_ENDERECO ENDO ON(FRE.CD_ENDERECO_ORIGEM = ENDO.CD_ENDERECO) ");
            SQL.append("INNER JOIN CAD_CIDADE CIDO ON(ENDO.CD_CIDADE = CIDO.CD_CIDADE) ");
            SQL.append("INNER JOIN CAD_ENDERECO ENDD ON(FRE.CD_ENDERECO_DESTINO = ENDD.CD_ENDERECO) ");
            SQL.append("INNER JOIN CAD_CIDADE CIDD ON(ENDD.CD_CIDADE = CIDD.CD_CIDADE) ");
            SQL.append("WHERE CIDD.NM_CIDADE LIKE ? ");
            
            ps = super.getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, "%" + destino + "%");
            
            super.resultSet = ps.executeQuery();
            
            return super.resultSet;
        } catch (Exception e) {
            //printar o comando SQL
            System.out.println(SQL);
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet resultSetGetByProduto(String produto){
        produto = produto.toUpperCase();
        PreparedStatement ps = null;
        try {
            SQL.setLength(0);
            SQL.append("SELECT FRE.NR_DOCUMENTO AS NR_DOCUMENTO, ");
            SQL.append("VEI.NR_PLACA AS NR_PLACA, ");
            SQL.append("MOD.NM_MODELO AS NM_MODELO, ");
            SQL.append("MAR.NM_MARCA AS NM_MARCA, ");
            SQL.append("TO_CHAR(DIE.DT_PRECO, 'DD/MM/YY HH24:MI:SS') AS DT_PRECO, ");
            SQL.append("CIDO.NM_CIDADE AS CID_ORIGEM, ");
            SQL.append("CIDD.NM_CIDADE AS CID_DESTINO, ");
            SQL.append("TO_CHAR(FRE.DT_FRETE, 'DD/MM/YY HH24:MI:SS') AS DT_FRETE, ");
            SQL.append("FRE.DS_PRODUTO AS DS_PRODUTO, ");
            SQL.append("QT_PRODUTO, ");
            SQL.append("VL_PESO_TON, ");
            SQL.append("VL_FRETE, ");
            SQL.append("DISTANCIA ");
            SQL.append("FROM FRETE FRE ");
            SQL.append("INNER JOIN CAD_VEICULO VEI ON(FRE.NR_PLACA = VEI.NR_PLACA) ");
            SQL.append("INNER JOIN CAD_MODELO MOD ON(VEI.CD_MODELO = MOD.CD_MODELO) ");
            SQL.append("INNER JOIN CAD_MARCA MAR ON(MOD.CD_MARCA = MAR.CD_MARCA) ");
            SQL.append("INNER JOIN CAD_DIESEL DIE ON(FRE.DT_PRECO = DIE.DT_PRECO) ");
            SQL.append("INNER JOIN CAD_ENDERECO ENDO ON(FRE.CD_ENDERECO_ORIGEM = ENDO.CD_ENDERECO) ");
            SQL.append("INNER JOIN CAD_CIDADE CIDO ON(ENDO.CD_CIDADE = CIDO.CD_CIDADE) ");
            SQL.append("INNER JOIN CAD_ENDERECO ENDD ON(FRE.CD_ENDERECO_DESTINO = ENDD.CD_ENDERECO) ");
            SQL.append("INNER JOIN CAD_CIDADE CIDD ON(ENDD.CD_CIDADE = CIDD.CD_CIDADE) ");
            SQL.append("WHERE FRE.DS_PRODUTO LIKE ? ");
            
            ps = super.getConexao().prepareStatement(SQL.toString(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ps.setObject(1, "%" + produto + "%");
            
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
