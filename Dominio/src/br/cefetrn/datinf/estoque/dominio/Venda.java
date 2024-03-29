package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@SuppressWarnings("serial")
public class Venda implements Serializable {

	
	private long id;
	private Date data;
	private Collection<ItemVenda> itens;
	private Collection<Pagamento> pagamentos;
	private PDV pdv;
	private Funcionario funcionario;
	private Cliente cliente;
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
	
	public long getId() {
		return id;
	}
	public void setId(long idVenda) {
		this.id = idVenda;
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

	public PDV getPdv() {
		return pdv;
	}

	public void setPdv(PDV pdv) {
		this.pdv = pdv;
	}

	/**
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
