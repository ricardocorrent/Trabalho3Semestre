/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.tools;

import br.com.rcorrent.dao.ConexaoOracle;
import java.sql.SQLException;

/**
 *Classe que retorna o último código salvo +1 
 * @author rcorrent
 */
public class UltimaSequencia extends ConexaoOracle{
    
    private final StringBuilder SQL = new StringBuilder();

    public Long getUltimaSequencia(String nomeTabela, String nomeColuna) {
        try {
            SQL.setLength(0);
            SQL.append("SELECT COALESCE(MAX(").append(nomeColuna).append("),0)+1 FROM ").append(nomeTabela);
            super.executeSQL(SQL.toString());
            super.resultSet.first();
            return super.resultSet.getLong(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            super.fecharCursores();
        }

    }
    
    public Long getUltimaSequencia(String nomeTabela, String nomeColuna, String campoChave, String valorChave) {
        try {
            SQL.setLength(0);
            SQL.append("SELECT COALESCE(MAX(").append(nomeColuna).append("),0)+1 FROM ").append(nomeTabela);
            SQL.append(" WHERE ").append(campoChave).append(" = ").append(valorChave);
            super.executeSQL(SQL.toString());
            super.resultSet.first();
            return super.resultSet.getLong(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            super.fecharCursores();
        }

    }
    
    
    
}
