package br.cefetrn.datinf.estoque.persistencia;

import java.sql.SQLException;

import br.cefetrn.datinf.estoque.dominio.Categoria;

public interface CategoriaDao {

	Categoria obterPorId(int id) throws SQLException;

	int inserir(Categoria categoria) throws SQLException;

	void deletar(Categoria categoria) throws SQLException;
}
