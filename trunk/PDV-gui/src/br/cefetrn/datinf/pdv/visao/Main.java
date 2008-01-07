/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.cefetrn.datinf.pdv.visao;

import br.cefetrn.datinf.estoque.remoto.IEstoque;
import br.cefetrn.datinf.pdv.ISistema;
import br.cefetrn.datinf.pdv.Sistema;
import java.rmi.Naming;

/**
 *
 * @author wilbert
 */
public class Main {

    public static void main(String[] args) {
        Main progrma = new Main();
         ISistema sistema = Sistema.getInstance();
         sistema.setarEstoqueRemoto(progrma.recuperarEstoqueremoto());
      //   telaPrincipal tela = new telaPrincipal(sistema);
       //  tela.setVisible(true);
         TelaVendajdk5 telaVendajdk5 = new TelaVendajdk5();
         telaVendajdk5.setVisible(true);
         
    }
    
    public IEstoque recuperarEstoqueremoto() {
                Object o;
                IEstoque estoque = null;;
                try {
                    
                        o = Naming.lookup("rmi://localhost/estoque");
                        estoque = (IEstoque)o;
                }
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                }
		return estoque;
    }
}
