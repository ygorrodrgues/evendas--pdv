package br.cefetrn.datinf.estoque.persistencia;

import java.sql.SQLException;

import br.cefetrn.datinf.estoque.dominio.SubCategoria;

public interface SubCategoriaDao {

	SubCategoria obterPorId(int id) throws SQLException;

	void deletar(SubCategoria subCategoria) throws SQLException;

	int inserir(SubCategoria subCategoria) throws SQLException;
	
}
