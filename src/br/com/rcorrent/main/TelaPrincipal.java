/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.main;

import br.com.rcorrent.view.CidadeView;
import br.com.rcorrent.view.DieselView;
import br.com.rcorrent.view.EnderecoView;
import br.com.rcorrent.view.FreteView;
import br.com.rcorrent.view.MarcaView;
import br.com.rcorrent.view.ModeloView;
import br.com.rcorrent.view.UfView;
import br.com.rcorrent.view.VeiculoView;
import br.com.rcorrent.view.busca.BuscarCidade;
import br.com.rcorrent.view.busca.BuscarDiesel;
import br.com.rcorrent.view.busca.BuscarEndereco;
import br.com.rcorrent.view.busca.BuscarFrete;
import br.com.rcorrent.view.busca.BuscarVeiculo;
import javax.swing.JFrame;

/**
 *
 * @author rcorrent
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jmCadastro = new javax.swing.JMenu();
        jmiDiesel = new javax.swing.JMenuItem();
        jmiCidade = new javax.swing.JMenuItem();
        jmiEstado = new javax.swing.JMenuItem();
        jmiVeiculo = new javax.swing.JMenuItem();
        jmiMarca = new javax.swing.JMenuItem();
        jmiModelo = new javax.swing.JMenuItem();
        jmiEndereco = new javax.swing.JMenuItem();
        jmConsulta = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jmFrete = new javax.swing.JMenu();
        jmiCadastro = new javax.swing.JMenuItem();
        jmiConsulta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jmCadastro.setText("Cadastro");

        jmiDiesel.setText("Diesel");
        jmiDiesel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDieselActionPerformed(evt);
            }
        });
        jmCadastro.add(jmiDiesel);

        jmiCidade.setText("Cidade");
        jmiCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCidadeActionPerformed(evt);
            }
        });
        jmCadastro.add(jmiCidade);

        jmiEstado.setText("Estado");
        jmiEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEstadoActionPerformed(evt);
            }
        });
        jmCadastro.add(jmiEstado);

        jmiVeiculo.setText("Veiculo");
        jmiVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVeiculoActionPerformed(evt);
            }
        });
        jmCadastro.add(jmiVeiculo);

        jmiMarca.setText("Marca");
        jmiMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMarcaActionPerformed(evt);
            }
        });
        jmCadastro.add(jmiMarca);

        jmiModelo.setText("Modelo");
        jmiModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiModeloActionPerformed(evt);
            }
        });
        jmCadastro.add(jmiModelo);

        jmiEndereco.setText("Endereço");
        jmiEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEnderecoActionPerformed(evt);
            }
        });
        jmCadastro.add(jmiEndereco);

        jMenuBar1.add(jmCadastro);

        jmConsulta.setText("Consulta");

        jMenuItem1.setText("Diesel");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmConsulta.add(jMenuItem1);

        jMenuItem2.setText("Endereço");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmConsulta.add(jMenuItem2);

        jMenuItem3.setText("Veiculo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmConsulta.add(jMenuItem3);

        jMenuItem4.setText("Cidade");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jmConsulta.add(jMenuItem4);

        jMenuBar1.add(jmConsulta);

        jmFrete.setText("Frete");

        jmiCadastro.setText("Cadastro");
        jmiCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastroActionPerformed(evt);
            }
        });
        jmFrete.add(jmiCadastro);

        jmiConsulta.setText("Consulta");
        jmiConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsultaActionPerformed(evt);
            }
        });
        jmFrete.add(jmiConsulta);

        jMenuBar1.add(jmFrete);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1008, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1018, 616));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiDieselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDieselActionPerformed
        new DieselView().setVisible(true);
    }//GEN-LAST:event_jmiDieselActionPerformed

    private void jmiCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCidadeActionPerformed
        new CidadeView().setVisible(true);
    }//GEN-LAST:event_jmiCidadeActionPerformed

    private void jmiEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEstadoActionPerformed
        new UfView().setVisible(true);
    }//GEN-LAST:event_jmiEstadoActionPerformed

    private void jmiVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVeiculoActionPerformed
        new VeiculoView().setVisible(true);
    }//GEN-LAST:event_jmiVeiculoActionPerformed

    private void jmiMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMarcaActionPerformed
        new MarcaView().setVisible(true);
    }//GEN-LAST:event_jmiMarcaActionPerformed

    private void jmiModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiModeloActionPerformed
        new ModeloView().setVisible(true);
    }//GEN-LAST:event_jmiModeloActionPerformed

    private void jmiEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEnderecoActionPerformed
        new EnderecoView().setVisible(true);
    }//GEN-LAST:event_jmiEnderecoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        BuscarDiesel buscarDiesel = new BuscarDiesel(this, true);
        buscarDiesel.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        BuscarEndereco buscarEndereco = new BuscarEndereco(this, true);
        buscarEndereco.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        BuscarVeiculo buscarVeiculo = new BuscarVeiculo(this, true);
        buscarVeiculo.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        BuscarCidade buscarCidade = new BuscarCidade(this, true);
        buscarCidade.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jmiCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastroActionPerformed
        new FreteView().setVisible(true);
    }//GEN-LAST:event_jmiCadastroActionPerformed

    private void jmiConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultaActionPerformed
        BuscarFrete buscarFrete = new BuscarFrete(this, true);
        buscarFrete.setVisible(true);
    }//GEN-LAST:event_jmiConsultaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu jmCadastro;
    private javax.swing.JMenu jmConsulta;
    private javax.swing.JMenu jmFrete;
    private javax.swing.JMenuItem jmiCadastro;
    private javax.swing.JMenuItem jmiCidade;
    private javax.swing.JMenuItem jmiConsulta;
    private javax.swing.JMenuItem jmiDiesel;
    private javax.swing.JMenuItem jmiEndereco;
    private javax.swing.JMenuItem jmiEstado;
    private javax.swing.JMenuItem jmiMarca;
    private javax.swing.JMenuItem jmiModelo;
    private javax.swing.JMenuItem jmiVeiculo;
    // End of variables declaration//GEN-END:variables
}
