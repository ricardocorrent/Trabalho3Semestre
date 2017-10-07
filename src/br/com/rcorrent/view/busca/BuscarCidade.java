/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.view.busca;

import br.com.rcorrent.dao.CidadeDao;
import br.com.rcorrent.tools.JTableUtils;
import br.com.rcorrent.view.CidadeView;
import java.awt.Dialog;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rcorrent
 */
public class BuscarCidade extends javax.swing.JDialog {
    
    private final CidadeDao cidadeDao = new CidadeDao();

    public BuscarCidade(Dialog owner, boolean modal) {
        super(owner, modal);
        initComponents();
        
        
        //formatar os campo da tabela de consulta
        JTableUtils.formatarJtable(jtLista,new int[]{60,170,170});
    }
    
    
    
    public String codigoCidade;
    /**
     * Creates new form BuscarCidade
     */
    public BuscarCidade(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        
        //formatar os campo da tabela de consulta
        JTableUtils.formatarJtable(jtLista,new int[]{60,170,170});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jcbFiltrar = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jtfValor = new javax.swing.JTextField();
        jbPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLista = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setText("Filtrar");

        jcbFiltrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Geral", "Código Cidade", "Nome Cidade", "UF" }));
        jcbFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltrarActionPerformed(evt);
            }
        });

        jLabel6.setText("Valor");

        jtfValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfValorActionPerformed(evt);
            }
        });

        jbPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/rcorrent/icons/1491673267_search.png"))); // NOI18N
        jbPesquisar.setMnemonic('P');
        jbPesquisar.setText("Pesquisar");
        jbPesquisar.setIconTextGap(10);
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        jtLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cidade", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtLista);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/rcorrent/icons/1491671388_new10.png"))); // NOI18N
        jButton1.setText("Adicionar Novo");
        jButton1.setIconTextGap(10);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtfValor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(643, 367));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiltrarActionPerformed
        if(jcbFiltrar.getSelectedIndex() == 0){
            jtfValor.setEnabled(false);
        }else{
            jtfValor.setVisible(true);
        }
    }//GEN-LAST:event_jcbFiltrarActionPerformed

    private void jtfValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfValorActionPerformed

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed
        List<String> campos = new ArrayList<>();
        campos.add("CD_CIDADE");
        campos.add("NM_CIDADE");
        campos.add("NM_UF");
        /**Buscar com base no que foi selecionado na ComboBox de opção de filtro.
        * Usa-se um switch para selecionar a opção.
        */
        switch(jcbFiltrar.getSelectedIndex()){
            case 0:{//caso seja escolhido a opção GERAL
                JTableUtils.preencherJTable(jtLista, cidadeDao.resultSetGetAllCidade(), campos);
            } break;
            case 1:{//caso seja escolhido a opção CÓDIGO DA CIDADE
                try {
                    JTableUtils.preencherJTable(jtLista, cidadeDao.resultSetGetByIdCidade(Long.parseLong(jtfValor.getText())), campos);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Informe um valor numérico");
                }
            } break;
            case 2:{//caso seja escolhido a opção NOME DA CIDADE
                JTableUtils.preencherJTable(jtLista, cidadeDao.resultSetGetByNomeCidade(jtfValor.getText()), campos);
            } break;
            case 3:{//caso seja escolhido a opção NOME DA UF
                JTableUtils.preencherJTable(jtLista, cidadeDao.resultSetGetByNomeUf(jtfValor.getText()), campos);
            } break;
        }
        cidadeDao.fecharCursores();
    }//GEN-LAST:event_jbPesquisarActionPerformed

    private void jtListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaMouseClicked
        if(evt.getClickCount() > 1){
            this.codigoCidade = jtLista.getValueAt(jtLista.getSelectedRow(), 0).toString();
            dispose();
        }
    }//GEN-LAST:event_jtListaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CidadeView cidadeView = new CidadeView(this, true);
        cidadeView.setVisible(true);
        //new CidadeView().setVisible(true);
        //dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscarCidade dialog = new BuscarCidade(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JComboBox<String> jcbFiltrar;
    private javax.swing.JTable jtLista;
    private javax.swing.JTextField jtfValor;
    // End of variables declaration//GEN-END:variables



}
