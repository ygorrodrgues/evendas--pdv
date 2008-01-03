package dominio;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Produto implements Serializable {
	private long id;
	private int codigo;
	private String descrico;
	private int qtde;
	private double preco;
	private SubCategoria subCategoria;  
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descrico;
	}
	public void setDescricao(String descricao) {
		this.descrico = descricao;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public SubCategoria getSubCategoria() {
		return subCategoria;
	}
	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}
}
