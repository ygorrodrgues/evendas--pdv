package br.cefetrn.datinf.estoque.persistencia;

import java.sql.SQLException;

import br.cefetrn.datinf.estoque.dominio.CupomDeTroca;

public interface CupomDeTrocaDao {
	
	public boolean existe(int numCupom) throws SQLException;

	public int inserir(CupomDeTroca cupom) throws SQLException;

}
