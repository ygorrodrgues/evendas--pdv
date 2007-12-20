package br.cefetrn.datinf.pdv.dominio;

import java.util.ArrayList;
import java.util.Date;

public class Venda {

	private long id;
	private double valorTotal;
	private Date data;
	private Cliente cliente;
	private Pagamento pagamento;
	private ArrayList<Item> itens;
	private Funcionario funcionario;
	
	
	public Venda() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Venda(long id, double valorTotal, Date data, Cliente cliente, Pagamento pagamento, ArrayList<Item> itens, Funcionario funcionario) {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
		this.data = data;
		this.cliente = cliente;
		this.pagamento = pagamento;
		this.itens = itens;
		this.funcionario = funcionario;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ArrayList<Item> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public void adicionarItem(Item item) {
		itens.add(item);
		
	}
	
}
