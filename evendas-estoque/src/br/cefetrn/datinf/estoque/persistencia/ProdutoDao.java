package br.cefetrn.datinf.estoque.persistencia;

import java.sql.SQLException;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.Categoria;
import br.cefetrn.datinf.estoque.dominio.Produto;
import br.cefetrn.datinf.estoque.dominio.SubCategoria;

public interface ProdutoDao {

	Collection<Produto> recuperarProdutosCategoria(int codCategoria) throws SQLException;

	Collection<Produto> recuperarProdutosSubCategoria(SubCategoria subCategoria) throws SQLException;

	Produto recuperarProduto(int id) throws SQLException;

}
