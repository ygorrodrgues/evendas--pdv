package br.cefetrn.datinf.estoque.remoto;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import br.cefetrn.datinf.estoque.EstoqueRemoto;
import br.cefetrn.datinf.estoque.negocio.CadastrosAdministrativos;


public class Servidor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			if(System.getSecurityManager() == null){
				System.setSecurityManager(new RMISecurityManager());
			}
			Naming.rebind("estoque", new EstoqueRemoto());
			Naming.rebind("cadAdmin", new CadastrosAdministrativos());
			System.out.println("Servidor do estoque pronto 26");			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
