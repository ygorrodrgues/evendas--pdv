package br.cefetrn.datinf.estoque.persistencia;

import java.sql.SQLException;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.Produto;
import br.cefetrn.datinf.estoque.dominio.SubCategoria;

public interface ProdutoDao {
	
	int inserir(Produto produto) throws SQLException;

	Collection<Produto> recuperarProdutosCategoria(int codCategoria) throws SQLException;

	Collection<Produto> recuperarProdutosSubCategoria(SubCategoria subCategoria) throws SQLException;

	Produto recuperarProduto(int id) throws SQLException;
	
	Produto buscarProduto(long id) throws SQLException;

	void deletar(Produto produto) throws SQLException;

	Collection<Produto> recuperarProdutos() throws SQLException;

}
