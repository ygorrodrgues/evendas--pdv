package br.cefetrn.datinf.estoque.negocio;

import java.sql.SQLException;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.Categoria;
import br.cefetrn.datinf.estoque.dominio.ItemProduto;
import br.cefetrn.datinf.estoque.dominio.Medida;
import br.cefetrn.datinf.estoque.dominio.Produto;
import br.cefetrn.datinf.estoque.dominio.SubCategoria;
import br.cefetrn.datinf.estoque.persistencia.FabricaDao;
import br.cefetrn.datinf.estoque.remoto.ICadastrosAdministrativos;

public class CadastrosAdministrativos implements ICadastrosAdministrativos {

	private FabricaDao fabrica;
	
	public CadastrosAdministrativos() {
		fabrica = FabricaDao.getInstance();
	}
	
	@Override
	public void deletarCategoria(Categoria categoria) throws SQLException {
		fabrica.getCategoriaDao().deletar(categoria);		
	}

	@Override
	public void deletarItemProduto(ItemProduto item) throws SQLException {
		fabrica.getItemProdutoDao().deletar(item);
	}

	@Override
	public void deletarMedida(Medida medida) throws SQLException {
		fabrica.getMedidaDaoDao().deletar(medida);		
	}

	@Override
	public void deletarProduto(Produto produto) throws SQLException {
		fabrica.getProdutoDao().deletar(produto);
	}

	@Override
	public void deletarSubCategoria(SubCategoria subCategoria) throws SQLException {
		fabrica.getSubCategoriaDao().deletar(subCategoria);
	}

	@Override
	public int inserirCategoria(Categoria categoria) throws SQLException {
		return fabrica.getCategoriaDao().inserir(categoria);
	}

	@Override
	public long inserirItemProduto(ItemProduto item) throws SQLException {
		return fabrica.getItemProdutoDao().inserir(item);
	}

	@Override
	public int inserirMedida(Medida medida) throws SQLException {
		return fabrica.getMedidaDaoDao().inserir(medida);
	}

	@Override
	public long inserirProduto(Produto produto) throws SQLException {
		return fabrica.getProdutoDao().inserir(produto);
	}

	@Override
	public int inserirSubCategoria(SubCategoria subCategoria) throws SQLException {
		return fabrica.getSubCategoriaDao().inserir(subCategoria);
	}

	@Override
	public Collection<Categoria> recuperarCategorias() throws SQLException {
		return fabrica.getCategoriaDao().recuperarCategorias();
	}

	@Override
	public Collection<Medida> recuperarMedidas() throws SQLException {
		return fabrica.getMedidaDaoDao().recuperarMedidas();
	}

	@Override
	public Collection<Produto> recuperarProdutos() throws SQLException {
		return fabrica.getProdutoDao().recuperarProdutos();
	}

	@Override
	public Collection<SubCategoria> recuperarSubCategorias() throws SQLException {
		return fabrica.getSubCategoriaDao().recuperarSubCategorias();
	}

	@Override
	public Collection<ItemProduto> recuperaritem() throws SQLException {
		return fabrica.getItemProdutoDao().recuperarItensProduto();
	}
	
	
	

}
