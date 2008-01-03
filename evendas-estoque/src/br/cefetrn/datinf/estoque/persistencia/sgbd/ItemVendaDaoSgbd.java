package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.ItemVenda;
import br.cefetrn.datinf.estoque.persistencia.ItemVendaDao;

public class ItemVendaDaoSgbd implements ItemVendaDao {

	public void atualizar(ItemVenda item) {
		// TODO Auto-generated method stub

	}

	public void inserir(ItemVenda item) {
		// TODO Auto-generated method stub

	}

	public ItemVenda obterPorCodigo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	public void remover(ItemVenda item) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spRemoverItemDeVenda(?)}");
		callableStatement.setInt(1, item.getId());
		callableStatement.execute();
	}

	public Collection<ItemVenda> obterItensPorVenda(int codigo) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spObterItensDeVendaPorVenda(?)}");
		callableStatement.setInt(1, codigo);
		ResultSet resultado = callableStatement.executeQuery();
		Collection<ItemVenda> itens = itens = new ArrayList<ItemVenda>();
		ItemVenda item;
		while(resultado.next ()){
			item = new ItemVenda();
			item.setId(resultado.getInt("codigo"));
			item.setNome(resultado.getString("descricao"));			
			item.setQtde(resultado.getInt("quantidade"));
			item.setPreco(resultado.getDouble("valor"));			
			itens.add(item);
		} 
		return itens;
	}
	
	public void registrarItemDeVenda(ItemVenda umItem) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spRegistrarItemVenda(?, ?, ?, ?)}");
		callableStatement.setLong(1, umItem.getVenda().getId());
		callableStatement.setLong(2, umItem.getItemProduto().getId());
		callableStatement.setString(3, umItem.getEstado().toString());
		callableStatement.setInt(4, umItem.getQtde());
		callableStatement.execute();
		
	}

}
