package br.cefetrn.datinf.estoque.persistencia;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import br.cefetrn.datinf.estoque.dominio.ItemVenda;
import br.cefetrn.datinf.estoque.dominio.Venda;


public interface VendaDao {

	void inserir(Venda item);
	void atualizar(Venda item);
	void remover(Venda item);
	Venda obterPorCodigo(int codigo) throws SQLException;
	void realizarTroca(int numCupomTroca, Collection<ItemVenda> itens) throws SQLException;
	long registrarVenda(int idFunc, int idPDv, long idCliente, Date data) throws SQLException;
	
}
