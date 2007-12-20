package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@SuppressWarnings("serial")
public class Venda implements Serializable {

	
	private int id;
	private Date data;
	private Collection<ItemDeVenda> itens;
	private Collection<Pagamento> pagamentos;
	private double valor;
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Venda(){
		this.itens = new ArrayList<ItemDeVenda>();
		this.pagamentos = new ArrayList<Pagamento>();
	}
	
	public void adicionarPagamento(Pagamento umPagamento){
		this.pagamentos.add(umPagamento);
	}
	
	public void removerPagamento(){
		//TODO
	}
	
	public void adicionarItem(ItemDeVenda umItem){
		this.itens.add(umItem);
	}
	
	public void removerItem(ItemDeVenda umItem){
		this.itens.remove(umItem);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Collection<ItemDeVenda> getItens() {
		return itens;
	}
	public void setItens(Collection<ItemDeVenda> itens) {
		this.itens = itens;
	}

	public Collection<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(Collection<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	
	
}
