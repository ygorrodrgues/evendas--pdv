package br.cefetrn.datinf.pdv;


import br.cefetrn.datinf.estoque.dominio.CupomDeTroca;
import cefetrn.datinf.tads.credito.interfaces.ICredito;
import java.util.ArrayList;
import br.cefetrn.datinf.estoque.dominio.ItemVenda;
import br.cefetrn.datinf.estoque.dominio.Pagamento;
import br.cefetrn.datinf.estoque.dominio.Venda;
import br.cefetrn.datinf.estoque.remoto.IEstoque;
import java.util.HashMap;

public interface ISistema {

	public Venda iniciarVenda();	
	public ItemVenda entrarItem(Venda venda, long codigoProduto, int qtd);
	public void finalizarVenda(Venda venda);
	public void fazerPagamento(double quantia);

       public void setarCreditoRemoto(ICredito recuperarCreditoremoto);
	public HashMap<Integer,String> tiposPagamento();
        public String solicitarAprovacaoDeCompra(String numeroCartao,double valorCompra,int qtdParcelas,String identPDV);
        public Venda buscarVenda(int idVenda);
	public ItemVenda criarItemVenda(long codigoProduto);
        public void setarEstoqueRemoto(IEstoque estoque);
        public int registrarCupomDeTroca(CupomDeTroca umCupom);
}
