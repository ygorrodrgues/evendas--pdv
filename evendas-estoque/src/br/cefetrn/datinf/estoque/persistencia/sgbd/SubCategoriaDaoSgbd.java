package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.cefetrn.datinf.estoque.dominio.SubCategoria;
import br.cefetrn.datinf.estoque.persistencia.SubCategoriaDao;

public class SubCategoriaDaoSgbd implements SubCategoriaDao {

	public SubCategoria obterPorId(int id) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spSelectSubCategoria(?)}");
		callableStatement.setInt(1, id);
		ResultSet resultado = callableStatement.executeQuery();
		SubCategoria subCategoria = null;
		if(resultado.next()){
			subCategoria = new SubCategoria();
			subCategoria.setId(id);
			subCategoria.setDescricao(resultado.getString("descricao_subcategoria"));
			subCategoria.setCategoria(new CategoriaDaoSgbd().obterPorId(resultado.getInt("id_Categoria")));
		}
		return subCategoria;
	}

}
