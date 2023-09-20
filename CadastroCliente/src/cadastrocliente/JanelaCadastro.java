/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package cadastrocliente;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
/**
 *
 * @author tatip
 */

public class JanelaCadastro extends javax.swing.JDialog {

    private ModeloTabelaPessoa modeloPessoa;
    
   
    /**
     * Creates new form JanelaCadastro
     */
    public JanelaCadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        modeloPessoa = new ModeloTabelaPessoa(new ArrayList<Pessoa>());
tabPessoa.setModel(modeloPessoa);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buIncluir = new javax.swing.JButton();
        buExcluir = new javax.swing.JButton();
        Selecionar = new javax.swing.JButton();
        buAlterar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabPessoa = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buIncluir.setText("Incluir");
        buIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buIncluirActionPerformed(evt);
            }
        });

        buExcluir.setText("Excluir");
        buExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buExcluirActionPerformed(evt);
            }
        });

        Selecionar.setText("Selecionar");
        Selecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelecionarActionPerformed(evt);
            }
        });

        buAlterar.setText("Alterar");
        buAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buAlterarActionPerformed(evt);
            }
        });

        tabPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabPessoa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buExcluir)
                    .addComponent(Selecionar)
                    .addComponent(buIncluir)
                    .addComponent(buAlterar))
                .addGap(0, 36, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Selecionar, buAlterar, buExcluir, buIncluir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Selecionar)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Selecionar, buAlterar, buExcluir, buIncluir});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buAlterarActionPerformed

int indice = tabPessoa.getSelectedRow();
if (indice >= 0){
Pessoa pessoa = modeloPessoa.obterPessoa(indice);
if (JanelaPessoa.executar(OperacaoCadastro.alterar, pessoa)){
modeloPessoa.atualizarPessoa(indice, pessoa);
}
}
    }//GEN-LAST:event_buAlterarActionPerformed

    private void buIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buIncluirActionPerformed

Pessoa pessoa = new Pessoa();
if (JanelaPessoa.executar(OperacaoCadastro.incluir, pessoa)){
modeloPessoa.incluirPessoa(pessoa);
}
    }//GEN-LAST:event_buIncluirActionPerformed

    private void buExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buExcluirActionPerformed
int indice = tabPessoa.getSelectedRow();
if (indice >= 0){
modeloPessoa.excluirPessoa(indice);
}        
    }//GEN-LAST:event_buExcluirActionPerformed

    private void SelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelecionarActionPerformed

int indice = tabPessoa.getSelectedRow();
if (indice >= 0){
Pessoa pessoa = modeloPessoa.obterPessoa(indice);
JanelaPessoa.executar(OperacaoCadastro.consultar, pessoa);}
    }//GEN-LAST:event_SelecionarActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaCadastro dialog = new JanelaCadastro(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Selecionar;
    private javax.swing.JButton buAlterar;
    private javax.swing.JButton buExcluir;
    private javax.swing.JButton buIncluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabPessoa;
    // End of variables declaration//GEN-END:variables
}
