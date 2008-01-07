package br.cefetrn.datinf.estoque.remoto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.Categoria;
import br.cefetrn.datinf.estoque.dominio.ItemProduto;
import br.cefetrn.datinf.estoque.dominio.Medida;
import br.cefetrn.datinf.estoque.dominio.Produto;
import br.cefetrn.datinf.estoque.dominio.SubCategoria;

public interface ICadastrosAdministrativos extends Remote {

	int inserirCategoria(Categoria categoria) throws SQLException, RemoteException;
	void deletarCategoria(Categoria categoria) throws SQLException, RemoteException;
	Collection<Categoria> recuperarCategorias() throws SQLException, RemoteException;
	
	int inserirSubCategoria(SubCategoria subCategoria) throws SQLException, RemoteException;
	void deletarSubCategoria(SubCategoria subCategoria) throws SQLException, RemoteException;
	Collection<SubCategoria> recuperarSubCategorias() throws SQLException, RemoteException;
	
	int inserirMedida(Medida medida) throws SQLException, RemoteException;
	void deletarMedida(Medida medida) throws SQLException, RemoteException;
	Collection<Medida> recuperarMedidas() throws SQLException, RemoteException;
	
	long inserirProduto(Produto produto) throws SQLException, RemoteException;
	void deletarProduto(Produto produto) throws SQLException, RemoteException;
	Collection<Produto> recuperarProdutos() throws SQLException, RemoteException;
	
	long inserirItemProduto(ItemProduto item) throws SQLException, RemoteException;
	void deletarItemProduto(ItemProduto item) throws SQLException, RemoteException;
	Collection<ItemProduto> recuperaritem() throws SQLException, RemoteException;
	
}
