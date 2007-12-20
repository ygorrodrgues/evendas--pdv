/*
 * testeMain.java
 *
 * Created on 20 de Dezembro de 2007, 09:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package teste;

import br.cefetrn.datinf.pdv.ISistema;
import br.cefetrn.datinf.pdv.Sistema;
import br.cefetrn.datinf.pdv.dominio.Item;
import br.cefetrn.datinf.pdv.dominio.Venda;

/**
 *
 * @author Raquel
 */
public class testeMain {
    
    /** Creates a new instance of testeMain */
    public testeMain() {
    }
   public static void main(String args[]) {
       ISistema sistema = Sistema.getInstance();
       Venda venda = sistema.iniciarVenda();
       int x=5;
       Item item = null;
       for(int i=0; i<10; i++){       
           item = sistema.entrarItem(i,x++);
           System.out.println(item.getQtd() + " X "+ item.getProduto().getDescricao()); 
           System.out.println(venda.getValorTotal());
       }
       venda = sistema.finalizarVenda();
   }
   public void imprimirNota(){
           System.out.println("");
    }
}
