package br.cefetrn.datinf.estoque.remoto;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

//import br.cefetrn.datinf.gerencial.dominio.CaixaEmpresa;
//import br.cefetrn.datinf.gerencial.rmi.ICaixa;


public class Cliente {
	public static void main(String[] args) {
		/*Context ic;
		Object objref; 
		//ICaixa hi; 
		//CaixaEmpresa c = new CaixaEmpresa();
		c.setValor_entrada(10.10);
		try { 
			ic = new InitialContext(); 
			objref = ic.lookup("CaixaEmpresaService"); 
			hi = (ICaixa) PortableRemoteObject.narrow( objref, ICaixa.class);
			hi.fecharCaixa(c);
		} catch( Exception e ) { 
			System.err.println( "Exception " + e + "Caught" );
			e.printStackTrace( ); 
			return;
		}
		//-Djava.naming.factory.initial=com.sun.jndi.cosnaming.CNCtxFactory -Djava.naming.provider.url=iiop://localhost:1050*/
	}
}

