package br.cefetrn.datinf.estoque.remoto;

import br.cefetrn.datinf.pdv.dominio.Produto;

public interface IEstoque {

	public Produto buscarProduto(long id); 
}
