package br.cefetrn.datinf.estoque.persistencia;

import java.sql.SQLException;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.ItemVenda;

public interface ItemVendaDao {
	
	void trocar(ItemVenda item) throws SQLException;
	Collection<ItemVenda> obterItensPorVenda(int codigo) throws SQLException;
	void registrarItemDeVenda(ItemVenda umItem) throws SQLException;
	
}
