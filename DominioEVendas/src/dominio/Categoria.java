package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Categoria implements Serializable{
	
	private int id;
	private String descricao;
	private Collection<SubCategoria> subs;
	
	public Categoria() {
		subs = new ArrayList<SubCategoria>();
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Collection<SubCategoria> getSubs() {
		return subs;
	}
	public void setSubs(Collection<SubCategoria> subs) {
		this.subs = subs;
	}
	public void addSubCategoria(SubCategoria sub ){
		subs.add(sub);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
