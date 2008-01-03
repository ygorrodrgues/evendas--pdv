package br.cefetrn.datinf.estoque.negocio;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.cefetrn.datinf.estoque.dominio.Cartao;
import br.cefetrn.datinf.estoque.dominio.Cliente;
import br.cefetrn.datinf.estoque.dominio.CupomDeTroca;
import br.cefetrn.datinf.estoque.dominio.EstadoItemVenda;
import br.cefetrn.datinf.estoque.dominio.Funcionario;
import br.cefetrn.datinf.estoque.dominio.ItemProduto;
import br.cefetrn.datinf.estoque.dominio.ItemVenda;
import br.cefetrn.datinf.estoque.dominio.Loja;
import br.cefetrn.datinf.estoque.dominio.Pagamento;
import br.cefetrn.datinf.estoque.dominio.PDV;
import br.cefetrn.datinf.estoque.dominio.PagamentoCartao;
import br.cefetrn.datinf.estoque.dominio.PagamentoCupomDeTroca;
import br.cefetrn.datinf.estoque.dominio.PagamentoDinheiro;
import br.cefetrn.datinf.estoque.dominio.Parcela;
import br.cefetrn.datinf.estoque.dominio.TipoPagamento;
import br.cefetrn.datinf.estoque.dominio.Venda;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Date data = new Date();
		int dia = data.getDay()+30;
		data.setDate(data.getDay()+30);
		System.out.println(""+data);
		
		String formato = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat formatter = new SimpleDateFormat(formato);
		System.out.println("A data formatada é: "+ formatter.format(data));*/
		
		Estoque estoque = new Estoque();
		Venda novaVenda = new Venda();
		
		novaVenda.setData(new Date());
		
		PDV pdv = new PDV();
		pdv.setID(1);
		
		Funcionario funcionario =  new Funcionario();
		funcionario.setId(1);
		
		Cliente cliente = new Cliente();
		cliente.setId(1);
		
		Loja loja = new Loja();
		loja.setId(1);
		
		ItemProduto itemProduto = new ItemProduto();
		itemProduto.setId(1);
		itemProduto.setLoja(loja);
		
		ItemVenda itemVenda1 =  new ItemVenda();
		itemVenda1.setEstado(EstadoItemVenda.ENTREGUE);
		itemVenda1.setItemProduto(itemProduto);		
		itemVenda1.setQtde(10);
		
		ItemVenda itemVenda2 =  new ItemVenda();
		itemVenda2.setEstado(EstadoItemVenda.ENTREGUE);
		itemVenda2.setItemProduto(itemProduto);		
		itemVenda2.setQtde(10);
		//TESTAR PAGAMENTO CARTAO
		
		/*Cartao cartao = new Cartao();
		cartao.setId(1);
		
		Pagamento pag =  new PagamentoCartao();
		pag.setTipo(TipoPagamento.Cartao);
		pag.setValor(80);
		((PagamentoCartao)pag).setCartao(cartao);*/
		
		
		//TESTAR PAGAMENTO TROCA
		CupomDeTroca cupomDeTroca = new CupomDeTroca();
		cupomDeTroca.setId(5);
		
		Pagamento pag =  new PagamentoCupomDeTroca();
		pag.setTipo(TipoPagamento.Troca);
		pag.setValor(80);
		((PagamentoCupomDeTroca)pag).setCupom(cupomDeTroca);
		cupomDeTroca.setPagamento(pag);
		
		//TESTAR PAGAMENTO DINEHIRO
		/*Pagamento pag =  new PagamentoDinheiro();
		pag.setTipo(TipoPagamento.Dinheiro);
		pag.setValor(80);*/
		
		
		
		//PARCELAS DO PAGAMENTO CARTAO
		/*int nParc = 4;
		int dias = 30;
		Date data = new Date();
		
		for(int i=0; i<nParc; ++i){
			Parcela parcela = new Parcela();
			parcela.setCartao(cartao);
			parcela.setValorVencmento(80/nParc);
			data.setDate(data.getDay()+dias);
			System.out.println("Parcela "+(i+1)+": "+data);
			parcela.setDataVencimento(data);
			((PagamentoCartao)pag).addParcela(parcela);
			parcela.setPagamento(pag);
			dias+=30;
		}*/
		
		novaVenda.setCliente(cliente);
		novaVenda.setFuncionario(funcionario);
		novaVenda.setPdv(pdv);
		
		novaVenda.adicionarItem(itemVenda1);
		itemVenda1.setVenda(novaVenda);
		novaVenda.adicionarItem(itemVenda2);
		itemVenda2.setVenda(novaVenda);
		
		
		novaVenda.adicionarPagamento(pag);
		pag.setVenda(novaVenda);
		
		long idVenda;
		try {
			idVenda = estoque.registrarVenda(novaVenda);
			System.out.println("Venda registrada. ID: "+idVenda);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
