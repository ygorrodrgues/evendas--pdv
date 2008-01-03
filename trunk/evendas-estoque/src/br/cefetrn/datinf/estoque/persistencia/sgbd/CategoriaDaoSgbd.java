package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.cefetrn.datinf.estoque.dominio.Categoria;
import br.cefetrn.datinf.estoque.persistencia.CategoriaDao;

public class CategoriaDaoSgbd implements CategoriaDao {

	public Categoria obterPorId(int id) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spSelectCategoria(?)}");
		callableStatement.setInt(1, id);
		ResultSet resultado = callableStatement.executeQuery();
		Categoria categoria = null;
		if(resultado.next()){
			categoria = new Categoria();
			categoria.setId(id);
			categoria.setDescricao(resultado.getString("descricao_categoria"));
		}
		return categoria;
	}

}
