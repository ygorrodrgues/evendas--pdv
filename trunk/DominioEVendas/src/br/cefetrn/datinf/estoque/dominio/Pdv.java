/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.cefetrn.datinf.estoque.dominio;

import java.util.Calendar;

/**
 *
 * @author Raquel
 */
public class Pdv {

    private int numero;
    private Calendar dataEntrada;
    private Calendar dataSaida;
    private Funcionario funcionario;    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Calendar getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Calendar dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Calendar getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Calendar dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
    
    
}
