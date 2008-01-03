package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;

public class PagamentoCupomDeTroca extends Pagamento implements Serializable{
	private CupomDeTroca cupom;

	/**
	 * @return the cupom
	 */
	public CupomDeTroca getCupom() {
		return cupom;
	}

	/**
	 * @param cupom the cupom to set
	 */
	public void setCupom(CupomDeTroca cupom) {
		this.cupom = cupom;
	}
}
