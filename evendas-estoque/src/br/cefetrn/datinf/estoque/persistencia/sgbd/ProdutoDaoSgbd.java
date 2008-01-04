package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.Categoria;
import br.cefetrn.datinf.estoque.dominio.Produto;
import br.cefetrn.datinf.estoque.dominio.SubCategoria;
import br.cefetrn.datinf.estoque.persistencia.ProdutoDao;

public class ProdutoDaoSgbd implements ProdutoDao {

	public ProdutoDaoSgbd() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<Produto> recuperarProdutosCategoria(int codCategoria) throws SQLException {
		Collection<Produto> produtos = new ArrayList<Produto>();
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spSelectProdutosByCategoria(?)}");
		callableStatement.setInt(1, codCategoria);
		ResultSet resultado = callableStatement.executeQuery();
		Produto produto = null;
		while(resultado.next()){
			produto = new Produto();
			produto.setId(resultado.getInt("codigo"));
			produto.setNome(resultado.getString("nome"));
			produto.setDescricao(resultado.getString("descricao"));
			produto.setQtde(resultado.getInt("quantidade"));
			produto.setPreco(resultado.getDouble("preco"));
			produto.setSubCategoria(new SubCategoriaDaoSgbd().obterPorId(resultado.getInt("cod_subcategoria")));
			produtos.add(produto);
		}
		return produtos;
	}

	@Override
	public Collection<Produto> recuperarProdutosSubCategoria(SubCategoria subCategoria) throws SQLException {
		Collection<Produto> produtos = new ArrayList<Produto>();
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spSelectProdutosBySubCategoria(?)}");
		callableStatement.setInt(1, subCategoria.getId());
		ResultSet resultado = callableStatement.executeQuery();
		Produto produto = null;
		while(resultado.next()){
			produto = new Produto();
			produto.setId(resultado.getInt("codigo"));
			produto.setNome(resultado.getString("nome"));
			produto.setDescricao(resultado.getString("descricao"));
			produto.setQtde(resultado.getInt("quantidade"));
			produto.setPreco(resultado.getDouble("preco"));
			produto.setSubCategoria(subCategoria);
			produtos.add(produto);
		}
		return produtos;
	}

	@Override
	public Produto recuperarProduto(int id) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spSelectProdutoById(?)}");
		callableStatement.setInt(1, id);
		ResultSet resultado = callableStatement.executeQuery();
		Produto produto = null;
		if(resultado.next()){
			produto = new Produto();
			produto.setId(resultado.getInt("codigo"));
			produto.setNome(resultado.getString("nome"));
			produto.setDescricao(resultado.getString("descricao"));
			produto.setQtde(resultado.getInt("quantidade"));
			produto.setPreco(resultado.getDouble("preco"));
			produto.setSubCategoria(new SubCategoriaDaoSgbd().obterPorId(resultado.getInt("cod_subcategoria")));
		}
		return produto;
	}

	@Override
	public Produto buscarProduto(long id) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spRecuperarProdutoById (?)}");
		callableStatement.setLong(1, id);
		ResultSet resultado = callableStatement.executeQuery();
		Produto produto = null;
		if(resultado.next()){
			produto = new Produto();
			produto.setId(resultado.getLong("ID-PRODUTO"));
			produto.setNome(resultado.getString("NOME_PRODUTO"));
			produto.setDescricao(resultado.getString("DESCRICAO_PRODUTO "));
			produto.setPreco(resultado.getDouble("CUSTO"));
			produto.setSubCategoria(new SubCategoriaDaoSgbd().obterPorId(resultado.getInt("ID_SUBCATEGORIA")));
		}
		return produto;
	}

	@Override
	public int inserir(Produto produto) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{? = call sp_Inserir_Produto(?,?,?,?,?)}");
		callableStatement.registerOutParameter(1, Types.INTEGER);
		callableStatement.setInt(2,produto.getCodigo());
		callableStatement.setInt(3,	produto.getMedida().getId());
		callableStatement.setString(4, produto.getNome());
		callableStatement.setString(5, produto.getDescricao());
		callableStatement.setDouble(6, produto.getPreco());
		callableStatement.execute();
		int idProduto = callableStatement.getInt(1);
		return idProduto;
	}
	
	@Override
	public void deletar(Produto produto) throws SQLException{
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call sp_Deletar_Produto(?)}");
		callableStatement.setLong(1, produto.getId());
		callableStatement.execute();
	}

}
