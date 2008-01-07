/*
 * TelaVendajdk5.java
 *
 * Created on 6 de Janeiro de 2008, 23:37
 */

package br.cefetrn.datinf.pdv.visao;
import br.cefetrn.datinf.estoque.dominio.Cliente;
import br.cefetrn.datinf.estoque.dominio.EstadoItemVenda;
import br.cefetrn.datinf.estoque.dominio.Funcionario;
import br.cefetrn.datinf.estoque.dominio.ItemVenda;

import br.cefetrn.datinf.estoque.dominio.PDV;
import br.cefetrn.datinf.estoque.dominio.Pagamento;
import br.cefetrn.datinf.estoque.dominio.PagamentoDinheiro;
import br.cefetrn.datinf.estoque.dominio.TipoPagamento;
import br.cefetrn.datinf.estoque.dominio.Venda;
import br.cefetrn.datinf.pdv.ISistema;
import br.cefetrn.datinf.pdv.Sistema;
import java.awt.event.KeyEvent;
/**
 *
 * @author  Raquel
 */
public class TelaVendajdk5 extends javax.swing.JFrame {
    private ISistema sistema = Sistema.getInstance();
    private ItemVenda itemVenda = null;
    private Venda venda = null;
    private Double valor = 0.0;
    
    /** Creates new form TelaVendajdk5 */
    public TelaVendajdk5() {
        
        initComponents();
    }

    private void addItemCumpom() {
        //  jTextArea1.append(this.getVenda().getItens().size()+1 + "  ");
     //   jTextArea1.append(itemVenda.getItemProduto().getProduto().getCodigo() + "  ");
      //  jTextArea1.append(itemVenda.getItemProduto().getProduto().getNome() + "  ");
      //  jTextArea1.append(itemVenda.getQtde() + "x" + itemVenda.getItemProduto().getPreco() + "  ");
      //  jTextArea1.append(itemVenda.getQtde()*itemVenda.getItemProduto().getPreco() + "");
    }

