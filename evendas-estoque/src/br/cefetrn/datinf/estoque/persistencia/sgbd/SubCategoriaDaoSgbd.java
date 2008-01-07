package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
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
	
	@Override
	public Collection<SubCategoria> recuperarSubCategoriasPorCategoria(Categoria categoria) throws SQLException{
		Collection<SubCategoria> subs = new ArrayList<SubCategoria>();
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spSelectSubCategoriasByCategoria(?)}");
		callableStatement.setInt(1, categoria.getId());
		ResultSet resultado = callableStatement.executeQuery();
		SubCategoria sub = null;
		while(resultado.next()){
			sub = new SubCategoria();
			sub.setId(resultado.getInt("id_subcategoria"));
			sub.setDescricao(resultado.getString("descricao_subcategoria"));
			sub.setCategoria(categoria);
			subs.add(sub);			
		}
		return subs;
	}
	
	@Override
	public int inserir(SubCategoria subCategoria) throws SQLException{
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{? = call sp_Inserir_SubCategoria(?,?)}");
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

	@Override
	public Collection<SubCategoria> recuperarSubCategorias() throws SQLException {
		Collection<SubCategoria> subs = new ArrayList<SubCategoria>();
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spSelectSubCategorias}");
		ResultSet resultado = callableStatement.executeQuery();
		SubCategoria sub = null;
		while(resultado.next()){
			sub = new SubCategoria();
			sub.setId(resultado.getInt("id_subcategoria"));
			sub.setDescricao(resultado.getString("descricao_subcategoria"));
			sub.setCategoria(new CategoriaDaoSgbd().obterPorId(resultado.getInt("id_categoria")));
			subs.add(sub);			
		}
		return subs;
	}

}
