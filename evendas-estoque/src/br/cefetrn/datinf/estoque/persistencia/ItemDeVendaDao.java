package br.cefetrn.datinf.estoque.persistencia;

import java.sql.SQLException;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.ItemDeVenda;

public interface ItemDeVendaDao {
	
	void inserir(ItemDeVenda item);
	void atualizar(ItemDeVenda item);
	void remover(ItemDeVenda item) throws SQLException;
	ItemDeVenda obterPorCodigo(int codigo);
	Collection<ItemDeVenda> obterItensPorVenda(int codigo) throws SQLException;
	boolean registrarItemDeVenda(ItemDeVenda umItem);
	
}
