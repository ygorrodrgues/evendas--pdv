package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.cefetrn.datinf.estoque.dominio.Loja;
import br.cefetrn.datinf.estoque.dominio.Produto;
import br.cefetrn.datinf.estoque.persistencia.LojaDao;

public class LojaDaoSgbd implements LojaDao {

	@Override
	public Loja buscarLojaById(int id) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spBuscarLojaById(?)}");
		callableStatement.setInt(1, id);
		ResultSet resultado = callableStatement.executeQuery();
		Loja loja = null;
		if(resultado.next()){
			loja = new Loja();
			loja.setId(resultado.getInt("ID_LOJA"));
			loja.setNome(resultado.getString("NOME_LOJA"));
			
		}
		return loja;
	}

}
