package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Funcionario implements Serializable {
	
	private int id;
	private String matricula;
	private String nome;
	private Funcao funcao;
	private Loja loja;
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
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Funcao getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}