    private void finalizarVenda() {
        sistema.finalizarVenda(venda);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 182, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 198, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .add(290, 290, 290)
                .add(jTextField4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .add(19, 19, 19))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(279, Short.MAX_VALUE)
                .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 79, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(140, 140, 140))
            .add(jPanel2Layout.createSequentialGroup()
                .add(373, 373, 373)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(34, 34, 34))
            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(25, 25, 25)
                .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(27, 27, 27)
                .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(40, 40, 40)
                .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(199, 199, 199))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        /* if(evt.getKeyCode() == KeyEvent.VK_F6) {            
                venda = new Venda();
                Cliente cliente = new Cliente();
                cliente.setId(1);
                Funcionario f = new Funcionario();
                f.setId(2);
                PDV pdv = new PDV();
                pdv.setID(1);
                venda.setCliente(cliente);
                venda.setFuncionario(f);
                venda.setPdv(pdv);
                System.out.println("venda iniciada");
                //mostrar mensagem ma tela!! Inicinando Venda ...
        }*/
         /* pagamento em DINHEIRO .. */          
        if(evt.getKeyCode() == KeyEvent.VK_F7) {              
         //   jTextArea1.setVisible(false);
            //setar a imagem aqui           
            jTextField1.setText("DINHEIRO");
            jTextField2.setText(venda.getValor() + "");
        }
          /* pagamento em CARTAO .. */  
        if(evt.getKeyCode() == KeyEvent.VK_F9) {    
            limparCampos();
         //   sistema.solicitarAprovacaoDeCompra("0515", double valorCompra, int qtdParcelas, String identPDV)
          //  jTextArea1.setVisible(false);
            //setar a imagem aqui           
          ///  jTextField1.setText("CARTÃO");
          //  jTextField2.setText(venda.getValor() + "");
        //    jTextField3.setVisible(false);
          //  jTextField4.setVisible(false);
            //setar a qtd maxima de camos editaveis no jte1
        }
    }//GEN-LAST:event_formKeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
		itemVenda = sistema.criarItemVenda(Long.parseLong(jTextField1.getText()));       
                jTextField1.setText(itemVenda.getItemProduto().getProduto().getNome());
                jTextField2.setText(itemVenda.getItemProduto().getPreco() + "");
        }
         if(evt.getKeyCode() == KeyEvent.VK_F6) {            
                venda = new Venda();
                Cliente cliente = new Cliente();
                cliente.setId(1);
                Funcionario f = new Funcionario();
                f.setId(2);
                PDV pdv = new PDV();
                pdv.setID(1);
                venda.setCliente(cliente);
                venda.setFuncionario(f);
                venda.setPdv(pdv);
                System.out.println("venda iniciada...");
                //mostrar mensagem ma tela!! Inicinando Venda ...
        }
         /* pagamento em DINHEIRO .. */          
        if(evt.getKeyCode() == KeyEvent.VK_F7) {              
         //   jTextArea1.setVisible(false);
            //setar a imagem aqui           
            jTextField1.setText("DINHEIRO");
            jTextField2.setText(venda.getValor() + "");
        }
          /* pagamento em CARTAO .. */  
        if(evt.getKeyCode() == KeyEvent.VK_F9) {    
            limparCampos();
         //   sistema.solicitarAprovacaoDeCompra("0515", double valorCompra, int qtdParcelas, String identPDV)
          //  jTextArea1.setVisible(false);
            //setar a imagem aqui           
          ///  jTextField1.setText("CARTÃO");
          //  jTextField2.setText(venda.getValor() + "");
        //    jTextField3.setVisible(false);
          //  jTextField4.setVisible(false);
            //setar a qtd maxima de camos editaveis no jte1
        }
        
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
         //exibir subtototal e adicionar intem
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                itemVenda.setQtde(Integer.parseInt(jTextField3.getText()));
                venda.adicionarItem(itemVenda);
                itemVenda.setVenda(venda);
                itemVenda.setEstado(EstadoItemVenda.ENTREGUE);
                venda.setValor(venda.getValor()+itemVenda.getItemProduto().getPreco()*itemVenda.getQtde());
                addItemCumpom();
                System.out.print("valor: "+venda.getValor()+"");
		jTextField4.setText(venda.getValor() + "");
                System.out.print("Enter esse");
        }
        //pagamento em money
        if(evt.getKeyCode()==KeyEvent.VK_F8){
            Double valorPago = Double.parseDouble(jTextField3.getText());
            Double troco = valorPago - venda.getValor();
            jTextField4.setText(troco.toString());
            PagamentoDinheiro pd = new PagamentoDinheiro();        
            pd.setValor(venda.getValor());
           // pd.setValorPago(valorPago);
            //pd.setId(1);  
            pd.setTipo(TipoPagamento.Dinheiro);
            venda.adicionarPagamento(pd);
            pd.setVenda(venda);
           // valor = 
            finalizarVenda();
           // System.out.print("f12");
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                Integer qtdParcelas =  Integer.parseInt(jTextField1.getText());
                Double valorparcela = venda.getValor()/qtdParcelas;
                jTextField3.setText(valorparcela.toString());
        }
         //pagamenteo em CARTAO ..  numero do cartao eh? eqtd de parcelas
        if(evt.getKeyCode()==KeyEvent.VK_F10){
            String numCartao = jTextField1.getText();
            Integer qtdParcelas = Integer.parseInt(jTextField2.getText());
            Double valorPago = 0.0;
            if(venda.getPagamentos().size()!=0){
                for(Pagamento pagamento : venda.getPagamentos()){
                    pagamento.getValor();
                    
                }
            }
            //jTextField3.setText(venda.getValor()/)
            String identPDV = "0";
            String mensagem = sistema.solicitarAprovacaoDeCompra(numCartao, venda.getValor(), qtdParcelas, identPDV);
            
            //se der erro mostra mensagem
            //JOptionPane.showMessageDialog(null, mensagem);
            //senao cotinua o processo
        }
    }//GEN-LAST:event_jTextField2KeyPressed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVendajdk5().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
    }
    
}
