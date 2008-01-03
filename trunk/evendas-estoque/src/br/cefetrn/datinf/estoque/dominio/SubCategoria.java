package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;

public class SubCategoria implements Serializable{
	
	private int id;
	private String descricao;
	private Categoria categoria;

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
