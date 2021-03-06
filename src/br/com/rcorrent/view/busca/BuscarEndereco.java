/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.view.busca;

import br.com.rcorrent.dao.EnderecoDao;
import br.com.rcorrent.tools.JTableUtils;
import br.com.rcorrent.view.EnderecoView;
import java.awt.Dialog;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rcorrent
 */
public class BuscarEndereco extends javax.swing.JDialog {
    
    public String codigoEndereco;
    
    private final EnderecoDao enderecoDao = new EnderecoDao();
    
    public Long codigoPassado;
    
    public BuscarEndereco(Dialog owner, boolean modal) {
        super(owner, modal);
        initComponents();
        this.codigoPassado = null;
        JTableUtils.formatarJtable(jtListaEndereco,new int[]{40,40,100,280,80});
    }
    public BuscarEndereco(Dialog owner, boolean modal, Long codigo) {
        super(owner, modal);
        initComponents();        
        this.codigoPassado = codigo;
        JTableUtils.formatarJtable(jtListaEndereco,new int[]{40,40,100,280,80});
    }
    
    /**
     * Creates new form BuscarEndereco
     */
    public BuscarEndereco(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.codigoPassado = null;
        JTableUtils.formatarJtable(jtListaEndereco,new int[]{40,40,100,280,80});
    }
    
    public BuscarEndereco(java.awt.Frame parent, boolean modal, Long codigo) {
        super(parent, modal);
        initComponents();
        this.codigoPassado = codigo;
        JTableUtils.formatarJtable(jtListaEndereco,new int[]{40,40,100,280,80});
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jtfValor = new javax.swing.JTextField();
        jbPesquisar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jcbFiltrar = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaEndereco = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel9.setText("Filtrar");

        jbPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/rcorrent/icons/1491673267_search.png"))); // NOI18N
        jbPesquisar.setMnemonic('P');
        jbPesquisar.setText("Pesquisar");
        jbPesquisar.setIconTextGap(10);
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        jLabel10.setText("Valor");

        jcbFiltrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Geral", "Código", "Cidade", "Logradouro", "CEP" }));
        jcbFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltrarActionPerformed(evt);
            }
        });

        jtListaEndereco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "UF", "Cidade", "Logradouro", "CEP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListaEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListaEnderecoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListaEndereco);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbPesquisar))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(681, 570));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed
        List<String> campos = new ArrayList<>();
        campos.add("CD_ENDERECO");
        campos.add("SG_UF");
        campos.add("NM_CIDADE");
        campos.add("NM_LOGRADOURO");
        campos.add("NR_CEP");

        switch(jcbFiltrar.getSelectedIndex()){
            case 0:{
                preencherTabelaEndereco();
            }break;
            case 1:{//código endereco
                try {
                    JTableUtils.preencherJTable(jtListaEndereco, enderecoDao.resultSetGetById(Long.valueOf(jtfValor.getText())), campos);
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Informe um valor numérico");
                    jtfValor.grabFocus();
                }
            }break;
            case 2:{//nome Cidade
                try {
                    if(!jtfValor.getText().isEmpty()){
                        JTableUtils.preencherJTable(jtListaEndereco, enderecoDao.resultSetGetByCidade(jtfValor.getText()), campos);
                    }else{
                        JOptionPane.showMessageDialog(null, "Alguma letra precisa ser informada");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Informe uma Cidade");
                    jtfValor.grabFocus();
                }
            }break;
            case 3:{//logradouro
                try {
                    if(!jtfValor.getText().isEmpty()){
                        JTableUtils.preencherJTable(jtListaEndereco, enderecoDao.resultSetGetByLogradouro(jtfValor.getText()), campos);
                    }else{
                        JOptionPane.showMessageDialog(null, "Alguma letra precisa ser informada");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Informe um Logradouro");
                    jtfValor.grabFocus();
                }
            }break;
            case 4:{//cep
                try {
                    if(!jtfValor.getText().isEmpty()){
                        JTableUtils.preencherJTable(jtListaEndereco, enderecoDao.resultSetGetByCep(jtfValor.getText()), campos);
                    }else{
                        JOptionPane.showMessageDialog(null, "Alguma letra precisa ser informada");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Informe um CEP");
                    jtfValor.grabFocus();
                }
            }break;
        }
        enderecoDao.fecharCursores();
    }//GEN-LAST:event_jbPesquisarActionPerformed

    private void jcbFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiltrarActionPerformed
        if(jcbFiltrar.getSelectedIndex() == 0){
            jtfValor.setEnabled(false);
        }else{
            jtfValor.setEnabled(true);
        }
    }//GEN-LAST:event_jcbFiltrarActionPerformed

    private void jtListaEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaEnderecoMouseClicked
        if(evt.getClickCount() > 1){
            this.codigoEndereco = jtListaEndereco.getValueAt(jtListaEndereco.getSelectedRow(), 0).toString();
            dispose();
        }
    }//GEN-LAST:event_jtListaEnderecoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EnderecoView enderecoView = new EnderecoView(this, true);
        enderecoView.setVisible(true);
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
            java.util.logging.Logger.getLogger(BuscarEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscarEndereco dialog = new BuscarEndereco(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JComboBox<String> jcbFiltrar;
    private javax.swing.JTable jtListaEndereco;
    private javax.swing.JTextField jtfValor;
    // End of variables declaration//GEN-END:variables
    
    
    public void preencherTabelaEndereco(){
        List<String> campos = new ArrayList<>();
        campos.add("CD_ENDERECO");
        campos.add("SG_UF");
        campos.add("NM_CIDADE");
        campos.add("NM_LOGRADOURO");
        campos.add("NR_CEP");
        
        JTableUtils.preencherJTable(jtListaEndereco, enderecoDao.resultSetGetAll(this.codigoPassado), campos);
    }


}
