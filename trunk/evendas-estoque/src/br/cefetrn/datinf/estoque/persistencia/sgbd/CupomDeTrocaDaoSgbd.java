package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;

import br.cefetrn.datinf.estoque.dominio.CupomDeTroca;
import br.cefetrn.datinf.estoque.persistencia.CupomDeTrocaDao;

public class CupomDeTrocaDaoSgbd implements CupomDeTrocaDao {

	public boolean existe(int numCupom) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{? = call spSelectTroca(?)}");
		callableStatement.registerOutParameter(1, Types.INTEGER);
		callableStatement.setInt(2, numCupom);
		callableStatement.execute();
		int num = callableStatement.getInt(1);
		return num == 0 ? false : true;
	}

	public int inserir(CupomDeTroca cupom) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{? = call spInserirCupom(?,?)}");
		callableStatement.registerOutParameter(1, Types.INTEGER);
		callableStatement.setLong(2, cupom.getVenda().getId());
		//callableStatement.setDate(3, (Date) cupom.getData());
		callableStatement.setDouble(3, cupom.getValor());
		callableStatement.execute();
		int codigo = callableStatement.getInt(1);
		return codigo;
	}
	
	public void ligarTrocaAoPagamento(CupomDeTroca cupomDeTroca) throws SQLException{
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spLigarTrocaAoPagamento(?,?)}");		
		callableStatement.setLong(1, cupomDeTroca.getId());		
		callableStatement.setLong(2, cupomDeTroca.getPagamento().getId());
		callableStatement.execute();
		
	}
	
}