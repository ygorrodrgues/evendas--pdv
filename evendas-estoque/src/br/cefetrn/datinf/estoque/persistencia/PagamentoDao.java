package br.cefetrn.datinf.estoque.persistencia;

import java.sql.SQLException;

import br.cefetrn.datinf.estoque.dominio.Pagamento;

public interface PagamentoDao {
	public long registrarPagamento(Pagamento umPagamento) throws SQLException;
}
