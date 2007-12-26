package br.cefetrn.datinf.estoque.negocio;

import java.util.Date;

import br.cefetrn.datinf.estoque.dominio.Pdv;
import br.cefetrn.datinf.estoque.dominio.Venda;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Estoque estoque = new Estoque();
		Venda novaVenda = new Venda();
		novaVenda.setData(new Date());
		Pdv pdv = new Pdv();
		pdv.setNumero(1);
		novaVenda.setPdv(pdv);
		
		estoque.registrarVenda(novaVenda);
	}

}
