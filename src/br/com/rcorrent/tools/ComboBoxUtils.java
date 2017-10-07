/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.tools;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author rcorrent
 */
public class ComboBoxUtils<T> {
    public void carregarCombo(JComboBox combo, ArrayList<T> lista) {
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) combo.getModel();
        combo.setModel(comboModel);
        try {
            //assim como é feito numa JTable, temos o DefaultComboBoxModel que é o model do JComboBox
            //removendo todos os elementos do combo
            comboModel.removeAllElements();
            //percorrendo a lista para inserir os valores no combo
            for (int linha = 0; linha < lista.size(); linha++) {
                //adicionando a categoria no combo
                comboModel.addElement(lista.get(linha));
            }

            combo.setSelectedIndex(-1);
        } catch (Exception e) {
            comboModel.removeAllElements();
        }
    }
    
    public static void preencherCombo(JComboBox combo, List<?> list) {

        DefaultComboBoxModel model = (DefaultComboBoxModel) combo.getModel();
        try {
            model.removeAllElements();

            for (int i = 0; i < list.size(); i++) {

                model.addElement(list.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
