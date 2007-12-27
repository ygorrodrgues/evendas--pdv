package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;

public class Loja implements Serializable {
	private int id;
	private String nome;
	private String endereco;
	//TODO criar a classe Endereco
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
