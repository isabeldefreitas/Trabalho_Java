package cadastrocliente;


import static cadastrocliente.FrameClientes.FrameConfirmacao;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class BuscarCliente extends javax.swing.JDialog {
    private ArrayList<Cliente> Lista = new ArrayList<Cliente>();
    private ClientesBD bd = new ClientesBD();
    private Cliente c;
    
    public BuscarCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Lista = bd.lerBancoClientes();
        updateRow();
    }
    
    private void updateRow(){
        DefaultTableModel model = (DefaultTableModel) TableClientes.getModel();
        ((DefaultTableModel)TableClientes.getModel()).setNumRows(0);
        Object rowData[] = new Object[7];
        for(int i = 0; i < Lista.size();i++){
            rowData[0] = Lista.get(i).getCodigo();
            rowData[1] = Lista.get(i).getNome();
            rowData[2] = Lista.get(i).getTelefone();
            rowData[3] = Lista.get(i).getEmail();
            rowData[4] = Lista.get(i).getRua();
            rowData[5] = Lista.get(i).getCasa();
            rowData[6] = Lista.get(i).getComplemento();
            model.addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableClientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        BuscarField = new javax.swing.JTextField();
        AdicionarButton = new javax.swing.JButton();
        CancelarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Adicionar cliente a venda");

        TableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Telefone", "Email", "Rua", "Casa", "Complemento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableClientes);

        jLabel2.setText("Busca");

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

        AdicionarButton.setBackground(new java.awt.Color(153, 102, 255));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(502, 502, 502)
                            .addComponent(CancelarButton))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BuscarField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AdicionarButton))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuscarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(AdicionarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CancelarButton)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarFieldActionPerformed

    private void BuscarFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarFieldKeyPressed
        DefaultTableModel model = (DefaultTableModel) TableClientes.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        TableClientes.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(BuscarField.getText().trim()));
    }//GEN-LAST:event_BuscarFieldKeyPressed

    private void AdicionarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarButtonActionPerformed
        switch(FrameConfirmacao("Confirma a adição do cliente à venda?")){
            case 0:
                int linha = TableClientes.getSelectedRow();
                int i;
                String codigo = String.valueOf(TableClientes.getValueAt(linha, 0));
                for(i=0;i<Lista.size();i++)
                    if(Lista.get(i).getCodigo() == codigo)
                        c = Lista.get(i);
                dispose();
                break;
            case 1:
                break;
        }
    }//GEN-LAST:event_AdicionarButtonActionPerformed
    
    public Cliente getCliente(){
        return c;
    }
    
    private void CancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarButtonActionPerformed
        dispose();
    }//GEN-LAST:event_CancelarButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarButton;
    private javax.swing.JTextField BuscarField;
    private javax.swing.JButton CancelarButton;
    private javax.swing.JTable TableClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
