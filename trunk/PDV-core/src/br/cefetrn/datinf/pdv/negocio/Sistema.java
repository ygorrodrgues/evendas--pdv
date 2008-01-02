package br.cefetrn.datinf.pdv.negocio;


import br.cefetrn.datinf.pdv.*;
import br.cefetrn.datinf.pdv.negocio.ControladorVenda;

import dominio.ItemProduto;
import dominio.ItemVenda;
import dominio.Venda;
import java.util.HashMap;


public class Sistema implements ISistema {

	private ControladorVenda controladorVenda = ControladorVenda.getInstance();
	//private Venda venda;
	private static ISistema pdv = null;
	
	private Sistema() {}
	
	public static ISistema getInstance() {
		if(pdv == null){
			pdv = new Sistema();
		}
		return pdv;
	}
	
	/*public ArrayList<Pagamento> tiposPagamento() {
		// TODO Auto-generated method stub
		return null;
	}*/

	//M�todos DE VENDA	
	public Venda iniciarVenda() {
		Venda venda = new Venda();
		return venda;
		
	}
	
	public ItemVenda entrarItem(Venda venda, long codigoProduto, int qtd) {
                ItemProduto itemProduto = controladorVenda.recuperarItem(codigoProduto);
                ItemVenda itemVenda = new ItemVenda();
                itemVenda.setQtde(qtd);
                itemVenda.setItemProduto(itemProduto);
                venda.adicionarItem(itemVenda);                             
                venda.setValor(venda.getValor() + qtd * itemVenda.getItemProduto().getPreco());
                
		return itemVenda;		
	}
	
	//nao precisa implementar aki soh no JFORM
        public Venda finalizarVenda(Venda venda) {
		//enviar venda para o PDV??
		return null;
	}
	
	public void fazerPagamento(double quantia) {
		// TODO Auto-generated method stub
		
	}

        public HashMap<Integer, String> tiposPagamento() {
            HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(1, "DIMHEIRO");
		hashMap.put(2, "CARTAO");
		hashMap.put(3, "TICKET TROCA");
		
            return hashMap;   
        }
        public String solicitarAprovacaoDeCompra(String numeroCartao, double valorCompra, int qtdParcelas, String identPDV) {
		String mensagem = controladorVenda.solicitarAprovacaoDeCompra(numeroCartao, valorCompra, qtdParcelas, identPDV);
		return mensagem;
	}
   
	
}
