package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;

public class PagamentoDinheiro extends Pagamento implements Serializable{
	private double valor;
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
