package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;

public class PagamentoCartao extends Pagamento implements Serializable{
	private double valor;
	private int numParcelas;
	private Cartao cartao;
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getNumParcelas() {
		return numParcelas;
	}
	public void setNumParcelas(int numParcelas) {
		this.numParcelas = numParcelas;
	}
	public Cartao getCartao() {
		return cartao;
	}
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
}
