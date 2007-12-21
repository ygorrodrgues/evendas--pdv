package dominio;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ItemVenda extends Produto implements Serializable{
	private int id;
	private int qtde;
	private Estado estado;
        private Produto produto;
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public int getIdProduto() {
		return super.getId();
	}

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
