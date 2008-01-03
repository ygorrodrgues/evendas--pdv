package br.cefetrn.datinf.pdv;


import java.util.ArrayList;
import br.cefetrn.datinf.estoque.dominio.ItemVenda;
import br.cefetrn.datinf.estoque.dominio.Pagamento;
import br.cefetrn.datinf.estoque.dominio.Venda;
import java.util.HashMap;

public interface ISistema {

	//quais os parametros  VENDA
	public Venda iniciarVenda();	
	//
	public ItemVenda entrarItem(Venda venda, long codigoProduto, int qtd);
	public Venda finalizarVenda(Venda venda);
	public void fazerPagamento(double quantia);
	public HashMap<Integer,String> tiposPagamento();
        public String solicitarAprovacaoDeCompra(String numeroCartao,double valorCompra,int qtdParcelas,String identPDV);
	
}
