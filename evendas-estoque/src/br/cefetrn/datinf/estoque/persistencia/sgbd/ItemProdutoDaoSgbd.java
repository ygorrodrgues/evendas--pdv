package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.ItemProduto;
import br.cefetrn.datinf.estoque.dominio.Loja;
import br.cefetrn.datinf.estoque.dominio.Produto;
import br.cefetrn.datinf.estoque.dominio.SubCategoria;
import br.cefetrn.datinf.estoque.persistencia.ItemProdutoDao;

public class ItemProdutoDaoSgbd implements ItemProdutoDao {
	/*TODO criar uma triger para evitar que mais de um item produto seja 
	criado para o mesmo peroduto em uma mesma loja*/
	
	
	@Override
	public int inserir(ItemProduto item) throws SQLException{
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{? = call sp_Inserir_Item_Produto(?,?,?,?)}");
		callableStatement.registerOutParameter(1, Types.INTEGER);
		callableStatement.setLong(2,item.getProduto().getId());
		callableStatement.setInt(3, item.getLoja().getId());
		callableStatement.setInt(4, item.getQtd());
		callableStatement.setDouble(1, item.getPreco());
		callableStatement.execute();
		int idItem = callableStatement.getInt(1);
		return idItem;
	}
	
	@Override
	public void deletar(ItemProduto item) throws SQLException{
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call sp_Deletar_Item_Produto(?)}");
		callableStatement.setLong(1, item.getId());
		callableStatement.execute();
	}
	
	
	@Override	
	public ItemProduto selectItemProdutoByCodigoProduto(long codProduto, int idLoja) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		//fcSelectItemProdutoByCodigoProduto(@codProduto bigint, @idLoja int)
		CallableStatement callableStatement = conexao.obterCallableStatement
			("{call sp_SelectItemProdutoByCodigoProduto(?,?)}");
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
	
	private Produto recuperarProdutoItem(int idProduto) throws SQLException{
		Produto produto = new ProdutoDaoSgbd().buscarProduto(idProduto);
		return produto;
		
	}
	private Loja recuperarLojaItem(int idLoja) throws SQLException{
		Loja loja = new LojaDaoSgbd().buscarLojaById(idLoja);
		return loja;
	}

	@Override
	public Collection<ItemProduto> recuperarItensProduto() throws SQLException {
		Collection<ItemProduto> itens = new ArrayList<ItemProduto>();
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call sp_SelectItensProduto}");
		ResultSet resultado = callableStatement.executeQuery();
		ItemProduto item = null;
		while(resultado.next()){
			item = new ItemProduto();
			item.setId(resultado.getInt("id_subcategoria"));
			item.setLoja(new LojaDaoSgbd().buscarLojaById((resultado.getInt("id_loja"))));
			item.setPreco(resultado.getDouble("preco_item_produto"));
			item.setQtd(resultado.getInt("qtd_item_produto"));
			item.setProduto(new ProdutoDaoSgbd().recuperarProduto(resultado.getInt("id_produto")));
			itens.add(item);			
		}
		return itens;
	}
	
	
}
