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
           // venda.setValor(resultado.getDouble("valor"));
            //TODO: Não está certo a recuperação do valor da compra
            venda.setItens(new ItemVendaDaoSgbd().obterItensPorVenda(codigo));
		} 
		return venda;
	}

	public void remover(Venda item) {
		// TODO Auto-generated method stub

	}
	
	
	public long registrarVenda(Date dataHoraVenda, int idPDV) throws SQLException {
		long idVenda = 0;
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{? = call RegistrarVenda(?)}");
			
			callableStatement.registerOutParameter(1, Types.INTEGER);
			callableStatement.setInt(2, idPDV);
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
				callableStatement.setInt(3, item.getQtde());
				callableStatement.execute();
			}
			/*CallableStatement callableStatement = conexao.obterCallableStatement("{ ? = call SCMBA_PROD.FUNC_UNIFICA_PACIENTE(?,?,?,?)}");
			callableStatement.registerOutputParameter( 1, OracleTypes.CURSOR ); // seu retorno da função
			callableStatement.setLong( 2, umLongQualquer );
			callableStatement.setLong( 3, umLongQualquer );
			callableStatement.setString( 4, umaStringQualquer );
			callableStatement.setTimestamp( 5, umTimestampQualquer );
			callableStatement.execute();*/
			//TODO:OLHAR ESSE PROCEDIMENTO
			
			/*
			create function snuffed_it_when (VARCHAR) returns integer '
			declare
			    poet_id NUMBER;
			    poet_age NUMBER;
			begin
			    -- first get the id associated with the poet.
			    SELECT id INTO poet_id FROM poets WHERE name = $1;
			    -- get and return the age.
			    SELECT age INTO poet_age FROM deaths WHERE mort_id = poet_id;
			    return age;
			end;
			' language 'pl/pgsql';
			
			connection.setAutoCommit(false);
			CallableStatement proc =
			    connection.prepareCall("{ ? = call snuffed_it_when(?) }");
			proc.registerOutParameter(1, Types.INTEGER);
			proc.setString(2, poetName);
			cs.execute();
			int age = proc.getInt(2);
			 */
	}

}
