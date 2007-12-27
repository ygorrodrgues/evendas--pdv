package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Pagamento implements Serializable{
	private long id;
	private Venda venda;
	private TipoPagamento tipo;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Venda getVenda() {
		return venda;
	}
	
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public TipoPagamento getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoPagamento tipo) {
		this.tipo = tipo;
	}
	
}
