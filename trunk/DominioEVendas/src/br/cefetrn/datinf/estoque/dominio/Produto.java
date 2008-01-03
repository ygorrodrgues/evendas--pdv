package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Produto implements Serializable {
	private long id;
        //id eh a chave en necessario ter um codigo?
        private int codigo;
	private String nome;
	private int qtde;
	private double preco;
	
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }
}
