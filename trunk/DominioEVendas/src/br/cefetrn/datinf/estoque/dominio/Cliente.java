package br.cefetrn.datinf.estoque.dominio;

public class Cliente {
	
	private String id;
	private String nome;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cliente(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
