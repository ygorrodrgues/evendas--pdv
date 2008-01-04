package br.cefetrn.datinf.estoque.persistencia;

import br.cefetrn.datinf.estoque.dominio.Loja;

public interface LojaDao {
	public Loja buscarLojaById(int id);
}
