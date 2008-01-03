package br.cefetrn.datinf.estoque.dominio;

public class PagamentoCartao extends Pagamento {

	private double valor;
	private int nParcelas;
	
	public void setValor(double valor){
		this.valor= valor;
	}
	public double getValor(){
		return this.valor;
	}
	public void setNParcelas(int nParcelas){
		this.nParcelas = nParcelas;
	}
	public int getNParcelas(){
		return this.nParcelas;
	}
}
