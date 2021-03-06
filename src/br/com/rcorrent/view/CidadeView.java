/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.view;

import br.com.rcorrent.dao.CidadeDao;
import br.com.rcorrent.dao.UfDao;
import br.com.rcorrent.enuns.Estados;
import br.com.rcorrent.model.Cidade;
import br.com.rcorrent.model.Uf;
import br.com.rcorrent.tools.ComboBoxUtils;
import br.com.rcorrent.tools.JTableUtils;
import java.awt.Dialog;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author rcorrent
 */
public class CidadeView extends javax.swing.JDialog {
    
    private Integer estado;
    
    private final CidadeDao cidadeDao = new CidadeDao();
    private final UfDao ufDao = new UfDao();
    
    private Cidade cidade;
    private Uf uf;
    
    private List<Uf> listaUf = new ArrayList<>();
    
    /**USAR COMO MODAL.
     * 
     * @param owner
     * @param modal 
     */
    public CidadeView(Dialog owner, boolean modal) {
        super(owner, modal);
        initComponents();
        this.estado = Estados.getPadrao().getEstado();
        
        //estadoPadraoDosBotoes();
        estadoInicialDosBotoes();
        habilitarCampos(false);
        
        //preencher Lista de cidades
        preencherListaCidades();
        jtfValor.setEnabled(false);
        //preencher jcb de uf
        ComboBoxUtils.preencherCombo(jcbUf, ufDao.getAll());
        jcbUf.setSelectedIndex(-1);
        
        //formatar os campo da tabela de consulta
        JTableUtils.formatarJtable(jtLista,new int[]{40,170,170});
    }
    
