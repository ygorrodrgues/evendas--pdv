package br.cefetrn.datinf.estoque.persistencia;

import br.cefetrn.datinf.estoque.dominio.Pagamento;

public interface PagamentoDao {
	public boolean registrarPagamento(Pagamento umPagamento);
}
