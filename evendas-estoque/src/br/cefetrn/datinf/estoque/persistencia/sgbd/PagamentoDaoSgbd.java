package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import br.cefetrn.datinf.estoque.dominio.Pagamento;
import br.cefetrn.datinf.estoque.persistencia.PagamentoDao;

public class PagamentoDaoSgbd implements PagamentoDao {
	
	public PagamentoDaoSgbd() {
		// TODO Auto-generated constructor stub
	}

	public long registrarPagamento(Pagamento umPagamento) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = 
			conexao.obterCallableStatement("{? = call RegistrarPagamento(?, ?, ?)}");
		callableStatement.registerOutParameter(1, Types.BIGINT);
		callableStatement.setString(2, umPagamento.getTipo().toString());
		callableStatement.setLong(3, umPagamento.getVenda().getId());
		callableStatement.setDouble(4,umPagamento.getValor());
		callableStatement.execute();
		long idPagamento = callableStatement.getLong(1);
		return idPagamento;
	}
}
