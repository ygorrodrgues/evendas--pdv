package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Parcela implements Serializable{
	private long id;
	private Cartao cartao;
	private Pagamento pagamento;
	private Date dataVencimento;
	private double valorVencmento;
	private Date dataPgto;
	private double valorPtgo;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the cartao
	 */
	public Cartao getCartao() {
		return cartao;
	}
	/**
	 * @param cartao the cartao to set
	 */
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	/**
	 * @return the pagamento
	 */
	public Pagamento getPagamento() {
		return pagamento;
	}
	/**
	 * @param pagamento the pagamento to set
	 */
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	/**
	 * @return the dataVencimento
	 */
	public Date getDataVencimento() {
		return dataVencimento;
	}
	/**
	 * @param dataVencimento the dataVencimento to set
	 */
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	/**
	 * @return the valorVencmento
	 */
	public double getValorVencmento() {
		return valorVencmento;
	}
	/**
	 * @param valorVencmento the valorVencmento to set
	 */
	public void setValorVencmento(double valorVencmento) {
		this.valorVencmento = valorVencmento;
	}
	/**
	 * @return the dataPgto
	 */
	public Date getDataPgto() {
		return dataPgto;
	}
	/**
	 * @param dataPgto the dataPgto to set
	 */
	public void setDataPgto(Date dataPgto) {
		this.dataPgto = dataPgto;
	}
	/**
	 * @return the valorPtgo
	 */
	public double getValorPtgo() {
		return valorPtgo;
	}
	/**
	 * @param valorPtgo the valorPtgo to set
	 */
	public void setValorPtgo(double valorPtgo) {
		this.valorPtgo = valorPtgo;
	}

}
