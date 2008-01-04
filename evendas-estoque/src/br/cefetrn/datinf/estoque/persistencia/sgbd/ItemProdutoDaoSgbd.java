package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.cefetrn.datinf.estoque.dominio.ItemProduto;
import br.cefetrn.datinf.estoque.dominio.Loja;
import br.cefetrn.datinf.estoque.dominio.Produto;
import br.cefetrn.datinf.estoque.persistencia.FabricaDao;
import br.cefetrn.datinf.estoque.persistencia.ItemProdutoDao;

public class ItemProdutoDaoSgbd implements ItemProdutoDao {
	/*TODO criar uma triger para evitar que mais de um item produto seja 
	criado para o mesmo peroduto em uma mesma loja*/
	
	private FabricaDao fabrica = FabricaDao.getInstance();
	@Override
	
	public ItemProduto SelectItemProdutoByCodigoProduto(long codProduto, int idLoja) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		//fcSelectItemProdutoByCodigoProduto(@codProduto bigint, @idLoja int)
		CallableStatement callableStatement = conexao.obterCallableStatement
			("{call Select * FROM fcSelectItemProdutoByCodigoProduto(?,?)}");
		callableStatement.setLong(1, codProduto);
		callableStatement.setInt(2, idLoja);
		ResultSet resultado = callableStatement.executeQuery();
		ItemProduto itemProduto = null;
		if(resultado.next()){
			itemProduto = new ItemProduto();
			itemProduto.setId(resultado.getInt("ID_ITEM_PRODUTO"));
			itemProduto.setLoja(this.recuperarLojaItem(resultado.getInt("ID_LOJA")));
			itemProduto.setProduto(this.recuperarProdutoItem(resultado.getInt("ID_PRODUTO")));
			itemProduto.setPreco(resultado.getDouble("PRECO_ITEM_PRODUTO"));
			itemProduto.setQtd(resultado.getInt("QTD_ITEM_PRODUTO"));
			
		}
		return itemProduto;
	}
	
	public Produto recuperarProdutoItem(int idProduto) throws SQLException{
		Produto produto = this.fabrica.getProdutoDao().buscarProduto(idProduto);
		return produto;
		
	}
	public Loja recuperarLojaItem(int idLoja) throws SQLException{
		Loja loja = this.fabrica.getLojaDao().buscarLojaById(idLoja);
		return loja;
	}
	
	
}
