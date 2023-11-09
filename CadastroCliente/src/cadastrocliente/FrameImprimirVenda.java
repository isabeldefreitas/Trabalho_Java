package cadastrocliente;


import java.io.IOException;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class FrameImprimirVenda extends javax.swing.JFrame {
    private ArrayList<Venda> Lista = new ArrayList<Venda>();
    private VendaBD bd = new VendaBD();
    private ClientesBD bdc = new ClientesBD();
    private PDF pdf = new PDF();
    
    public FrameImprimirVenda() {
        initComponents();
        Lista = bd.lerBancoVendaDistintos();
        updateRow();
    }
    
    private void updateRow(){
        DefaultTableModel model = (DefaultTableModel) TableVenda.getModel();
        ((DefaultTableModel)TableVenda.getModel()).setNumRows(0);
        Object rowData[] = new Object[3];
        for(int i = 0; i < Lista.size();i++){
            rowData[0] = Lista.get(i).getCodigo();
            if(Lista.get(i).getCliente().equals("-1"))
                rowData[1] = "Cliente não registrado";
            else
                rowData[1] = bdc.buscaNome(Lista.get(i).getCliente());
            rowData[2] = Lista.get(i).getTotal();
            model.addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableVenda = new javax.swing.JTable();
        BuscarField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ImprimirButton = new javax.swing.JButton();
        CancelarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cliente", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableVenda);

        BuscarField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarFieldActionPerformed(evt);
            }
        });
        BuscarField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BuscarFieldKeyPressed(evt);
            }
        });

        jLabel1.setText("Busca");

        ImprimirButton.setBackground(new java.awt.Color(153, 102, 255));
        ImprimirButton.setText("Imprimir");
        ImprimirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirButtonActionPerformed(evt);
            }
        });

        CancelarButton.setText("Voltar");
        CancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BuscarField, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(ImprimirButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuscarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelarButton)
                    .addComponent(ImprimirButton))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarFieldActionPerformed
    }//GEN-LAST:event_BuscarFieldActionPerformed

    private void BuscarFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarFieldKeyPressed
        DefaultTableModel model = (DefaultTableModel) TableVenda.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        TableVenda.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(BuscarField.getText().trim()));
    }//GEN-LAST:event_BuscarFieldKeyPressed

    private void ImprimirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirButtonActionPerformed
         int linha = TableVenda.getSelectedRow();
    if (linha >= 0) {
        String codigo = String.valueOf(TableVenda.getValueAt(linha, 0));
        pdf.gerarPdf(codigo);
    } else {
        System.err.println("Nenhuma venda selecionada para imprimir.");
    }
    }//GEN-LAST:event_ImprimirButtonActionPerformed

    private void CancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarButtonActionPerformed
        dispose();
    }//GEN-LAST:event_CancelarButtonActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BuscarField;
    private javax.swing.JButton CancelarButton;
    private javax.swing.JButton ImprimirButton;
    private javax.swing.JTable TableVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
