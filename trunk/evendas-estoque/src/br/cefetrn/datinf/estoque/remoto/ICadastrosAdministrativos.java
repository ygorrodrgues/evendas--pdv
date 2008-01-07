package br.cefetrn.datinf.estoque.remoto;

import java.rmi.Remote;
import java.sql.SQLException;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.Categoria;
import br.cefetrn.datinf.estoque.dominio.ItemProduto;
import br.cefetrn.datinf.estoque.dominio.Medida;
import br.cefetrn.datinf.estoque.dominio.Produto;
import br.cefetrn.datinf.estoque.dominio.SubCategoria;

public interface ICadastrosAdministrativos extends Remote {

	int inserirCategoria(Categoria categoria) throws SQLException;
	void deletarCategoria(Categoria categoria) throws SQLException;
	Collection<Categoria> recuperarCategorias() throws SQLException;
	
	int inserirSubCategoria(SubCategoria subCategoria) throws SQLException;
	void deletarSubCategoria(SubCategoria subCategoria) throws SQLException;
	Collection<SubCategoria> recuperarSubCategorias() throws SQLException;
	
	int inserirMedida(Medida medida) throws SQLException;
	void deletarMedida(Medida medida) throws SQLException;
	Collection<Medida> recuperarMedidas() throws SQLException;
	
	long inserirProduto(Produto produto) throws SQLException;
	void deletarProduto(Produto produto) throws SQLException;
	Collection<Produto> recuperarProdutos() throws SQLException;
	
	long inserirItemProduto(ItemProduto item) throws SQLException;
	void deletarItemProduto(ItemProduto item) throws SQLException;
	Collection<ItemProduto> recuperaritem() throws SQLException;
	
}