    /**
     * Creates new form CidadeView
     */
    public CidadeView() {
        initComponents();
        this.estado = Estados.getPadrao().getEstado();
        
        //estadoPadraoDosBotoes();
        estadoInicialDosBotoes();
        habilitarCampos(false);
        
        //preencher Lista de cidades
        preencherListaCidades();
        jtfValor.setEnabled(false);
        //preencher jcb de uf
        ComboBoxUtils.preencherCombo(jcbUf, ufDao.getAll());
        jcbUf.setSelectedIndex(-1);
         
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jtfCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jpBotoes = new javax.swing.JPanel();
        jbNovo = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbGravar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jcbUf = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jcbFiltrar = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jtfValor = new javax.swing.JTextField();
        jbPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLista = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtfCodigo.setEnabled(false);

        jLabel2.setText("Código");

        jLabel4.setText("Nome Cidade");

        jLabel7.setText("Listar Estado");

        jpBotoes.setBackground(new java.awt.Color(204, 204, 204));
        jpBotoes.setPreferredSize(new java.awt.Dimension(600, 40));

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
        jpBotoes.add(jbNovo);

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
        jpBotoes.add(jbAlterar);

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
        jpBotoes.add(jbExcluir);

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
        jpBotoes.add(jbGravar);

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
        jpBotoes.add(jbCancelar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfNome)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jcbUf, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("Cadastrar", jPanel1);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtfValor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(599, 372));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        estadoDosBotoesAoInserirNovo();
        habilitarCampos(true);
        limparCampo();
        this.estado = Estados.getInsercao().getEstado();
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        estadoDosBotoesAoInserirNovo();
        habilitarCampos(true);
        this.estado = Estados.getAlteracao().getEstado();
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        try{
            Cidade cidadeDeletar = getCidade();
            //tratar (se a cidade veio com todos os campos corretos ou se ela veio por completo.
                if (cidadeDeletar == null) {
                    JOptionPane.showMessageDialog(null, "Selecione uma Cidade para excluir");
                    return;
                }
                //criando uma optionPane para confirmar a exclusão
                if (JOptionPane.showConfirmDialog(null, "Deseja Realment exlcuir a Cidade?", "ATENÇÃO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    cidadeDao.excluirCidade(cidadeDeletar);
                    JOptionPane.showMessageDialog(null, "Cidade excluída com sucesso!!!");
                    limparCampo();
                }
            } catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao excluir Cidade");
            } finally{
                cidadeDao.fecharCursores();
                preencherListaCidades();
            }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGravarActionPerformed
        try {
            Cidade cidadeGravar = getCidade();
            //testa se a cidade veio completa, com todos os itens a serem salvos
            if(cidadeGravar == null){
                return;
            }
            //testa se está ocorrendo uma gravação
            if(this.estado == Estados.getInsercao().getEstado()){
                cidadeDao.inserirCidade(cidadeGravar);
                jtfCodigo.setText(cidadeGravar.getCodigoCidade().toString());
                JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso!");
            }
            //testa se está ocorrendo um update ou uma alteração
            if(this.estado == Estados.getAlteracao().getEstado()){
                cidadeDao.alterarCidade(cidadeGravar);
                JOptionPane.showMessageDialog(null, "Registro de Cidade alterado com sucesso!");
            }
            //deixar os botões em estado PADRAO
            estadoPadraoDosBotoes();
            //desabilitar os campos de 'nome e uf'
            habilitarCampos(false);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar Cidade..");
        } finally {
            cidadeDao.fecharCursores();
            preencherListaCidades();
        }
    }//GEN-LAST:event_jbGravarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        //definir estado padrão inicial aos botoes
        estadoInicialDosBotoes();
        //PERGUNTAR SOBRE ENUM
        this.estado = Estados.getPadrao().getEstado();
        limparCampo();
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
                preencherListaCidades();
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
            Cidade cidadeGet = (Cidade) cidadeDao.getByIdCidade(Long.valueOf(jtLista.getValueAt(jtLista.getSelectedRow(), 0).toString()));
            setCidade(cidadeGet);
            jcbUf.setSelectedItem(ufDao.getById(cidadeGet.getUf().getCodigoUf()));            
            jTabbedPane1.setSelectedIndex(0);
            estadoBotoesModoEdicao();
        }
    }//GEN-LAST:event_jtListaMouseClicked

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
            java.util.logging.Logger.getLogger(CidadeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CidadeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CidadeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CidadeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CidadeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbGravar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JComboBox<String> jcbFiltrar;
    private javax.swing.JComboBox<String> jcbUf;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JTable jtLista;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfValor;
    // End of variables declaration//GEN-END:variables
    
    
    /**PREENCHER TABLE.
     * 
     */
    public void preencherListaCidades(){
        List<String> campos = new ArrayList<>();
        campos.add("CD_CIDADE");
        campos.add("NM_CIDADE");
        campos.add("NM_UF");
        
        JTableUtils.preencherJTable(jtLista, cidadeDao.resultSetGetAllCidade(), campos);
    }
    /**getCidade.
     * Método para buscar as informações de uma cidade.
     * Ao ser 'chamada', ela busca todas as informações da cidade 
     * e retorna uma Cidade com os dados.
     * @return 
     */
    public Cidade getCidade(){
        try {
            cidade = new Cidade();
            
            //tratamento (se o campo código estiver vazio)
            if(!jtfCodigo.getText().isEmpty()){
                cidade.setCodigoCidade(Long.valueOf(jtfCodigo.getText()));//vá buscar o código
            }
            
            //tratamento(se o campo nome estiver vazio)
            if(jtfNome.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe um nome para a Cidade");
                //seta o fóco para o campo jtfNome
                jtfNome.grabFocus();
                return null;
            }            
            
            cidade.setNomeCidade(jtfNome.getText());
            cidade.setUf((Uf) jcbUf.getSelectedItem());
            
            return cidade;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**Método para setar uma Cidade.
     * Ao ser 'chamada', ela carrega as informações de uma cidade
     * @param cidade
     */
    public void setCidade(Cidade cidade){
        try {
            jtfCodigo.setText(cidade.getCodigoCidade().toString());
            jtfNome.setText(cidade.getNomeCidade());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**Habilita/Desabilita campos.
     * Método que ao iniciar, habilita ou desabilita os campos 'nome e uf'
     */
    public void habilitarCampos(boolean estado){
        jtfNome.setEnabled(estado);
        jcbUf.setEnabled(estado);
    }
    
    /**LimparCampos
     * Método para limpar caixas de JTextField no JForm
     */
    public void limparCampo(){
        jtfCodigo.setText("");
        jtfNome.setText("");
        //jcbUf.setSelectedIndex(-1);
    }   
    
    /**Método para habilitar/desabilitar os BOTÓES, ao iniciar a tela.
     * Ao iniciar, manter os botões principais em estado de habilitado
     */
    public void estadoPadraoDosBotoes(){
        jbNovo.setEnabled(true);
        jbAlterar.setEnabled(true);
        jbExcluir.setEnabled(true);
        
        jbGravar.setEnabled(false);
        jbCancelar.setEnabled(false);
    }
    
    /**Editando um objeto.
     * após duplo clique no objeto da listagem
     */
    public void estadoBotoesModoEdicao(){
        jbNovo.setEnabled(true);
        jbAlterar.setEnabled(true);
        jbExcluir.setEnabled(true);
        
        jbGravar.setEnabled(false);
        jbCancelar.setEnabled(true);
    }
    /**Inserindo NOVO.
     * Ao inserir um novo objeto
     * os botões ficam em 
     */
    public void estadoDosBotoesAoInserirNovo(){
        jbNovo.setEnabled(false);
        jbAlterar.setEnabled(false);
        jbExcluir.setEnabled(false);
        
        jbGravar.setEnabled(true);
        jbCancelar.setEnabled(true);
    }
    
    /**Método inicial dos botões.
     * Ao iniciar a tela, os botões ficam
     * em estado Padrão
     */
    public void estadoInicialDosBotoes(){
        jbNovo.setEnabled(true);
        jbAlterar.setEnabled(false);
        jbExcluir.setEnabled(false);
        
        jbGravar.setEnabled(false);
        jbCancelar.setEnabled(false);
    }
    
    

}
