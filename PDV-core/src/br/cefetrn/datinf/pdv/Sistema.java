package br.cefetrn.datinf.pdv;

import java.util.ArrayList;
import java.util.Date;

import br.cefetrn.datinf.pdv.dominio.Funcionario;
import br.cefetrn.datinf.pdv.dominio.Item;
import br.cefetrn.datinf.pdv.dominio.Pagamento;
import br.cefetrn.datinf.pdv.dominio.Produto;
import br.cefetrn.datinf.pdv.dominio.Venda;
import br.cefetrn.datinf.pdv.negocio.ControladorProduto;
import br.cefetrn.datinf.pdv.negocio.ControladorVenda;
import br.cefetrn.datinf.pdv.negocio.interfac.IControladorVenda;

public class Sistema implements ISistema {

	private IControladorVenda controladorVenda = ControladorVenda.getInstance();
	//private Venda venda;
	private static ISistema pdv = null;
	
	private Sistema() {}
	
	public static ISistema getInstance() {
		if(pdv == null){
			pdv = new Sistema();
		}
		return pdv;
	}
	
	public ArrayList<Pagamento> tiposPagamento() {
		// TODO Auto-generated method stub
		return null;
	}

	//Métodos DE VENDA	
	public Item entrarItem(long id, int qtd) {
		Item item = controladorVenda.inserirItem(id, qtd);
		return item;		
	}

	public void fazerPagamento(double quantia) {
		// TODO Auto-generated method stub
		
	}

	public Venda iniciarVenda() {
		Venda venda = controladorVenda.iniciarVenda();
		return venda;
		
	}

	public Venda finalizarVenda() {
		//return venda;
		return null;
	}

	
}
