package br.cefetrn.datinf.estoque.persistencia;

import java.sql.SQLException;

import br.cefetrn.datinf.estoque.dominio.Parcela;

public interface ParcelaDao {
	
	public void registrarParcela(Parcela parcela, int numeroParcela) throws SQLException;
	
}
