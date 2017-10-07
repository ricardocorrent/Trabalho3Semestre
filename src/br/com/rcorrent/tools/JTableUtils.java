/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.tools;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jsoliveira
 */
public class JTableUtils {
    
    public static void preencherJTable(JTable jTable, ResultSet resultSet, List<String> campos ){
        try {            
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            model.setNumRows(0);            
            while(resultSet.next()){                
                Object [] row = new Object[campos.size()];                
                int contador = 0;                
                for(String s : campos){
                    row[contador] = resultSet.getString(s);
                    contador++;
                }
                model.addRow(row);
            }            
        } catch (SQLException e) {            
        }
    }
    
    public static void formatarJtable(JTable tabela, int valores[]) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        if (modelo.getColumnCount() == valores.length) {
            for (int x = 0; x < valores.length; x++) {
                tabela.getColumnModel().getColumn(x).setPreferredWidth(valores[x]);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor verificar os parametros passados !");
        }
    }

    public static void limparJtable(JTable table) {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setNumRows(0);
        } catch (Exception ex) {

        }
    }
}