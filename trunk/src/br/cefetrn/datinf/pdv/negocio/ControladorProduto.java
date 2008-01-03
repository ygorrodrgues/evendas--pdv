package br.cefetrn.datinf.pdv.negocio;

import br.cefetrn.datinf.estoque.dominio.Produto;
import br.cefetrn.datinf.estoque.dominio.Venda;


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
