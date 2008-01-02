package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;
import java.util.Collection;
/**
 * @author Gleison
 *
 */
public class PagamentoCartao extends Pagamento implements Serializable{
	
	private Cartao cartao;
	private Collection<Parcela> parcelas;

	public Cartao getCartao() {
		return cartao;
	}
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	/**
	 * @return the parcelas
	 */
	public Collection<Parcela> getParcelas() {
		return parcelas;
	}
	
	public void addParcela(Parcela parcela){
		this.parcelas.add(parcela);
	}
	
	public void removerParcela(Parcela parcela){
		this.parcelas.remove(parcela);
	}
	
}