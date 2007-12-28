package br.cefetrn.datinf.estoque.remoto;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import br.cefetrn.datinf.estoque.EstoqueRemoto;


public class Servidor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		try {
			//EstoqueRemoto estoque = new EstoqueRemoto();
			if(System.getSecurityManager() == null){
				System.setSecurityManager(new RMISecurityManager());
			}
			Naming.rebind("estoque", new EstoqueRemoto());
			System.out.println("Servidor do estoque pronto");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
