package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Funcionario implements Serializable {
        private int id;
	private String matricula;
	private String nome;
	//private Funcao funcao;
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
	/*public Funcao getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
