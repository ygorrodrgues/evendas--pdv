package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import br.cefetrn.datinf.estoque.dominio.Loja;
import br.cefetrn.datinf.estoque.dominio.Produto;
import br.cefetrn.datinf.estoque.persistencia.LojaDao;

public class LojaDaoSgbd implements LojaDao {

	@Override
	public Loja buscarLojaById(int id) {
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spRecuperarProdutoById (?)}");
		callableStatement.setLong(1, id);
		ResultSet resultado = callableStatement.executeQuery();
		Produto produto = null;
		if(resultado.next()){
			produto = new Produto();
			produto.setId(resultado.getLong("ID-PRODUTO"));
			produto.setNome(resultado.getString("NOME_PRODUTO"));
			produto.setDescricao(resultado.getString("DESCRICAO_PRODUTO "));
			produto.setPreco(resultado.getDouble("CUSTO"));
			produto.setSubCategoria(new SubCategoriaDaoSgbd().obterPorId(resultado.getInt("ID_SUBCATEGORIA")));
		}
		return produto;
	}

}
