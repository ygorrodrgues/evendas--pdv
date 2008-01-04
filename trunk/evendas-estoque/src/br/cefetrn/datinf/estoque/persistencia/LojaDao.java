package br.cefetrn.datinf.estoque.persistencia;

import java.sql.SQLException;

import br.cefetrn.datinf.estoque.dominio.Loja;

public interface LojaDao {
	public Loja buscarLojaById(int id) throws SQLException;
}
