/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import br.cefetrn.datinf.pdv.ISistema;
import br.cefetrn.datinf.pdv.negocio.Sistema;
import dominio.ItemVenda;
import dominio.Venda;
import java.util.HashMap;

/**
 *
 * @author Raquel
 */
public class MAain {

    public static void main(String args[]) {
       ISistema sistema = Sistema.getInstance();
       Venda venda = sistema.iniciarVenda();
       int x=5;
       ItemVenda item = null;
       for(int i=0; i<10; i++){ 
           item = sistema.entrarItem(venda, i,x++);
          // venda.adicionarItem(item);
           //System.out.println(item.getQtde() + " X "+ item.getProduto().getNome()));
           System.out.println(/*item.getItemProduto().getProduto().getNome() + " - "+  */item.getQtde() + "XX" + item.getItemProduto().getPreco());
           System.out.println("subtotal " + venda.getValor());
       }
       venda = sistema.finalizarVenda(venda);
       //mostrar EM UM OUTRO PANEL O TOTAL
       //OU NO MESMO PANEL  
       System.out.println("VALOR TOTAL" + venda.getValor());
       HashMap<Integer, String> tipos = sistema.tiposPagamento();
       for(int i=0; i<tipos.size(); i++){
           //System.out.println(i. + " -" tipos.get(i).toString());
       }
       System.out.println();
       
   }
   public void imprimirNota(){
           System.out.println("");
    }
}
