package br.cefetrn.datinf.credito.remoto;

public interface ICredito {
public String solicitarAprovacaoDeCompra(String numeroCartao,double valorCompra,
    		int qtdParcelas,String identPDV);
}
