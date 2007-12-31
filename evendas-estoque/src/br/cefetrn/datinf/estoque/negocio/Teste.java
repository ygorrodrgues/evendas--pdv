package br.cefetrn.datinf.estoque.negocio;

import java.util.Date;

import br.cefetrn.datinf.estoque.dominio.Cliente;
import br.cefetrn.datinf.estoque.dominio.Funcionario;
import br.cefetrn.datinf.estoque.dominio.ItemVenda;
import br.cefetrn.datinf.estoque.dominio.Pagamento;
import br.cefetrn.datinf.estoque.dominio.PDV;
import br.cefetrn.datinf.estoque.dominio.PagamentoDinheiro;
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
		
		Funcionario funcionario =  new Funcionario();
		funcionario.setId(1);
		
		Cliente cliente = new Cliente();
		cliente.setId(2);
		
		ItemVenda itemVenda =  new ItemVenda();
		
		Pagamento pag =  new PagamentoDinheiro();
		
		novaVenda.setCliente(cliente);
		novaVenda.setFuncionario(funcionario);
		novaVenda.setPdv(pdv);
		novaVenda.adicionarItem(itemVenda);
		novaVenda.adicionarPagamento(pag);
		
		long idVenda = estoque.registrarVenda(novaVenda);
		System.out.println("Venda registrada. ID: "+idVenda);
		
	}

}
