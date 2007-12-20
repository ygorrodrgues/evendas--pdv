package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.ItemDeVenda;
import br.cefetrn.datinf.estoque.persistencia.ItemDeVendaDao;

public class ItemDeVendaDaoSgbd implements ItemDeVendaDao {

	public void atualizar(ItemDeVenda item) {
		// TODO Auto-generated method stub

	}

	public void inserir(ItemDeVenda item) {
		// TODO Auto-generated method stub

	}

	public ItemDeVenda obterPorCodigo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	public void remover(ItemDeVenda item) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spRemoverItemDeVenda(?)}");
		callableStatement.setInt(1, item.getId());
		callableStatement.execute();
	}

	public Collection<ItemDeVenda> obterItensPorVenda(int codigo) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spObterItensDeVendaPorVenda(?)}");
		callableStatement.setInt(1, codigo);
		ResultSet resultado = callableStatement.executeQuery();
		Collection<ItemDeVenda> itens = itens = new ArrayList<ItemDeVenda>();
		ItemDeVenda item;
		while(resultado.next ()){
			item = new ItemDeVenda();
			item.setId(resultado.getInt("codigo"));
			item.setNome(resultado.getString("descricao"));
			item.setQtde(resultado.getInt("quantidade"));
			item.setPreco(resultado.getDouble("valor"));			
			itens.add(item);
		} 
		return itens;
	}
	
	public boolean registrarItemDeVenda(ItemDeVenda umItem) {
		// TODO Auto-generated method stub
		return false;
	}

}
