package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Cartao implements Serializable{
	private long id;
	private int digito;
	private Date vencimento;
	private Cliente cliente;
	private double limite;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getDigito() {
		return digito;
	}
	public void setDigito(int digito) {
		this.digito = digito;
	}
	public Date getVencimento() {
		return vencimento;
	}
	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
}
