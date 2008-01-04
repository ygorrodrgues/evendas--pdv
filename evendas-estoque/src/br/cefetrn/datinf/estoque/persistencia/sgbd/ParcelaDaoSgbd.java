package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.SQLException;

import br.cefetrn.datinf.estoque.dominio.Parcela;
import br.cefetrn.datinf.estoque.persistencia.ParcelaDao;

public class ParcelaDaoSgbd implements ParcelaDao {

	@Override
	public void registrarParcela(Parcela parcela, int numeroParcela) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		//(ID_PAGAMENTO, ID_CARTAO, DATA_VENC, VALOR_VENC) 
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spRegistrarParcela(?, ?, ?, ?, ?)}");
		callableStatement.setLong(1, parcela.getPagamento().getId());
		System.out.println("Id pagamento: "+parcela.getPagamento().getId());
		callableStatement.setLong(2, parcela.getCartao().getId());
		//FIXME nao sei como converter o date do java pro date do sql server
		callableStatement.setDate(3,null);
		callableStatement.setDouble(4, parcela.getValorVencmento());
		callableStatement.setInt(5, numeroParcela);
		callableStatement.execute();
		

	}

}
