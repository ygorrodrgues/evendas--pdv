package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@SuppressWarnings("serial")
public class Venda implements Serializable {

	
	private int id;
	private Date data;
	private Collection<ItemVenda> itens;
	private Collection<Pagamento> pagamentos;
	private Pdv pdv;
	private double valor;
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Venda(){
		this.itens = new ArrayList<ItemVenda>();
		this.pagamentos = new ArrayList<Pagamento>();
	}
	
	public void adicionarPagamento(Pagamento umPagamento){
		this.pagamentos.add(umPagamento);
	}
	
	public void removerPagamento(){
		//TODO
	}
	
	public void adicionarItem(ItemVenda umItem){
		this.itens.add(umItem);
	}
	
	public void removerItem(ItemVenda umItem){
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
	public Collection<ItemVenda> getItens() {
		return itens;
	}
	public void setItens(Collection<ItemVenda> itens) {
		this.itens = itens;
	}

	public Collection<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(Collection<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Pdv getPdv() {
		return pdv;
	}

	public void setPdv(Pdv pdv) {
		this.pdv = pdv;
	}
	
	
}
