package br.cefetrn.datinf.estoque.persistencia;

import java.sql.SQLException;

import br.cefetrn.datinf.estoque.dominio.ItemProduto;

public interface ItemProdutoDao {
	public ItemProduto SelectItemProdutoByCodigoProduto(long codProduto , int idLoja) throws SQLException;

}
