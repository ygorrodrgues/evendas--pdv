package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public Collection<Produto> recuperarProdutos(Categoria categoria) throws SQLException {
		Collection<Produto> produtos = new ArrayList<Produto>();
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spSelectProdutosByCategoria(?)}");
		callableStatement.setInt(1, categoria.getId());
		ResultSet resultado = callableStatement.executeQuery();
		Produto produto = null;
		while(resultado.next()){
			produto = new Produto();
			produto.setId(resultado.getInt("ID_PRODUTO"));
			produto.setDescricao(resultado.getString("DESCRICAO"));
			produto.setQtde(resultado.getInt("qtd"));
			produto.setPreco(resultado.getDouble("preco"));
			produto.setSubCategoria(new SubCategoriaDaoSgbd().obterPorId(resultado.getInt("idsubcategoria")));
			produtos.add(produto);
		}
		return produtos;
	}

	@Override
	public Collection<Produto> recuperarProdutos(SubCategoria subCategoria) throws SQLException {
		Collection<Produto> produtos = new ArrayList<Produto>();
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spSelectProdutosBySubCategoria(?)}");
		callableStatement.setInt(1, subCategoria.getId());
		ResultSet resultado = callableStatement.executeQuery();
		Produto produto = null;
		while(resultado.next()){
			produto = new Produto();
			produto.setId(resultado.getInt("id"));
			produto.setDescricao(resultado.getString("nome"));
			produto.setQtde(resultado.getInt("qtd"));
			produto.setPreco(resultado.getDouble("preco"));
			produto.setSubCategoria(subCategoria);
			produtos.add(produto);
		}
		return produtos;
	}

	@Override
	public Produto recuperarProduto(int id) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spSelectProdutosById(?)}");
		callableStatement.setInt(1, id);
		ResultSet resultado = callableStatement.executeQuery();
		Produto produto = null;
		if(resultado.next()){
			produto = new Produto();
			produto.setId(resultado.getInt("id"));
			produto.setDescricao(resultado.getString("nome"));
			produto.setQtde(resultado.getInt("qtd"));
			produto.setPreco(resultado.getDouble("preco"));
			produto.setSubCategoria(new SubCategoriaDaoSgbd().obterPorId(resultado.getInt("idsubcategoria")));
		}
		return produto;
	}

}