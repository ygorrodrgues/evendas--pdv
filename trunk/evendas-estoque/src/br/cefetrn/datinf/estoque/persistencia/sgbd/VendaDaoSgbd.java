package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;
import java.util.Date;

import br.cefetrn.datinf.estoque.dominio.ItemVenda;
import br.cefetrn.datinf.estoque.dominio.Venda;
import br.cefetrn.datinf.estoque.persistencia.VendaDao;
/**
 * 
 * @author Gleison
 *
 */
public class VendaDaoSgbd implements VendaDao {

	public void atualizar(Venda item) {
		// TODO Auto-generated method stub

	}

	public void inserir(Venda item) {
		// TODO Auto-generated method stub

	}

	public Venda obterPorCodigo(int codigo) throws SQLException {
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spObterVendaPorCod(?)}");
		callableStatement.setInt(1, codigo);
		ResultSet resultado = callableStatement.executeQuery();
		Venda venda = null;
		if(resultado.next()){
			venda = new Venda();
			venda.setId(codigo);
            venda.setData(resultado.getDate("data"));
            venda.setValor(resultado.getDouble("valor"));
            venda.setItens(new ItemVendaDaoSgbd().obterItensPorVenda(codigo));
		} 
		return venda;
	}

	public void remover(Venda item) {
		// TODO Auto-generated method stub

	}
	
	
	public long registrarVenda(int idFunc, int idPDV, long idCliente, Date data) throws SQLException {
		long idVenda = 0;
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = 
			conexao.obterCallableStatement("{? = call spRegistrarVenda(?, ?, ?, ?)}");
			
			callableStatement.registerOutParameter(1, Types.INTEGER);
			callableStatement.setInt(2, idFunc);
			callableStatement.setInt(3, idPDV);
			callableStatement.setLong(4, idCliente);
			//FIXME Não sei como coverter o Date do java para o datetime do sql server
			callableStatement.setDate(5, null);
			callableStatement.execute();
			idVenda = callableStatement.getLong(1);
		
		return idVenda;
	}

	public void realizarTroca(int numCupomTroca, Collection<ItemVenda> itens) throws SQLException {
			Conexao conexao = Conexao.obterInstancia();
			for(ItemVenda item: itens){
				CallableStatement callableStatement = conexao.obterCallableStatement("{call spRealizarTroca(?,?,?)}");
				callableStatement.setInt(1, numCupomTroca);
				callableStatement.setInt(2, item.getIdProduto());
				callableStatement.setInt(3, item.getQtde()-1);
				callableStatement.execute();
			}
	}

}
