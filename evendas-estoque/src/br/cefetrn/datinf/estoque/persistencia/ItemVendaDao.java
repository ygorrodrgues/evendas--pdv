package br.cefetrn.datinf.estoque.persistencia;

import java.sql.SQLException;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.ItemVenda;

public interface ItemVendaDao {
	
	void inserir(ItemVenda item);
	void atualizar(ItemVenda item);
	void remover(ItemVenda item) throws SQLException;
	ItemVenda obterPorCodigo(int codigo);
	Collection<ItemVenda> obterItensPorVenda(int codigo) throws SQLException;
	boolean registrarItemDeVenda(ItemVenda umItem);
	
}
