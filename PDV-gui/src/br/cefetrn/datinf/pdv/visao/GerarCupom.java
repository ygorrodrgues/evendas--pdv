/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.cefetrn.datinf.pdv.visao;

import br.cefetrn.datinf.estoque.dominio.ItemVenda;
import br.cefetrn.datinf.estoque.dominio.Venda;
import br.cefetrn.datinf.pdv.ISistema;
import br.cefetrn.datinf.pdv.Sistema;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kelyson
 */
public class GerarCupom extends JDialog{
    private JFrame parent;
    private ISistema sis;
    private Venda venda;
   
    public GerarCupom(JFrame owner){
        super(owner);
        this.parent = owner;
        initComponents();
        sis = Sistema.getInstance();
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                setVisibleDialog(false);
                dispose();
            }            
        });
    }
    
    public void setVisibleDialog( boolean b ){
	parent.setEnabled(!b);
        setVisible(b);
    }
    
    private int close(){
        return javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
    }
    
    private void jButtonCancelarMouseClicked(MouseEvent evt) {
        setVisibleDialog(false);
    }
    
    private void jButtonProcurarMouseClicked(MouseEvent evt) {
         venda = new Venda();
         try{
            venda = sis.buscarVenda(Integer.parseInt(jTextFieldIdVenda.getText()));
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Valor inválido");
         }
         
         for(ItemVenda item : venda.getItens()){
             Object[] it = {item.getId(),item.getItemProduto().getProduto().getNome(), item.getItemProduto().getPreco(), item.getQtde()};
             ((DefaultTableModel) jTableProdutos.getModel()).addRow(it);
         }         
    }

    private void initComponents() {
        this.setSize(640,480);
        this.setAlwaysOnTop(true);     
        this.setMaximumSize(new Dimension(640,480));
        
        this.setLayout(null);
        
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldIdVenda = new javax.swing.JTextField();
        jButtonProcurar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButtonGerarCupomtroca = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        
        jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt){
                    jButtonCancelarMouseClicked(evt);
                }
            }
        );
        
        jButtonProcurar.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt){
                    jButtonProcurarMouseClicked(evt);
                }
            }
        );
        
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setText("Gerar Boleto de troca");

        jLabel2.setText("Id da Venda");

        jButtonProcurar.setText("Buscar Venda");

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Nome", "Preço", "Qtd"
            }
        ));
        jScrollPane1.setViewportView(jTableProdutos);

        jLabel3.setText("Produtos da venda");

        jButtonGerarCupomtroca.setText("Gerar cupom de troca");

        jButtonCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonProcurar))
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGerarCupomtroca)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonProcurar))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGerarCupomtroca)
                    .addComponent(jButtonCancelar))
                .addGap(20, 20, 20))
        );
        
        pack();
        
    }
    
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGerarCupomtroca;
    private javax.swing.JButton jButtonProcurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextFieldIdVenda;
    
}
