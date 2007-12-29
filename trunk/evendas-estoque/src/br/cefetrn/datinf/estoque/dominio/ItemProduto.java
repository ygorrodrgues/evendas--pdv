package br.cefetrn.datinf.estoque.dominio;

public class ItemProduto {
	private long id;
	private Produto produto;
	private Loja loja;
	private int qtd;
	private double preco;
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
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}
	/**
	 * @param produto the produto to set
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	/**
	 * @return the loja
	 */
	public Loja getLoja() {
		return loja;
	}
	/**
	 * @param loja the loja to set
	 */
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	/**
	 * @return the qtd
	 */
	public int getQtd() {
		return qtd;
	}
	/**
	 * @param qtd the qtd to set
	 */
	public void setQtd(int qtd) {
		this.qtd = qtd;
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
}
