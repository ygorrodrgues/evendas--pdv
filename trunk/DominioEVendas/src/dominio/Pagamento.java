package dominio;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Pagamento implements Serializable{
	private int id;
	private Venda venda;
	private double valor;
	private TipoPagamento tipo;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Venda getVenda() {
		return venda;
	}
	
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public TipoPagamento getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoPagamento tipo) {
		this.tipo = tipo;
	}
	
}
