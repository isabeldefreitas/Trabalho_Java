package cadastrocliente;


import static cadastrocliente.FrameClientes.FrameConfirmacao;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrameVenda extends javax.swing.JFrame {
    private Cliente c = new Cliente();
    private ArrayList<Cliente> Lista = new ArrayList<Cliente>();   
    private ArrayList<Venda> ListaV = new ArrayList<Venda>();
    private ArrayList<Venda> ListaVbd = new ArrayList<Venda>();  
    private Date hoje = new Date();
    private VendaBD bdv = new VendaBD();
    private ProdutosBD bdp = new ProdutosBD();
    private String codigo;
    private float soma;
    
public FrameVenda() {
    initComponents();
    c.setCodigo("-1");
    c.setNome("Cliente não registrado");
    ClienteLabel.setText(c.getNome()); 
    
    ListaVbd = bdv.lerBancoVenda();
    
    if (!ListaVbd.isEmpty()) {
        codigo = String.valueOf(Integer.parseInt(ListaVbd.get(ListaVbd.size() - 1).getCodigo()) + 1);
    } else {
        codigo = "1"; // Defina um valor padrão caso a lista esteja vazia
    }
    
    VendaLabel.setText("Venda nº " + codigo);
    DataLabel.setText(String.valueOf(hoje));
}

private void updateRow() {
    soma = 0;
    Object rowData[] = new Object[5];
    DefaultTableModel model = (DefaultTableModel) TableVenda.getModel();
    ((DefaultTableModel) TableVenda.getModel()).setNumRows(0);

    if (!ListaV.isEmpty()) {
        for (int i = 0; i < ListaV.size(); i++) {
            rowData[0] = ListaV.get(i).getCodProduto();
            rowData[1] = bdp.buscaNome(ListaV.get(i).getCodProduto());
            rowData[2] = ListaV.get(i).getQtdProduto();
            rowData[3] = bdp.buscaPreco(ListaV.get(i).getCodProduto());
            rowData[4] = ListaV.get(i).getTotalProduto();
            soma += Float.valueOf(ListaV.get(i).getTotalProduto());
            model.addRow(rowData);
        }
    }
    
    TotalLabel.setText("Total: " + String.valueOf(soma));
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pagamento = new javax.swing.ButtonGroup();
        ClienteLabel = new javax.swing.JLabel();
        BuscarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableVenda = new javax.swing.JTable();
        FinalizarButton = new javax.swing.JButton();
        AdicionarProdutoButton = new javax.swing.JButton();
        RemoverProdutoButton = new javax.swing.JButton();
        TotalLabel = new javax.swing.JLabel();
        CreditoButton = new javax.swing.JRadioButton();
        DebitoButton = new javax.swing.JRadioButton();
        DinheiroButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        VendaLabel = new javax.swing.JLabel();
        DataLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ClienteLabel.setText("Cliente");

        BuscarButton.setText("Buscar Cliente");
        BuscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarButtonActionPerformed(evt);
            }
        });

        TableVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Produto", "Quantidade", "Preco", "Sub-Total"
            }
        ));
        jScrollPane1.setViewportView(TableVenda);

        FinalizarButton.setBackground(new java.awt.Color(153, 102, 255));
        FinalizarButton.setText("Finalizar");
        FinalizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarButtonActionPerformed(evt);
            }
        });

        AdicionarProdutoButton.setText("Adicionar Produto");
        AdicionarProdutoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarProdutoButtonActionPerformed(evt);
            }
        });

        RemoverProdutoButton.setText("Remover Produto");
        RemoverProdutoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverProdutoButtonActionPerformed(evt);
            }
        });

        TotalLabel.setText("Total:");

        Pagamento.add(CreditoButton);
        CreditoButton.setText("Credito");

        Pagamento.add(DebitoButton);
        DebitoButton.setText("Debito");
        DebitoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DebitoButtonActionPerformed(evt);
            }
        });

        Pagamento.add(DinheiroButton);
        DinheiroButton.setSelected(true);
        DinheiroButton.setText("Dinheiro");
        DinheiroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DinheiroButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Pagamento:");

        VendaLabel.setText("jLabel4");

        DataLabel.setText("jLabel5");

        jButton1.setText("Cancelar");
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
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TotalLabel)
                                .addGap(226, 226, 226)
                                .addComponent(FinalizarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CreditoButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DebitoButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DinheiroButton))
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BuscarButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(VendaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DataLabel)))
                        .addGap(106, 106, 106))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ClienteLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AdicionarProdutoButton)
                                .addGap(18, 18, 18)
                                .addComponent(RemoverProdutoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(ClienteLabel)
                        .addGap(16, 16, 16)
                        .addComponent(VendaLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(BuscarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DataLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdicionarProdutoButton)
                    .addComponent(RemoverProdutoButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DinheiroButton)
                    .addComponent(DebitoButton)
                    .addComponent(CreditoButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalLabel)
                    .addComponent(FinalizarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RemoverProdutoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverProdutoButtonActionPerformed
        switch(FrameConfirmacao("Confirma a exclusão?")){
            case 0:
                int linha = TableVenda.getSelectedRow();
                String codigo = String.valueOf(TableVenda.getValueAt(linha, 0));
                DefaultTableModel model = (DefaultTableModel)TableVenda.getModel();
                for(int i=0; i < ListaV.size (); i++){
                    Venda v = ListaV.get(i);
                    if(v.getCodProduto().equals(codigo)){
                        ListaV.remove(v);
                        break;
                    }
                }
                updateRow();
                break;
            case 1:
                break;
        }
    }//GEN-LAST:event_RemoverProdutoButtonActionPerformed

    private void DebitoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DebitoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DebitoButtonActionPerformed

    private void DinheiroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DinheiroButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DinheiroButtonActionPerformed

    private void BuscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarButtonActionPerformed
        BuscarCliente bc = new BuscarCliente(this,true);
        bc.setVisible(true);
        c = bc.getCliente();
        ClienteLabel.setText("Cliente : " + c.getNome());       
    }//GEN-LAST:event_BuscarButtonActionPerformed

    private void FinalizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarButtonActionPerformed
        switch (FrameConfirmacao("Confirma a finalização da venda?")) {
        case 0:
            String pagamento = null;
            if (DebitoButton.isSelected())
                pagamento = "Debito";
            else if (CreditoButton.isSelected())
                pagamento = "Credito";
            else if (DinheiroButton.isSelected())
                pagamento = "Dinheiro";
            
            for (int i = 0; i < ListaV.size(); i++) {
    ListaV.get(i).setData(String.valueOf(hoje));
    ListaV.get(i).setCliente(c.getCodigo());
    ListaV.get(i).setPagamento(pagamento);
    ListaV.get(i).setTotal(String.valueOf(soma));
    bdv.adicionarVenda(ListaV.get(i));

                
                // Atualize a quantidade de produtos no banco de dados aqui
                bdp.atualizarProduto(ListaV.get(i).getCodProduto(), ListaV.get(i).getQtdProduto());
                bdp.atualizarDataUltimaVenda(ListaV.get(i).getCodProduto(), DataLabel.getText());
            }
            
            JOptionPane.showMessageDialog(null, "Venda adicionada!");
            dispose();
            break;
        case 1:
            break;
    }
        
        
    }//GEN-LAST:event_FinalizarButtonActionPerformed

    private void AdicionarProdutoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarProdutoButtonActionPerformed
        BuscarProduto bp = new BuscarProduto(this,true);
        bp.setVisible(true);
        Venda v = new Venda();
        if(bp.getOperacao() == 1){
            v.setCodProduto(bp.getCodigo());
            v.setQtdProduto(bp.getQuantidade());
            v.setTotalProduto(bp.getTotal());
            v.setCodigo(codigo);
            v.setCliente(c.getCodigo());
            ListaV.add(v);
            updateRow();
        }
    }//GEN-LAST:event_AdicionarProdutoButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarProdutoButton;
    private javax.swing.JButton BuscarButton;
    private javax.swing.JLabel ClienteLabel;
    private javax.swing.JRadioButton CreditoButton;
    private javax.swing.JLabel DataLabel;
    private javax.swing.JRadioButton DebitoButton;
    private javax.swing.JRadioButton DinheiroButton;
    private javax.swing.JButton FinalizarButton;
    private javax.swing.ButtonGroup Pagamento;
    private javax.swing.JButton RemoverProdutoButton;
    private javax.swing.JTable TableVenda;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JLabel VendaLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
