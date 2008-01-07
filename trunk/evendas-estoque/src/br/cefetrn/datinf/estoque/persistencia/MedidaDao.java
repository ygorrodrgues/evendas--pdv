package br.cefetrn.datinf.estoque.persistencia;

import java.sql.SQLException;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.Medida;
import br.cefetrn.datinf.estoque.dominio.SubCategoria;

public interface MedidaDao {

	int inserir(Medida medida) throws SQLException;

	void deletar(Medida medida) throws SQLException;

	Collection<Medida> recuperarMedidas() throws SQLException;
}
