package br.cefetrn.datinf.estoque.persistencia;

import java.sql.SQLException;

import br.cefetrn.datinf.estoque.dominio.Medida;

public interface MedidaDao {

	int inserir(Medida medida) throws SQLException;

	void deletar(Medida medida) throws SQLException;
}
