/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package cadastrocliente;


import static cadastrocliente.FrameClientes.FrameConfirmacao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class BuscarProduto extends javax.swing.JDialog {
    private ArrayList<Produto> Lista = new ArrayList<Produto>();
    private ProdutosBD bd = new ProdutosBD(); 
    private Produto p;
    private String codigo;
    private int quantidade, op;

    public BuscarProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Lista = bd.lerBancoProdutos();
        updateRow();
        op = 0;
    }
    
    private void updateRow(){
        DefaultTableModel model = (DefaultTableModel) TableProdutos.getModel();
        ((DefaultTableModel)TableProdutos.getModel()).setNumRows(0);
        Object rowData[] = new Object[6];
        for(int i = 0; i < Lista.size();i++){
            rowData[0] = Lista.get(i).getCodigo();
            rowData[1] = Lista.get(i).getNome();
            rowData[2] = Lista.get(i).getUnidade();
            rowData[3] = Lista.get(i).getPreco();
            rowData[4] = Lista.get(i).getQuantidade();
            rowData[5] = Lista.get(i).getData();
            model.addRow(rowData);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProdutos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        BuscarField = new javax.swing.JTextField();
        AdicionarButton = new javax.swing.JButton();
        CancelarButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        QuantidadeField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Adicionar Produtos");

        TableProdutos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Unidade", "Preço", "Quantidade", "Ultima Venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableProdutos);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Buscar:");

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

        AdicionarButton.setBackground(new java.awt.Color(153, 51, 255));
        AdicionarButton.setText("Adicionar");
        AdicionarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarButtonActionPerformed(evt);
            }
        });

        CancelarButton.setText("Cancelar");
        CancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade:");

        QuantidadeField.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(QuantidadeField, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(CancelarButton))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BuscarField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AdicionarButton)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(BuscarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdicionarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(QuantidadeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CancelarButton)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarFieldActionPerformed

    private void BuscarFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarFieldKeyPressed
        DefaultTableModel model = (DefaultTableModel) TableProdutos.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        TableProdutos.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(BuscarField.getText().trim()));
    }//GEN-LAST:event_BuscarFieldKeyPressed

    private void AdicionarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarButtonActionPerformed
        int linha = TableProdutos.getSelectedRow();
        codigo = String.valueOf(TableProdutos.getValueAt(linha, 0));
        
        for(int i=0 ; i < Lista.size(); i++)
            if(Lista.get(i).getCodigo() == codigo)
                p = Lista.get(i);
        
        quantidade = Integer.valueOf(p.getQuantidade()) - Integer.valueOf(QuantidadeField.getText());
        System.out.println(quantidade);
        
        if(quantidade < 0){
            JOptionPane.showMessageDialog(null, "Quantidade invalida!");
        }
        else{
            switch(FrameConfirmacao("Confirma a adição do produto à venda?")){
                case 0:
                    op = 1;
                    dispose();
                    break;
                case 1:
                    break;
            }
        }
    }//GEN-LAST:event_AdicionarButtonActionPerformed
    
    public int getOperacao(){
        return op;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public String getQuantidade(){
        return QuantidadeField.getText();
    }
    
    public String getTotal(){
        return String.valueOf(p.getPreco() * Integer.valueOf(QuantidadeField.getText()));
    }
    
    
    private void CancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarButtonActionPerformed
        dispose();
    }//GEN-LAST:event_CancelarButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarButton;
    private javax.swing.JTextField BuscarField;
    private javax.swing.JButton CancelarButton;
    private javax.swing.JTextField QuantidadeField;
    private javax.swing.JTable TableProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
