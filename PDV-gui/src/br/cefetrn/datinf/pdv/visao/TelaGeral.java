/*
 * TelaGeral.java
 *
 * Created on 7 de Janeiro de 2008, 20:59
 */

package br.cefetrn.datinf.pdv.visao;

import java.awt.event.KeyEvent;
import javax.swing.UIManager;

/**
 *
 * @author  gleison
 * SETAR IMAGEM CAIXA LIVRE
 */
public class TelaGeral extends javax.swing.JFrame {
    
    /** Creates new form TelaGeral */
    public TelaGeral() {
        initComponents();
        setLookAndFell();
    }
    
     private void setLookAndFell() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        
        } 
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setText("F1 (Iniciar Venda)");

        jLabel2.setText("F2 (Trocar produto)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(592, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(575, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:  
        if(evt.getKeyCode() == KeyEvent.VK_F2){
            cupom = new CupomTroca(this);
            cupom.setVisibleDialog(true);
        }        
        if(evt.getKeyCode() == KeyEvent.VK_F1){
            vendaGui = new VendaGui(this);
            vendaGui.setVisibleDialog(true);
        }
    }//GEN-LAST:event_formKeyPressed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGeral().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
    private CupomTroca cupom;
    private VendaGui vendaGui;
}