/*
 * PagamentoTela2.java
 *
 * Created on 8 de Janeiro de 2008, 20:18
 */

package br.cefetrn.datinf.pdv.visao;
import br.cefetrn.datinf.estoque.dominio.Cartao;
import br.cefetrn.datinf.estoque.dominio.PagamentoCartao;
import br.cefetrn.datinf.estoque.dominio.PagamentoDinheiro;
import br.cefetrn.datinf.estoque.dominio.PagamentoCupomDeTroca;
import br.cefetrn.datinf.estoque.dominio.Parcela;
import br.cefetrn.datinf.estoque.dominio.TipoPagamento;
import br.cefetrn.datinf.estoque.dominio.Venda;
import br.cefetrn.datinf.pdv.ISistema;
import br.cefetrn.datinf.pdv.Sistema;


/**
 *
 * @author  Raquel
 */
public class PagamentoTela2 extends javax.swing.JFrame {
    private ISistema sistema = Sistema.getInstance();
    private Double entrada = 0.0;
    private Double restante = 0.0;
    private Double valorPago = 0.0;    
    private Venda venda = null;    
    private TelaVendajdk5 telaVendajdk5;
    private int tipoPagamento = 0;
    
    /** Creates new form PagamentoTela2 */
    public PagamentoTela2() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabelTotalAPagar = new javax.swing.JLabel();
        jLabelTipoPagamento = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTipoPagamento = new javax.swing.JTextField();
        jLabelVPagoOUNCartao = new javax.swing.JLabel();
        jTextFieldVPagoOUNCartao = new javax.swing.JTextField();
        jLabelValorPagCart = new javax.swing.JLabel();
        jTextFieldValorPagCart = new javax.swing.JTextField();
        jLabelNParcOUTroco = new javax.swing.JLabel();
        jTextFieldNParcOUTroco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabelNParcOUTroco1 = new javax.swing.JLabel();
        jTextFieldNParcOUTroco1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pagamento");

        jLabelTotalAPagar.setFont(new java.awt.Font("Tahoma", 0, 36));
        jLabelTotalAPagar.setForeground(new java.awt.Color(255, 0, 0));
        jLabelTotalAPagar.setText("TOTAL A PAGAR: R$");

        jLabelTipoPagamento.setFont(new java.awt.Font("Tahoma", 0, 36));
        jLabelTipoPagamento.setText("Pagamento em");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36));
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("1000.000");

        jTextFieldTipoPagamento.setFont(new java.awt.Font("Tahoma", 0, 36));
        jTextFieldTipoPagamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTipoPagamento.setText("Dinheiro");

        jLabelVPagoOUNCartao.setFont(new java.awt.Font("Tahoma", 0, 36));
        jLabelVPagoOUNCartao.setText("Valor Pago");

        jTextFieldVPagoOUNCartao.setFont(new java.awt.Font("Tahoma", 0, 36));
        jTextFieldVPagoOUNCartao.setText("1000.000");

        jLabelValorPagCart.setFont(new java.awt.Font("Tahoma", 0, 36));
        jLabelValorPagCart.setText("Valor");

        jTextFieldValorPagCart.setFont(new java.awt.Font("Tahoma", 0, 36));
        jTextFieldValorPagCart.setText("jTextField2");

        jLabelNParcOUTroco.setFont(new java.awt.Font("Tahoma", 0, 36));
        jLabelNParcOUTroco.setText("Parcelas");

        jTextFieldNParcOUTroco.setText("jTextField2");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Parcelas: 3 X 1000.000");

        jLabelNParcOUTroco1.setFont(new java.awt.Font("Tahoma", 0, 36));
        jLabelNParcOUTroco1.setText("Restante");

        jTextFieldNParcOUTroco1.setFont(new java.awt.Font("Tahoma", 0, 36));
        jTextFieldNParcOUTroco1.setText("1000.000");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel3.setText("F1 (Dinheiro)");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel4.setText("F2 (Cartão)");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel5.setText("F3 (Troca)");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel6.setText("F4 (Confirmar)");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel7.setText("F5 (Encerrar)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldValorPagCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelValorPagCart, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelTotalAPagar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldVPagoOUNCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVPagoOUNCartao)
                                            .addComponent(jLabel1)))
                                    .addComponent(jLabelNParcOUTroco)
                                    .addComponent(jTextFieldNParcOUTroco)))
                            .addComponent(jLabelTipoPagamento)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabelNParcOUTroco1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNParcOUTroco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(173, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipoPagamento)
                    .addComponent(jLabelVPagoOUNCartao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldVPagoOUNCartao))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValorPagCart)
                    .addComponent(jLabelNParcOUTroco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNParcOUTroco, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jTextFieldValorPagCart))
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNParcOUTroco1)
                    .addComponent(jTextFieldNParcOUTroco1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                                         
    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagamentoTela2().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelNParcOUTroco;
    private javax.swing.JLabel jLabelNParcOUTroco1;
    private javax.swing.JLabel jLabelTipoPagamento;
    private javax.swing.JLabel jLabelTotalAPagar;
    private javax.swing.JLabel jLabelVPagoOUNCartao;
    private javax.swing.JLabel jLabelValorPagCart;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldNParcOUTroco;
    private javax.swing.JTextField jTextFieldNParcOUTroco1;
    private javax.swing.JTextField jTextFieldTipoPagamento;
    private javax.swing.JTextField jTextFieldVPagoOUNCartao;
    private javax.swing.JTextField jTextFieldValorPagCart;
    // End of variables declaration//GEN-END:variables
}
