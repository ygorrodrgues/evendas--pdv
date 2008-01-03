package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.SQLException;
import java.util.ArrayList;

import br.cefetrn.datinf.estoque.dominio.ItemVenda;


public class Main {

	public static void main(String[] args) {
		
		try {
			ArrayList<ItemVenda> itens = (ArrayList<ItemVenda>) new VendaDaoSgbd().obterPorCodigo(3).getItens();
			new VendaDaoSgbd().realizarTroca(1, itens);
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
