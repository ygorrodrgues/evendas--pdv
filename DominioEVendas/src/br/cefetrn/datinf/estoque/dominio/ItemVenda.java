package br.cefetrn.datinf.estoque.dominio;

import java.io.Serializable;

@SuppressWarnings("serial")
//extends produtos  ??tem dependencisomente!
public class ItemVenda /*extends Produto*/ implements Serializable{
	private long id;
	private int qtde;
	private Estado estado;
        private ItemProduto itemProduto;
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

    public ItemProduto getItemProduto() {
        return itemProduto;
    }

    public void setItemProduto(ItemProduto itemProduto) {
        this.itemProduto = itemProduto;
    }
	

   
}
