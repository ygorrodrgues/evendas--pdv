package br.cefetrn.datinf.pdv.negocio.interfac;

import java.util.Date;

import br.cefetrn.datinf.pdv.dominio.Funcionario;
import br.cefetrn.datinf.pdv.dominio.Item;
import br.cefetrn.datinf.pdv.dominio.Produto;
import br.cefetrn.datinf.pdv.dominio.Venda;

public interface IControladorVenda {
	
	public Venda iniciarVenda();
	public Produto buscarProduto(long id);
	public Item inserirItem(long itemId, int qtd);

	
}
