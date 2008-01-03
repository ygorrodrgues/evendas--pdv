/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

import java.io.Serializable;

/***
 * 
 * @author Gleison
 *
 */
public class PDV implements Serializable{

    private int id;
    private Loja loja;
    
    public int getID() {
        return id;
    }

    public void setID(int numero) {
        this.id = numero;
    }
	/**
	 * @return the loja
	 */
	public Loja getLoja() {
		return loja;
	}

	/**
	 * @param loja the loja to set
	 */
	public void setLoja(Loja loja) {
		this.loja = loja;
	}    
}
