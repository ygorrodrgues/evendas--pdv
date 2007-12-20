package br.cefetrn.datinf.pdv.dominio;

public class PagamentoCartao extends Pagamento{

	private int qtdParcelas;
	private double valorParcela;
	

	public int getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(int qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

	public double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(double valorParcela) {
		this.valorParcela = valorParcela;
	}
	
	
}
