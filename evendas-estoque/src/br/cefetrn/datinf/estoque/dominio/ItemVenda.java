package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ItemVenda implements Serializable{
	
	private int id;
	private int qtde;
	private EstadoItemVenda estado;
	private ItemProduto itemProduto;
	private double preco;
	private String nome;
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}
	/**
	 * @param preco the preco to set
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	/**
	 * @return the itemProduto
	 */
	public ItemProduto getItemProduto() {
		return itemProduto;
	}
	/**
	 * @param itemProduto the itemProduto to set
	 */
	public void setItemProduto(ItemProduto itemProduto) {
		this.itemProduto = itemProduto;
	}
	public EstadoItemVenda getEstado() {
		return estado;
	}
	public void setEstado(EstadoItemVenda estado) {
		this.estado = estado;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public int getIdProduto() {
		return getId();
	}
}
