package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Loja implements Serializable {
	private int id;
	private String nome;
	private Endereco endereco;
	private Collection<Telefone> telefone;
	private Collection<Funcionario> funcionarios;
	private Collection<ItemProduto> itensproduto;
	private Collection<PDV> pdvs;
	
	public Loja(){
		this.funcionarios =  new ArrayList<Funcionario>();
		this.itensproduto = new ArrayList<ItemProduto>();
		this.pdvs = new ArrayList<PDV>();
	}
	
	/**
	 * @return the itensproduto
	 */
	public Collection<ItemProduto> getItensproduto() {
		return itensproduto;
	}
	
	public void removerItemProduto(ItemProduto itemProduto){
		this.itensproduto.remove(itemProduto);
	}
	
	public void addItemProduto(ItemProduto itemProduto){
		this.itensproduto.remove(itemProduto);
	}
	
	public int getId() {
		return id;
	}
	/**
	 * @return the telefone
	 */
	public Collection<Telefone> getTelefone() {
		return telefone;
	}

	/**
	 * @return the pdvs
	 */
	public Collection<PDV> getPdvs() {
		return pdvs;
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Collection<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public void addFuncionario(Funcionario novoFuncionario){
		this.funcionarios.add(novoFuncionario);
	}
	public void removerFuncionario(Funcionario funcionario){
		this.funcionarios.remove(funcionario);
	}
}
