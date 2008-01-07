package br.cefetrn.datinf.estoque.persistencia;

import java.sql.SQLException;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.Categoria;
import br.cefetrn.datinf.estoque.dominio.SubCategoria;

public interface SubCategoriaDao {

	SubCategoria obterPorId(int id) throws SQLException;

	void deletar(SubCategoria subCategoria) throws SQLException;

	int inserir(SubCategoria subCategoria) throws SQLException;

	Collection<SubCategoria> recuperarSubCategoriasPorCategoria(
			Categoria categoria) throws SQLException;

	Collection<SubCategoria> recuperarSubCategorias() throws SQLException;
	
}
