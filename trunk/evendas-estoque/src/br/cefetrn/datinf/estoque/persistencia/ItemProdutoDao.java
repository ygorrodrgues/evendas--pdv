package br.cefetrn.datinf.estoque.persistencia;

import java.sql.SQLException;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.ItemProduto;

public interface ItemProdutoDao {
	public ItemProduto selectItemProdutoByCodigoProduto(long codProduto , int idLoja) throws SQLException;

	int inserir(ItemProduto item) throws SQLException;

	void deletar(ItemProduto item) throws SQLException;

	public Collection<ItemProduto> recuperarItensProduto() throws SQLException;

}
