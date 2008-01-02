package br.cefetrn.datinf.pdv.negocio;



//essa classe eh soh pra ver a sequencia...
import dominio.Produto;
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
