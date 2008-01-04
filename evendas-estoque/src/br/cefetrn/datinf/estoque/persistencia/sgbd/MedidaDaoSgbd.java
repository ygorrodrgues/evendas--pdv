package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import br.cefetrn.datinf.estoque.dominio.Medida;
import br.cefetrn.datinf.estoque.persistencia.MedidaDao;

public class MedidaDaoSgbd implements MedidaDao {

	@Override
	public int inserir(Medida medida) throws SQLException{
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{? = call sp_Inserir_Medida(?)}");
		callableStatement.registerOutParameter(1, Types.INTEGER);
		callableStatement.setString(2, medida.getDescricao());
		callableStatement.execute();
		int idItem = callableStatement.getInt(1);
		return idItem;
	}
	
	@Override
	public void deletar(Medida medida) throws SQLException{
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call sp_Deletar_Medida(?)}");
		callableStatement.setLong(1, medida.getId());
		callableStatement.execute();
	}

}
