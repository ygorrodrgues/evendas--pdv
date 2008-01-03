/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.cefetrn.datinf.estoque.dominio;

/**
 *
 * @author Raquel
 */
public class ItemProduto {
    private long id;
    private int qtd;
    private double preco;
    private Produto produto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}
