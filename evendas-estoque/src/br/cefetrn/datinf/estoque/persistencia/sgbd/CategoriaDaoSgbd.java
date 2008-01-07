package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.Categoria;
import br.cefetrn.datinf.estoque.persistencia.CategoriaDao;

public class CategoriaDaoSgbd implements CategoriaDao {

	@Override
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
	
	@Override
	public int inserir(Categoria categoria) throws SQLException{
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{? = call sp_Inserir_Categoria(?)}");
		callableStatement.registerOutParameter(1, Types.INTEGER);
		callableStatement.setString(2, categoria.getDescricao());
		callableStatement.execute();
		int idItem = callableStatement.getInt(1);
		return idItem;
	}
	
	@Override
	public void deletar(Categoria categoria) throws SQLException{
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call sp_Deletar_Categoria(?)}");
		callableStatement.setLong(1, categoria.getId());
		callableStatement.execute();
	}
	
	@Override
	public Collection<Categoria> recuperarCategorias() throws SQLException {
		Collection<Categoria> categorias = new ArrayList<Categoria>();
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spSelectCategoria }");
		ResultSet resultado = callableStatement.executeQuery();
		Categoria categoria = null;
		while(resultado.next()){
			categoria = new Categoria();
			categoria.setId(resultado.getInt("id_categoria"));
			categoria.setDescricao(resultado.getString("descricao_categoria"));
			categoria.setSubs(new SubCategoriaDaoSgbd().recuperarSubCategoriasPorCategoria(categoria));
			categorias.add(categoria);
		}
		return categorias;
	}

}
