package br.cefetrn.datinf.pdv.negocio;

import br.cefetrn.datinf.pdv.dominio.Produto;

//essa classe eh soh pra ver a sequencia...
// foi implementada sem padraaaaaaaaaaaaaaaaaaaao!!!
//se liguem ;) *)


public class ControladorProduto {

	public void inserir(Produto produto) {
		//vai pra interface remota
	}
	
	private static ControladorProduto controlador = null;
	
	private ControladorProduto() {}
	
	public static ControladorProduto getInstance() {
		if(controlador == null){
			controlador = new ControladorProduto();
		}
		return controlador;
	}
	
}
