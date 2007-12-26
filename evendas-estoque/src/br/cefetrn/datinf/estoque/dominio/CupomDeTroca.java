package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class CupomDeTroca implements Serializable{
	
	private static final long serialVersionUID = 7447493748410370873L;
	private int numero;
	private Date data;
	private Venda venda;
	private double valor;
	private Collection<ItemVenda> itens;
	
	
	
	public CupomDeTroca() {
		itens = new ArrayList<ItemVenda>();
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	public Collection<ItemVenda> getItens() {
		return itens;
	}
	public void setItens(Collection<ItemVenda> itens) {
		this.itens = itens;
	}
	
	
	

}
