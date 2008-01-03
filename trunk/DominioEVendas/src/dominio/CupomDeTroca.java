package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class CupomDeTroca implements Serializable{
	
	private static final long serialVersionUID = 7447493748410370873L;
	private int id;
	private Date data;
	private Venda venda;
	private double valor;
	private Collection<ItemVenda> itens;
	private Pagamento pagamento;
	
	
	
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
	/**
	 * @return the pagamento
	 */
	public Pagamento getPagamento() {
		return pagamento;
	}
	/**
	 * @param pagamento the pagamento to set
	 */
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public CupomDeTroca() {
		itens = new ArrayList<ItemVenda>();
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getID() {
		return id;
	}
	public void setID(int numero) {
		this.id = numero;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	public Collection<ItemVenda> getItens() {
		return itens;
	}
	public void setItens(Collection<ItemVenda> itens) {
		this.itens = itens;
	}
	
	
	

}
package dominio;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class CupomDeTroca implements Serializable{
	
	private int numero;
	private Date data;
	private Venda venda;
	private double valor;
	private Collection<ItemVenda> itens;
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	public Collection<ItemVenda> getItens() {
		return itens;
	}
	public void setItens(Collection<ItemVenda> itens) {
		this.itens = itens;
	}
	
	
	

}
