package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.Categoria;
import br.cefetrn.datinf.estoque.dominio.Medida;
import br.cefetrn.datinf.estoque.dominio.SubCategoria;
import br.cefetrn.datinf.estoque.persistencia.MedidaDao;

public class MedidaDaoSgbd implements MedidaDao {

	@Override
	public int inserir(Medida medida) throws SQLException{
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{? = call sp_Inserir_Medida(?)}");
		callableStatement.registerOutParameter(1, Types.INTEGER);
		callableStatement.setString(2, medida.getDescricao());
		callableStatement.execute();
		int idItem = callableStatement.getInt(1);
		return idItem;
	}
	
	@Override
	public void deletar(Medida medida) throws SQLException{
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call sp_Deletar_Medida(?)}");
		callableStatement.setLong(1, medida.getId());
		callableStatement.execute();
	}
	
	@Override
	public Collection<Medida> recuperarMedidas() throws SQLException{
		Collection<Medida> medidas = new ArrayList<Medida>();
		Conexao conexao = Conexao.obterInstancia();
		CallableStatement callableStatement = conexao.obterCallableStatement("{call spSelectMedidas}");
		ResultSet resultado = callableStatement.executeQuery();
		Medida medida = null;
		while(resultado.next()){
			medida = new Medida();
			medida.setId(resultado.getInt("id_medida"));
			medida.setDescricao(resultado.getString("descricao_medida"));
			medidas.add(medida);
		}
		return medidas;
	}

}
