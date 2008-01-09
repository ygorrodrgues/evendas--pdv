/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.cefetrn.datinf.pdv.visao;

import br.cefetrn.datinf.estoque.remoto.IEstoque;
import br.cefetrn.datinf.pdv.ISistema;
import br.cefetrn.datinf.pdv.Sistema;
import cefetrn.datinf.tads.credito.interfaces.ICredito;
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
         sistema.setarCreditoRemoto(progrma.recuperarCreditoremoto());
        //telaPrincipal tela = new telaPrincipal(sistema);
        //tela.setVisible(true);
        //TelaVendajdk5 telaVendajdk5 = new TelaVendajdk5();
        //telaVendajdk5.setVisible(true);
        TelaGeral telaGeral = new TelaGeral();
        telaGeral.setVisible(true);     
    }
    
    public IEstoque recuperarEstoqueremoto() {
                Object o;
                IEstoque estoque = null;
                try {
                    o = Naming.lookup("rmi://10.3.120.2/estoque");
                    estoque = (IEstoque)o;
                }
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                }
		return estoque;
    }
    public ICredito recuperarCreditoremoto() {
                Object o;
                ICredito credito = null;
                try {
                    o = Naming.lookup("rmi://localhost/credito");
                    credito = (ICredito)o;
                }
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                }
		return credito;
    }
}
