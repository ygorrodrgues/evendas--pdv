/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.cefetrn.datinf.estoque.dominio;

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
}
