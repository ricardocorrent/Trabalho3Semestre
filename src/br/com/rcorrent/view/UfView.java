/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.view;

import br.com.rcorrent.dao.UfDao;
import br.com.rcorrent.enuns.Estados;
import br.com.rcorrent.model.Uf;
import br.com.rcorrent.tools.JTableUtils;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rcorrent
 */
public class UfView extends javax.swing.JFrame {
    
    private Integer estado;
    
    private final UfDao ufDao = new UfDao();
    
    public String codigoUf;
    
    /**
     * Creates new form UfView
     */
    public UfView() {
        initComponents();
        
        this.estado = Estados.getPadrao().getEstado();
        
        //estadoPadraoDosBotoes();
        botoesAoIniciar();
        
        habilitarCampos(false);
        jtfValor.setEnabled(false);
        JTableUtils.formatarJtable(jtListar,new int[]{40,100,200});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jlCodigo = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jlNome = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jbNovo = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbGravar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jtfSigla = new javax.swing.JTextField();
        jlSigla = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jlFiltrar = new javax.swing.JLabel();
        jcbFiltrar = new javax.swing.JComboBox<>();
        jbPesquisar = new javax.swing.JButton();
        jtfValor = new javax.swing.JTextField();
        jlValor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlCodigo.setText("Código");

        jtfCodigo.setEditable(false);
        jtfCodigo.setEnabled(false);
        jtfCodigo.setPreferredSize(new java.awt.Dimension(20, 27));

        jlNome.setText("Nome");

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/rcorrent/icons/1491671388_new10.png"))); // NOI18N
        jbNovo.setMnemonic('N');
        jbNovo.setText("Novo");
        jbNovo.setIconTextGap(10);
        jbNovo.setPreferredSize(new java.awt.Dimension(110, 30));
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });
        jPanel3.add(jbNovo);

        jbAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/rcorrent/icons/1491672282_page14.png"))); // NOI18N
        jbAlterar.setMnemonic('A');
        jbAlterar.setText("Alterar");
        jbAlterar.setIconTextGap(10);
        jbAlterar.setPreferredSize(new java.awt.Dimension(110, 30));
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });
        jPanel3.add(jbAlterar);

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/rcorrent/icons/1491672387_garbage.png"))); // NOI18N
        jbExcluir.setMnemonic('E');
        jbExcluir.setText("Excluir");
        jbExcluir.setIconTextGap(10);
        jbExcluir.setPreferredSize(new java.awt.Dimension(110, 30));
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });
        jPanel3.add(jbExcluir);

        jbGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/rcorrent/icons/1491672401_vintage11.png"))); // NOI18N
        jbGravar.setMnemonic('G');
        jbGravar.setText("Gravar");
        jbGravar.setIconTextGap(10);
        jbGravar.setPreferredSize(new java.awt.Dimension(110, 30));
        jbGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGravarActionPerformed(evt);
            }
        });
        jPanel3.add(jbGravar);

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/rcorrent/icons/1491672468_cancel-2.png"))); // NOI18N
        jbCancelar.setMnemonic('C');
        jbCancelar.setText("Cancelar");
        jbCancelar.setIconTextGap(10);
        jbCancelar.setPreferredSize(new java.awt.Dimension(110, 30));
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(jbCancelar);

        jlSigla.setText("Sigla");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jlCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlNome)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSigla)
                    .addComponent(jtfSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlSigla)
                .addGap(3, 3, 3)
                .addComponent(jtfSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastrar", jPanel1);

        jlFiltrar.setText("Filtrar");

        jcbFiltrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Geral", "Código", "Nome" }));
        jcbFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltrarActionPerformed(evt);
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

        jlValor.setText("Valor");

        jtListar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Sigla", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlFiltrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlValor)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtfValor, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFiltrar)
                    .addComponent(jlValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consultar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setSize(new java.awt.Dimension(602, 355));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        habilitarCampos(true);
        estadoBotoes();
        limparCampos();

        this.estado = Estados.getInsercao().getEstado();
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        estadoBotoes();
        habilitarCampos(true);
        this.estado = Estados.getAlteracao().getEstado();
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        try {
            Uf ufDeletar = getUf();
            //tratar (se a uf veio com todos os campos corretos ou se ela veio por completo.
                if (ufDeletar == null) {
                    JOptionPane.showMessageDialog(null, "Selecione um Estado para excluir");
                    return;
                }
                //criando uma optionPane para confirmar a exclusão
                if (JOptionPane.showConfirmDialog(null, "Deseja Realment exlcuir o Estado?", "ATENÇÃO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    ufDao.excluir(ufDeletar);
                    JOptionPane.showMessageDialog(null, "Estado excluída com sucesso!!!");
                    limparCampos();
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao excluir Estado");
            } finally{
                ufDao.fecharCursores();
            }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGravarActionPerformed
        try {
            Uf ufGravar = getUf();
            //testa se a uf veio completa, com todos os itens a serem salvos
            if(ufGravar == null){
                return;
            }
            //testa se está ocorrendo uma gravação
            if(this.estado == Estados.getInsercao().getEstado()){
                ufDao.inserir(ufGravar);
                jtfCodigo.setText(ufGravar.getCodigoUf().toString());
                JOptionPane.showMessageDialog(null, "Estado cadastrada com sucesso!");
            }

            //testa se está ocorrendo um update ou uma alteração
            if(this.estado == Estados.getAlteracao().getEstado()){
                ufDao.alterar(ufGravar);
                JOptionPane.showMessageDialog(null, "Registro de Estado alterado com sucesso!");
            }

            //deixar os botões em estado PADRAO
            estadoPadraoDosBotoes();

            //desabilitar os campos de 'nome e sigla1'
            habilitarCampos(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar Estado.." + e);
        }

    }//GEN-LAST:event_jbGravarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        //definir estado padrão inicial aos botoes
        estadoPadraoDosBotoes();
        //PERGUNTAR SOBRE ENUM
        this.estado = Estados.getPadrao().getEstado();
        limparCampos();
        habilitarCampos(false);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jcbFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiltrarActionPerformed
        if(jcbFiltrar.getSelectedIndex() == 0){
            jtfValor.setEnabled(false);
            jtfValor.setText("");
        }else{
            jtfValor.setEnabled(true);
            jtfValor.setText("");
        }
    }//GEN-LAST:event_jcbFiltrarActionPerformed

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed
        List<String> campos = new ArrayList<>();
        campos.add("CD_UF");
        campos.add("SG_UF");
        campos.add("NM_UF");
        switch(jcbFiltrar.getSelectedIndex()){
            case 0:{
                JTableUtils.preencherJTable(jtListar, ufDao.resultSetGetAll(), campos);
            }break;
            case 1:{//caso seja escolhido a opção CÓDIGO DA UF
                try {
                    JTableUtils.preencherJTable(jtListar, ufDao.resultSetGetById(Long.parseLong(jtfValor.getText())), campos);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Informe um valor numérico");
                }
            }break;
            case 2:{//caso seja escolhido a opção NOME DO ESTADO
                JTableUtils.preencherJTable(jtListar, ufDao.resultSetGetByNomeUf(jtfValor.getText()), campos);
            } break;
        }
        ufDao.fecharCursores();

    }//GEN-LAST:event_jbPesquisarActionPerformed

    private void jtListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListarMouseClicked
        if(evt.getClickCount() > 1){
            Uf uf = ufDao.getById(Long.valueOf(jtListar.getValueAt(jtListar.getSelectedRow(), 0).toString()));
            setUf(uf);
            jTabbedPane1.setSelectedIndex(0);
            jbAlterar.setEnabled(true);
            this.estado = Estados.getAlteracao().getEstado();
        }
    }//GEN-LAST:event_jtListarMouseClicked

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
            java.util.logging.Logger.getLogger(UfView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UfView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UfView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UfView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UfView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbGravar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JComboBox<String> jcbFiltrar;
    private javax.swing.JLabel jlCodigo;
    private javax.swing.JLabel jlFiltrar;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlSigla;
    private javax.swing.JLabel jlValor;
    private javax.swing.JTable jtListar;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfSigla;
    private javax.swing.JTextField jtfValor;
    // End of variables declaration//GEN-END:variables
    
    
    /**getUf.
     * Método para buscar as informações de uma UF.
     * Ao ser 'chamada', ela busca todas as informações da uf 
     * e retorna uma Uf com os dados.
     * @return 
     */
    public Uf getUf(){
        try {
            Uf uf = new Uf();
            //tratamento (se o campo código estiver vazio)
            if(!jtfCodigo.getText().isEmpty()){
                uf.setCodigoUf(Long.valueOf(jtfCodigo.getText()));//vá buscar o código
            }
            //tratamento(se o campo nome estiver vazio)
            if(jtfNome.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe um nome para o Estado");
                //seta o fóco para o campo jtfNome
                jtfNome.grabFocus();
                return null;
            }
            uf.setSiglaUf(jtfSigla.getText());
            uf.setNomeUf(jtfNome.getText());
            return uf;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally{
            
        }
    }
    
    
    
    
    /**setUf
     * Método para setar uma UF.
     * Ao ser 'chamada', ela carrega as informações de uma UF
     * @param uf
     */
    public void setUf(Uf uf){
        try {
            jtfCodigo.setText(uf.getCodigoUf().toString());
            jtfSigla.setText(uf.getSiglaUf());
            jtfNome.setText(uf.getNomeUf());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    /**Habilita/Desabilita campos.
     * Método que ao iniciar, habilita ou desabilita os campos 'nome e uf'
     */
    public final void habilitarCampos(boolean estado){
        jtfNome.setEnabled(estado);
        jtfSigla.setEnabled(estado);
    }
    
    
    /**LimparCampos.
     * Método para limpar caixas de JTextField no JForm
     */
    public final void limparCampos(){
        jtfCodigo.setText("");
        jtfNome.setText("");
        jtfSigla.setText("");
    }
    
    /**Estado inicial dos botões.
     * Método para habilitar/desabilitar os BOTÓES, ao iniciar a tela.
     * Ao iniciar, manter os botões principais em estado de habilitado
     */
    public final void estadoPadraoDosBotoes(){
        jbNovo.setEnabled(true);
        jbAlterar.setEnabled(true);
        jbExcluir.setEnabled(true);
        
        jbGravar.setEnabled(false);
        jbCancelar.setEnabled(false);
    }
    
    /**Métod para habilitar/desabilitar os BOTÕES, quando se está em modo de edição.
     * 
     */
    public final void estadoBotoes(){
        jbNovo.setEnabled(false);
        jbAlterar.setEnabled(false);
        jbExcluir.setEnabled(false);
        
        jbGravar.setEnabled(true);
        jbCancelar.setEnabled(true);
    }
    
    /**Botões ao iniciar
     * ao inicar manter somente o NOVO ativo
     */
    public final void botoesAoIniciar(){
        jbNovo.setEnabled(true);
        jbAlterar.setEnabled(false);
        jbExcluir.setEnabled(false);
        
        jbGravar.setEnabled(false);
        jbCancelar.setEnabled(false);
    }

}