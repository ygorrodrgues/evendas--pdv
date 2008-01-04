package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.Categoria;
import br.cefetrn.datinf.estoque.dominio.SubCategoria;
import br.cefetrn.datinf.estoque.persistencia.SubCategoriaDao;

public class SubCategoriaDaoSgbd implements SubCategoriaDao {

	@Override
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
	
	//@Override
	//public Collection<SubCategoria> 
	
	@Override
	public int inserir(SubCategoria subCategoria) throws SQLException{
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{? = call sp_Select_SubCategoria(?,?)}");
		callableStatement.registerOutParameter(1, Types.INTEGER);
		callableStatement.setInt(2, subCategoria.getCategoria().getId());
		callableStatement.setString(3, subCategoria.getDescricao());
		callableStatement.execute();
		int idItem = callableStatement.getInt(1);
		return idItem;
	}
	
	@Override
	public void deletar(SubCategoria subCategoria) throws SQLException{
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call sp_Deletar_SubCategoria(?)}");
		callableStatement.setLong(1, subCategoria.getId());
		callableStatement.execute();
	}

}
