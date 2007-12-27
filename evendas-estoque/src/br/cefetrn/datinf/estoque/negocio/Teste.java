package br.cefetrn.datinf.estoque.negocio;

import java.util.Date;

import br.cefetrn.datinf.estoque.dominio.Pagamento;
import br.cefetrn.datinf.estoque.dominio.PDV;
import br.cefetrn.datinf.estoque.dominio.TipoPagamento;
import br.cefetrn.datinf.estoque.dominio.Venda;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Estoque estoque = new Estoque();
		Venda novaVenda = new Venda();
		novaVenda.setData(new Date());
		PDV pdv = new PDV();
		pdv.setID(1);
		novaVenda.setPdv(pdv);
		//Pagamento pag =  new Pagamento();
		//pag.setTipo(TipoPagamento.CARTAO);
		
		long idVenda = estoque.registrarVenda(novaVenda);
		System.out.println("Venda registrada. ID: "+idVenda);
		
	}

}
